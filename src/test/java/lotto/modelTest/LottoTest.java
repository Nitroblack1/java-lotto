package lotto.modelTest;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.model.Lotto;
import lotto.model.WinResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 결과 테스트")
    @Test
    void returnWinNumber() {
        List<List<Integer>> mockedTickets = new ArrayList<>();
        mockedTickets.add(Arrays.asList(1,2,3,4,5,6)); // 3
        mockedTickets.add(Arrays.asList(1,3,5,7,9,11)); // 0
        mockedTickets.add(Arrays.asList(1,4,7,10,13,16)); // 1
        mockedTickets.add(Arrays.asList(2,4,6,8,10,11)); // 5.5
        mockedTickets.add(Arrays.asList(2,4,6,8,10,13)); // 5
        mockedTickets.add(Arrays.asList(2,4,6,8,10,14)); // 5

        Lotto lotto = new Lotto(List.of(2,4,6,8,10,12));
        lotto.receiveBonusNumber(11);

        lotto.winNumber(mockedTickets);
        assertThat(WinResult.THREE.getCount()).isEqualTo(1);
        assertThat(WinResult.FIVE_BONUS.getCount()).isEqualTo(1);
        assertThat(WinResult.FIVE.getCount()).isEqualTo(2);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculate_earning_rate() {
        List<List<Integer>> mockedTickets = new ArrayList<>();
        mockedTickets.add(Arrays.asList(1,2,3,4,5,6)); // 3
        mockedTickets.add(Arrays.asList(1,3,5,7,9,11)); // 0

        Lotto lotto = new Lotto(List.of(2,4,6,8,10,12));
        lotto.receiveBonusNumber(11);

        lotto.winNumber(mockedTickets);
        assertThat(lotto.calculateEarningRates(mockedTickets.size())).isEqualTo(250.0);
    }
}
