package quizapp;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class UpdateQuestionsPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField aField;
	private JTextField bField;
	private JTextField cField;
	private JTextField dField;
	private JTextField questionIdField;
    private JTextArea questionArea;
    private JComboBox<String> correctChoiceBox;
    private JComboBox<String> difficultyBox;
    private JButton updateBtn;
    private JDBC jdbc;
    private Question currentQuestion;

	/**
	 * Create the panel.
	 */
	public UpdateQuestionsPage(QuizAppWindow frame) {
		jdbc=new JDBC();
		setLayout(null);
		
		JButton backBtn = new JButton("Go Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("Navigating to AdminDashBoard Page.");
                frame.showPage("admindashboard");
			}
		});
		backBtn.setBounds(10, 20, 139, 42);
		add(backBtn);
		
		JLabel idLabel = new JLabel("Question ID : ");
        idLabel.setBounds(31, 72, 100, 30);
        add(idLabel);
        
        questionIdField = new JTextField();
        questionIdField.setBounds(141, 72, 100, 30);
        add(questionIdField);
        
        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(294, 72, 100, 30);
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchQuestion();
            }
        });
        add(searchBtn);
		
		JLabel questionLabel = new JLabel("Question : ");
		questionLabel.setBounds(119, 142, 165, 42);
		add(questionLabel);
		
		questionArea = new JTextArea();
		questionArea.setBounds(294, 142, 688, 42);
		add(questionArea);
		
		JLabel lblOptions = new JLabel("Options : ");
		lblOptions.setBounds(31, 194, 311, 54);
		add(lblOptions);
		
		aField = new JTextField();
		aField.setBounds(112, 277, 96, 18);
		add(aField);
		aField.setColumns(10);
		
		JLabel a = new JLabel("A : ");
		a.setBounds(58, 280, 44, 12);
		add(a);
		
		JLabel b = new JLabel("B : ");
		b.setBounds(321, 277, 44, 18);
		add(b);
		
		bField = new JTextField();
		bField.setColumns(10);
		bField.setBounds(375, 277, 96, 18);
		add(bField);
		
		JLabel c = new JLabel("C : ");
		c.setBounds(575, 277, 44, 18);
		add(c);
		
		cField = new JTextField();
		cField.setColumns(10);
		cField.setBounds(629, 277, 96, 18);
		add(cField);
		
		JLabel d = new JLabel("D : ");
		d.setBounds(813, 277, 44, 18);
		add(d);
		
		dField = new JTextField();
		dField.setColumns(10);
		dField.setBounds(886, 277, 96, 18);
		add(dField);
		
		String[] choices={"A","B","C","D"};
		correctChoiceBox = new JComboBox<>(choices);
		correctChoiceBox.setBounds(381, 335, 90, 20);
		add(correctChoiceBox);
		
		JLabel lblNewLabel = new JLabel("Correct Option : ");
		lblNewLabel.setBounds(271, 330, 94, 31);
		add(lblNewLabel);
		
		String[] difficulty={"Beginner","Intermediate","Advanced"};
		difficultyBox = new JComboBox<>(difficulty);
		difficultyBox.setBounds(629, 335, 90, 20);
		add(difficultyBox);
		
		JLabel lblDifficulty = new JLabel("Difficulty : ");
		lblDifficulty.setBounds(570, 330, 49, 31);
		add(lblDifficulty);
		
		updateBtn = new JButton("Update Question");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			updateQuestion();
			}
		});
		updateBtn.setBounds(473, 377, 146, 42);
		add(updateBtn);

	}
	
	private void searchQuestion() {
        String idText=questionIdField.getText().trim();
        
        if (!Validation.isNumeric(idText)) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid question ID", 
                "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int questionId=Integer.parseInt(idText);
        currentQuestion=jdbc.getQuestionById(questionId);
        
        if (currentQuestion != null) {
            questionArea.setText(currentQuestion.getQuestionText());
            aField.setText(currentQuestion.getOptionA());
            bField.setText(currentQuestion.getOptionB());
            cField.setText(currentQuestion.getOptionC());
            dField.setText(currentQuestion.getOptionD());
            correctChoiceBox.setSelectedItem(currentQuestion.getCorrectOption());
            difficultyBox.setSelectedItem(currentQuestion.getDifficulty());
            
            questionArea.setEnabled(true);
            aField.setEnabled(true);
            bField.setEnabled(true);
            cField.setEnabled(true);
            dField.setEnabled(true);
            correctChoiceBox.setEnabled(true);
            difficultyBox.setEnabled(true);
            updateBtn.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, 
                "Question not found with ID: " + questionId, 
                "Not Found", JOptionPane.ERROR_MESSAGE);
            clearFields();
        }
    }
    
    private void updateQuestion() {
        if (currentQuestion == null) {
            return;
        }
        
        String questionText=questionArea.getText().trim();
        String optionA=aField.getText().trim();
        String optionB=bField.getText().trim();
        String optionC=cField.getText().trim();
        String optionD=dField.getText().trim();
        String correctOption=(String) correctChoiceBox.getSelectedItem();
        String difficulty=(String) difficultyBox.getSelectedItem();
        
        String validationError=Validation.validateQuestion(
            questionText,optionA,optionB,optionC,optionD,correctOption,difficulty
        );
        
        if (validationError != null) {
            JOptionPane.showMessageDialog(this, validationError, 
                "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        currentQuestion.setQuestionText(questionText);
        currentQuestion.setOptionA(optionA);
        currentQuestion.setOptionB(optionB);
        currentQuestion.setOptionC(optionC);
        currentQuestion.setOptionD(optionD);
        currentQuestion.setCorrectOption(correctOption);
        currentQuestion.setDifficulty(difficulty);
        
        boolean success=jdbc.updateQuestion(currentQuestion);
        
        if (success) {
            JOptionPane.showMessageDialog(this, 
                "Question updated successfully!", 
                "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, 
                "Failed to update question. Please try again.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearFields() {
        questionIdField.setText("");
        questionArea.setText("");
        aField.setText("");
        bField.setText("");
        cField.setText("");
        dField.setText("");
        correctChoiceBox.setSelectedIndex(0);
        difficultyBox.setSelectedIndex(0);
        
        questionArea.setEnabled(false);
        aField.setEnabled(false);
        bField.setEnabled(false);
        cField.setEnabled(false);
        dField.setEnabled(false);
        correctChoiceBox.setEnabled(false);
        difficultyBox.setEnabled(false);
        updateBtn.setEnabled(false);
        currentQuestion = null;
    }
}
