import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class AdminDashBoardPage extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AdminDashBoardPage(QuizAppWindow frame) {
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
		
		JButton leaderBoardBtn = new JButton("LeaderBoard");
		leaderBoardBtn.setBounds(26, 30, 120, 20);
		leaderBoardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("LeaderBoard button clicked. Navigating to LeaderBoard Page.");
				frame.showPage("leaderboard");
			}
		});
		add(leaderBoardBtn);
		
		JButton readButton = new JButton("View All Questions");
		readButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("View All Questions button clicked. Navigating to View Page.");
                frame.showPage("all");
			}
		});
		readButton.setBounds(175, 262, 141, 36);
		add(readButton);
		
		JButton addButton = new JButton("Add Question");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("Add Questions button clicked. Navigating to Add Page.");
                frame.showPage("add");
			}
		});
		addButton.setBounds(797, 262, 141, 36);
		add(addButton);
		
		JButton editButton = new JButton("Edit Question");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("Edit Questions button clicked. Navigating to Edit Page.");
                frame.showPage("update");
			}
		});
		editButton.setBounds(175, 403, 141, 36);
		add(editButton);
		
		JButton deleteButton = new JButton("Delete Question");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("Delete Questions button clicked. Navigating to Delete Page.");
                frame.showPage("delete");
			}
		});
		deleteButton.setBounds(797, 403, 141, 36);
		add(deleteButton);
		
		JLabel adminMessage = new JLabel("Welcome, Admin");
		adminMessage.setBounds(377, 72, 474, 112);
		adminMessage.setFont(newFont);
		add(adminMessage);
	}
}