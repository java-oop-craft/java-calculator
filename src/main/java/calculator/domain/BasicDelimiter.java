package calculator.domain;

public enum BasicDelimiter {
    COMMA(","),
    COLON(":"),
    ;

    private String basicDelimiter;

    private BasicDelimiter(String basicDelimiter) {
        this.basicDelimiter = basicDelimiter;
    }
}
