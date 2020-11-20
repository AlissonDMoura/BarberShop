/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_shop;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author aliss
 */
public class Barber_Shop extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
       //dbConector.getConnection();
        
        // LoginPage();
        //RegisterPage();
        //CustomerPage();
                
    }
    
    
    private static void LoginPage(){
            
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel labEmail = new JLabel("E-mail");
        JLabel labPassword = new JLabel("Password");
        JTextField txtEmail = new JTextField(20);
        JPasswordField txtPassword = new JPasswordField(20);
        JButton loginButton = new JButton("Sign in");
        JButton registerButton = new JButton("Register");
        //Frame created, Panel created, E-mail label created
        
        frame.setSize(440, 180);
        frame.setTitle("Login into BarberShop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        //
        
        panel.setVisible(true);
        panel.setLayout(null);
        panel.add(labEmail);
        panel.add(txtEmail);
        panel.add(labPassword);
        panel.add(txtPassword);
        panel.add(loginButton);
        panel.add(registerButton);
        //
        
        labEmail.setBounds(43, 20, 50, 20);
        txtEmail.setBounds(90, 20, 200, 20);
        
        labPassword.setBounds(20, 50, 80, 20);
        txtPassword.setBounds(90, 50, 200, 20);
        
        
        loginButton.setBounds(300, 30, 100, 20);
                
        registerButton.setBounds(90, 100, 200, 30);
        //
    }
    
    private static void RegisterPage(){
            
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        
        //All Labels
        JLabel labEmail = new JLabel("E-mail");
        JLabel labPassword = new JLabel("Password");
        JLabel labPassword2 = new JLabel("Confirm Password");
        JLabel labName = new JLabel("User Name");
        JLabel labSurname = new JLabel("Surname");
        JLabel labPhone = new JLabel("Phone");
        JLabel labLocation = new JLabel("Location");
        
        //All Text fields and password Fields
        JTextField txtEmail = new JTextField(20);
        JTextField txtName = new JTextField(20);
        JTextField txtSurname = new JTextField(20);
        JTextField txtPhone = new JTextField(20);
        JTextField txtLocation = new JTextField(20);
        JPasswordField txtPassword = new JPasswordField(20);
        JPasswordField txtPassword2 = new JPasswordField(20);
        
        //Regular Buttons 
        JButton LoginPageButton = new JButton("Go Back");
        JButton registerButton = new JButton("Register me");
        
        //Radio buttons group together for further selection.
        String[] userType = {"Hairdresser", "Customer"};
        JRadioButton hairDButton = new JRadioButton(userType[0]);
        JRadioButton customerButton = new JRadioButton(userType[1]);
        ButtonGroup typeSelect = new ButtonGroup();
        customerButton.setSelected(true);
        typeSelect.add(hairDButton);
        typeSelect.add(customerButton);
        
        
        //Frame Settings
        frame.setSize(350, 500);
        frame.setTitle("Register into BarberShop's");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        
        //Panel visisible, and layout null, so I can position every item by coordinates.
        panel.setVisible(true);
        panel.setLayout(null);

        
            
        
        //Add labels and text boxes onto the panel, and position the coordinates.
        labName.setBounds(20, 50, 80, 20);
        txtName.setBounds(110, 50, 200, 20);
        panel.add(labName);
        panel.add(txtName);
        
        labSurname.setBounds(20, 80, 80, 20);
        txtSurname.setBounds(110, 80, 200, 20);
        panel.add(labSurname);
        panel.add(txtSurname);
                
        labEmail.setBounds(20, 110, 80, 20);
        txtEmail.setBounds(110, 110, 200, 20);
        panel.add(labEmail);
        panel.add(txtEmail);
                
        labPhone.setBounds(20, 140, 80, 20);
        txtPhone.setBounds(110, 140, 200, 20);
        panel.add(labPhone);
        panel.add(txtPhone);
        
        labLocation.setBounds(20, 170, 80, 20);
        txtLocation.setBounds(110, 170, 200, 20);
        panel.add(labLocation);
        panel.add(txtLocation);
        
        labPassword.setBounds(20, 200, 80, 20);
        txtPassword.setBounds(110, 200, 200, 20);
        panel.add(labPassword);
        panel.add(txtPassword);
        
        labPassword2.setBounds(1, 230, 120, 20);
        txtPassword2.setBounds(110, 230, 200, 20);
        panel.add(labPassword2);
        panel.add(txtPassword2);
        
        //Add Buttons to the panel and set coordinates.
        panel.add(registerButton);
        registerButton.setBounds(110, 280, 130, 50);
        
        panel.add(hairDButton);
        panel.add(customerButton);
        hairDButton.setBounds(50, 20, 100, 20);
        customerButton.setBounds(180, 20, 100, 20);
        
        LoginPageButton.setBounds(110, 370, 130, 50);
        panel.add(LoginPageButton);
        
        
        frame.validate();
        frame.repaint();
    }

    private static void CustomerPage() {
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        
        frame.setSize(400, 300);
        frame.setTitle("Customer + Customer name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        
        
        
        
        JLabel welcome = new JLabel("Welcome, + Customer Name + Today is + Today's Date.");
        JLabel welcome2 = new JLabel("What would you like to do?");
        
                JButton searchHd = new JButton("Search Hairdresser");
        JButton viewApp = new JButton("My Appointments");
        JButton SubFb = new JButton ("Submit a Feedback");
        JButton Logout = new JButton ("Logout");
        
        panel.add(welcome);
        welcome.setBounds(30, 10, 400, 20);
        panel.add(welcome2);
        welcome2.setBounds(100, 30, 400, 20);
        
        panel.add(searchHd);
        searchHd.setBounds(100, 70, 150, 40);
        
        panel.add(SubFb);
        SubFb.setBounds(100, 110, 150, 40);
        
        panel.add(viewApp);
        viewApp.setBounds(100, 150, 150, 40);
        
        panel.add(Logout);
        Logout.setBounds(295, 230, 80, 20);
        
    }
    }

