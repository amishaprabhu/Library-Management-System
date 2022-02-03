package library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



public class login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 744);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		

		JPanel panel = new JPanel();
		  panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		  panel.setBackground(new Color(0, 204, 51));
		  panel.setBounds(0, 0, 1261, 702);
		  contentPane.add(panel);
		  
		  JButton btnNewButton_2 = new JButton("<-  Back");
		  btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  btnNewButton_2.setBounds(60, 571, 181, 49);
		  btnNewButton_2.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e)
		  	{
		  		login l=new login();
		  		l.setVisible(false);
		  		registee r=new registee();
		  		r.setVisible(true);
		  		dispose();
		  	}
		  });
		  panel.setLayout(null);
		  btnNewButton_2.setForeground(new Color(255, 0, 0));
		  btnNewButton_2.setBackground(new Color(255, 204, 51));
		  btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		  panel.add(btnNewButton_2);
		  
		  
		  
		  JTextField textField = new JTextField();
		  textField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		  textField.setBounds(803, 169, 320, 54);
		  textField.setBackground(new Color(255, 222, 173));
		  textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		  panel.add(textField);
		  textField.setColumns(10);
		  
		  
		  JPasswordField passwordField = new JPasswordField();
		  passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		  passwordField.setBounds(803, 325, 320, 49);
		  passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		  passwordField.setBackground(new Color(255, 218, 185));
		  panel.add(passwordField);
		  
		  
		  JButton btnNewButton_1 = new JButton("Login");
		  btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  btnNewButton_1.setBounds(915, 500, 162, 54);
		btnNewButton_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) 
		  	{
		  		String u=textField.getText();
		  		try
		  		{
		  			Class.forName("com.mysql.jdbc.Driver");
		  			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?useSSL=false&allowPublicKeyRetrieval=true","root","Gayatri17#");
		  			Statement st=conn.createStatement();
		  			String query="select *from library where username='"+textField.getText()+"'and password='"+passwordField.getText()+"'";
		  			ResultSet rs=st.executeQuery(query);
		  			if(textField .getText().equals("")||passwordField.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please enter details ,all fields are mandatory");
					}
		  			else if(rs.next())
		  			{
		  				JOptionPane.showMessageDialog(null,"Login successfull");
		  				Dashboard d=new Dashboard(u);
				  		d.setVisible(true);
				  		dispose();
		  			}
		  			else
		  			{
		  				JOptionPane.showMessageDialog(null,"OOPS!!  Please enter valid username or password");
		  				textField.setText(null);
		  				passwordField.setText(null);
		  				
		  			}
		  			st.close();
		  			conn.close();
		  			
		  		}
		  		catch(Exception e1)
		  		{
		  			JOptionPane.showMessageDialog(null, e1);
		  			
		  		}
		  		
		  		
		  	}
		  });
		  btnNewButton_1.setBackground(Color.ORANGE);
		  btnNewButton_1.setForeground(Color.RED);
		  btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		  panel.add(btnNewButton_1);
		  
		  JButton btnNewButton = new JButton("Register");
		  btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  btnNewButton.setBounds(532, 500, 181, 54);
		  btnNewButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) 
		  	{
		  		login l2=new login();
				l2.setVisible(false);
		  		dispose();
		  		registee r=new registee();
		  		r.setVisible(true);
		  		
		  	}
		  });
		  btnNewButton.setBackground(Color.ORANGE);
		  btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		  btnNewButton.setForeground(Color.RED);
		  panel.add(btnNewButton);
		  
		  JLabel lblNewLabel_1 = new JLabel("  UserName:");
		  lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  lblNewLabel_1.setBounds(489, 166, 208, 54);
		  lblNewLabel_1.setForeground(Color.RED);
		  lblNewLabel_1.setBackground(Color.ORANGE);
		  lblNewLabel_1.setOpaque(true);
		  panel.add(lblNewLabel_1);
		  lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		  
		  JLabel lblNewLabel_2 = new JLabel("  Password :");
		  lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  lblNewLabel_2.setBounds(489, 325, 208, 49);
		  lblNewLabel_2.setOpaque(true);
		  lblNewLabel_2.setBackground(Color.ORANGE);
		  lblNewLabel_2.setForeground(new Color(255, 0, 0));
		  panel.add(lblNewLabel_2);
		  lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		  
		  JLabel lblNewLabel = new JLabel("      Login Here");
		  lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		  lblNewLabel.setBounds(532, 10, 320, 54);
		  lblNewLabel.setBackground(new Color(255, 51, 255));
		  lblNewLabel.setOpaque(true);
		  lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		  lblNewLabel.setForeground(new Color(0, 0, 0));
		  panel.add(lblNewLabel);
		  
		 
		  
		  JLabel lblNewLabel_5 = new JLabel("");
		  lblNewLabel_5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		  lblNewLabel_5.setBounds(430, 118, 777, 519);
		  lblNewLabel_5.setBackground(new Color(199, 21, 133));
		  lblNewLabel_5.setOpaque(true);
		  panel.add(lblNewLabel_5);
		  
		  JLabel lblNewLabel_2_1 = new JLabel("  Forgot Password?");
		  lblNewLabel_2_1.setOpaque(true);
		  lblNewLabel_2_1.setForeground(Color.RED);
		  lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		  lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  lblNewLabel_2_1.setBackground(Color.ORANGE);
		  lblNewLabel_2_1.setBounds(55, 268, 235, 49);
		  panel.add(lblNewLabel_2_1);
		  
		  JButton btnChangePassword = new JButton("Change Password");
		  btnChangePassword.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) 
		  	{
		  		changepass c=new changepass();
		  		c.setVisible(true);
		  		dispose();
		  	}
		  });
		  btnChangePassword.setForeground(Color.RED);
		  btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 23));
		  btnChangePassword.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  btnChangePassword.setBackground(Color.ORANGE);
		  btnChangePassword.setBounds(60, 343, 215, 54);
		  panel.add(btnChangePassword);
		  
		  JLabel lblNewLabel_3 = new JLabel("Don't have account? Register now !");
		  lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 14));
		  lblNewLabel_3.setForeground(new Color(0, 0, 0));
		  lblNewLabel_3.setBackground(SystemColor.controlLtHighlight);
		  lblNewLabel_3.setBounds(261, 251, 252, 24);
		  contentPane.add(lblNewLabel_3);
	}
}
