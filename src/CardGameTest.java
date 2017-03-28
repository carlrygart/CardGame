import cards.Card;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests for the application CardGame.
 */
public class CardGameTest {

    private CardGame cg;

    @Before
    public void setUp() throws Exception {
        cg = new CardGame(2);
    }

    @Test
    public void mix() throws Exception {
        Card firstCard = cg.getCard(0);
        cg.mix();
        assertNotEquals(firstCard, cg.getCard(0));
    }

    @Test
    public void sort() throws Exception {
        cg.mix();
        cg.sort();
        assertEquals("Ace of Hearts", cg.getCard(0).toString());
        assertEquals("Ace of Hearts", cg.getCard(1).toString());
    }

    @Test
    public void draw() throws Exception {
        cg.sort();
        assertEquals("Ace of Hearts", cg.draw().toString() );
        assertEquals("Ace of Hearts", cg.draw().toString());
        assertEquals("Two of Hearts", cg.draw().toString());
        assertEquals("Two of Hearts", cg.draw().toString());
    }
}