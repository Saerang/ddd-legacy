package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperandTest {

    @DisplayName("더해질 숫자는 음수일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5})
    void negativeException(int negativeNumber) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new Operand(negativeNumber));
    }

    @DisplayName("정수 외 값은 더해질 숫자가 될 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"#", "AB", "C"})
    void negativeException(String invalidString) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> Operand.from(invalidString));
    }

    @DisplayName("공백이 주어질 경우 0으로 변환한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void convertToZero(String value) {
        assertThat(Operand.from(value)).isEqualTo(new Operand(0));
    }

    @DisplayName("null이 주어질 경우 0으로 변환한다.")
    @Test
    void convertToZero() {
        assertThat(Operand.from(null)).isEqualTo(new Operand(0));
    }
}