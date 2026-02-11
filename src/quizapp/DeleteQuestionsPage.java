package quizapp;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteQuestionsPage extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField questionField;
    private JLabel questionTextLabel;
    private JButton deleteBtn;
    private JDBC jdbc;
    private Question currentQuestion;

    public DeleteQuestionsPage(QuizAppWindow frame) {
        jdbc=new JDBC();
        setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Enter Question ID : ");
        lblNewLabel.setBounds(69, 73, 177, 56);
        add(lblNewLabel);
        
        JButton backBtn = new JButton("Go Back");
        backBtn.setBounds(10, 10, 139, 42);
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.showPage("admindashboard");
            }
        });
        add(backBtn);
        
        questionField = new JTextField();
        questionField.setBounds(266, 73, 303, 56);
        add(questionField);
        questionField.setColumns(10);
        
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(636, 73, 145, 56);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchQuestion();
            }
        });
        add(searchButton);
        
        JLabel lblNewLabel_1 = new JLabel("Question : ");
        lblNewLabel_1.setBounds(69, 148, 177, 56);
        add(lblNewLabel_1);
        
        questionTextLabel = new JLabel("");
        questionTextLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        questionTextLabel.setBounds(69, 214, 913, 189);
        add(questionTextLabel);
        
        deleteBtn = new JButton("Delete Question");
        deleteBtn.setBounds(452, 475, 145, 56);
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteQuestion();
            }
        });
        add(deleteBtn);
    }
    
    private void searchQuestion() {
        String idText=questionField.getText().trim();
        
        if (!Validation.isNumeric(idText)) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid question ID", 
                "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int questionId = Integer.parseInt(idText);
        currentQuestion = jdbc.getQuestionById(questionId);
        
        if (currentQuestion != null) {
            String displayText="<html><b>ID:</b> " + currentQuestion.getQuestionId() + "<br>" +
                               "<b>Question:</b> " + currentQuestion.getQuestionText() + "<br>" +
                               "<b>A:</b> " + currentQuestion.getOptionA() + "<br>" +
                               "<b>B:</b> " + currentQuestion.getOptionB() + "<br>" +
                               "<b>C:</b> " + currentQuestion.getOptionC() + "<br>" +
                               "<b>D:</b> " + currentQuestion.getOptionD() + "<br>" +
                               "<b>Correct:</b> " + currentQuestion.getCorrectOption() + 
                               " | <b>Difficulty:</b> " + currentQuestion.getDifficulty() + "</html>";
            
            questionTextLabel.setText(displayText);
            deleteBtn.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, 
                "Question not found with ID: " + questionId, 
                "Not Found", JOptionPane.ERROR_MESSAGE);
            clearFields();
        }
    }
    
    private void deleteQuestion() {
        if (currentQuestion == null) {
            return;
        }
        
        int confirm=JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this question?\nThis action cannot be undone.", 
            "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (confirm==JOptionPane.YES_OPTION) {
            boolean success = jdbc.deleteQuestion(currentQuestion.getQuestionId());
            
            if (success) {
                JOptionPane.showMessageDialog(this, 
                    "Question deleted successfully!", 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Failed to delete question. Please try again.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void clearFields() {
        questionField.setText("");
        questionTextLabel.setText("");
        deleteBtn.setEnabled(false);
        currentQuestion = null;
    }
}