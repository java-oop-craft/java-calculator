package calculator.domain;

import java.util.Objects;

import static calculator.domain.BasicDelimiter.isBasicDelimiter;

public class CustomDelimiter {

    private final Character customDelimiter;

    private CustomDelimiter(Character customDelimiter) {
        validateCustomDelimiterPolicy(customDelimiter);
        this.customDelimiter = customDelimiter;
    }

    public static CustomDelimiter create(Character customDelimiter) {
        return new CustomDelimiter(customDelimiter);
    }

    public Character value() {
        return customDelimiter;
    }

    private void validateCustomDelimiterPolicy(Character input) {
        validateCharacterIsDigit(input);
        validateCharacterIsLetter(input);
        validateIsNotBasicDelimiter(input);
    }

    private void validateCharacterIsDigit(char input) {
        if (Character.isDigit(input)) {
            throw new IllegalArgumentException("[ERROR]: 숫자는 커스텀 구분자로 등록할 수 없습니다.");
        }
    }

    private void validateCharacterIsLetter(char input) {
        if (Character.isAlphabetic(input)) {
            throw new IllegalArgumentException("[ERROR]: 특수 문자가 아닌 문자는 커스텀 구분자로 등록할 수 없습니다.");
        }
    }

    private void validateIsNotBasicDelimiter(char input) {
        if (isBasicDelimiter(input)) {
            throw new IllegalArgumentException("[ERROR]: 기본 구분자는 커스텀 구분자로 등록할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomDelimiter that = (CustomDelimiter) o;
        return Objects.equals(customDelimiter, that.customDelimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customDelimiter);
    }

    @Override
    public String toString() {
        return "CustomDelimiter{" +
                "customDelimiter=" + customDelimiter +
                '}';
    }
}
