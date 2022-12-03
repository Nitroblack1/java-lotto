package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public InputView() {
        System.out.println(PrintOuts.INPUT_MONEY);
    }

    public int inputMoney(String userInput) {
        return Integer.parseInt(validateMoneyInput(userInput));
    }

    private String validateMoneyInput(String userInput) throws IllegalArgumentException {
        String pattern = "^[0-9]*$";
        if (!userInput.matches(pattern)) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_SHOULD_1_000_UNIT);
        }
        if (Integer.parseInt(userInput) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_SHOULD_1_000_UNIT);
        }
        if (Integer.parseInt(userInput) >= 2_000_000_000) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_SHOULD_SMALLER_THAN_2BILLION);
        }
        return userInput;
    }
}
