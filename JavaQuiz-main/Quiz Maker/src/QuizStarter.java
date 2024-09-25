import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
import java.util.*;


public class QuizStarter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel buttonPanel;
	private SqlWorker sqlWorker = new SqlWorker();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizStarter frame = new QuizStarter();
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
	public QuizStarter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 385);
		buttonPanel = new JPanel();
		buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(buttonPanel);
		buttonPanel.setLayout(new GridLayout(0, 2, 10, 15));
		for (String quiz : sqlWorker.showAlltables()) {
			JButton quizButton = new JButton(quiz);
			quizButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println();
				}
			});
			buttonPanel.add(quizButton);
		}
		
		   
	}
	
	public void initiateQuiz(String quiz) {
		
	}

}
