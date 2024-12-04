package airlinesreservationsystem;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Random;

public class Home extends JFrame implements ActionListener{
    JLabel  labelfname, labelfcode;
    JButton   flight;
    Choice source, destination;
    
    
    public Home() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinesreservationsystem/icons/front1.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(500, 10, 900, 650);
        add(image);
        
        // Heading text
        JLabel heading = new JLabel("Connecting Dreams, One Flight at a Time");
        heading.setBounds(50, 40, 1000, 40);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.BOLD, 36));
        image.add(heading);
        
        JLabel heading2 = new JLabel("Search Your Flights Here");
        heading2.setBounds(35, 60, 1000, 40);
        heading2.setForeground(Color.black);
        heading2.setFont(new Font("Tahoma", Font.BOLD, 36));
        add(heading2);
        
       
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 200, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220, 200, 150, 25);       
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 250, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220, 250, 150, 25);       
        add(destination);
        
        try {
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(150, 400, 120, 25);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 300, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 300, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 350, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220, 350, 150, 25);
        add(labelfcode);
        
       
       

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
        if (ae.getSource() == flight){
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            try {
                Conn conn = new Conn();

                String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    labelfname.setText(rs.getString("f_name")); 
                    labelfcode.setText(rs.getString("f_code")); 
                } else {
                    JOptionPane.showMessageDialog(null, "No Flights Found");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else  {
            Random random = new Random();
            
            String flightname = labelfname.getText(); 
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem(); 
            String des = destination.getSelectedItem();
           
            
          
        }
        
    }
    
    public static void main(String[] args) {
        new Home();  // Create Home object and display the window
    }
}
