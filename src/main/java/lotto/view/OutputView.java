package lotto.view;

import java.util.List;
import lotto.model.WinResult;

public class OutputView {

    public void printTickets(List<List<Integer>> tickets) {
        System.out.println("\n" + tickets.size() + PrintOuts.YOU_PURCHASED);
        for (List<Integer> ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public void printResult(double earningRate) {
        System.out.println("\n" + PrintOuts.WINNING_STATISTICS);
        for (WinResult winResult : WinResult.values()) {
            if (winResult.getWinNumber() == 5.5) {
                System.out.printf("5개 일치, 보너스 볼 일치 (" + winResult.getWinMoney() + "원) - %d개 \n",
                        winResult.getCount());
            } else {
                System.out.printf("%d개 일치 (" + winResult.getWinMoney() + "원) - %d개\n",
                        (int) winResult.getWinNumber(), winResult.getCount());
            }
        }
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
