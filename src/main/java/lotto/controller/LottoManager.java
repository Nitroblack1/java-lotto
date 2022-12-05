package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Tickets;

public class LottoManager {

    private Tickets tickets;
    private Lotto lotto;

    public LottoManager() {
        this.tickets = new Tickets();
    }

    public void orderTickets(int money) {
        tickets.issueTickets(money / 1_000);
    }

    public void receiveLottoNumber(List<Integer> number) {
        lotto = new Lotto(number);
    }

    public void receiveBonusNumber(int bonus) {
        lotto.receiveBonusNumber(bonus);
    }

    public double calculateWinResult() {
        lotto.winNumber(this.tickets.getTickets());
        return lotto.calculateEarningRates(tickets.getTickets().size());
    }

    public Tickets getTickets() {
        return this.tickets;
    }

    public Lotto getLotto() {
        return this.lotto;
    }
}
