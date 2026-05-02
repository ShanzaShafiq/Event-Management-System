import javax.swing.*;

public class OrganizerGUI {

    public OrganizerGUI() {

        JFrame frame = new JFrame("Organizer - Create Event");
        frame.setSize(420,350);
        frame.setLayout(null);

        JLabel title = new JLabel("Create New Event");
        title.setBounds(140,20,200,30);
        frame.add(title);

        JLabel nameLabel = new JLabel("Event Name:");
        nameLabel.setBounds(40,80,100,25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(160,80,200,25);
        frame.add(nameField);

        JLabel feeLabel = new JLabel("Fee:");
        feeLabel.setBounds(40,120,100,25);
        frame.add(feeLabel);

        JTextField feeField = new JTextField();
        feeField.setBounds(160,120,200,25);
        frame.add(feeField);

        JButton createBtn = new JButton("Create Event");
        createBtn.setBounds(140,190,140,30);
        frame.add(createBtn);

        createBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,
                    "Event Created Successfully!");
        });

        frame.setVisible(true);
    }
}

