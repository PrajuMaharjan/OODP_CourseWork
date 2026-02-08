import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AllQuestionsPage extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable questionsTable;
    private JDBC jdbc;

    public AllQuestionsPage(QuizAppWindow frame) {
        jdbc=new JDBC();
        setLayout(null);
        
        JButton backBtn=new JButton("Go Back");
        backBtn.setBounds(10, 10, 139, 42);
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.showPage("admindashboard");
            }
        });
        add(backBtn);
        
        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(700, 10, 139, 42);
        refreshBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadQuestions();
            }
        });
        add(refreshBtn);
        
        JLabel titleLabel = new JLabel("All Questions");
        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        titleLabel.setBounds(350, 20, 200, 30);
        add(titleLabel);
        
        String[] columnNames={"ID","Question","A","B","C","D","Correct","Difficulty"};
        DefaultTableModel model = new DefaultTableModel(columnNames,0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        questionsTable=new JTable(model);
        questionsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        questionsTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        questionsTable.getColumnModel().getColumn(6).setPreferredWidth(60);
        questionsTable.getColumnModel().getColumn(7).setPreferredWidth(100);
        
        JScrollPane scrollPane=new JScrollPane(questionsTable);
        scrollPane.setBounds(10, 70, 970, 400);
        add(scrollPane);
        
        loadQuestions();
    }
    
    private void loadQuestions() {
        List<Question> questions=jdbc.readAllQuestions();
        DefaultTableModel model=(DefaultTableModel) questionsTable.getModel();
        model.setRowCount(0);
        
        for (Question q : questions) {
            model.addRow(new Object[]{
                q.getQuestionId(),
                q.getQuestionText(),
                q.getOptionA(),
                q.getOptionB(),
                q.getOptionC(),
                q.getOptionD(),
                q.getCorrectOption(),
                q.getDifficulty()
            });
        }
    }
}