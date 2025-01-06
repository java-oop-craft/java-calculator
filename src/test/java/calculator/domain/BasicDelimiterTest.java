package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class BasicDelimiterTest {

    @ParameterizedTest
    @ValueSource(chars = {',', ':'})
    @DisplayName("기본 구분자인 경우 true를 반환한다.")
    void should_ReturnTrue_When_InputIsBasicDelimiter(char input) {
        //when
        boolean result = BasicDelimiter.isBasicDelimiter(input);

        //then
        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(chars = {';', '|', '-', 'a', '1'})
    @DisplayName("기본 구분자가 아닌 경우 false를 반환한다.")
    void should_ReturnFalse_When_InputIsNotBasicDelimiter(char input) {
        // when
        boolean result = BasicDelimiter.isBasicDelimiter(input);

        // then
        Assertions.assertThat(result).isFalse();
    }
}