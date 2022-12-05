package lotto.model;

public enum WinNumberStatus {

    THREE(3, "5,000"),
    FOUR(4, "50,000"),
    FIVE(5, "1,500,000"),
    FIVE_BONUS(5.5, "30,000,000"),
    SIX(6, "2,000,000,000");

    private double winNumber;
    private String winMoney;
    private int count;

    WinNumberStatus(double winNumber, String winMoney) {
        this.winNumber = winNumber;
        this.winMoney = winMoney;
    }

    public double getWinNumber() {
        return winNumber;
    }

    public String getWinMoney() {
        return winMoney;
    }

    public int getCount() {
        return this.count;
    }

    public void plusCount() {
        this.count++;
    }
}
