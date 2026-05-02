import javax.swing.*;

public class ConfirmationGUI {

    public ConfirmationGUI() {

        JFrame frame = new JFrame("Success");
        frame.setSize(350,220);
        frame.setLayout(null);

        JLabel msg = new JLabel("Registration Successful!");
        msg.setBounds(90,60,200,30);
        frame.add(msg);

        frame.setVisible(true);
    }
}

