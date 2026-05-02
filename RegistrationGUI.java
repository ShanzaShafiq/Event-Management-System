import javax.swing.*;

public class RegistrationGUI {

    public RegistrationGUI(String event) {

        JFrame frame = new JFrame("Registration");
        frame.setSize(400,300);
        frame.setLayout(null);

        JLabel e = new JLabel(event);
        e.setBounds(50,30,300,25);
        frame.add(e);

        JTextField name = new JTextField();
        name.setBounds(100,80,200,25);
        frame.add(name);

        JButton next = new JButton("Proceed");
        next.setBounds(140,140,120,30);
        frame.add(next);

        next.addActionListener(x -> {
            frame.dispose();
            new PaymentGUI(event);
        });

        frame.setVisible(true);
    }
}

