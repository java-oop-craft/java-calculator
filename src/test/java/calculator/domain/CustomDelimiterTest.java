package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CustomDelimiterTest {

    @Nested
    @DisplayName("실패 케이스")
    class Failure {

        @Test
        @DisplayName("숫자는 커스텀 구분자로 등록할 수 없다.")
        public void should_Throw_Exception_When_Delimiter_IsDigit() {
            // given
            Character invalidInput = '3';

            // when & then
            Assertions.assertThatThrownBy(() -> CustomDelimiter.create(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR]: 숫자는 커스텀 구분자로 등록할 수 없습니다.");
        }

        @ParameterizedTest
        @ValueSource(chars = {'a', 'z', '가', '나'})
        @DisplayName("특수 문자가 아닌 문자는 커스텀 구분자로 등록할 수 없다.")
        public void should_Throw_Exception_When_Delimiter_IsNot_SpecialCharacter(char input) {
            // given
            Character invalidInput = input;

            // when & then
            Assertions.assertThatThrownBy(() -> CustomDelimiter.create(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR]: 특수 문자가 아닌 문자는 커스텀 구분자로 등록할 수 없습니다.");
        }

        @ParameterizedTest
        @ValueSource(chars = {',', ':'})
        @DisplayName("기본 구분자는 커스텀 구분자로 등록할 수 없다.")
        public void should_Throw_Exception_When_Delimiter_Is_BasicDelimiter(char input) {
            //given
            Character invalidInput = input;

            // when & then
            Assertions.assertThatThrownBy(() -> CustomDelimiter.create(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR]: 기본 구분자는 커스텀 구분자로 등록할 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("성공 케이스")
    class Success {
        @ParameterizedTest
        @ValueSource(chars = {'@', '#', '$', '%', '!', '^'})
        @DisplayName("유효한 특수 문자는 커스텀 구분자로 등록할 수 있다.")
        public void should_Register_CustomDelimiter_When_ValidSpecialCharacter(char input) {
            // given
            CustomDelimiter customDelimiter = CustomDelimiter.create(input);

            // then
            Assertions.assertThat(true).isTrue();
        }
    }
}
