package cards;

public class Spades implements Card {

    private int color = 3;
    private String colorString = "Spades";
    private int denomination;
    private String denominationString;

    public Spades(int denomination, String denominationString) {
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