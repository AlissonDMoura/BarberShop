/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_shop;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author aliss
 */
public class Barber_Shop extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        //For easy navigation through the Code, please click on every '-' for all blocks, and expand the block you're going to analyse.
        
        
        //FeedBackPage();
        //LoginPage();
        //RegisterPage();
        //CustomerPage();
        //MyAppointments(6);
        HairDresserPanel(7);
        
                
    }
    
    
    public static void LoginPage(){
        
        //Frame created, Panel created, E-mail label created
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JLabel labEmail = new JLabel("E-mail");
        JLabel labPassword = new JLabel("Password");
        JTextField txtEmail = new JTextField(20);
        JPasswordField txtPassword = new JPasswordField(20);
        
        JButton loginButton = new JButton("Sign in");
        loginButton.addActionListener(new ActionListener() {

            
            //SIGN in Button action
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    
                    // Check what type of user was entered
                    String userType="";
                    Statement typeCheck = dbConector.getConnection().createStatement();
                   
                    ResultSet utype;               
                    utype = typeCheck.executeQuery("Select userType from users where Id =" +
                            dbConector.userLogin(txtEmail.getText(), String.valueOf(txtPassword.getPassword())));
                    while(utype.next()){
                        userType = utype.getString(1);
                    }
                    System.out.println("ecred = " + userType);
                    
                    
                    //Directs the user to it's respective Page.
                if(userType.equals("false")){
                    //This opens the customer page with the customer's ID, and close the login page.
                    frame.dispose();
                    CustomerPage(dbConector.userLogin(txtEmail.getText(), String.valueOf(txtPassword.getPassword())));
                    
                }
                    else{
                    //This opens the barber page with the user's id.
                    System.out.println("No barber supported page, please wait");
                        
                    };
                } catch (SQLException ex) {
                    System.out.println("This shouldn't have happened, please check your connection");;
                } }        });
        
        
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {

            @Override
            
            //close frame and open registration page.
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                        Barber_Shop.RegisterPage();
               
            }        });
        
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
        
        frame.validate();
        frame.repaint();
    }
    
    public static void RegisterPage(){
            
                
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
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
        
        //Radio buttons group together for further selection.
        String[] UserType = {"Hairdresser", "Customer"};
        JRadioButton hairDButton = new JRadioButton(UserType[0]);
        JRadioButton customerButton = new JRadioButton(UserType[1]);
        ButtonGroup typeSelect = new ButtonGroup();
        customerButton.setSelected(true);
        typeSelect.add(hairDButton);
        typeSelect.add(customerButton);
        
        //Add Location when barber is selected
        hairDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                customerButton.setSelected(false);
                hairDButton.setSelected(true);
                panel.add(labLocation); panel.add(txtLocation);
                frame.show();}
        });
        //Remove location when Customer is selected.
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                customerButton.setSelected(true);
                hairDButton.setSelected(false);
                panel.remove(labLocation); panel.remove(txtLocation);
                frame.show();
                }
        });
        
        //Go back to login page, close the actual frame.
        JButton LoginPageButton = new JButton("Go Back");
        LoginPageButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Barber_Shop.LoginPage();
            }        });
        
        //Register Button actions, details inside.
        JButton registerButton = new JButton("Register me");
        registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            
                //this first 'if' block check if the password is the same before registration
                
                if(String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtPassword2.getPassword()))){
                    
                // this block checks if the user is registrating as barber or as a customer, and then register them into the database
                             if(customerButton.isSelected()){
                             System.out.println("Customer Selected");
                             dbConector.insertSt(txtName.getText(), txtSurname.getText(), txtEmail.getText(),txtPhone.getText(),
                             txtLocation.getText(), String.valueOf(txtPassword.getPassword()), "'false'");}
                             
                             else{
                             System.out.println("Barber Selected");
                             dbConector.insertSt(txtName.getText(), txtSurname.getText(), txtEmail.getText(),txtPhone.getText(),
                             txtLocation.getText(), String.valueOf(txtPassword.getPassword()), "'true'");}
                } else {
                    txtPassword.setText(null);
                    txtPassword2.setText(null);
                    
                    JOptionPane.showMessageDialog(frame, "Please re-enter your password, it's different");}
                   }   }) ;
        
        
        
        
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
        
        if(hairDButton.isSelected()){
            panel.add(labLocation); panel.add(txtLocation);}
        
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

    public static void CustomerPage(int id) throws SQLException {
        
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        
        frame.setSize(400, 300);
        frame.setTitle("Customer + Customer name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        
        
        panel.setLayout(null);
        
        DateFormat DFdate = new SimpleDateFormat("dd-MM-yyyy");
        String Sdate = DFdate.format(new Date());
        String name = "";
        String surname = "";
        
        
                    //Personalize our Customer with name and other related data
                    Statement credCheck;              
                    credCheck = dbConector.getConnection().createStatement();
                
                    ResultSet cName;               
                    cName = credCheck.executeQuery("Select name from users where Id = " + id);
                    while(cName.next()){
                        name = cName.getString(1);
                    }
                    System.out.println("name = " + name);
                    
                    ResultSet cSurName;               
                    cSurName = credCheck.executeQuery("Select surname from users where Id = " + id);
                    while(cSurName.next()){
                        surname = cSurName.getString(1);
                    }
                    System.out.println("surname = " + surname);
                    System.out.println("id =" + id);
                    
                    
        
        
                JLabel welcome = new JLabel("Welcome, "+ name +" " + surname +" Today is " + Sdate);
        JLabel welcome2 = new JLabel("What would you like to do?");
        
        JButton searchHd = new JButton("Search Hairdresser");
        searchHd.addActionListener(new ActionListener() {
            
            //close the frame and opens a Search haior Dresser page.
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        
        JButton viewApp = new JButton("My Appointments");
        viewApp.addActionListener(new ActionListener() {

            //Close the frame and opens the Appointments
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        
        JButton SubFb = new JButton ("Submit a Feedback");
        SubFb.addActionListener(new ActionListener() {

                //close the page and opens the feedback page.
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Barber_Shop.FeedBackPage(id);
            }        });
       
        JButton Logout = new JButton ("Logout");
        Logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //closes the window and open the Login page
                frame.dispose();
                Barber_Shop.LoginPage();
            }        });
        
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
    
               
        frame.validate();
        frame.repaint();}
        
    public static void FeedBackPage(int id) {
     
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        
        frame.setSize(500, 500);
        frame.setTitle("Feedback");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        
        panel.setVisible(true);
        panel.setLayout(null);
        
        JLabel message = new JLabel("Please, inform the subject and to what Hairdresser you want write to");
        JLabel subjectLab = new JLabel("Subject");
        JLabel hairdLab = new JLabel("Hair Dresser");
        
        JTextField hairdTxt = new JTextField(20);
        JTextField subjectTxt = new JTextField(20);
        
        JTextArea feedback = new JTextArea();
        JScrollPane scroll = new JScrollPane(feedback);
        feedback.setLineWrap(true);
                
        JButton goBack = new JButton("Back to Menu");
        goBack.addActionListener((ActionEvent e) -> {
            try {
                //closes the window and open the customer main page
                frame.dispose();
                Barber_Shop.CustomerPage(id);
            } catch (SQLException ex) {
                System.out.println("Error at login back, please close the program");                }
        });
        JButton SendMessage = new JButton("Send");
                
        panel.add(message);
        message.setBounds(50, 10, 450, 20);
        
        panel.add(subjectLab);
        subjectLab.setBounds(50, 38, 50, 20);
        panel.add(subjectTxt);
        subjectTxt.setBounds(100, 40, 100, 20);
        
        panel.add(hairdLab);
        hairdLab.setBounds(235, 38, 80, 20);
        panel.add(hairdTxt);
        hairdTxt.setBounds(310, 40, 130, 20);
        
        panel.add(scroll);
        scroll.setBounds(50, 70, 390, 220);
        
        panel.add(goBack);
        goBack.setBounds(50, 310, 120, 30);
        panel.add(SendMessage);
        SendMessage.setBounds(320, 310, 120, 30);
        
        
        frame.validate();
        frame.repaint();}

    public static void MyAppointments(int id) throws SQLException{
                
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        
        frame.setSize(500, 500);
        frame.setTitle("My Appointments");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        frame.validate();
        frame.repaint();
        panel.setVisible(true);
        panel.setLayout(null);
        
                    //Retrieve user information from the database.
                    String name = "";
                    String surname = "";
                
                    Statement credCheck;              
                    credCheck = dbConector.getConnection().createStatement();
                
                    ResultSet cName;               
                    cName = credCheck.executeQuery("Select name from users where Id = " + id);
                    while(cName.next()){
                        name = cName.getString(1);                    }
                                       
                    ResultSet cSurName;               
                    cSurName = credCheck.executeQuery("Select surname from users where Id = " + id);
                    while(cSurName.next()){
                        surname = cSurName.getString(1);                    }
                    
                    
                    
        
                    // frame components:
        JLabel info1 = new JLabel("Dear "+ name + ", this is your next five appointments.", SwingConstants.CENTER);
        JLabel info2 = new JLabel("You can navigate and cancel appointments here.", SwingConstants.CENTER);
        
        
        
        String[] columnNames = {"Hairdresser", "Location", "Date", "Time"};
        String[][] data ={
                                {"Leila", "Jacana", "20/07", "1"},
                                {"Leila", "Jacana", "20/07", "2"},
                                {"Leila", "Jacana", "20/07", "3"},
                                {"Leila", "Jacana", "20/07", "4"},
                                {"Leila", "Jacana", "20/07", "5"}
    };
        
    
        
        JTable table = new JTable(data, columnNames);
        table.setBounds(80,100,299,80);
        table.setEnabled(false);
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(70, 100, 319, 80);
        
        panel.add(info1);
        info1.setBounds(50, 20,400,20);
        panel.add(info2);
        info2.setBounds(50, 40,400,20);
                
        panel.add(sp);
        
        //Button to Go back.
        JButton goBack = new JButton("Go to Menu");
        goBack.addActionListener((ActionEvent e) -> {
            try {
                frame.dispose();
                Barber_Shop.CustomerPage(id);
            } catch (SQLException ex) {
                System.out.println("Error loging back, please try login again");           }        });
        
        
        panel.add(goBack);
        goBack.setBounds(200, 350, 100, 80);}

    public static void HairDresserPanel(int id) throws SQLException {
        //It will bring the ID selection from the login page to personalize the user experience.
        
         JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        //Frame creation and setup
        
        panel.setLayout(null);
        //layout by coordinates
        
                DateFormat DFdate = new SimpleDateFormat("dd/MM/yyyy");
                String Sdate = DFdate.format(new Date());
                String date1 = Sdate;
                //Collect System's date
                
        String hairDresser = "";
        String hsurname = "";
        String location = "";
        
                    //Personalize our Customer with name and other related data
                    Statement credCheck;              
                    credCheck = dbConector.getConnection().createStatement();
                
                    ResultSet hName;               
                    hName = credCheck.executeQuery("Select name from users where Id = " + id);
                    while(hName.next()){
                        hairDresser = hName.getString(1);
                    }
                    System.out.println("name = " + hairDresser);
                    
                    ResultSet hSurName;               
                    hSurName = credCheck.executeQuery("Select surname from users where Id = " + id);
                    while(hSurName.next()){
                        hsurname = hSurName.getString(1);
                    }
                    
                    ResultSet hlocation;               
                    hlocation = credCheck.executeQuery("Select address from users where Id = " + id);
                    while(hlocation.next()){
                        location = hlocation.getString(1);
                    }
                    final String myName = hairDresser;
                    final String myLoc = location;
                    //Final Strings as the class that will call it only accept final strings.
                    
                    
                    System.out.println("surname = " + hsurname);
                    System.out.println("id =" + id);
                    //terminal confirm the Credentials for the programmer.
                    
                    frame.setTitle("Hairdresser: "+ hairDresser);
        

        
                    
        JLabel welcome = new JLabel("Welcome, "+ hairDresser +" " + hsurname +" Today is " + Sdate);
        JLabel newAgenda = new JLabel("Choose your next vacant time, accept or decline a appointment");
        JLabel OtherApp = new JLabel("Your apointments");
        JLabel Ldate = new JLabel("Date");
        JLabel Lhour = new JLabel("Hour");
              
        JButton upApp = new JButton("Set to Database");
                
        //To avoid tiping mistakes, I'll provide the data to be entered
        String [] hourString = {"9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"};
        JComboBox hourList = new JComboBox(hourString);
        hourList.setSelectedIndex(0);
        
        
        String [] dateString = {"","","","","","","","","",""};
        int i= 0;
        
        //To avoid mistakes, I'll provide the possible dates, the hairdresser can select 10 days counting from the actual day.      
        while(i != 10 ){
             try {dateString[i] = date1;
                 Calendar c = Calendar.getInstance();
                 c.setTime(DFdate.parse(date1));
                 c.add(Calendar.DATE, 1);
                 date1 = DFdate.format(c.getTime());
                 i++;} catch (ParseException ex) {System.out.println("Error inside the loop for Date ComboBox");      } }
        
        JComboBox dateList = new JComboBox(dateString);
        dateList.setSelectedIndex(0);
        
        
        
        //Set Appointment Button, shows a dialog for confirmation and writes into the database.
        upApp.addActionListener(new ActionListener() {

            
            
             @Override
             public void actionPerformed(ActionEvent e) {
                 
                 int result;                                  
                 result = JOptionPane.showConfirmDialog(frame,"You've selected day: " + dateList.getSelectedItem() + " and time: " + hourList.getSelectedItem() + "?","Confirm appointment!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                System.out.println("YES");
                dbConector.insertApp(dateList.getSelectedItem().toString(), hourList.getSelectedItem().toString(), myName, myLoc);
                JOptionPane.showMessageDialog(frame,"Your appointment was successfuly done!");}
            else {System.out.println("No action taken");};}          });
        
        
        int[] idAppointment = dbConector.viewAppH(dateString[0], dateString[1], dateString[2], dateString[3], dateString[4]);
        
                //What i'm going to display:
                JTextField dDate1 = new JTextField();
                JTextField dHour1 = new JTextField();
                JTextField dhair_dresser = new JTextField();
        
        
        
        
        
        //Add objects into the frame.        
        panel.add(welcome);
        welcome.setBounds(100, 20, 400, 20);
        panel.add(newAgenda);
        newAgenda.setBounds(60, 40, 400, 20);
        panel.add(Ldate);
        Ldate.setBounds(50, 100, 50, 20);
        panel.add(Lhour);
        Lhour.setBounds(200, 100, 50, 20);
        panel.add(OtherApp);
        OtherApp.setBounds(50, 160, 120, 20);
               
        panel.add(hourList);
        hourList.setBounds(250, 100, 80, 20);
        panel.add(dateList);
        dateList.setBounds(100, 100, 80, 20);
        
        panel.add(upApp);
        upApp.setBounds(340, 90, 130, 40);
        
        
        
    }

    

}
 