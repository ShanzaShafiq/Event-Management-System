import javax.swing.*;
import java.awt.*;

public class ReportsGUI {

    public ReportsGUI() {

        JFrame frame = new JFrame("Reports Dashboard");
        frame.setSize(450,350);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(44, 62, 80));

        JLabel title = new JLabel("System Reports");
        title.setBounds(120,20,300,30);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        frame.add(title);

        // Sample report data
        JLabel eventsCount = new JLabel("Total Events: 3");
        eventsCount.setBounds(120,80,250,25);
        eventsCount.setFont(new Font("Tahoma", Font.BOLD, 16));
        eventsCount.setForeground(Color.WHITE);
        frame.add(eventsCount);

        JLabel registrationsCount = new JLabel("Total Registrations: 5");
        registrationsCount.setBounds(120,120,250,25);
        registrationsCount.setFont(new Font("Tahoma", Font.BOLD, 16));
        registrationsCount.setForeground(Color.WHITE);
        frame.add(registrationsCount);

        JLabel attendeesCount = new JLabel("Total Attendees: 3");
        attendeesCount.setBounds(120,160,250,25);
        attendeesCount.setFont(new Font("Tahoma", Font.BOLD, 16));
        attendeesCount.setForeground(Color.WHITE);
        frame.add(attendeesCount);

        // Buttons
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(120,220,100,35);
        styleButton(backBtn, new Color(127, 140, 141), Color.WHITE);
        frame.add(backBtn);

        JButton closeBtn = new JButton("Close");
        closeBtn.setBounds(240,220,100,35);
        styleButton(closeBtn, new Color(192, 57, 43), Color.WHITE);
        frame.add(closeBtn);

        // Button actions
        backBtn.addActionListener(e -> {
            frame.dispose();
            new AdminGUI(); // Return to Admin Dashboard
        });

        closeBtn.addActionListener(e -> frame.dispose());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Style button with hover effect
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
