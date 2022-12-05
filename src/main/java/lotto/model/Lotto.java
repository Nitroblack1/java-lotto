package lotto.model;

import java.util.ArrayList;
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

    public void winNumber(List<List<Integer>> tickets) {
        List<Double> winNumber = new ArrayList<>();
        for(List<Integer> ticket : tickets) {
            if ((int)ticket.stream().filter(this.numbers::contains).count() == 5) {
                if (ticket.contains(this.bonusNumber)) {
                    winNumber.add(5.5);
                    continue;
                }
            }
            winNumber.add((double)ticket.stream().filter(this.numbers::contains).count());
        }
        for(WinResult winResult : WinResult.values()) {
            while(winResult.getCount() < winNumber.stream().filter(e->e.equals(winResult.getWinNumber())).count()) {
                winResult.plusCount();
            }
        }
    }

    public void receiveBonusNumber(int bonus) {
        this.bonusNumber = bonus;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
