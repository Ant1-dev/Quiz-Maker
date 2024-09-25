import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StartPage extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private SqlWorker sqlWorker = new SqlWorker();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage frame = new StartPage();
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
	public StartPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Welcome to Quiz Maker");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		title.setBounds(6, 6, 438, 40);
		contentPane.add(title);
		
		JLabel subtitle = new JLabel("Select From Below:");
		subtitle.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		subtitle.setHorizontalAlignment(SwingConstants.CENTER);
		subtitle.setBounds(134, 71, 164, 16);
		contentPane.add(subtitle);
		
		JButton btnMakeQuiz = new JButton("Make Quiz");
		btnMakeQuiz.setBounds(50, 134, 133, 40);
		contentPane.add(btnMakeQuiz);
		
		JButton btnShowQuizes = new JButton("Show Quizes");
		btnShowQuizes.setBounds(258, 134, 133, 40);
		contentPane.add(btnShowQuizes);
		
		JButton btnPlayAQuiz = new JButton("Play Quizes");
		btnPlayAQuiz.setBounds(50, 203, 133, 40);
		contentPane.add(btnPlayAQuiz);
		
		JButton btnQuit = new JButton("Exit");
		btnQuit.setBounds(258, 203, 133, 40);
		contentPane.add(btnQuit);
		
		// Add an ActionListener to the "Exit" button to quit the program
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exit the program when the "Exit" button is clicked
                System.exit(0);
            }
        });
        //process for the show Quizes button to show all quizes in the database
        btnShowQuizes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		sqlWorker.showAlltables();
        	}
        });
        
        //intiate the table making process
        btnMakeQuiz.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		StartPage.this.setVisible(false);
        		if (sqlWorker.makeTable()) {
        			QuestionSetter questionSetter = new QuestionSetter();
        			questionSetter.setVisible(true);
        			questionSetter.addQuestion(sqlWorker.getQuizName());
        		}
        		
        	}
        });
        
        
	}
}
