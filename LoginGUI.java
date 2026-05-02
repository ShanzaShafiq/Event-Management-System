import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoginGUI {

    static int adminAttempts = 0; // Only for Admin
    static String role;

    public LoginGUI(String selectedRole) {
        role = selectedRole;

        JFrame frame = new JFrame(role + " Login");
        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(52, 73, 94)); // Dark background

        // Title
        JLabel title = new JLabel(role + " Login");
        title.setBounds(160,30,300,30);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        frame.add(title);

        if(role.equals("Admin")) {
            adminLogin(frame);
        } else if(role.equals("Attendee")) {
            attendeeLogin(frame);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // ====== ADMIN LOGIN ======
    private void adminLogin(JFrame frame) {
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(60,90,100,25);
        emailLabel.setForeground(Color.WHITE);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(160,90,200,25);
        frame.add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(60,140,100,25);
        passLabel.setForeground(Color.WHITE);
        frame.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(160,140,200,25);
        frame.add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(160,200,120,40);
        styleButton(loginBtn, new Color(231, 76, 60), Color.WHITE);
        frame.add(loginBtn);

        loginBtn.addActionListener(e -> {
            String email = emailField.getText().trim();
            String pass = new String(passField.getPassword()).trim();

            if(email.equals("admin@gmail.com") && pass.equals("admin")) {
                frame.dispose();
                new AdminGUI(); // Admin Dashboard
            } else {
                adminAttempts++;
                if(adminAttempts < 3) {
                    JOptionPane.showMessageDialog(frame,
                            "Wrong credentials! Attempts left: " + (3 - adminAttempts));
                } else {
                    JOptionPane.showMessageDialog(frame,"Too many attempts! System exiting.");
                    System.exit(0);
                }
            }
        });
    }

    // ====== ATTENDEE LOGIN / REGISTER ======
    private void attendeeLogin(JFrame frame) {
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(60,90,100,25);
        emailLabel.setForeground(Color.WHITE);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(160,90,200,25);
        frame.add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(60,140,100,25);
        passLabel.setForeground(Color.WHITE);
        frame.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(160,140,200,25);
        frame.add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(100,200,120,35);
        styleButton(loginBtn, new Color(39, 174, 96), Color.WHITE);
        frame.add(loginBtn);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(250,200,120,35);
        styleButton(registerBtn, new Color(41, 128, 185), Color.WHITE);
        frame.add(registerBtn);

        loginBtn.addActionListener(e -> {
            String email = emailField.getText().trim();
            String pass = new String(passField.getPassword()).trim();
            boolean found = false;

            for(Attendee a : UserStore.attendees) {
                if(a.email.equals(email) && a.password.equals(pass)) {
                    found = true;
                    frame.dispose();
                    new AttendeeGUI(email); // pass email to dashboard
                    break;
                }
            }

            if(!found) {
                JOptionPane.showMessageDialog(frame,"Invalid Attendee Credentials!");
            }
        });

        registerBtn.addActionListener(e -> {
            frame.dispose();
            new AttendeeRegisterGUI(); // New attendee registration
        });
    }

    // Button style with hover effect
    private void styleButton(JButton btn, Color bgColor, Color fgColor) {
        btn.setBackground(bgColor);
        btn.setForeground(fgColor);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(bgColor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(bgColor);
            }
        });
    }
}
