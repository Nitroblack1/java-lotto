package lotto.controller;

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

    public Tickets getTickets() {
        return this.tickets;
    }
}
