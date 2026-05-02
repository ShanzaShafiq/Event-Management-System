import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventGUI {

    ArrayList<Event> events = new ArrayList<>();
    String attendeeEmail;

    public EventGUI(String email) {
        this.attendeeEmail = email;
        initialize();
    }

    private void initialize() {
        events.add(new Event("SE Workshop", "20-Oct-2026", 2000));
        events.add(new Event("AI Conference", "25-Oct-2026", 3000));
        events.add(new Event("Tech Seminar", "30-Oct-2026", 0));

        JFrame frame = new JFrame("Available Events");
        frame.setSize(550,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(52, 73, 94));

        JLabel title = new JLabel("Available Events");
        title.setBounds(180,20,200,30);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        frame.add(title);

        DefaultListModel<String> eventModel = new DefaultListModel<>();
        for(Event e : events) {
            String feeText = (e.fee > 0) ? "Rs." + e.fee : "Free";
            eventModel.addElement(e.name + " - " + e.date + " - " + feeText);
        }

        JList<String> eventList = new JList<>(eventModel);
        JScrollPane scroll = new JScrollPane(eventList);
        scroll.setBounds(80,70,380,150);
        frame.add(scroll);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(150,250,120,40);
        frame.add(registerBtn);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(300,250,120,40);
        frame.add(backBtn);

        eventList.addListSelectionListener(e -> registerBtn.setEnabled(!eventList.isSelectionEmpty()));

        registerBtn.addActionListener(e -> {
            int index = eventList.getSelectedIndex();
            if(index != -1) {
                Event selectedEvent = events.get(index);
                String eventName = selectedEvent.name + " (" + selectedEvent.date + ")";

                if(selectedEvent.fee > 0) {
                    String input = JOptionPane.showInputDialog(frame,
                            "Event Fee: Rs." + selectedEvent.fee + "\nEnter amount to pay:");
                    try {
                        double paid = Double.parseDouble(input);
                        if(paid >= selectedEvent.fee) {
                            JOptionPane.showMessageDialog(frame,
                                    "Registration successful!\nPayment received: Rs." + paid);
                            AttendeeGUI.addRegistration(eventName, selectedEvent.date, attendeeEmail);
                        } else {
                            JOptionPane.showMessageDialog(frame,
                                    "Insufficient amount! Registration failed.");
                        }
                    } catch(Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid input! Registration failed.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Registration successful! This is a free event.");
                    AttendeeGUI.addRegistration(eventName, selectedEvent.date, attendeeEmail);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select an event first.");
            }
        });

        backBtn.addActionListener(e -> {
            frame.dispose();
            new AttendeeGUI(attendeeEmail);
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    class Event {
        String name;
        String date;
        double fee;
        Event(String name, String date, double fee) { this.name=name; this.date=date; this.fee=fee; }
    }
}
