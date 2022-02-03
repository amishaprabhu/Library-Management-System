package library;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import java.awt.Color;
import javax.swing.border.LineBorder;

public class Welcome {

	private JFrame frmWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.getContentPane().setBackground(new Color(0, 204, 51));
		frmWelcome.setTitle("welcome");
		frmWelcome.setBounds(100, 100, 1278, 753);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("   Welcome to Our Library");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 102, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(327, 42, 581, 74);
		frmWelcome.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("      New student ?");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBackground(new Color(255, 102, 255));
		lblNewLabel_1.setBounds(165, 264, 307, 59);
		frmWelcome.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Already have a membership ?");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(255, 102, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(91, 400, 473, 59);
		frmWelcome.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton(" Register");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				registee r=new registee();
				r.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 102, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(876, 264, 224, 59);
		frmWelcome.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("  Login");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				login l=new login();
				l.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_1.setBackground(new Color(255, 102, 255));
		btnNewButton_1.setBounds(876, 400, 224, 59);
		frmWelcome.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Librarian login");
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				librarian l=new librarian();
				l.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(255, 51, 204));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_2.setBounds(459, 564, 286, 84);
		frmWelcome.getContentPane().add(btnNewButton_2);
	}
}
