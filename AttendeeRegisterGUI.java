import javax.swing.*;

public class AttendeeRegisterGUI {

    public AttendeeRegisterGUI() {

        JFrame frame = new JFrame("Attendee Registration");
        frame.setSize(400,300);
        frame.setLayout(null);

        JLabel emailLbl = new JLabel("Email:");
        emailLbl.setBounds(50,70,100,25);
        frame.add(emailLbl);

        JTextField emailField = new JTextField();
        emailField.setBounds(150,70,180,25);
        frame.add(emailField);

        JLabel passLbl = new JLabel("Password:");
        passLbl.setBounds(50,120,100,25);
        frame.add(passLbl);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150,120,180,25);
        frame.add(passField);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(140,180,120,30);
        frame.add(registerBtn);

        registerBtn.addActionListener(e -> {
            String email = emailField.getText();
            String pass = new String(passField.getPassword());

            if(email.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(frame,"Fill all fields");
                return;
            }

            UserStore.attendees.add(new Attendee(email, pass));
            JOptionPane.showMessageDialog(frame,"Registration Successful!");
            frame.dispose();
            new LoginGUI("Attendee");
        });

        frame.setVisible(true);
    }
}

