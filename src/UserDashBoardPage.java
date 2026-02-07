import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class UserDashBoardPage extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public UserDashBoardPage(QuizAppWindow frame) {
		setLayout(null);
		
        Font newFont = new Font("Arial", Font.PLAIN, 30);
		
        JButton logoutBtn = new JButton("Log Out");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("LogOut button clicked. Navigating to Landing Page.");
                frame.showPage("landing");
			}
		});
		logoutBtn.setBounds(879, 30, 84, 20);
		add(logoutBtn);
		
		JLabel welcomeMessage = new JLabel("Welcome, ");
		welcomeMessage.setBounds(268, 47, 438, 82);
		welcomeMessage.setFont(newFont);
		add(welcomeMessage);
	}
}
