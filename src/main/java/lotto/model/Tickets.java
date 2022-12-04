package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tickets {
    private List<List<Integer>> tickets;

    public Tickets() {
        tickets = new ArrayList<>();
    }

    public void issueTickets(int number) {
        for(int i = 0; i < number; i++) {
            this.tickets.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    public List<List<Integer>> getTickets() {
        return this.tickets;
    }
}
