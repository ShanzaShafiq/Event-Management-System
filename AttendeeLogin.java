import javax.swing.*;
import java.util.ArrayList;

public class AttendeeLogin {

    static ArrayList<String> emails = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();

    public static void main(String[] args) {
        new loginScreen();
    }

    static class loginScreen {
        loginScreen() {
            JFrame frame = new JFrame("Attendee Login");
            frame.setSize(400,250);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);

            JLabel emailLabel = new JLabel("Email:");
            emailLabel.setBounds(50,40,80,25);
            frame.add(emailLabel);

            JTextField emailField = new JTextField();
            emailField.setBounds(130,40,200,25);
            frame.add(emailField);

            JLabel passLabel = new JLabel("Password:");
            passLabel.setBounds(50,80,80,25);
            frame.add(passLabel);

            JPasswordField passField = new JPasswordField();
            passField.setBounds(130,80,200,25);
            frame.add(passField);

            JButton loginBtn = new JButton("Login");
            loginBtn.setBounds(130,120,90,30);
            frame.add(loginBtn);

            JButton registerBtn = new JButton("Register");
            registerBtn.setBounds(240,120,90,30);
            frame.add(registerBtn);

            // Login action
            loginBtn.addActionListener(e -> {
                String email = emailField.getText();
                String pass = new String(passField.getPassword());
                boolean found = false;
                for(int i=0;i<emails.size();i++) {
                    if(emails.get(i).equals(email) && passwords.get(i).equals(pass)) {
                        JOptionPane.showMessageDialog(frame, "Login successful!");
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials!");
                }
            });

            // Register action
            registerBtn.addActionListener(e -> {
                String email = emailField.getText();
                String pass = new String(passField.getPassword());
                if(email.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter email & password!");
                } else if(emails.contains(email)) {
                    JOptionPane.showMessageDialog(frame, "Email already exists!");
                } else {
                    emails.add(email);
                    passwords.add(pass);
                    JOptionPane.showMessageDialog(frame, "Registration successful! Now login.");
                }
            });

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }
}
