import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LandingPage extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public LandingPage(QuizAppWindow frame) {
		setLayout(null);
        
		Font newFont = new Font("Arial", Font.PLAIN, 24);
        
		JLabel welcomeMessage = new JLabel("Welcome to the QuizApp");
        welcomeMessage.setFont(newFont);
		welcomeMessage.setBounds(349, 20, 302, 43);
		add(welcomeMessage);
        
        JLabel lblLoginOrSign = new JLabel("Login or Sign Up to Continue");
        lblLoginOrSign.setFont(new Font("Arial", Font.PLAIN, 24));
        lblLoginOrSign.setBounds(318, 96, 458, 43);
        add(lblLoginOrSign);
        
        JButton signupBtn = new JButton("Sign Up");
        signupBtn.setBounds(264, 261, 109, 33);
        signupBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Sign Up button clicked. Navigating to SignUp Page.");
                frame.showPage("signup");
            }
        });
        add(signupBtn);
        
        JButton loginBtn = new JButton("LogIn");
        loginBtn.setBounds(633, 261, 109, 33);
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Login button clicked. Navigating to Login Page.");
                frame.showPage("login");
            }
        });
        add(loginBtn);

	}
}
