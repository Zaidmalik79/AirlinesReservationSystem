package airlinesreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    public Home() {
        setLayout(null);
        
        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinesreservationsystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1350, 650);
        add(image);
        
        // Heading text
        JLabel heading = new JLabel("PZ AIRLINES WELCOMES YOU");
        heading.setBounds(500, 40, 1000, 40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
        image.add(heading);
        
        // Menu bar and menu items
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        // Details menu
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        // Menu items under "Details"
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        // Ticket menu
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
        // Boarding Pass menu item inside the "Ticket" menu
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);  // Add ActionListener
        ticket.add(boardingPass);
        
        // Maximizing the window
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        
        if (text.equals("Add Customer Details")) {
            new AddCustomer();  // Open AddCustomer window
        } else if (text.equals("Flight Details")) {
            new FlightInfo();  // Open FlightInfo window
        } else if (text.equals("Book Flight")) {
            new BookFlight();  // Open BookFlight window
        } else if (text.equals("Journey Details")) {
            new JourneyDetails();  // Open JourneyDetails window
        } else if (text.equals("Cancel Ticket")) {
            new Cancel();  // Open Cancel window
        } else if (text.equals("Boarding Pass")) {
            new BoardingPass();  // Open BoardingPass window (This is the new action for Boarding Pass)
        }
    }
    
    public static void main(String[] args) {
        new Home();  // Create Home object and display the window
    }
}
