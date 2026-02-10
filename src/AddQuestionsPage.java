import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AddQuestionsPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField aField;
	private JTextField bField;
	private JTextField cField;
	private JTextField dField;
	private JTextArea questionArea;
    private JComboBox<String> correctChoiceBox;
    private JComboBox<String> difficultyBox;
    private JDBC jdbc;

	/**
	 * Create the panel.
	 */
	public AddQuestionsPage(QuizAppWindow frame) {
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
		
		JLabel questionLabel = new JLabel("Question : ");
		questionLabel.setBounds(31, 72, 311, 42);
		add(questionLabel);
		
		questionArea = new JTextArea();
		questionArea.setBounds(31, 132, 949, 42);
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
		
		JButton addBtn = new JButton("Add Question");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			addQuestion();
			}
		});
		addBtn.setBounds(473, 377, 146, 42);
		add(addBtn);

	}
	private void addQuestion() {
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
        
        Question question = new Question(
            questionText, optionA, optionB, optionC, optionD, correctOption, difficulty
        );
        
        boolean success=jdbc.addQuestion(question);
        
        if (success){
            JOptionPane.showMessageDialog(this, 
                "Question added successfully!", 
                "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, 
                "Failed to add question. Please try again.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearFields() {
        questionArea.setText("");
        aField.setText("");
        bField.setText("");
        cField.setText("");
        dField.setText("");
        correctChoiceBox.setSelectedIndex(0);
        difficultyBox.setSelectedIndex(0);
    }
	
}
