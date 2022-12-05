package lotto.modelTest;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.model.Lotto;
import lotto.model.WinNumberStatus;
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
        mockedTickets.add(Arrays.asList(1,2,3,4,5,6));
        mockedTickets.add(Arrays.asList(1,3,5,7,9,11));
        mockedTickets.add(Arrays.asList(1,4,7,10,13,16));
        mockedTickets.add(Arrays.asList(2,4,6,8,10,11));
        Lotto lotto = new Lotto(List.of(2,4,6,8,10,12));
        lotto.receiveBonusNumber(11);

        lotto.winNumber(mockedTickets);
        assertThat(WinNumberStatus.THREE.getCount()).isEqualTo(1);
        assertThat(WinNumberStatus.FIVE_BONUS.getCount()).isEqualTo(1);
    }
}
