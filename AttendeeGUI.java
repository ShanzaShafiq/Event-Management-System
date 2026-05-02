import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AttendeeGUI {

    // Track registered events
    static ArrayList<AttendeeRegistration> registrations = new ArrayList<>();
    String attendeeEmail;

    // Constructor
    public AttendeeGUI(String email) {
        this.attendeeEmail = email;

        JFrame frame = new JFrame("Attendee Dashboard");
        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(52, 73, 94));

        JLabel title = new JLabel("Welcome, Attendee!");
        title.setBounds(120,30,300,30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(title);

        JButton viewEvents = new JButton("View Events");
        viewEvents.setBounds(170,100,160,40);
        styleButton(viewEvents, new Color(26, 188, 156), Color.WHITE);
        frame.add(viewEvents);

        JButton myRegistrations = new JButton("My Registrations");
        myRegistrations.setBounds(170,160,160,40);
        styleButton(myRegistrations, new Color(52, 152, 219), Color.WHITE);
        frame.add(myRegistrations);

        JButton logout = new JButton("Logout");
        logout.setBounds(170,220,160,40);
        styleButton(logout, new Color(231, 76, 60), Color.WHITE);
        frame.add(logout);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(10,300,100,30);
        styleButton(backBtn, new Color(149, 165, 166), Color.WHITE);
        frame.add(backBtn);

        // Actions
        viewEvents.addActionListener(e -> new EventGUI(attendeeEmail));
        myRegistrations.addActionListener(e -> {
            if(registrations.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No registrations yet.");
            } else {
                DefaultListModel<String> regModel = new DefaultListModel<>();
                for(AttendeeRegistration ar : registrations) {
                    if(ar.attendeeEmail.equals(attendeeEmail)) {
                        regModel.addElement(ar.eventName + " - " + ar.eventDate);
                    }
                }
                JList<String> regList = new JList<>(regModel);
                JScrollPane scroll = new JScrollPane(regList);
                scroll.setPreferredSize(new Dimension(300,200));
                JOptionPane.showMessageDialog(frame, scroll, "My Registrations", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        logout.addActionListener(e -> {
            frame.dispose();
            new RoleSelectionGUI(); // back to role selection
        });
        backBtn.addActionListener(e -> {
            frame.dispose();
            new RoleSelectionGUI();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Button styling
    private void styleButton(JButton btn, Color bgColor, Color fgColor) {
        btn.setBackground(bgColor);
        btn.setForeground(fgColor);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) { btn.setBackground(bgColor.darker()); }
            public void mouseExited(java.awt.event.MouseEvent evt) { btn.setBackground(bgColor); }
        });
    }

    // Static method to add registration
    public static void addRegistration(String eventName, String eventDate, String attendeeEmail) {
        registrations.add(new AttendeeRegistration(attendeeEmail, eventName, eventDate));
    }

    // Inner class for registration
    static class AttendeeRegistration {
        String attendeeEmail;
        String eventName;
        String eventDate;

        AttendeeRegistration(String email, String name, String date) {
            this.attendeeEmail = email;
            this.eventName = name;
            this.eventDate = date;
        }
    }
}
