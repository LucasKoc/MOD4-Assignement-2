/**
 * Class RollTheDice
 * Generate a frame which will store an image of the dice and a button to roll the dice (1 to 6).
 *
 * Credits assets :
 * - Dice images : Mike Zuidgeest on Flaticon (https://www.flaticon.com/authors/mike-zuidgeest)
 *
 * @author SOLAN Tao & KOCOGLU Lucas
 * @version N/A
 * @since 2023-09-08
 */

package RollTheDice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RollTheDice extends JFrame {

    // Window size
    private final int WINDOW_WIDTH = 408;
    private final int WINDOW_HEIGHT = 166;

    private JButton rollTheDiceButton; // Button to roll the dice
    private ImageIcon[] diceImages; // Array of dices images
    private JLabel diceLabel1; // Label to store the image1
    private JLabel diceLabel2; // Label to store the image2

    /**
     * Constructor of the class RollTheDice
     * It set the frame parameters and load dices images, add an ActionListener and display the frame
     */
    public RollTheDice() {
        // Frame Parameters : Title, window size, close operation and initial location of the window.
        setTitle("Roll the dice !");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Store the path of images into the array diceImages
        diceImages = new ImageIcon[6]; // Array of six ImageIcon
        for (int i = 0; i < 6; i++) {
            // Images names is set to the dice number (ex: 1 -> dice1.png), images are stored into 'assets/png/diceX.png'
            diceImages[i] = new ImageIcon(getClass().getResource("assets/png/dice" + (i + 1) + ".png"));
        }

        // Settings of labels & buttons
        diceLabel1 = new JLabel("Please roll", SwingConstants.CENTER);
        diceLabel2 = new JLabel("the dice", SwingConstants.CENTER);
        diceLabel1.setPreferredSize(new Dimension(128, 128));
        diceLabel2.setPreferredSize(new Dimension(128, 128));
        rollTheDiceButton = new JButton("Roll the Dice !");

        // Action Listener, when the user click on the rollTheDiceButton, launch rollDice() function.
        rollTheDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        // Display the frame
        setLayout(new FlowLayout());
        add(diceLabel1);
        add(diceLabel2);
        add(rollTheDiceButton);
        setVisible(true);
    }

    /**
     * Function rollDice
     * Will instantiate a variable from Random class
     * Store a random number between 1 to 6
     * Set the Image to the diceLabel1 (and remove its text)
     * And resize the window to match the label size (by default, no needed because WINDOW_WIDTH/WINDOW_HEIGHT)
     *  already at the good size.
     */
    private void rollDice() {
        // Instantiate random variable to generate the dice number
        Random random = new Random();
        int dice1Value = random.nextInt(6);
        int dice2Value = random.nextInt(6);

        // Catch the dice from diceImages(Array) and reshape the image to a 128*128 size.
        diceLabel1.setIcon(new ImageIcon(diceImages[dice1Value].getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT)));
        diceLabel2.setIcon(new ImageIcon(diceImages[dice2Value].getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT)));
        diceLabel1.setText(null);
        diceLabel2.setText(null);

        // Pack will resize the window to match labels max width/height.
        pack();
    }
}
