package lotto.view;

import java.util.List;

public class OutputView {
    public void printTickets(List<List<Integer>> tickets) {
        System.out.println("\n" + tickets.size() + PrintOuts.YOU_PURCHASED);
        for(List<Integer> ticket : tickets) {
            System.out.println(ticket);
        }
    }
}
