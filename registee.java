package library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.border.LineBorder;


public class registee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registee frame = new registee();
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
	public registee() {
		setTitle("register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1317, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("    New student registration");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblNewLabel.setBackground(new Color(255, 51, 204));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(306, 36, 556, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("    Name        :");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel_2.setBackground(new Color(255, 51, 255));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(153, 151, 214, 42);
		contentPane.add(lblNewLabel_2);
		
		JTextField textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setBounds(676, 147, 408, 55);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("    Phone no  :");
		lblPhoneNo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblPhoneNo.setBackground(new Color(255, 51, 255));
		lblPhoneNo.setOpaque(true);
		lblPhoneNo.setForeground(new Color(0, 0, 0));
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPhoneNo.setBounds(153, 238, 214, 43);
		contentPane.add(lblPhoneNo);
		
		JLabel lblUsername = new JLabel("    Username :");
		lblUsername.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblUsername.setOpaque(true);
		lblUsername.setBackground(new Color(255, 51, 255));
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUsername.setBounds(153, 322, 214, 55);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("    Password  :");
		lblPassword.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblPassword.setOpaque(true);
		lblPassword.setBackground(new Color(255, 51, 255));
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPassword.setBounds(153, 425, 214, 42);
		contentPane.add(lblPassword);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(676, 234, 408, 55);
		contentPane.add(textField_1);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(676, 324, 408, 55);
		contentPane.add(textField_3);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField.setBounds(676, 421, 408, 55);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton(" <- Back");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				registee r1=new registee();
				r1.setVisible(false);
				dispose();
				login l2=new login();
				l2.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 51, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(198, 555, 179, 69);
		contentPane.add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String password=passwordField.getText();
				String numbers = "(.*[0-9].*)";
				try
				{
					/*long q=Long.parseLong(textField_1).getText();
					int  q1=q.length();*/
					if(textField .getText().equals("")|| textField_1.getText().equals("")|| textField_3.getText().equals("")|| passwordField.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please enter details ,all fields are mandatory");
					}
					
					else if(textField_1.getText().length()<10)
					{
						JOptionPane.showMessageDialog(null, "Please enter a proper 10 digit mobile number");
						textField_1.setText(null);
					}
					else if ((password.matches(numbers ))==false &&(password.matches("[a-z A-Z]")==false))
					{
						JOptionPane.showMessageDialog(null, "Password must contain atleast one special symnbol and atleast one digit");
						passwordField.setText(null);

					}
					else 
					{
						
					String query="insert into library(name,phoneno,username,password)values(?,?,?,? )";
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?useSSL=false&allowPublicKeyRetrieval=true","root" ,"Gayatri17#" );
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setLong(2, Long.parseLong(textField_1.getText()));
					pst.setString(3, textField_3.getText());
					pst.setString(4, passwordField.getText());
					pst.executeUpdate(); 
					pst.close();
					JOptionPane.showMessageDialog(null, "Your account is created successfully please login and go ahead");
					login l1=new login();
					l1.setVisible(true);
					dispose();
					}
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnRegister.setBackground(new Color(255, 51, 255));
		btnRegister.setBounds(692, 555, 220, 69);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 204, 51));
		lblNewLabel_1.setBounds(10, 10, 1276, 688);
		contentPane.add(lblNewLabel_1);
		
		
	}

}
