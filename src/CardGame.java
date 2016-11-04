import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Main model class for the game.
 */
public class CardGame {

    private static final CardFactory cardFactory = new CardFactory();
    private LinkedList<Card> deck;

    public CardGame() {
        initiateCardGame(1);
    }

    public CardGame(int nbrOfDecks) {
        initiateCardGame(nbrOfDecks);
    }

    /**
     * Initiates the game by creating all the cards with the factory and puts them in the deck.
     * @param nbrOfDecks The chosen number of decks that will be used.
     */
    private void initiateCardGame(int nbrOfDecks) {
        deck = new LinkedList<>();
        for (int d = 0; d<nbrOfDecks; d++) {
            for (int color = 0; color<4; color++) {
                for (int den = 1; den<=13; den++) {
                    deck.add(cardFactory.createCard(color, den));
                }
            }
        }
    }

    /**
     * Mixes the deck of cards by randomly choose a card in the deck and put in a new deck.
     */
    public void mix() {
        Random rand = new Random();
        LinkedList<Card> mixedDeck = new LinkedList<>();
        int deckSize = deck.size();
        for (int i = 0; i<deckSize; i++) {
            int index = rand.nextInt(deck.size());
            mixedDeck.add(deck.get(index));
            deck.remove(index);
        }
        deck = mixedDeck;
    }

    /**
     * Sorts the cards in the deck according to the color and then denomination.
     */
    public void sort() {
        deck.sort(Comparator.comparing((Card card) -> card.getColor()).thenComparing(card -> card.getDenomination()));
    }

    /**
     * Draws and returns the top card in the deck until all the cards are drawn.
     * @return The top card.
     */
    public Card draw() {
        if (deck.isEmpty()) return null;
        return deck.poll();
    }

    /**
     * Resets the game with the requested number of decks.
     * @param nbrOfDecks The reqeusted number of decks.
     */
    public void resetGame(int nbrOfDecks) {
        initiateCardGame(nbrOfDecks);
    }

    /**
     * Returns a card in a specific position in the deck. Is mainly used for the JUnit testing.
     * @param index Index of the requested card.
     * @return The requested card.
     */
    public Card getCard(int index) {
        return deck.get(index);
    }
}
