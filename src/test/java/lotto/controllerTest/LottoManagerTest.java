package lotto.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.controller.LottoManager;
import lotto.model.Lotto;
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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
        assertThat(lottoManager.getTickets().getTickets().size()).isEqualTo(8);
    }


}
