package com.linicar.calculator.service.ParserServiceImpl.parser;

import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.Expression;
import com.linicar.calculator.service.ParserServiceImpl.operations.interfaces.Operations;
import com.linicar.calculator.service.ParserServiceImpl.operations.operations.*;

import java.util.HashMap;
import java.util.Map;

public class ExpressionParser implements Parser {

    private int openBraceCounter;
    private String expression;
    private Operations mode;
    private int posInExpression;

    private Double value;

    private Token curToken;
    private Token prevToken;

    public enum Token {
        PLUS("operator"),
        MUL("operator"),
        DIV("operator"),
        ABS("operator"),
        MOD("operator"),
        OPEN_BRACE("brace"),
        CLOSE_BRACE("brace"),
        MINUS("minus"),
        END("end"),
        ERROR("err"),
        COMMA("comma"),
        CONST("value"),
        SQRT("operator"),
        POW("operator"),
        FACT("operator"),
        SIN("operator"),
        COS("operator"),
        TAN("operator"),
        ATAN("operator"),
        LOG("operator");

        final String type;

        Token(String type) {
            this.type = type;
        }
    }

    private static Map<String, Double> constantMap = new HashMap<>();

    private static Map<Character, Token> tokenMap = new HashMap<>();

    private static Map<String, Token> functionsMap = new HashMap<>();

    public ExpressionParser(Operations mode) {
        this.mode = mode;
    }

    //Constants
    static {
        constantMap.put("e", Math.E);
        constantMap.put("pi", Math.PI);
    }

    //Operators
    static {
        tokenMap.put('+', Token.PLUS);
        tokenMap.put('-', Token.MINUS);
        tokenMap.put('/', Token.DIV);
        tokenMap.put('*', Token.MUL);
        tokenMap.put('(', Token.OPEN_BRACE);
        tokenMap.put(')', Token.CLOSE_BRACE);
        tokenMap.put('^', Token.POW);
    }

    //functions
    static {
        functionsMap.put("abs", Token.ABS);
        functionsMap.put("sqrt", Token.SQRT);
        functionsMap.put("pow", Token.POW);
        functionsMap.put("sin", Token.SIN);
        functionsMap.put("cos", Token.COS);
        functionsMap.put("tan", Token.TAN);
        functionsMap.put("atan", Token.ATAN);
        functionsMap.put("factorial", Token.FACT);
        functionsMap.put("log", Token.LOG);
    }

    private void skipWhiteSpace() {
        while (posInExpression < expression.length() &&
                Character.isWhitespace(expression.charAt(posInExpression))) {
            posInExpression++;
        }
    }

    private void nextToken() throws ParserException {

        skipWhiteSpace();

        if (posInExpression >= expression.length()) {
            curToken = Token.END;
            return;
        }

        char ch = expression.charAt(posInExpression++);

        prevToken = curToken;

        if (tokenMap.containsKey(ch)) {
            curToken = tokenMap.get(ch);
            if (ch == '/') {
                if (posInExpression >= expression.length()) {
                    throw new MissedArgumentException("last", expression);
                } else if (expression.charAt(posInExpression) == ch) {
                    ++posInExpression;
                    curToken = Token.LOG;
                }
            }
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

    private Double getConst() throws ParserException {
        int left = posInExpression - 1;
        while (posInExpression < expression.length() &&
                (Character.isDigit(expression.charAt(posInExpression)) ||
                        expression.charAt(posInExpression) == '.')) {
            posInExpression++;
        }
        return mode.parseConst(expression.substring(left, posInExpression));
    }

    private void getId() throws ParserException {
        int left = posInExpression - 1;
        while (posInExpression < expression.length() &&
                Character.isLetter(expression.charAt(posInExpression))) {
            posInExpression++;
        }
        String str = expression.substring(left, posInExpression);


        if (constantMap.containsKey(str)) {
            value = constantMap.get(str);
            curToken = Token.CONST;
            return;
        }

        if (functionsMap.containsKey(str)) {
            curToken = functionsMap.get(str);
            return;
        }

        throw new WrongTokenException(str, expression);
    }

    private void match() throws ParserException {
        if (curToken.type.equals("operator")) {
            if (prevToken == Token.OPEN_BRACE || prevToken == Token.ERROR) {
                throw new MissedArgumentException("first", expression);
            }
            if (prevToken.type.equals("operator")) {
                throw new MissedArgumentException("middle", expression);
            }
        }

        if (curToken == Token.OPEN_BRACE
                && (prevToken == Token.CLOSE_BRACE || prevToken.type.equals("value"))) {
            throw new MissedOperatorException(expression);
        }

        if (curToken == Token.CLOSE_BRACE) {
            if (openBraceCounter == 0) {
                throw new WrongBraceException("closing", expression, posInExpression - 1);
            }
            if (prevToken.type.equals("operator") || prevToken.type.equals("minus")) {
                throw new MissedArgumentException("last", expression);
            }
        }
    }

    private Expression unaryOperations(boolean newToken) throws ParserException {
        if (newToken) {
            nextToken();
        }
        switch (curToken) {
            case CONST:
                Double number = value;
                nextToken();
                return new Const(number);
            case MINUS:
                if (Character.isDigit(expression.charAt(posInExpression))) {
                    curToken = Token.CONST;
                    value = getConst();
                    nextToken();
                    return new Const(value);
                }
                return new Negative(unaryOperations(true));
            case FACT:
                return new Factorial(unaryOperations(true));
            case ABS:
                return new Abs(unaryOperations(true));
            case SQRT:
                return new Sqrt(unaryOperations(true));
            case SIN:
                return new Sin(unaryOperations(true));
            case COS:
                return new Cos(unaryOperations(true));
            case TAN:
                return new Tan(unaryOperations(true));
            case ATAN:
                return new Atan(unaryOperations(true));
            case OPEN_BRACE:
                openBraceCounter++;
                Expression e = addSub(true);
                if (curToken == Token.COMMA) {
                    return e;
                }
                if (curToken == Token.CLOSE_BRACE) {
                    openBraceCounter--;
                    nextToken();
                } else {
                    throw new WrongBraceException("opening", expression, posInExpression - 1);
                }
                return e;
            default:
                throw new MissedArgumentException("last", expression);
        }
    }

    private Expression logPow(boolean newToken) throws ParserException {
        Expression left = unaryOperations(newToken);
        while (true) {
            if (curToken == Token.LOG) {
                left = new Log(left, unaryOperations(true));
            } else if (curToken == Token.POW) {
                left = new Pow(left, unaryOperations(true));
            } else {
                return left;
            }
        }
    }

    private Expression binaryOperations(boolean newToken) throws ParserException {
        Expression left = logPow(newToken);

        while (true) {
            switch (curToken) {
                case MUL:
                    left = new Multiply(left, unaryOperations(true));
                    continue;
                case DIV:
                    left = new Divide(left, unaryOperations(true));
                    continue;
                case MOD:
                    left = new Mod(left, unaryOperations(true));
                    continue;
                default:
                    return left;
            }
        }
    }

    private Expression addSub(boolean newToken) throws ParserException {
        Expression left = binaryOperations(newToken);

        while (true) {
            switch (curToken) {
                case PLUS:
                    left = new Add(left, binaryOperations(true));
                    break;
                case MINUS:
                    left = new Subtract(left, binaryOperations(true));
                    break;
                default:
                    if (curToken != Token.END && curToken != Token.CLOSE_BRACE && curToken != Token.COMMA) {
                        throw new WrongTokenException(curToken.toString().toLowerCase(), expression);
                    }
                    return left;
            }
        }
    }

    public Expression parse(String expression) throws ParserException {

        this.expression = expression;
        openBraceCounter = 0;
        posInExpression = 0;
        curToken = Token.ERROR;
        nextToken();

        return addSub(false);
    }
}
