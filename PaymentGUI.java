import javax.swing.*;

public class PaymentGUI {

    public PaymentGUI(String event) {

        JFrame frame = new JFrame("Payment");
        frame.setSize(350,250);
        frame.setLayout(null);

        JLabel label = new JLabel(event);
        label.setBounds(50,40,300,25);
        frame.add(label);

        JButton pay = new JButton("Pay Now");
        pay.setBounds(110,100,120,30);
        frame.add(pay);

        pay.addActionListener(e -> {
            frame.dispose();
            new ConfirmationGUI();
        });

        frame.setVisible(true);
    }
}

