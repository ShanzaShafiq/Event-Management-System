import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManageUsersGUI {

    DefaultListModel<String> userModel = new DefaultListModel<>();

    public ManageUsersGUI() {

        JFrame frame = new JFrame("Manage Users");
        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(44, 62, 80));

        JLabel title = new JLabel("User Management");
        title.setBounds(140,20,300,30);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        frame.add(title);

        // Sample users
        userModel.addElement("admin@gmail.com - Admin");
        userModel.addElement("organizer@gmail.com - Organizer");
        userModel.addElement("user@gmail.com - Attendee");

        JList<String> userList = new JList<>(userModel);
        userList.setFont(new Font("Tahoma", Font.PLAIN, 16));
        JScrollPane scroll = new JScrollPane(userList);
        scroll.setBounds(80,70,330,150);
        scroll.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        frame.add(scroll);

        // Buttons
        JButton addBtn = new JButton("Add User");
        addBtn.setBounds(80,250,120,40);
        styleButton(addBtn, new Color(39, 174, 96), Color.WHITE);
        frame.add(addBtn);

        JButton deleteBtn = new JButton("Delete User");
        deleteBtn.setBounds(230,250,120,40);
        styleButton(deleteBtn, new Color(192, 57, 43), Color.WHITE);
        frame.add(deleteBtn);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(180,310,120,40);
        styleButton(backBtn, new Color(127, 140, 141), Color.WHITE);
        frame.add(backBtn);

        // ADD USER
        addBtn.addActionListener(e -> {
            String email = JOptionPane.showInputDialog(frame, "Enter user email:");
            if(email == null || email.isEmpty()) return;

            String[] roles = {"Admin", "Organizer", "Attendee"};
            String role = (String) JOptionPane.showInputDialog(frame,
                    "Select role:", "User Role",
                    JOptionPane.QUESTION_MESSAGE, null, roles, roles[0]);

            if(role != null) {
                userModel.addElement(email + " - " + role);
            }
        });

        // DELETE USER
        deleteBtn.addActionListener(e -> {
            int index = userList.getSelectedIndex();
            if(index != -1) {
                int confirm = JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to delete this user?",
                        "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION)
                    userModel.remove(index);
            } else {
                JOptionPane.showMessageDialog(frame,"Please select a user first");
            }
        });

        // BACK BUTTON
        backBtn.addActionListener(e -> {
            frame.dispose();
            new AdminGUI(); // return to Admin Dashboard
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Style button with hover effect
    private void styleButton(JButton btn, Color bgColor, Color fgColor) {
        btn.setBackground(bgColor);
        btn.setForeground(fgColor);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
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
