package calculator.domain;

import java.util.Arrays;

public enum BasicDelimiter {
    COMMA(','),
    COLON(':'),
    ;

    private Character basicDelimiter;

    private BasicDelimiter(Character basicDelimiter) {
        this.basicDelimiter = basicDelimiter;
    }

    public static boolean isBasicDelimiter(Character input) {
        return Arrays.stream(BasicDelimiter.values())
                .anyMatch(delimiter -> delimiter.basicDelimiter.equals(input));
    }
}
