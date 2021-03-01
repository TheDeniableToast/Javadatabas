/**
 * This class is the GUI for the program
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoloLayout {

    public DatabasImport db;
    public JLabel title = new JLabel("Soloäventyr");
    public JTextPane Storytext;
    public JButton Button1;
    public JButton Button2;
    public JTextPane Option1;
    public JTextPane Option2;
    public JButton Reset;
    public JLabel Soloäventyr;
    public JPanel mainPanel;

    public SoloLayout() {
        /**This method implements elements into the GUI*/
        db = new DatabasImport();
        Storytext.setText(db.getBodyfromID(1));
        Option1.setText(db.getDescriptionfromStoryId(1));
        Option2.setText(db.getDescriptionfromStoryId(2));
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args) {
        /**This is the method that launches the program*/
        JFrame frame = new JFrame("SoloLayout");
        frame.setContentPane(new SoloLayout().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
