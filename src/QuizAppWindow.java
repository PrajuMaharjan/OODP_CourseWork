import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class QuizAppWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private CardLayout layout;
    private JPanel jpanel;
    
    public QuizAppWindow() {
        setTitle("Quiz App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 854, 480);

        layout=new CardLayout();
        jpanel=new JPanel(layout);
        
        // Add new pages here
        jpanel.add(new LandingPage(this),"landing");
        jpanel.add(new LoginPage(this),"login");
        jpanel.add(new SignUpPage(this),"signup");
        jpanel.add(new UserDashBoardPage(this),"userdashboard");
        jpanel.add(new AdminDashBoardPage(this),"admindashboard");
        jpanel.add(new LeaderBoardPage(this),"leaderboard");
        jpanel.add(new QuizTimePage(this),"quiztime");
        jpanel.add(new ScorePage(this),"score");
        jpanel.add(new AddQuestionsPage(this),"add");
        jpanel.add(new DeleteQuestionsPage(this),"delete");
        jpanel.add(new UpdateQuestionsPage(this),"leaderboard");

        add(jpanel);
        
        showPage("landing");
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void showPage(String pageName){
    	layout.show(jpanel,pageName);
    }

    public static void main(String[] args) {
    	System.out.println("QuizApp started.");
        EventQueue.invokeLater(() -> {
            new QuizAppWindow();
        });
    }
}
