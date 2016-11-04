import cards.Card;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The Swing implementation and representation of the game CardGame.
 */
public class SwingImpl {

    private CardGame cg;

    private JFrame mainFrame;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel headerText;
    private JPanel buttonsPanel;
    private JPanel decksInputPanel;
    private JLabel decksInputText;
    private JTextField decksInputField;
    private JPanel statusTextPanel;
    private JLabel statusTextTitle;
    private JLabel statusText;
    private JLabel drawnCardsTitle;
    private JTextArea drawnCardsText;
    private JButton drawButton;

    public SwingImpl(){
        cg = new CardGame(2);
        prepareGUI();
    }

    public static void main(String[] args){
        SwingImpl swingImpl = new SwingImpl();
        swingImpl.fillPanelsWithContent();
    }

    /**
     * Prepares the main frame with all the objects that are about to show.
     */
    private void prepareGUI(){
        mainFrame = new JFrame("CardGame");
        mainFrame.setSize(440,440);
        mainFrame.setLayout(new GridLayout(1, 2));

        headerText = new JLabel("", JLabel.CENTER);
        headerText.setFont(new Font(Font.SANS_SERIF, 3, 20));

        decksInputPanel = new JPanel(new FlowLayout());
        decksInputText = new JLabel("");
        decksInputField = new JTextField();
        decksInputPanel.add(decksInputText);
        decksInputPanel.add(decksInputField);

        statusTextPanel = new JPanel(new BorderLayout());
        statusTextTitle = new JLabel("", JLabel.CENTER);
        statusTextTitle.setFont(new Font(Font.SANS_SERIF, 3, 15));
        statusText = new JLabel("", JLabel.CENTER);
        statusTextPanel.add(statusTextTitle, BorderLayout.NORTH);
        statusTextPanel.add(statusText, BorderLayout.CENTER);

        drawnCardsTitle = new JLabel("", JLabel.CENTER);
        drawnCardsTitle.setFont(new Font(Font.SANS_SERIF, 3, 15));
        drawnCardsText = new JTextArea();
        drawnCardsText.setBackground(null);
        drawnCardsText.setEditable(false);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(5, 1));
        rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        mainFrame.add(leftPanel);
        mainFrame.add(rightPanel);
        leftPanel.add(headerText);
        leftPanel.add(decksInputPanel);
        leftPanel.add(buttonsPanel);
        leftPanel.add(statusTextPanel);
        rightPanel.add(drawnCardsTitle, BorderLayout.NORTH);
        rightPanel.add(drawnCardsText);

        mainFrame.setVisible(true);
    }

    /**
     * Fills the frames with content.
     */
    private void fillPanelsWithContent(){
        headerText.setText("CardGame 1.0");
        statusTextTitle.setText("Current card");
        drawnCardsTitle.setText("Used cards");
        decksInputText.setText("Nbr of decks: ");
        decksInputField.setText("2");

        drawButton = new JButton("Draw");
        JButton sortButton = new JButton("Sort");
        JButton mixButton = new JButton("Mix");
        JButton resetGameButton = new JButton("Reset Game");

        drawButton.addActionListener(new OnClickListener());
        sortButton.addActionListener(new OnClickListener());
        mixButton.addActionListener(new OnClickListener());
        resetGameButton.addActionListener(new OnClickListener());

        drawButton.setActionCommand("Draw");
        sortButton.setActionCommand("Sort");
        mixButton.setActionCommand("Mix");
        resetGameButton.setActionCommand("Reset Game");

        buttonsPanel.add(drawButton);
        buttonsPanel.add(sortButton);
        buttonsPanel.add(mixButton);
        buttonsPanel.add(resetGameButton);

        mainFrame.setVisible(true);
    }

    /**
     * Listener class for the buttons in the SwingImpl.
     */
    private class OnClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "Draw":
                    Card card = cg.draw();
                    String cardText;
                    if (card == null) {
                        cardText = "No card left in deck...";
                        drawButton.setEnabled(false);
                    } else {
                        cardText = card.toString();
                        drawnCardsText.setText(cardText + "\n" + drawnCardsText.getText());
                    }
                    statusText.setText(cardText);
                    break;
                case "Sort":
                    cg.sort();
                    statusText.setText("Deck sorted!");
                    break;
                case "Mix":
                    cg.mix();
                    statusText.setText("Deck mixed!");
                    break;
                case "Reset Game":
                    String input = decksInputField.getText();
                    int nbrOfDecks;
                    try {
                        nbrOfDecks = Integer.parseInt(input);
                    } catch (NumberFormatException exception) {
                        nbrOfDecks = 1;
                    }
                    cg.resetGame(nbrOfDecks);
                    drawnCardsText.setText("");
                    drawButton.setEnabled(true);
                    statusText.setText("Game reset!");
                default:
                    break;
            }
        }
    }
}