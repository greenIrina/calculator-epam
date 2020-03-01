package com.linicar.calculator.service;

import com.linicar.calculator.repository.ParserRepository.ModeOperations;
import com.linicar.calculator.repository.ParserRepository.Parser;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;
import com.linicar.calculator.repository.ParserRepository.*;
import com.linicar.calculator.service.ParserServiceImpl.operations.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpressionParser<T> implements Parser {

    private int openBraceCounter;
    private String expression;
    private ModeOperations<T> mode;
    private int positionInExpression;

    private T value;
    private String nameOfVariable;

    private Token curToken;
    private Token prevToken;

    public enum Token {
        PLUS("operator"),
        MUL("operator"),
        DIV("operator"),
        ABS("operator"),
        SQUARE("operator"),
        MOD("operator"),
        OPEN_BRACE("brace"),
        CLOSE_BRACE("brace"),
        MINUS("minus"),
        END("end"),
        ERROR("err"),
        VARIABLE("value"),
        CONST("value");

        final String type;

        Token(String type) {
            this.type = type;
        }
    }

    private static Map<Character, Token> tokenMap = new HashMap<>();

    public ExpressionParser(ModeOperations<T> mode) {
        this.mode = mode;
    }

    static {
        tokenMap.put('+', Token.PLUS);
        tokenMap.put('-', Token.MINUS);
        tokenMap.put('/', Token.DIV);
        tokenMap.put('*', Token.MUL);
        tokenMap.put('(', Token.OPEN_BRACE);
        tokenMap.put(')', Token.CLOSE_BRACE);
    }

    private void skipWhiteSpace() {
        while (positionInExpression < expression.length() &&
                Character.isWhitespace(expression.charAt(positionInExpression))) {
            positionInExpression++;
        }
    }

    private void nextToken() throws ParserException {

        skipWhiteSpace();

        if (positionInExpression >= expression.length()) {
            curToken = Token.END;
            return;
        }

        char ch = expression.charAt(positionInExpression++);
        prevToken = curToken;

        if (tokenMap.containsKey(ch)) {
            curToken = tokenMap.get(ch);
            match();
            return;
        }

        if (Character.isLetter(ch)) {
            getId();
            return;
        }

        if (Character.isDigit(ch)) {
            value = getConst();
            curToken = Token.CONST;
            return;
        }
        throw new WrongTokenException(ch, expression);
    }

    private T getConst() throws ParserException {
        int left = positionInExpression - 1;
        while (positionInExpression < expression.length() &&
                Character.isDigit(expression.charAt(positionInExpression))) {
            positionInExpression++;
        }
        return mode.parseConst(expression.substring(left, positionInExpression));

    }

    private void getId() throws ParserException {
        int left = positionInExpression - 1;
        while (positionInExpression < expression.length() &&
                Character.isLetter(expression.charAt(positionInExpression))) {
            positionInExpression++;
        }
        String str = expression.substring(left, positionInExpression);

        switch (str) {
            case "x":
            case "y":
            case "z":
                nameOfVariable = str;
                curToken = Token.VARIABLE;
                return;
        }
        throw new WrongTokenException(str, expression);
    }

    private void match() throws ParserException {
        if (curToken.type.equals("operator")) {
            if (prevToken == Token.OPEN_BRACE || prevToken == Token.ERROR) {
                throw new MissedArgumentException("first", expression, positionInExpression - 1);
            }
            if (prevToken.type.equals("operator")) {
                throw new MissedArgumentException("middle", expression, positionInExpression - 1);
            }
        }

        if (curToken == Token.OPEN_BRACE
                && (prevToken == Token.CLOSE_BRACE || prevToken.type.equals("value"))) {
            throw new MissedOperatorException(expression, positionInExpression - 1);
        }

        if (curToken == Token.CLOSE_BRACE) {
            if (openBraceCounter == 0) {
                throw new WrongBraceException("closing", expression, positionInExpression - 1);
            }
            if (prevToken.type.equals("operator") || prevToken.type.equals("minus")) {
                throw new MissedArgumentException("last", expression, positionInExpression - 1);
            }
        }

    }

    private TripleExpression<T> unaryOperations(boolean newToken) throws ParserException {
        if (newToken) {
            nextToken();
        }
        switch (curToken) {
            case CONST:
                T number = value;
                nextToken();
                return new Const<>(number);
            case VARIABLE:
                String name = nameOfVariable;
                nextToken();
                return new Variable<>(name);
            case MINUS:
                if (Character.isDigit(expression.charAt(positionInExpression))) {
                    curToken = Token.CONST;
                    value = getConst();
                    nextToken();
                    return new Const<>(value);
                }
                return new Negative<>(unaryOperations(true), mode);
            case ABS:
                return new Abs<>(unaryOperations(true), mode);
            case SQUARE:
                return new Square<>(unaryOperations(true), mode);
            case OPEN_BRACE:
                openBraceCounter++;
                TripleExpression<T> e = addSub(true);
                if (curToken == Token.CLOSE_BRACE) {
                    openBraceCounter--;
                    nextToken();
                } else {
                    throw new WrongBraceException("opening", expression, positionInExpression - 1);
                }
                return e;
            default:
                throw new MissedArgumentException("last", expression, positionInExpression - 1);
        }
    }

    private TripleExpression<T> mulDiv(boolean newToken) throws ParserException {
        TripleExpression<T> left = unaryOperations(newToken);

        while (true) {
            if (curToken == Token.MUL) {
                left = new Multiply<>(left, unaryOperations(true), mode);
            } else if (curToken == Token.DIV) {
                left = new Divide<>(left, unaryOperations(true), mode);
            } else if (curToken == Token.MOD) {
                left = new Mod<>(left, unaryOperations(true), mode);
            } else {
                return left;
            }
        }
    }

    private TripleExpression<T> addSub(boolean newToken) throws ParserException {
        TripleExpression<T> left = mulDiv(newToken);

        while (true) {
            if (curToken == Token.PLUS) {
                left = new Add<>(left, mulDiv(true), mode);
            } else if (curToken == Token.MINUS) {
                left = new Subtract<>(left, mulDiv(true), mode);
            } else {
                return left;
            }
        }
    }

    public TripleExpression parse(String expression) throws ParserException {

        this.expression = expression;
        openBraceCounter = 0;
        positionInExpression = 0;
        curToken = Token.ERROR;
        nextToken();

        return addSub(false);
    }
}