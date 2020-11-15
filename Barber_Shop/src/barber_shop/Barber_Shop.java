/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_shop;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
        
        //Organization:
        //Create all elements toghether, and edit them in order.       
        
        String userEmail;
        String userPass;
        
        
        //LoginPage();
        RegisterPage();
                
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
        
        frame.setSize(500, 480);
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
                
        registerButton.setBounds(200, 100, 100, 100);
        //
    }
    
    private static void RegisterPage(){
            
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        
        JLabel labEmail = new JLabel("E-mail");
        JLabel labPassword = new JLabel("Password");
        JLabel labPassword2 = new JLabel("Confirm Password");
        JLabel labName = new JLabel("User Name");
        JLabel labSurname = new JLabel("Surname");
        JLabel labPhone = new JLabel("Phone");
        JLabel labLocation = new JLabel("Location");
        //All Labels
        
        JTextField txtEmail = new JTextField(20);
        JTextField txtName = new JTextField(20);
        JTextField txtSurname = new JTextField(20);
        JTextField txtPhone = new JTextField(20);
        JTextField txtLocation = new JTextField(20);
        JPasswordField txtPassword = new JPasswordField(20);
        JPasswordField txtPassword2 = new JPasswordField(20);
        //All Text fields and password Fields
        
        JButton LoginPageButton = new JButton("Go Back");
        JButton registerButton = new JButton("Register me");
        JButton barberUser = new JButton("I'm a Barber");
        JButton customerUser = new JButton ("I'm a Customer");
        //All buttons
        
        frame.setSize(350, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        //
        
        panel.setVisible(true);
        panel.setLayout(null);

            
        
        //
        
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
        
        panel.add(registerButton);
        registerButton.setBounds(110, 280, 130, 50);
        
        panel.add(barberUser);
        barberUser.setBounds(20, 20, 130, 20);
        
        panel.add(customerUser);
        customerUser.setBounds(180, 20, 130, 20);
        
        LoginPageButton.setBounds(110, 370, 130, 50);
        panel.add(LoginPageButton);
        
        
        
    }
    }

