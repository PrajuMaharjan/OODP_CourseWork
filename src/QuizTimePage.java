import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QuizTimePage extends JPanel {
    private static final long serialVersionUID = 1L;
    private List<Question> questions;
    private int currentQuestionIndex=0;
    private int score=0;
    private String difficulty;
    
    private JLabel questionLabel;
    private JLabel questionNumberLabel;
    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private JRadioButton optionD;
    private ButtonGroup buttonGroup;
    private JButton nextButton;
    private JButton submitButton;

    public QuizTimePage(QuizAppWindow frame) {
        setLayout(null);
        
        Font headerFont=new Font("Arial", Font.BOLD, 18);
        Font questionFont=new Font("Arial", Font.PLAIN, 16);
        
        questionNumberLabel=new JLabel("Question 1 of 10");
        questionNumberLabel.setFont(headerFont);
        questionNumberLabel.setBounds(350, 20, 200, 30);
        add(questionNumberLabel);
        
        questionLabel=new JLabel(" ");
        questionLabel.setFont(questionFont);
        questionLabel.setBounds(50, 80, 750, 100);
        questionLabel.setVerticalAlignment(SwingConstants.TOP);
        add(questionLabel);
        
        buttonGroup=new ButtonGroup();
        
        optionA=new JRadioButton("A. Option A");
        optionA.setFont(questionFont);
        optionA.setBounds(100, 200, 650, 30);
        buttonGroup.add(optionA);
        add(optionA);
        
        optionB=new JRadioButton("B. Option B");
        optionB.setFont(questionFont);
        optionB.setBounds(100, 250, 650, 30);
        buttonGroup.add(optionB);
        add(optionB);
        
        optionC=new JRadioButton("C. Option C");
        optionC.setFont(questionFont);
        optionC.setBounds(100, 300, 650, 30);
        buttonGroup.add(optionC);
        add(optionC);
        
        optionD=new JRadioButton("D. Option D");
        optionD.setFont(questionFont);
        optionD.setBounds(100, 350, 650, 30);
        buttonGroup.add(optionD);
        add(optionD);
        
        nextButton=new JButton("Next");
        nextButton.setBounds(350, 400, 150, 40);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswers();
            }
        });
        add(nextButton);
        
        submitButton=new JButton("Submit Quiz");
        submitButton.setBounds(350, 400, 150, 40);
        submitButton.setVisible(false);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswers();
            }
        });
        add(submitButton);
    }
    
    public void loadQuiz(List<Question> questions, String difficulty) {
        this.questions=questions;
        this.difficulty=difficulty;
        this.currentQuestionIndex = 0;
        this.score=0;
        
        if (questions.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "No questions available for this difficulty level.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        displayQuestion();
    }
    
    private void displayQuestion() {
        if (currentQuestionIndex<questions.size()) {
            Question q=questions.get(currentQuestionIndex);
            
            questionNumberLabel.setText("Question "+(currentQuestionIndex + 1) + " of " + questions.size());
            questionLabel.setText("<html>" + q.getQuestionText() + "</html>");
            
            optionA.setText("A. "+q.getOptionA());
            optionB.setText("B. "+q.getOptionB());
            optionC.setText("C. "+q.getOptionC());
            optionD.setText("D. "+q.getOptionD());
            
            buttonGroup.clearSelection();
            
            if (currentQuestionIndex==questions.size()-1) {
                nextButton.setVisible(false);
                submitButton.setVisible(true);
            } else {
                nextButton.setVisible(true);
                submitButton.setVisible(false);
            }
        }
    }
    
    private void checkAnswers() {
        String selectedAnswer=null;
        
        if (optionA.isSelected()) selectedAnswer="A";
        else if (optionB.isSelected()) selectedAnswer="B";
        else if (optionC.isSelected()) selectedAnswer="C";
        else if (optionD.isSelected()) selectedAnswer="D";
        
        if (selectedAnswer==null) {
            JOptionPane.showMessageDialog(this, 
                "Please select an answer before proceeding.", 
                "No Answer Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Question currentQuestion=questions.get(currentQuestionIndex);
        if (selectedAnswer.equals(currentQuestion.getCorrectOption())) {
            score++;
        }
        
        currentQuestionIndex++;
        
        if (currentQuestionIndex<questions.size()) {
            displayQuestion();
        } else {
            QuizAppWindow frame=(QuizAppWindow) SwingUtilities.getWindowAncestor(this);
            frame.showScore(score, questions.size(), difficulty);
        }
    }
}