package quizapp;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JDBC {
	public static final String url="jdbc:mysql://localhost:3306/coursework_db";
	public static final String user="root";
	public static final String password="";
	
	
	private Connection connect() {
		try {
			Connection conn=DriverManager.getConnection(url,user,password);
			System.out.println("Database connection successfull");
			return conn;
		}catch(SQLException e){
			System.out.println("Database Connection failed");
			e.printStackTrace();
			return null;
		}	
	}
	
	public User authentication(String name,String pass) {
		String checkquery="SELECT * FROM users WHERE name=? AND password=?";
		try(Connection conn=connect();
			PreparedStatement stmt=conn.prepareStatement(checkquery)){
			stmt.setString(1,name);
			stmt.setString(2,pass);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				return new User(rs.getInt("user_id"),rs.getString("name"),rs.getBoolean("is_admin"));
			}
		}catch(SQLException e) {
			System.out.println("Authentication failed.");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean registerUser(String name,String pass) {
		String registerquery="INSERT INTO users (name,password,is_admin) VALUES (?,?,FALSE)";
		try(Connection conn=connect();
			PreparedStatement stmt=conn.prepareStatement(registerquery)){
			stmt.setString(1,name);
			stmt.setString(2,pass);
			int rows=stmt.executeUpdate();
			if(rows>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Registration failed.");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addQuestion(Question question) {
		String addquery="INSERT INTO questions (question_text,option_a,option_b,option_c,option_d,correct_option,difficulty) VALUES (?,?,?,?,?,?,?)";
		try(Connection conn=connect();
			PreparedStatement stmt=conn.prepareStatement(addquery)){
			
			stmt.setString(1,question.getQuestionText());
			stmt.setString(2,question.getOptionA());
			stmt.setString(3,question.getOptionB());
			stmt.setString(4,question.getOptionC());
			stmt.setString(5,question.getOptionD());
			stmt.setString(6,question.getCorrectOption());	
			stmt.setString(7,question.getDifficulty());
			int rows=stmt.executeUpdate();
			if(rows>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e){
			System.out.println("Adding questions failed.");
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Question> readAllQuestions(){
		List<Question> questions=new ArrayList<>();
		String readquery="SELECT * FROM questions ORDER BY question_id";
		try(Connection conn=connect();
			PreparedStatement stmt=conn.prepareStatement(readquery);
			ResultSet rs=stmt.executeQuery(readquery)){
				while(rs.next()) {
					questions.add(new Question(
				rs.getInt("question_id"),
				rs.getString("question_text"),
				rs.getString("option_a"),
				rs.getString("option_b"),
				rs.getString("option_c"),
				rs.getString("option_d"),
				rs.getString("correct_option"),
				rs.getString("difficulty")
				));
				}
			}catch(SQLException e){
				System.out.println("Reading questions failed.");
				e.printStackTrace();
			}
		return questions;
	}
	
	public List<Question> getQuestionsByDifficulty(String difficulty){
		List<Question> questions=new ArrayList<>();
		String readquery="SELECT * FROM questions WHERE difficulty=?";
		try(Connection conn=connect();
			PreparedStatement stmt=conn.prepareStatement(readquery)){
			
			stmt.setString(1,difficulty);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				questions.add(new Question(
						rs.getInt("question_id"),
	                    rs.getString("question_text"),
	                    rs.getString("option_a"),
	                    rs.getString("option_b"),
	                    rs.getString("option_c"),
	                    rs.getString("option_d"),
	                    rs.getString("correct_option"),
	                    rs.getString("difficulty")
			  ));
			}
			}catch(SQLException e){
				System.out.println("Reading questions by difficulty failedfailed.");
				e.printStackTrace();
			}
		Collections.shuffle(questions);
		return questions.subList(0,Math.min(20,questions.size()));
	}
	
	public Question getQuestionById(int questionID) {
		String readquery="SELECT * FROM questions WHERE question_id = ?";
        try (Connection conn=connect();
             PreparedStatement stmt=conn.prepareStatement(readquery)) {
            
        	stmt.setInt(1,questionID);
            ResultSet rs=stmt.executeQuery();
            if (rs.next()){
                return new Question(
                    rs.getInt("question_id"),
                    rs.getString("question_text"),
                    rs.getString("option_a"),
                    rs.getString("option_b"),
                    rs.getString("option_c"),
                    rs.getString("option_d"),
                    rs.getString("correct_option"),
                    rs.getString("difficulty")
                );
            }
        } catch (SQLException e) {
        	System.out.println("Reading questions by ID failed.");
            e.printStackTrace();
        }
        return null;
	}
	
	public boolean updateQuestion(Question question) {
		String updatequery="UPDATE questions SET question_text=?,option_a=?,option_b=?,option_c=?,option_d=?,correct_option=?,difficulty=? WHERE question_id=?";
        try(Connection conn=connect();
            PreparedStatement stmt=conn.prepareStatement(updatequery)) {
            stmt.setString(1,question.getQuestionText());
            stmt.setString(2,question.getOptionA());
            stmt.setString(3,question.getOptionB());
            stmt.setString(4,question.getOptionC());
            stmt.setString(5,question.getOptionD());
            stmt.setString(6,question.getCorrectOption());
            stmt.setString(7,question.getDifficulty());
            stmt.setInt(8,question.getQuestionId());
            int rows=stmt.executeUpdate();
            if(rows>0) {
            	return true;
            }else {
            		return false;
            	}
            }catch (SQLException e) {
            System.out.println("Updating questions failed");
            e.printStackTrace();
            return false;
        }
	}
	
	public boolean deleteQuestion(int questionID) {
		String deletequery="DELETE FROM questions WHERE question_id=?";
		try(Connection conn=connect();
			PreparedStatement stmt=conn.prepareStatement(deletequery)){
			stmt.setInt(1, questionID);
			int rows=stmt.executeUpdate();
			if (rows>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Deleting questions failed");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean saveScore(int userID,String difficulty,int score,int totalQuestions) {
		String scorequery="INSERT INTO scores (user_id, difficulty, score, total_questions) VALUES (?, ?, ?, ?)";
		try (Connection conn = connect();
	         PreparedStatement stmt = conn.prepareStatement(scorequery)) {
	            stmt.setInt(1,userID);
	            stmt.setString(2,difficulty);
	            stmt.setInt(3,score);
	            stmt.setInt(4,totalQuestions);
	            int rows=stmt.executeUpdate();
	            if(rows > 0) {
	            	return true;
	            }else {
	            	return false;
	            }
	        } catch (SQLException e) {
	        	System.out.println("Saving scores failed");
	            e.printStackTrace();
	            return false;
	        }   
	}

	public List<LeaderboardEntry> getLeaderboard(String difficulty) {
        List<LeaderboardEntry> leaderboard=new ArrayList<>();
        String query="SELECT u.name,SUM(s.score) as total_score,COUNT(s.score_id) as tests_taken " +
                      "FROM users u " +
                      "INNER JOIN scores s ON u.user_id = s.user_id " +
                      "WHERE s.difficulty = ? " +
                      "GROUP BY u.user_id, u.name " +
                      "ORDER BY total_score DESC " +
                      "LIMIT 10";
        try (Connection conn=connect();
             PreparedStatement stmt=conn.prepareStatement(query)) {
            stmt.setString(1,difficulty);
            ResultSet rs=stmt.executeQuery();
            int rank=1;
            while (rs.next()) {
                leaderboard.add(new LeaderboardEntry(
                    rank++,
                    rs.getString("name"),
                    rs.getInt("total_score"),
                    rs.getInt("tests_taken")
                ));
            }
        } catch (SQLException e) {
        	System.out.println("Leaderboard loading failed.");
            e.printStackTrace();
        }
        return leaderboard;
    }
	
	public int getUserBestScore(int userId, String difficulty) {
        String query="SELECT MAX(score) as best_score FROM scores WHERE user_id = ? AND difficulty = ?";
        try (Connection conn=connect();
             PreparedStatement pstmt=conn.prepareStatement(query)) {
            pstmt.setInt(1,userId);
            pstmt.setString(2,difficulty);
            ResultSet rs=pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("best_score");
            }
        } catch (SQLException e) {
        	System.out.println("Getting best score failed...");
            e.printStackTrace();
        }
        return 0;
    }
	
}



















