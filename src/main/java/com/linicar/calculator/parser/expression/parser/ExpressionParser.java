package com.linicar.calculator.parser.expression.parser;

import expression.*;
import expression.exceptions.*;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExpressionParser implements Parser {
    private static final Map<String, Token> IDS = new HashMap<>();
    private static final Map<Character, Token> BIN_OP = new HashMap<>(); //IDENTICAL
    private static final Set<Token> OPS = EnumSet.of(Token.MINUS, Token.ADD, Token.SUB, Token.MUL, Token.DIV,
            Token.HIGH, Token.LOW);
    private static Set<Token> BIN_OPS = EnumSet.of(Token.ADD, Token.SUB, Token.MUL, Token.DIV);
    private int curIndex;
    private int numericalValue;
    private int balance;
    private String stringToParse;
    private String stringValue;
    private Token currentToken;

    static {
        IDS.put("high", Token.HIGH);
        IDS.put("low", Token.LOW);
        IDS.put("x", Token.VAR);
        IDS.put("y", Token.VAR);
        IDS.put("z", Token.VAR);
        BIN_OP.put('+', Token.ADD);
        BIN_OP.put('*', Token.MUL);
        BIN_OP.put('/', Token.DIV);
    }

    private void getToken() throws ParsingException {
        while (curIndex < stringToParse.length() && Character.isWhitespace(stringToParse.charAt(curIndex))) {
            curIndex++;
        }
        if (curIndex >= stringToParse.length()) {
            checkForOperand(curIndex);
            currentToken = Token.END;
            return;
        }

        switch (stringToParse.charAt(curIndex)) {
            case '-':
                if (checkIfSubtractable()) {
                    currentToken = Token.SUB;
                } else {
                    if (curIndex + 1 >= stringToParse.length()) {
                        throw new MissingOperandException(curIndex + 1);
                    }
                    if (Character.isDigit(stringToParse.charAt(curIndex + 1))) {
                        curIndex++;
                        String tmp = getNumber();
                        String temp = "-" + tmp;
                        tryParseInt(temp, curIndex - tmp.length());
                        currentToken = Token.CONST;
                    } else {
                        currentToken = Token.MINUS;
                    }
                }
                curIndex++;
                return;
            case '(':
                checkForOperation(curIndex);
                currentToken = Token.LEFT_BR;
                balance++;
                curIndex++;
                return;
            case ')':
                if (OPS.contains(currentToken) || currentToken == Token.LEFT_BR) {
                    throw new MissingOperandException(curIndex);
                }
                balance--;
                if (balance < 0) {
                    throw new MissingOpeningParenthesisException(curIndex);
                }
                currentToken = Token.RIGHT_BR;
                curIndex++;
                return;
            default:
                if (BIN_OP.containsKey(stringToParse.charAt(curIndex))) {
                    checkForOperand(curIndex);
                    currentToken = BIN_OP.get(stringToParse.charAt(curIndex));
                    curIndex++;
                } else if (Character.isDigit(stringToParse.charAt(curIndex))) {
                    checkForOperation(curIndex);
                    String tmp = getNumber();
                    int pos = curIndex - tmp.length() + 1;
                    tryParseInt(tmp, pos);
                    currentToken = Token.CONST;
                    curIndex++;
                } else {
                    String curOp = getOp();
                    int pos = curIndex - curOp.length() + 1;
                    if (!IDS.containsKey(curOp)) {
                        throw new UnknownOpException(curOp, pos);
                    }
                    if (BIN_OPS.contains(IDS.get(curOp))) {
                        checkForOperand(pos);
                    } else {
                        checkForOperation(pos);
                    }
                    currentToken = IDS.get(curOp);
                    if (currentToken == Token.VAR) {
                        stringValue = Character.toString(curOp.charAt(0));
                    }
                    curIndex++;
                }
        }
    }

    public TripleExpression parse(String expression) throws ParsingException {
        currentToken = Token.BEGIN;
        curIndex = 0;
        stringToParse = expression;
        balance = 0;
        return getAddSub();
    }

    private TripleExpression getAddSub() throws ParsingException {
        TripleExpression res = getMulDiv();
        while ((currentToken == Token.ADD) || currentToken == Token.SUB) {
            switch (currentToken) {
                case ADD:
                    res = new CheckedAdd(res, getMulDiv());
                    break;
                case SUB:
                    res = new CheckedSubtract(res, getMulDiv());
                    break;
            }
        }
        return res;
    }

    private TripleExpression getMulDiv() throws ParsingException {
        TripleExpression res = getUnary();
        while (currentToken == Token.MUL || currentToken == Token.DIV) {
            switch (currentToken) {
                case MUL:
                    res = new CheckedMultiply(res, getUnary());
                    break;
                case DIV:
                    res = new CheckedDivide(res, getUnary());
                    break;
            }
        }
        return res;
    }

    private TripleExpression getUnary() throws ParsingException {
        getToken();
        switch (currentToken) {
            case LEFT_BR:
                int pos = curIndex;
                TripleExpression x = getAddSub();
                if (currentToken != Token.RIGHT_BR) {
                    throw new MissingClosingParenthesisException(pos - 1);
                }
                getToken();
                return x;
            case HIGH:
                return new High(getUnary());
            case LOW:
                return new Low(getUnary());
            case MINUS:
                return new CheckedNegate(getUnary());
            case CONST:
                getToken();
                return new Const(numericalValue);
            case VAR:
                getToken();
                return new Variable(stringValue);
            default:
                throw new ParsingException("Incorrect expression" + "\n" + stringToParse);
        }
    }

    enum Token {
        BEGIN, HIGH, LOW, ADD, SUB, MINUS, MUL, DIV, LEFT_BR, RIGHT_BR, CONST, VAR, END
    }

    private void checkForOperand(final int pos) throws MissingOperandException {
        if (OPS.contains(currentToken) || currentToken == Token.LEFT_BR || currentToken == Token.BEGIN) {
            throw new MissingOperandException(pos);
        }
    }

    private void checkForOperation(final int pos) throws MissingOperationException {
        if (currentToken == Token.RIGHT_BR || currentToken == Token.VAR || currentToken == Token.CONST) {
            throw new MissingOperationException(pos);
        }
    }

    private String getOp() throws UnknownSymbolException {
        if (!Character.isLetter(stringToParse.charAt(curIndex))) {
            throw new UnknownSymbolException(stringToParse, curIndex);
        }
        int left = curIndex;
        while (curIndex < stringToParse.length() && Character.isLetter(stringToParse.charAt(curIndex))) {
            curIndex++;
        }
        int right = curIndex;
        curIndex--;
        return stringToParse.substring(left, right);
    }

    private String getNumber() {
        int left = curIndex;
        while (curIndex < stringToParse.length() && Character.isDigit(stringToParse.charAt(curIndex))) {
            curIndex++;
        }
        int right = curIndex;
        curIndex--;
        return stringToParse.substring(left, right);
    }

    private Boolean checkIfSubtractable() {
        return currentToken == Token.CONST || currentToken == Token.VAR || currentToken == Token.RIGHT_BR;
    }

    private void tryParseInt(String s, int pos) throws IllegalConstantException {
        try {
            numericalValue = Integer.parseInt(s);
        } catch (NumberFormatException NFE) {
            throw new IllegalConstantException(s, pos);
        }
    }
}
