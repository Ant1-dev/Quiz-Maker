import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class QuestionSetter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Question;
	private JTextField textField_C;
	private JButton btnExitPanel;
	private JLabel lblNewLabel;
	private JTextField textField_D;
	private JTextField textField_B;
	private JTextField textField_A;
	private JLabel lblChoiceA;
	private JLabel lblChoiceB;
	private JLabel lblChoiceD;
	private JLabel lblQuestion;
	private JTextField textField_Answer;
	private JLabel lblAnswer;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionSetter frame = new QuestionSetter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuestionSetter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 418);
		contentPane = new JPanel();
		contentPane.setLayout(null);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		textField_Question = new JTextField();
		textField_Question.setBounds(87, 33, 389, 65);
		contentPane.add(textField_Question);
		textField_Question.setColumns(10);
		
		textField_C = new JTextField();
		textField_C.setBounds(50, 220, 175, 44);
		contentPane.add(textField_C);
		textField_C.setColumns(10);
		
		btnExitPanel = new JButton("Exit");
		btnExitPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnExitPanel.setBounds(346, 332, 149, 36);
		contentPane.add(btnExitPanel);
		
		lblNewLabel = new JLabel("Choice C");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(67, 187, 142, 33);
		contentPane.add(lblNewLabel);
		
		textField_D = new JTextField();
		textField_D.setColumns(10);
		textField_D.setBounds(334, 220, 175, 44);
		contentPane.add(textField_D);
		
		textField_B = new JTextField();
		textField_B.setColumns(10);
		textField_B.setBounds(334, 137, 175, 44);
		contentPane.add(textField_B);
		
		textField_A = new JTextField();
		textField_A.setColumns(10);
		textField_A.setBounds(50, 137, 175, 44);
		contentPane.add(textField_A);
		
		lblChoiceA = new JLabel("Choice A");
		lblChoiceA.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblChoiceA.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoiceA.setBounds(67, 110, 142, 33);
		contentPane.add(lblChoiceA);
		
		lblChoiceB = new JLabel("Choice B");
		lblChoiceB.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblChoiceB.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoiceB.setBounds(353, 110, 142, 33);
		contentPane.add(lblChoiceB);
		
		lblChoiceD = new JLabel("Choice D");
		lblChoiceD.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblChoiceD.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoiceD.setBounds(360, 187, 142, 33);
		contentPane.add(lblChoiceD);
		
		lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setBounds(87, 0, 389, 33);
		contentPane.add(lblQuestion);
		
		textField_Answer = new JTextField();
		textField_Answer.setColumns(10);
		textField_Answer.setBounds(50, 309, 175, 44);
		contentPane.add(textField_Answer);
		
		lblAnswer = new JLabel("Answer");
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAnswer.setBounds(67, 276, 142, 33);
		contentPane.add(lblAnswer);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAdd.setBounds(346, 276, 149, 36);
		contentPane.add(btnAdd);
		
		btnAdd.addActionListener(e -> {
			String question = textField_Question.getText();
			String choiceA = textField_A.getText();
			String choiceB = textField_B.getText();
			String choiceC = textField_C.getText();
			String choiceD = textField_D.getText();
			String answer = textField_Answer.getText();
			
			SqlWorker sqlWorker = new SqlWorker();
			sqlWorker.insertQuestion(question, choiceA, choiceB, choiceC, choiceD, answer);
			
			textField_Question.setText("");
			textField_A.setText("");
			textField_B.setText("");
			textField_C.setText("");
			textField_D.setText("");
			textField_Answer.setText("");
		});
		
		btnExitPanel.addActionListener(e -> {
			QuestionSetter.this.setVisible(false);
			StartPage startPage = new StartPage();
			startPage.setVisible(true);
		});
		
	}
	
	public void addQuestion(String quizName) {
		btnAdd.addActionListener(e -> {
			String question = textField_Question.getText();
			String choiceA = textField_A.getText();
			String choiceB = textField_B.getText();
			String choiceC = textField_C.getText();
			String choiceD = textField_D.getText();
			String answer = textField_Answer.getText();
			
			SqlWorker sqlWorker = new SqlWorker();
			sqlWorker.setQuizName(quizName);
			sqlWorker.insertQuestion(question, choiceA, choiceB, choiceC, choiceD, answer);
			
			textField_Question.setText("");
			textField_A.setText("");
			textField_B.setText("");
			textField_C.setText("");
			textField_D.setText("");
			textField_Answer.setText("");
		});
	}
}
