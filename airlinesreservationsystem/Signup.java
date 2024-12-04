

package airlinesreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {
    JButton register, back;
    JTextField tfusername, tfname, tfemail;
    JPasswordField tfpassword;

    public Signup() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JLabel heading = new JLabel("Signup Page");
        heading.setBounds(150, 20, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(50, 80, 100, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 80, 150, 20);
        add(tfusername);

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50, 120, 100, 20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(150, 120, 150, 20);
        add(tfname);

        JLabel lblemail = new JLabel("Email:");
        lblemail.setBounds(50, 160, 100, 20);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(150, 160, 150, 20);
        add(tfemail);

        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setBounds(50, 200, 100, 20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 200, 150, 20);
        add(tfpassword);

        register = new JButton("Register");
        register.setBounds(50, 250, 100, 25);
        register.addActionListener(this);
        add(register);

        back = new JButton("Back");
        back.setBounds(200, 250, 100, 25);
        back.addActionListener(this);
        add(back);

        setSize(400, 400);
        setLocation(600, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == register) {
            String username = tfusername.getText();
            String name = tfname.getText();
            String email = tfemail.getText();
            String password = tfpassword.getText();

            try {
                Conn c = new Conn();
                String query = "insert into login(username, password) values('" + username + "', '" + password + "')";
                //String querya="insert into Signup(username, name, email, password) values('" + username + "', '" + name + "', '" + email + "', '" + password + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args){
        new Signup();
    }
}
