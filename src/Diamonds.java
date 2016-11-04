public class Diamonds implements Card {

    private int color = 1;
    private String colorString = "Diamonds";
    private int denomination;
    private String denominationString;

    public Diamonds(int denomination, String denominationString) {
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