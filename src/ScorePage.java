import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class ScorePage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblYourScore;
    private JLabel messageLabel;

    public ScorePage(QuizAppWindow frame) {
		setLayout(null);
		
		Font headerFont=new Font("Arial", Font.BOLD, 28);
        Font scoreFont=new Font("Arial", Font.BOLD, 24);
		
        JLabel lblNewLabel=new JLabel("Quiz Completed!");
		lblNewLabel.setBounds(363, 21, 298, 97);
		lblNewLabel.setFont(headerFont);
		add(lblNewLabel);
		
		lblYourScore = new JLabel("Your Score : 0/10");
		lblYourScore.setBounds(363, 114, 298, 97);
		lblYourScore.setFont(scoreFont);
		add(lblYourScore);
		
		messageLabel=new JLabel("");
        messageLabel.setFont(scoreFont);
        messageLabel.setBounds(10, 210, 1012, 50);
        add(messageLabel);
        
		JButton backBtn = new JButton("Back to HomePage");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("Navigating to UserDashBoard Page.");
                frame.showPage("userdashboard");
			}
		});
		backBtn.setBounds(421, 288, 145, 59);
		add(backBtn);
		
	
    }
    
    public void displayScore(int score,int total) {
        lblYourScore.setText("Your Score: "+score+"/"+total);
        
        double percentage=(score * 100.0) / total;
        String message="";
        
        if (percentage>=90) {
            message="Excellent! Outstanding performance!";
        } else if (percentage>=70) {
            message="Great job! Well done!";
        } else if (percentage>=50) {
            message="Good effort! Keep practicing!";
        } else {
            message="Keep learning! You'll do better next time!";
        }
        messageLabel.setText(message);
}
}