import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuessingGame extends JFrame {
    private int randomNumber;
    private int attempts;

    private JTextField guessField;
    private JLabel feedbackLabel;
    private JLabel attemptsLabel;

    public NumberGuessingGame() {
        // Set up the frame
        setTitle("Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new GridLayout(4, 1));

        // Generate a random number between 1 and 100
        randomNumber = (int) (Math.random() * 100) + 1;
        attempts = 0;

        // Create GUI components
        JLabel titleLabel = new JLabel("Guess the Number(1-100)");
        guessField = new JTextField();
        JButton guessButton = new JButton("Submit Guess");
        feedbackLabel = new JLabel("");
        attemptsLabel = new JLabel("");

        // Add components to the frame
        add(titleLabel);
        add(guessField);
        add(guessButton);
        add(feedbackLabel);
        add(attemptsLabel);

        // Add action listener to the guessButton
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(guessField.getText());
            attempts++;

            if (userGuess < randomNumber) {
                feedbackLabel.setText("Too Low! Try again.");
            } else if (userGuess > randomNumber) {
                feedbackLabel.setText("Too High! Try again.");
            } else {
                feedbackLabel.setText("Congratulations! You guessed the number.");
                attemptsLabel.setText("Number of attempts: " + attempts);
                guessField.setEnabled(false);
            }
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGuessingGame().setVisible(true);
            }
        });
    }
}
