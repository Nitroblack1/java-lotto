package lotto.viewTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

public class InputViewTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Mock
    InputView inputView = new InputView();

    @Nested
    @DisplayName("입력 금액 테스트")
    class MoneyTest {

        @DisplayName("금액을 받아 검증 후 올바른 입력이면 반환한다.")
        @Test
        void right_Money() {
            String money = "8000";

            assertThat(inputView.inputMoney(money)).isEqualTo(Integer.parseInt(money));
        }

        @DisplayName("올바르지 않은 금액일 경우 [ERROR]가 포함된 에러 메시지를 출력한다.")
        @ParameterizedTest
        @ValueSource(strings = {"8100", "300", "2000000000", "hello"})
        void wrong_Money(String money) {

            assertThatThrownBy(() -> inputView.inputMoney(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

    @Nested
    @DisplayName("로또 번호 테스트")
    class LottoNumberTest {

        @DisplayName("올바른 로또 번호를 받으면 검증 후 이를 리스트로 리턴한다.")
        @Test
        void wright_Lotto_Number() {
            String lottoNumber = "1,2,3,4,5,6";
            List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
            InputStream in = new ByteArrayInputStream(lottoNumber.getBytes());
            System.setIn(in);

            assertThat(inputView.inputLottoNumbers()).isEqualTo(expected);
        }

        @DisplayName("올바르지 않은 금액일 경우 [ERROR]가 포함된 에러 메시지를 출력한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4", "46,1,2,3,4,5", "1,2,3,4,5,6,7", "hello,0,h,3,5,q",
                "1,2,3,4,5,5"})
        void wrong_Money(String lottoNumber) {
            InputStream in = new ByteArrayInputStream(lottoNumber.getBytes());
            System.setIn(in);

            assertThatThrownBy(() -> inputView.inputLottoNumbers())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

    @Nested
    @DisplayName("보너스 번호 테스트")
    class BonusNumberTest {

        @DisplayName("보너스 번호를 받아 검증 후 올바른 입력이면 반환한다.")
        @Test
        void right_Bonus_Number() {
            String money = "7";
            InputStream in = new ByteArrayInputStream(money.getBytes());
            System.setIn(in);

            assertThat(inputView.inputBonusNumber()).isEqualTo(Integer.parseInt(money));
        }

        @DisplayName("올바르지 않은 보너스 번호일 경우 [ERROR]가 포함된 에러 메시지를 출력한다.")
        @ParameterizedTest
        @ValueSource(strings = {"46", "0", "2,5", "h", "hello"})
        void wrong_Bonus_Number(String bonusNumber) {
            InputStream in = new ByteArrayInputStream(bonusNumber.getBytes());
            System.setIn(in);

            assertThatThrownBy(() -> inputView.inputBonusNumber())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }
}
