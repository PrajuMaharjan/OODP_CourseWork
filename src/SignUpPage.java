import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SignUpPage extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField nameField;
    private JTextField passwordField;

   public SignUpPage(QuizApp frame) {

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

        passwordField = new JTextField();
        passwordField.setBounds(421, 154, 109, 19);
        add(passwordField);

        JButton signupBtn = new JButton("Sign Up");
        signupBtn.setBounds(380, 204, 109, 33);
        signupBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Signing In...");
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
                frame.showPage("login");
            }
        });
        add(registerBtn);
    }
}
