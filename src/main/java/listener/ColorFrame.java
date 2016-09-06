package listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Jeka on 06/09/2016.
 */
public class ColorFrame extends JFrame {
    public ColorFrame(Integer max) {
        setSize(500,500);
        JButton button = new JButton("click to change color");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                getContentPane().setBackground(new Color(random.nextInt(max),random.nextInt(max),random.nextInt(max)));
            }
        });

        getContentPane().add(button, BorderLayout.SOUTH);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
