package mySpring;

import javax.swing.*;

/**
 * Created by Jeka on 08/09/2016.
 */
public class PopupSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
