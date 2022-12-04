package lotto.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.controller.LottoManager;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class LottoManagerTest {

    @Mock
    LottoManager lottoManager = new LottoManager();
    InputView inputView = new InputView();

    @DisplayName("구입 금액에 해당하는 매수를 Tickets 에 보내면 Tickets 에 티켓들을 저장한다.")
    @Test
    void issue_as_much_as_money_input() {
        String money = "8000";

        lottoManager.orderTickets(inputView.inputMoney(money));
        System.out.println(lottoManager.getTickets().getTickets());
        assertThat(lottoManager.getTickets().getTickets().size()).isEqualTo(8);
    }

    @DisplayName("당첨 번호를 전달받으면 이를 Lotto 에 보낸다.")
    @Test
    void pass_lotto_number_to_Lotto() {
        String lottoNumber = "1,2,3,4,5,6";
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        InputStream in = new ByteArrayInputStream(lottoNumber.getBytes());
        System.setIn(in);

        lottoManager.receiveLottoNumber(inputView.inputLottoNumbers());
        assertThat(lottoManager.getLotto().getNumbers()).isEqualTo(expected);
    }

    @DisplayName("보너스 번호를 받으면 이를 Lotto 에 보낸다.")
    @Test
    void pass_bonus_number_to_LottoManager() {
        String bonusNumber = "7";
        InputStream in = new ByteArrayInputStream(bonusNumber.getBytes());
        System.setIn(in);

        lottoManager.receiveLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoManager.receiveBonusNumber(inputView.inputBonusNumber());
        assertThat(lottoManager.getLotto().getBonusNumber()).isEqualTo(
                Integer.parseInt(bonusNumber));
    }
}
