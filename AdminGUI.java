import javax.swing.*;

public class AdminGUI {

    public AdminGUI() {

        JFrame frame = new JFrame("Admin Panel");
        frame.setSize(400,300);
        frame.setLayout(null);

        JLabel title = new JLabel("Admin Dashboard");
        title.setBounds(140,20,200,30);
        frame.add(title);

        JButton manageUsers = new JButton("Manage Users");
        manageUsers.setBounds(120,70,160,30);
        frame.add(manageUsers);

        JButton manageEvents = new JButton("Manage Events");
        manageEvents.setBounds(120,120,160,30);
        frame.add(manageEvents);

        JButton reports = new JButton("View Reports");
        reports.setBounds(120,170,160,30);
        frame.add(reports);

        manageUsers.addActionListener(e -> {
            new ManageUsersGUI();
        });
        manageEvents.addActionListener(e -> {
            new ManageEventsGUI();  // open Manage Events GUI
        });
        reports.addActionListener(e -> {
            new ReportsGUI();
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


