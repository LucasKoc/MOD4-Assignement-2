/**
 * Credits assets :
 * - Dices image : Mike Zuidgeest on Flaticon (https://www.flaticon.com/authors/mike-zuidgeest)
 * - Dice icon : smashingstocks on Flaticon (https://www.flaticon.com/authors/smashingstocks)
 */

package RollTheDice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RollTheDice extends JFrame {
    private final int WINDOW_WIDTH = 275;
    private final int WINDOW_HEIGHT = 166;

    private JButton rollTheDiceButton;
    private ImageIcon[] diceImages;
    private JLabel diceLabel1;

    public RollTheDice() {
        // Frame Parameters
        setTitle("Roll the dice !");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Dice images
        diceImages = new ImageIcon[6];
        for (int i = 0; i < 6; i++) {
            diceImages[i] = new ImageIcon(getClass().getResource("assets/png/dice" + (i + 1) + ".png"));
        }

        diceLabel1 = new JLabel("Please roll", SwingConstants.CENTER);
        diceLabel1.setPreferredSize(new Dimension(128, 128));
        rollTheDiceButton = new JButton("Roll the Dice !");

        rollTheDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        setLayout(new FlowLayout());
        add(diceLabel1);
        add(rollTheDiceButton);

        setVisible(true);
    }

    private void rollDice() {
        Random random = new Random();
        int dice1Value = random.nextInt(6);

        diceLabel1.setIcon(new ImageIcon(diceImages[dice1Value].getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT)));
        diceLabel1.setText(null);

        pack();
    }
}
