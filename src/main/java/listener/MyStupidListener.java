package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jeka on 06/09/2016.
 */
public class MyStupidListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(123);
    }
}
