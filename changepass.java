package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class changepass extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changepass frame = new changepass();
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
	public changepass() {
		setTitle("change password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1190, 667);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Enter old password:");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(86, 297, 276, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterNewPassword = new JLabel("  Enter new password:");
		lblEnterNewPassword.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblEnterNewPassword.setOpaque(true);
		lblEnterNewPassword.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEnterNewPassword.setBounds(86, 387, 276, 42);
		contentPane.add(lblEnterNewPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField.setBackground(new Color(255, 222, 173));
		passwordField.setBounds(664, 300, 287, 42);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("      Change password");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblNewLabel_1.setBounds(388, 37, 406, 57);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Change");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String u=passwordField.getText();
				String v=passwordField_1.getText();
				String w=textField.getText();
				try
		  		{
					if(textField .getText().equals("")|| passwordField_1.getText().equals("")|| passwordField.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please enter details ,all fields are mandatory");
					}
					else if(u!=v)
					{
					Class.forName("com.mysql.jdbc.Driver");
		  			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?useSSL=false&allowPublicKeyRetrieval=true","root","Gayatri17#");
		  			PreparedStatement st = (PreparedStatement) conn.prepareStatement("Update library set password=? where username=?");
		  			st.setString(1, v);
	                st.setString(2, w);
	                st.executeUpdate();
	                JOptionPane.showMessageDialog(null, "Password has been successfully changed");
	                st.close();
		  			conn.close();
		  			dispose();
					}
		  			else
		  			{
		  				JOptionPane.showMessageDialog(null,"OOPS!!  Please enter valid username or password");
		  				textField.setText(null);
		  				passwordField.setText(null);
		  				passwordField_1.setText(null);
		  				
		  			}
		  		}
		  		catch(Exception e1)
		  		{
		  			JOptionPane.showMessageDialog(null, e1);
		  			
		  		}
		  		
			}
		});
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton.setBackground(new Color(255, 228, 181));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(423, 490, 187, 57);
		contentPane.add(btnNewButton);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField_1.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		passwordField_1.setBackground(new Color(255, 222, 173));
		passwordField_1.setBounds(664, 390, 287, 42);
		contentPane.add(passwordField_1);
		
		JLabel lblUsername = new JLabel("        Username:");
		lblUsername.setOpaque(true);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUsername.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblUsername.setBounds(86, 200, 276, 42);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField.setBackground(new Color(255, 222, 173));
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setBounds(664, 200, 287, 42);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
