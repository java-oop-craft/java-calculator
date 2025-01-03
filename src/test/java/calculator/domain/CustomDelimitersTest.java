package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CustomDelimitersTest {

    @Nested
    @DisplayName("실패 케이스")
    class Failure {

        @ParameterizedTest
        @CsvSource({"@, @"})
        @DisplayName("등록하려는 커스텀 구분자는 기존 구분자와 중복될 수 없다")
        void should_Throw_Exception_When_CustomDelimiter_Is_Duplicate(Character alreadyRegistered, Character inputToRegister) {
            // given
            CustomDelimiters customDelimiters = CustomDelimiters.create();
            customDelimiters.register(alreadyRegistered);

            // when & then
            Assertions.assertThatThrownBy(() -> customDelimiters.register(inputToRegister))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR]: 이미 등록된 커스텀 구분자입니다.");
        }
    }

    @Nested
    @DisplayName("성공 케이스")
    class Success {

        @ParameterizedTest
        @CsvSource({"@, !"})
        @DisplayName("이미 존재하는 커스텀 구분자가 있을 때 새 구분자를 성공적으로 등록한다.")
        void should_Successfully_Register_NewCustomDelimiter_When_OtherDelimiterExists(Character alreadyRegistered, Character inputToRegister) {
            // given
            CustomDelimiters customDelimiters = CustomDelimiters.create();
            customDelimiters.register(alreadyRegistered);

            // when
            customDelimiters.register(inputToRegister);

            // then
            Assertions.assertThat(customDelimiters).isNotNull();
        }

        @ParameterizedTest
        @ValueSource(chars = {'@', '!', '%'})
        @DisplayName("빈 상태에서 커스텀 구분자를 성공적으로 등록한다.")
        void should_Successfully_Register_CustomDelimiter_When_Empty(Character inputToRegister) {
            // given
            CustomDelimiters customDelimiters = CustomDelimiters.create();

            // when
            customDelimiters.register(inputToRegister);

            // then
            Assertions.assertThat(customDelimiters).isNotNull();
        }
    }
}