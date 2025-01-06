package calculator.domain;

import java.util.Arrays;

public enum BasicDelimiters {
    COMMA(','),
    COLON(':'),
    ;

    private Character basicDelimiter;

    private BasicDelimiters(Character basicDelimiter) {
        this.basicDelimiter = basicDelimiter;
    }

    public static boolean isBasicDelimiter(Character input) {
        return Arrays.stream(BasicDelimiters.values())
                .anyMatch(delimiter -> delimiter.basicDelimiter.equals(input));
    }

    public Character getValue() {
        return basicDelimiter;
    }
}
