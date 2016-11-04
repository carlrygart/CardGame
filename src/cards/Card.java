package cards;

/**
 * This interface is used for the four different card classes. However, this can also be used for other
 * types of cards, ie. Jokers etc.
 */
public interface Card {

    /**
     * Returns the denomination of the card.
     * @return The denomination.
     */
    int getDenomination();

    /**
     * Returns the color index of the card (ie cards.Hearts, cards.Diamonds etc.)
     * @return The color index.
     */
    int getColor();

    /**
     * Returns a string regarding the card.
     * @return The name of the card.
     */
    String toString();
}
