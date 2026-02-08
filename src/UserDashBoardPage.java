import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class UserDashBoardPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel welcomeMessage;
    private JComboBox<String> comboBox;
	
	
	public UserDashBoardPage(QuizAppWindow frame) {
		
        Font newFont = new Font("Arial", Font.PLAIN, 30);
		
        JButton logoutBtn = new JButton("Log Out");
        logoutBtn.setBounds(879, 30, 84, 20);
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("LogOut button clicked. Navigating to Landing Page.");
                frame.showPage("landing");
			}
		});
		setLayout(null);
		add(logoutBtn);
		
		welcomeMessage=new JLabel("Welcome, ");
		welcomeMessage.setBounds(268, 47, 438, 82);
		welcomeMessage.setFont(newFont);
		add(welcomeMessage);
		
		JButton leaderBoardbtn = new JButton("LeaderBoard");
		leaderBoardbtn.setBounds(26, 30, 135, 45);
		leaderBoardbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Navigating to LeaderBoard.");
				frame.showPage("leaderboard");
			}
		});
		add(leaderBoardbtn);
		
		JLabel lblNewLabel = new JLabel("Play Quiz");
		lblNewLabel.setBounds(377, 234, 275, 34);
		add(lblNewLabel);
		lblNewLabel.setFont(newFont);
		
		String[] difficulty={"Beginner","Intermediate","Advanced"};
		JComboBox <String>comboBox = new JComboBox<>(difficulty);
		comboBox.setBounds(303, 301, 146, 34);
		add(comboBox);
		
		JButton playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedDifficulty=(String) comboBox.getSelectedItem();
                System.out.println("Starting quiz with difficulty : "+selectedDifficulty);
                frame.startQuiz(selectedDifficulty);
			}
		});
		playButton.setBounds(494, 301, 135, 34);
		add(playButton);
		
		JLabel lblNewLabel_1 = new JLabel("Difficulty : ");
		lblNewLabel_1.setBounds(199, 301, 94, 29);
		add(lblNewLabel_1);
	}
	public void personalWelcomeMessage(String username) {
        welcomeMessage.setText("Welcome, "+username);
    }
}
