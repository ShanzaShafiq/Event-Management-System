import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManageEventsGUI {

    DefaultListModel<String> eventModel = new DefaultListModel<>();

    public ManageEventsGUI() {

        JFrame frame = new JFrame("Manage Events");
        frame.setSize(600,450);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(52, 73, 94));

        JLabel title = new JLabel("Event Management");
        title.setBounds(180,20,300,30);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        frame.add(title);

        // Sample events
        eventModel.addElement("SE Workshop - 20-Oct-2026 - Rs.2000");
        eventModel.addElement("AI Conference - 25-Oct-2026 - Rs.3000");
        eventModel.addElement("Tech Seminar - 30-Oct-2026 - Free");

        JList<String> eventList = new JList<>(eventModel);
        eventList.setFont(new Font("Tahoma", Font.PLAIN, 16));
        JScrollPane scroll = new JScrollPane(eventList);
        scroll.setBounds(80,70,420,160);
        scroll.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        frame.add(scroll);

        // Buttons
        JButton addBtn = new JButton("Add Event");
        addBtn.setBounds(80,250,120,40);
        styleButton(addBtn, new Color(39, 174, 96), Color.WHITE);
        frame.add(addBtn);

        JButton editBtn = new JButton("Edit Event");
        editBtn.setBounds(220,250,120,40);
        styleButton(editBtn, new Color(41, 128, 185), Color.WHITE);
        frame.add(editBtn);

        JButton deleteBtn = new JButton("Delete Event");
        deleteBtn.setBounds(360,250,140,40);
        styleButton(deleteBtn, new Color(192, 57, 43), Color.WHITE);
        frame.add(deleteBtn);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(220,310,140,40);
        styleButton(backBtn, new Color(127, 140, 141), Color.WHITE);
        frame.add(backBtn);

        // ADD EVENT
        addBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame,"Enter Event Name:");
            String date = JOptionPane.showInputDialog(frame,"Enter Event Date (dd-MMM-yyyy):");
            String fee = JOptionPane.showInputDialog(frame,"Enter Fee (0 for Free):");

            if(name != null && date != null && fee != null) {
                String feeText = fee.equals("0") ? "Free" : "Rs." + fee;
                eventModel.addElement(name + " - " + date + " - " + feeText);
            }
        });

        // EDIT EVENT
        editBtn.addActionListener(e -> {
            int index = eventList.getSelectedIndex();
            if(index != -1) {
                String oldData = eventModel.getElementAt(index);
                String[] parts = oldData.split(" - ");
                String name = JOptionPane.showInputDialog(frame,"Edit Event Name:", parts[0]);
                String date = JOptionPane.showInputDialog(frame,"Edit Event Date:", parts[1]);
                String fee = JOptionPane.showInputDialog(frame,"Edit Fee:", parts[2].replace("Rs.","").replace("Free","0"));

                if(name != null && date != null && fee != null) {
                    String feeText = fee.equals("0") ? "Free" : "Rs." + fee;
                    eventModel.setElementAt(name + " - " + date + " - " + feeText, index);
                }
            } else {
                JOptionPane.showMessageDialog(frame,"Select an event to edit");
            }
        });

        // DELETE EVENT
        deleteBtn.addActionListener(e -> {
            int index = eventList.getSelectedIndex();
            if(index != -1) {
                int confirm = JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to delete this event?",
                        "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION)
                    eventModel.remove(index);
            } else {
                JOptionPane.showMessageDialog(frame,"Select an event to delete");
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
