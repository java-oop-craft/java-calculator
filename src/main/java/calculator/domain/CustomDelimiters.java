package calculator.domain;

import java.util.HashSet;
import java.util.Set;

public class CustomDelimiters {

    private final Set<CustomDelimiter> customDelimiters;

    private CustomDelimiters(Set<CustomDelimiter> customDelimiters) {
        this.customDelimiters = new HashSet<>(customDelimiters);
    }

    public static CustomDelimiters create() {
        return new CustomDelimiters(new HashSet<>());
    }

    public void register(Character input) {
        CustomDelimiter customDelimiter = CustomDelimiter.create(input);
        validateDuplicateCustomDelimiter(customDelimiter);
        customDelimiters.add(customDelimiter);
    }

    private void validateDuplicateCustomDelimiter(CustomDelimiter input) {
        if (customDelimiters.contains(input)) {
            throw new IllegalArgumentException("[ERROR]: 이미 등록된 커스텀 구분자입니다.");
        }
    }
}
