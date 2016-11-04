public class Clubs implements Card {

    private int color = 2;
    private String colorString = "Clubs";
    private int denomination;
    private String denominationString;

    public Clubs(int denomination, String denominationString) {
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