
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoleSelectionGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Event Management System - Select Role");
        frame.setSize(500,350);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(45, 62, 80)); // Dark Blue Background
        frame.setLocationRelativeTo(null); // Center on screen

        // Title
        JLabel label = new JLabel("Welcome to Event Management System");
        label.setBounds(50,30,400,40);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label);

        // Admin Button
        JButton adminBtn = new JButton("ADMIN");
        adminBtn.setBounds(100,120,120,50);
        styleButton(adminBtn, new Color(26, 188, 156), Color.WHITE);
        frame.add(adminBtn);

        // Attendee Button
        JButton attendeeBtn = new JButton("ATTENDEE");
        attendeeBtn.setBounds(280,120,120,50);
        styleButton(attendeeBtn, new Color(231, 76, 60), Color.WHITE);
        frame.add(attendeeBtn);

        // Action Listeners
        adminBtn.addActionListener(e -> {
            frame.dispose();
            new LoginGUI("Admin");
        });

        attendeeBtn.addActionListener(e -> {
            frame.dispose();
            new LoginGUI("Attendee");
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Button styling method
    private static void styleButton(JButton btn, Color bgColor, Color fgColor) {
        btn.setBackground(bgColor);
        btn.setForeground(fgColor);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        // Hover effect
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
