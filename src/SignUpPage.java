import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SignUpPage extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField nameField;
    private JTextField passwordField;
    private JDBC jdbc;
    private JPasswordField passwordField_1;

   public SignUpPage(QuizAppWindow frame) {
	   jdbc=new JDBC();

        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        Font newFont = new Font("Arial", Font.PLAIN, 24);

        JLabel signupLabel = new JLabel("Sign Up");
        signupLabel.setBounds(389, 10, 291, 65);
        signupLabel.setFont(newFont);
        add(signupLabel);

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

        JButton signupBtn = new JButton("Sign Up");
        signupBtn.setBounds(380, 204, 109, 33);
        signupBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String username=nameField.getText().trim();
            	String password=new String(((JPasswordField) passwordField).getPassword()).trim();
            	if (!Validation.isValidUsername(username)) {
                    JOptionPane.showMessageDialog(SignUpPage.this, 
                        "Username must be 3-20 alphanumeric characters", 
                        "Validation Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!Validation.isValidPassword(password)) {
                    JOptionPane.showMessageDialog(SignUpPage.this, 
                        "Password must be at least 4 characters", 
                        "Validation Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            	System.out.println("Signing Up...");
            	
            	boolean success=jdbc.registerUser(username,password);
                if (success){
                    JOptionPane.showMessageDialog(SignUpPage.this, 
                        "Registration successful! Please login.", 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                    nameField.setText("");
                    passwordField.setText("");
                    frame.showPage("login");
                } else {
                    JOptionPane.showMessageDialog(SignUpPage.this, 
                        "Username already exists.Please choose another.", 
                        "Registration Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(signupBtn);

        JLabel question = new JLabel("Already have an account? Login");
        question.setBounds(280, 245, 363, 56);
        question.setFont(newFont);
        add(question);

        JButton registerBtn = new JButton("Log In");
        registerBtn.setBounds(380, 311, 109, 44);
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Login button clicked. Navigating to Login Page.");
                nameField.setText("");
                passwordField.setText("");
            	frame.showPage("login");
            }
        });
        add(registerBtn);
        
    }
}
