package quizapp;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class LeaderBoardPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable beginnerTable;
	private JTable intermediateTable;
	private JTable advancedTable;
	private JDBC jdbc;
	/**
	 * Create the panel.
	 */
	public LeaderBoardPage(QuizAppWindow frame) {
		jdbc=new JDBC();
		setLayout(null);
		Font headerFont = new Font("Arial", Font.BOLD, 24);

		
		JLabel lblNewLabel = new JLabel("LEADERBOARD");
		lblNewLabel.setBounds(386, 36, 326, 74);
		lblNewLabel.setFont(headerFont);
		add(lblNewLabel);
		
		JButton backBtn = new JButton("Go Back");
		backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                QuizAppWindow window = (QuizAppWindow) SwingUtilities.getWindowAncestor(LeaderBoardPage.this);
                if (window.getCurrentUser() != null) {
                    if (window.getCurrentUser().getisAdmin()) {
                        window.showPage("admindashboard");
                    } else {
                        window.showPage("userdashboard");
                    }
                }
            }
        });
		backBtn.setBounds(10, 10, 139, 42);
		add(backBtn);
		
        JButton refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(850, 10, 100, 42);
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadLeaderboards();
			}
		});
		add(refreshBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Top Beginners");
		lblNewLabel_1.setBounds(10, 118, 211, 51);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Top Intermediate");
		lblNewLabel_1_1.setBounds(380, 118, 211, 51);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Top Advanced");
		lblNewLabel_1_1_1.setBounds(787, 118, 211, 51);
		add(lblNewLabel_1_1_1);
		
		String[] columnNames={"Rank","Player","Total Score","Tests"};
        
        DefaultTableModel beginnertable=new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        beginnerTable = new JTable(beginnertable);
        JScrollPane beginnerScroll = new JScrollPane(beginnerTable);
        beginnerScroll.setBounds(10, 179, 280, 303);
        add(beginnerScroll);
        
        DefaultTableModel intermediatetable = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        intermediateTable=new JTable(intermediatetable);
        JScrollPane intermediateScroll=new JScrollPane(intermediateTable);
        intermediateScroll.setBounds(323, 179, 280, 303);
        add(intermediateScroll);
        
        DefaultTableModel advancedModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        advancedTable = new JTable(advancedModel);
        JScrollPane advancedScroll = new JScrollPane(advancedTable);
        advancedScroll.setBounds(640, 179, 280, 303);
        add(advancedScroll);
        
        loadLeaderboards();
	
    }
    
    public void loadLeaderboards() {
    	
        List<LeaderboardEntry> beginnerList=jdbc.getLeaderboard("Beginner");
        DefaultTableModel beginnerModel=(DefaultTableModel) beginnerTable.getModel();
        beginnerModel.setRowCount(0);
        for (LeaderboardEntry entry:beginnerList) {
            beginnerModel.addRow(new Object[]{
                entry.getRank(),
                entry.getUsername(),
                entry.getTotalScore(),
                entry.getTestsTaken()
            });
        }
        
        List<LeaderboardEntry> intermediateList = jdbc.getLeaderboard("Intermediate");
        DefaultTableModel intermediateModel = (DefaultTableModel) intermediateTable.getModel();
        intermediateModel.setRowCount(0);
        for (LeaderboardEntry entry : intermediateList) {
            intermediateModel.addRow(new Object[]{
                entry.getRank(),
                entry.getUsername(),
                entry.getTotalScore(),
                entry.getTestsTaken()
            });
        }
        
        List<LeaderboardEntry> advancedList=jdbc.getLeaderboard("Advanced");
        DefaultTableModel advancedModel=(DefaultTableModel) advancedTable.getModel();
        advancedModel.setRowCount(0);
        for (LeaderboardEntry entry : advancedList) {
            advancedModel.addRow(new Object[]{
                entry.getRank(),
                entry.getUsername(),
                entry.getTotalScore(),
                entry.getTestsTaken()
            });
        }
	}
}
