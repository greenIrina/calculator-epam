package com.linicar.calculator.service.ParserServiceImpl.generic;

import com.linicar.calculator.repository.ParserRepository.*;
import com.linicar.calculator.service.ParserServiceImpl.exceptions.*;
import com.linicar.calculator.service.ParserServiceImpl.generic.modes.*;
import com.linicar.calculator.service.ExpressionParser;


public class GenericTabulator implements Tabulator {
    public Object[][][] tabulate(String mode, String expression,
                                 int x1, int x2, int y1,
                                 int y2, int z1, int z2) throws ParserException {
        return createNewTable(getMode(mode), expression, x1, x2, y1, y2, z1, z2);
    }

    private ModeOperations<?> getMode(String mode) throws UnsupportedModeException {
        switch (mode) {
            case "i":
                return new IntegerOperations();
            case "d":
                return new DoubleOperations();
            case "bi":
                return new BigIntegerOperations();
            default:
                throw new UnsupportedModeException(mode);
        }
    }

    private <T> Object[][][] createNewTable(ModeOperations<?> mode, String expression,
                                            int x1, int x2, int y1,
                                            int y2, int z1, int z2) throws ParserException {
        Object[][][] result = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        ExpressionParser<?> parser = new ExpressionParser<>(mode);
        TripleExpression expression1 = parser.parse(expression);
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    try {
                        result[i - x1][j - y1][k - z1] = expression1.evaluate(mode.getNumber(i), mode.getNumber(j), mode.getNumber(k));
                    } catch (EvaluatingExceptions e) {
                        result[i - x1][j - y1][k - z1] = null;
                    }
                }
            }
        }
        return result;
    }
}
