package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView OutputView = new OutputView();
        LottoManager lottoManager = new LottoManager();
        try {
            lottoManager.orderTickets(inputView.inputMoney(readLine()));
            OutputView.printTickets(lottoManager.getTickets().getTickets());
            lottoManager.receiveLottoNumber(inputView.inputLottoNumbers());
            lottoManager.receiveBonusNumber(inputView.inputBonusNumber());
            lottoManager.calculateWinResult();
            OutputView.printResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
