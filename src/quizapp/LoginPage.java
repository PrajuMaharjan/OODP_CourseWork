package quizapp;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginPage extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField nameField;
    private JDBC jdbc;
    private JPasswordField passwordField;

    public LoginPage(QuizAppWindow frame) {
    	
    	jdbc=new JDBC();
    	
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        Font newFont = new Font("Arial", Font.PLAIN, 24);

        JLabel loginLabel = new JLabel("Login To Your Account");
        loginLabel.setBounds(295, 10, 291, 65);
        loginLabel.setFont(newFont);
        add(loginLabel);

        JLabel nameLabel = new JLabel("Name : ");
        nameLabel.setBounds(344, 111, 67, 19);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(421, 111, 109, 19);
        add(nameField);

        JLabel lblPassword = new JLabel("Password : ");
        lblPassword.setBounds(344, 154, 80, 19);
        add(lblPassword);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(421, 154, 109, 19);
        add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(380, 204, 109, 33);
        loginBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	System.out.println("Logging In...");
                	String username=nameField.getText().trim();
                	String password=new String(passwordField.getPassword()).trim();
                	
                	if(!Validation.isValidUsername(username)) {
                		JOptionPane.showMessageDialog(LoginPage.this, 
                                "Username must be 3-20 alphanumeric characters", 
                                "Validation Error", JOptionPane.ERROR_MESSAGE);
                            return;
                	}
                    User user=jdbc.authentication(username, password);
                    
                    if (user!=null) {
                        System.out.println("Login successful for: " + user.getUsername());
                        frame.setCurrentUser(user);
                        
                        nameField.setText("");
                        passwordField.setText("");
                        
                        if (user.getisAdmin()) {
                            frame.showPage("admindashboard");
                        } else {
                            frame.showPage("userdashboard");
                        }
                    } else {
                        JOptionPane.showMessageDialog(LoginPage.this, 
                            "Invalid username or password", 
                            "Login Failed",JOptionPane.ERROR_MESSAGE);
                    }
                }
        });
        add(loginBtn);

        JLabel question = new JLabel("Don't have an account? Register");
        question.setBounds(280, 245, 363, 56);
        question.setFont(newFont);
        add(question);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(380, 311, 109, 44);
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    	System.out.println("Register button clicked. Navigating to Signup Page.");
                    	nameField.setText("");
                        passwordField.setText("");
                    	frame.showPage("signup");
                    }
        });
        add(registerBtn);
       
    }
}
