import cards.*;

import java.util.HashMap;

/**
 * Factory used to create new cards for the CardGame.
 */
public class CardFactory {

    private String[] inputStrings = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private HashMap<Integer, String> denominationStrings;

    public CardFactory() {
        denominationStrings = new HashMap<>();
        for (int i = 0; i<13; i++) {
            denominationStrings.put(Integer.valueOf(i+1), inputStrings[i]);
        }
    }

    /**
     * Creates a specific card depending on the parameters.
     * @param color Color index of the wanted card.
     * @param denomination Denomination of the wanted card, ie Queen == 12.
     * @return The wanted card.
     */
    public Card createCard(int color, int denomination) {
        switch (color) {
            case 0:
                return new Hearts(denomination, denominationStrings.get(Integer.valueOf(denomination)));
            case 1:
                return new Diamonds(denomination, denominationStrings.get(Integer.valueOf(denomination)));
            case 2:
                return new Clubs(denomination, denominationStrings.get(Integer.valueOf(denomination)));
            case 3:
                return new Spades(denomination, denominationStrings.get(Integer.valueOf(denomination)));
            default:
                return null;
        }
    }
}
