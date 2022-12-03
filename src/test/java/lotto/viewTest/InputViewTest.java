package lotto.viewTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import lotto.view.InputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

public class InputViewTest {

    @Mock
    InputView inputView = new InputView();

    @Nested
    @DisplayName("입력 금액 테스트")
    class validateInput {

        @DisplayName("올바른 금액일 경우")
        @Test
        void rightMoneyInput() {
            String money = "8000";

            assertThat(inputView.inputMoney(money)).isEqualTo(Integer.parseInt(money));
        }

        @DisplayName("올바르지 않은 금액일 경우")
        @ParameterizedTest
        @ValueSource(strings = {"8100", "300", "2000000000", "hello"})
        void wrongMoneyTest(String money) {

            assertThatThrownBy(() -> inputView.inputMoney(money))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
