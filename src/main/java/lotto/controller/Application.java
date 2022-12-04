package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        InputView inputView = new InputView();
        OutputView OutputView = new OutputView();
        lottoManager.orderTickets(inputView.inputMoney(readLine()));
//        OutputView.printTickets();
        lottoManager.receiveLottoNumber(inputView.inputLottoNumbers(readLine()));
//        inputView.inputBonusNumber(readLine());
//        OutputView.printResult();
    }
}
