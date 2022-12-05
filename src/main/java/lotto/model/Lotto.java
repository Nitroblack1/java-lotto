package lotto.model;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    private int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void receiveBonusNumber(int bonus) {
        this.bonusNumber = bonus;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
