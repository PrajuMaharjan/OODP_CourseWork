import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AdminDashBoardPage extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AdminDashBoardPage(QuizAppWindow frame) {
		setLayout(null);
		
		JButton logoutBtn = new JButton("Log Out");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("LogOut button clicked. Navigating to Landing Page.");
                frame.showPage("landing");
			}
		});
		logoutBtn.setBounds(879, 30, 84, 20);
		add(logoutBtn);
	}
}
