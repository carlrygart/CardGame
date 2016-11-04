package cards;

public class Hearts implements Card {

    private int color = 0;
    private String colorString = "Hearts";
    private int denomination;
    private String denominationString;

    public Hearts(int denomination, String denominationString) {
        this.denomination = denomination;
        this.denominationString = denominationString;
    }

    public int getColor() {
        return color;
    }

    public int getDenomination() {
        return denomination;
    }

    public String toString() {
        return denominationString + " of " + colorString;
    }
}