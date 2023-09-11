/**
 * Credits assets :
 * - Dices image : Mike Zuidgeest on Flaticon (https://www.flaticon.com/authors/mike-zuidgeest)
 * - Dice icon : smashingstocks on Flaticon (https://www.flaticon.com/authors/smashingstocks)
 */

package RollTheDice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class RollTheDice extends JFrame {
    private final int WINDOW_WIDTH = 720;
    private final int WINDOW_HEIGHT = 480;

    private JButton rollTheDiceButton;
    private ImageIcon[] diceImages;
    private JLabel diceLabel1;
    private JLabel diceLabel2;

    public RollTheDice() {
        // Frame Parameters
        setTitle("Roll the dice !");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0,0);

        // Dice images
        diceImages = new ImageIcon[6];
        for (int i = 0; i < 6; i++) {
            diceImages[i] = new ImageIcon("assets/png/dice" + (i + 1) + ".png");
        }
        System.out.println(Arrays.toString(diceImages));

        diceLabel1 = new JLabel();
        diceLabel2 = new JLabel();
        rollTheDiceButton = new JButton("Roll the Dice !");

        rollTheDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        setLayout(new FlowLayout());
        add(diceLabel1);
        add(diceLabel2);
        add(rollTheDiceButton);

        setVisible(true);
    }

    private void rollDice() {
        Random random = new Random();
        int dice1Value = random.nextInt(6) + 1;
        int dice2Value = random.nextInt(6) + 1;

        ImageIcon dice1Image = new ImageIcon("assets/png/dice" + dice1Value + ".png");
        ImageIcon dice2Image = new ImageIcon("assets/png/dice" + dice2Value + ".png");

        diceLabel1.setIcon(dice1Image);
        diceLabel2.setIcon(dice2Image);
        System.out.println(diceLabel1);
        System.out.println(diceLabel2);
        System.out.println(dice1Image);
        System.out.println(dice2Image);
    }
}
