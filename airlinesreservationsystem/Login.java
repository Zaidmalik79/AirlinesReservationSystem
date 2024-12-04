package airlinesreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton submit, reset, close, signup;
    JTextField tfusername;
    JPasswordField tfpassword;

    public Login() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinesreservationsystem/icons/login1.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 20, 1000, 650);
        add(image);

        JLabel heading = new JLabel("WINGS THAT CARE, FLIGHT THAT INSPIRE");
        heading.setBounds(133, 40, 1000, 40);
        heading.setForeground(Color.black);
        heading.setFont(new Font("Tahoma", Font.BOLD, 36));
        image.add(heading);

        JLabel heading2 = new JLabel("Welcome to PZ");
        heading2.setBounds(30, 200, 1000, 40);
        heading2.setForeground(Color.BLACK);
        heading2.setFont(new Font("Tahoma", Font.BOLD, 36));
        add(heading2);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 300, 100, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(130, 300, 200, 20);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20, 360, 100, 20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(130, 360, 200, 20);
        add(tfpassword);

        reset = new JButton("Reset");
        reset.setBounds(40, 420, 120, 20);
        reset.addActionListener(this);
        add(reset);

        submit = new JButton("Submit");
        submit.setBounds(190, 420, 120, 20);
        submit.addActionListener(this);
        add(submit);

        close = new JButton("Close");
        close.setBounds(120, 460, 120, 20);
        close.addActionListener(this);
        add(close);

        signup = new JButton("Signup");
        signup.setBounds(120, 500, 120, 20);
        signup.addActionListener(this);
        add(signup);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String username = tfusername.getText();
            String password = tfpassword.getText();

            try {
                Conn c = new Conn();

                String query = "select * from login where username = '" + username + "' and password = '" + password + "'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    new Home();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == close) {
            setVisible(false);
        } else if (ae.getSource() == reset) {
            tfusername.setText("");
            tfpassword.setText("");
        } else if (ae.getSource() == signup) {
            new Signup();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
