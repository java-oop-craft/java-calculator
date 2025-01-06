package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;

class DelimitersTest {

    @Nested
    @DisplayName("Delimiters 초기화 테스트")
    class Initialization {

        @Test
        @DisplayName("기본 구분자와 커스텀 구분자가 올바르게 초기화된다.")
        void should_Initialize_With_BasicAndCustomDelimiters() {
            // given
            CustomDelimiters customDelimiters = CustomDelimiters.create();
            customDelimiters.register('@');

            // when
            Delimiters delimiters = Delimiters.of(customDelimiters);

            // then
            Set<Character> expected = Set.of(',', ':', '@');
            Assertions.assertThat(delimiters.getDelimiters())
                    .containsExactlyInAnyOrderElementsOf(expected);
        }
    }

    @Nested
    @DisplayName("구분자 등록 테스트")
    class RegisterDelimiter {

        @Test
        @DisplayName("커스텀 구분자를 등록하면 구분자 목록에 추가된다.")
        void should_Add_CustomDelimiter_To_Delimiters() {
            // given
            CustomDelimiters customDelimiters = CustomDelimiters.create();
            Delimiters delimiters = Delimiters.of(customDelimiters);

            // when
            delimiters.registerDelimiter('#');

            // then
            Assertions.assertThat(delimiters.getDelimiters()).contains('#');
        }

        @Test
        @DisplayName("기본 구분자는 이미 포함되어 있다.")
        void should_AlreadyContain_BasicDelimiters() {
            // given
            Delimiters delimiters = Delimiters.of(CustomDelimiters.create());

            // when & then
            Assertions.assertThat(delimiters.getDelimiters())
                    .containsExactlyInAnyOrder(',', ':');
        }
    }

    @Nested
    @DisplayName("구분자 확인 테스트")
    class CheckDelimiter {

        @Test
        @DisplayName("등록된 구분자는 true를 반환한다.")
        void should_Return_True_For_RegisteredDelimiter() {
            // given
            CustomDelimiters customDelimiters = CustomDelimiters.create();
            Delimiters delimiters = Delimiters.of(customDelimiters);
            delimiters.registerDelimiter('#');

            // when
            boolean result = delimiters.isDelimiter('#');

            // then
            Assertions.assertThat(result).isTrue();
        }

        @Test
        @DisplayName("등록되지 않은 구분자는 false를 반환한다.")
        void should_Return_False_For_UnregisteredDelimiter() {
            // given
            Delimiters delimiters = Delimiters.of(CustomDelimiters.create());

            // when
            boolean result = delimiters.isDelimiter('&');

            // then
            Assertions.assertThat(result).isFalse();
        }
    }
}
