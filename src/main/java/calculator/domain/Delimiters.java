package calculator.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Delimiters {

    private final Set<Character> delimiters;
    private final CustomDelimiters customDelimiters;

    private Delimiters(Set<Character> delimiters, CustomDelimiters customDelimiters) {
        this.delimiters = new HashSet<>(delimiters);
        this.customDelimiters = customDelimiters;
        initializeDelimiters();
    }

    public static Delimiters of(CustomDelimiters customDelimiters) {
        return new Delimiters(new HashSet<>(), customDelimiters);
    }

    public Set<Character> getDelimiters() {
        return delimiters;
    }

    public boolean isDelimiter(Character input) {
        return delimiters.contains(input);
    }

    public void registerDelimiter(Character input) {
        customDelimiters.register(input);
        delimiters.add(input);
    }

    private void initializeDelimiters() {
        Arrays.stream(BasicDelimiters.values())
                .map(BasicDelimiters::getValue)
                .forEach(delimiters::add);

        customDelimiters.getCustomDelimiters().stream()
                .map(CustomDelimiter::value)
                .forEach(delimiters::add);
    }
}
