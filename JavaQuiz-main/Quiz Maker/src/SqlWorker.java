
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class SqlWorker {
	private String sqlPassword = System.getenv("MYSQL_PASSWORD");
	private String sqlUsername = System.getenv("MYSQL_USERNAME");
	private String url = "jdbc:mysql://localhost:3306/Quizes";
	private String quizName;
	
	
	public List<String> showAlltables(){
		List<String> tableNames = new ArrayList<>();
		String showTables = "SHOW TABLES";
		
		try(Connection connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);
		Statement statement = connection.createStatement()) {
		
			// Query to get all tables from the database
		ResultSet resultSet = statement.executeQuery(showTables);
		while(resultSet.next()) {
			tableNames.add(resultSet.getString(1));
		}
		
		}
	catch (SQLException e) {
		e.printStackTrace();
		}
		System.out.println(tableNames);
		return tableNames;
		
		}
	
	public Boolean makeTable(){
		try(Connection connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);
				Statement statement = connection.createStatement()) {
			this.quizName =JOptionPane.showInputDialog(null, "What is the title of the quiz you'd like to make?", "Quiz name", JOptionPane.QUESTION_MESSAGE);
			String createTable ="CREATE TABLE " + this.quizName + "("+
              "QuestionNumber INT NOT NULL AUTO_INCREMENT, " +
              "Question VARCHAR(100), " +
              "ChoiceA VARCHAR(100), " +
              "ChoiceB VARCHAR(100), " +
              "ChoiceC VARCHAR(100), " +
              "ChoiceD VARCHAR(100), " +
              "Answer VARCHAR(100)," + 
              "PRIMARY KEY (QuestionNumber))";
		 
		 	statement.execute(createTable);
		}
		 catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There was an error, Maybe that quiz already exists?", "Error", JOptionPane.ERROR_MESSAGE);
				StartPage startPage = new StartPage();
				startPage.setVisible(true);
				return false;
		 }
		return true;
		
		
	}
	
	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public void insertQuestion(String question, String choiceA, String choiceB, String choiceC, String choiceD, String answer) {
	
		String insertSQL = "INSERT INTO " + this.quizName + "(Question, ChoiceA, ChoiceB, ChoiceC, ChoiceD, Answer) VALUES (?, ?, ?, ?, ?, ?)";
		try(Connection connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
			preparedStatement.setString(1, question);
	        preparedStatement.setString(2, choiceA);
	        preparedStatement.setString(3, choiceB);
	        preparedStatement.setString(4, choiceC);
	        preparedStatement.setString(5, choiceD);
	        preparedStatement.setString(6, answer);
			
	        int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Question added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
		}
		catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "There was an error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	}
	

