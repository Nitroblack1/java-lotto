package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            throw new IllegalArgumentException(ErrorMessages.INPUT_NUMBER);
        }
        if (Integer.parseInt(userInput) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_SHOULD_1_000_UNIT);
        }
        if (Integer.parseInt(userInput) >= 2_000_000_000) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_SHOULD_SMALLER_THAN_2BILLION);
        }
        return userInput;
    }

    public List<Integer> inputLottoNumbers() {
        System.out.println("\n" + PrintOuts.INPUT_LOTTO_NUMBERS);
        String userInput = readLine();
        return Arrays.stream(validateLottoNumbers(userInput).split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String validateLottoNumbers(String userInput) throws IllegalArgumentException {
        if (userInput.split(",").length != 6) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBERS_LENGTH_6);
        }
        for (String number : userInput.split(",")) {
            if (!number.matches("^[0-9]$")) {
                throw new IllegalArgumentException(ErrorMessages.INPUT_NUMBER);
            }
            if (Integer.parseInt(number) > 45 || Integer.parseInt(number) < 1) {
                throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_WRONG_FORMAT);
            }
        }
        return userInput;
    }

    public int inputBonusNumber() {
        System.out.println("\n" + PrintOuts.INPUT_BONUS_NUMBER);
        String userInput = readLine();
        return Integer.parseInt(validateBonusNumber(userInput));
    }

    private String validateBonusNumber(String bonusNumber) throws IllegalArgumentException {
        String pattern = "^[0-9]$";
        if (!bonusNumber.matches(pattern)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NUMBER);
        }
        if (Integer.parseInt(bonusNumber) > 45 || Integer.parseInt(bonusNumber) < 1) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_WRONG_FORMAT);
        }
        return bonusNumber;
    }
}
