package quizapp;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.util.List;

public class QuizAppWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private CardLayout layout;
    private JPanel jpanel;
    private User currentUser;
    private JDBC jdbc;
    private UserDashBoardPage userDashboard;
    private QuizTimePage quizTimePage;
    private ScorePage scorePage;
    private LeaderBoardPage leaderboardPage;
    
    public QuizAppWindow() {
        jdbc=new JDBC();
        
        setTitle("Quiz App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 550);

        layout=new CardLayout();
        jpanel=new JPanel(layout);
        
        userDashboard=new UserDashBoardPage(this);
        quizTimePage=new QuizTimePage(this);
        scorePage=new ScorePage(this);
        leaderboardPage=new LeaderBoardPage(this);
        
        jpanel.add(new LandingPage(this), "landing");
        jpanel.add(new LoginPage(this), "login");
        jpanel.add(new SignUpPage(this), "signup");
        jpanel.add(userDashboard, "userdashboard");
        jpanel.add(new AdminDashBoardPage(this), "admindashboard");
        jpanel.add(leaderboardPage, "leaderboard");
        jpanel.add(quizTimePage, "quiztime");
        jpanel.add(scorePage, "score");
        jpanel.add(new AllQuestionsPage(this), "all");
        jpanel.add(new AddQuestionsPage(this), "add");
        jpanel.add(new DeleteQuestionsPage(this), "delete");
        jpanel.add(new UpdateQuestionsPage(this), "update");

        add(jpanel);
        
        showPage("landing");
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void showPage(String pageName) {
        layout.show(jpanel,pageName);
    }
    
    public void setCurrentUser(User user) {
        this.currentUser=user;
        if (user != null && !user.getisAdmin()) {
            userDashboard.personalWelcomeMessage(user.getUsername());
        }
    }
    
    public User getCurrentUser() {
        return currentUser;
    }
    
    public void startQuiz(String difficulty) {
        if (currentUser == null) {
            System.out.println("No user logged in");
            return;
        }
        
        List<Question> questions=jdbc.getQuestionsByDifficulty(difficulty);
        
        if (questions.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "No questions available for " + difficulty + " level.", 
                "No Questions", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        quizTimePage.loadQuiz(questions, difficulty);
        showPage("quiztime");
    }
    
    public void showScore(int score, int total, String difficulty) {
        if (currentUser != null) {
            jdbc.saveScore(currentUser.getUserId(), difficulty, score, total);
        }
        
        scorePage.displayScore(score, total);
        showPage("score");
    }

    public static void main(String[] args) {
        System.out.println("QuizApp started.");
        EventQueue.invokeLater(() -> {
            new QuizAppWindow();
        });
    }
}