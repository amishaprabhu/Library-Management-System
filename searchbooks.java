package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class searchbooks extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchbooks frame = new searchbooks();
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
	String u;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public searchbooks(String username)
	{
		this();
		u=username;
		
	}
	public searchbooks() {
		setBackground(Color.WHITE);
		setTitle("searchbooks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1328, 794);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Which book do you want to issue ?");
		lblNewLabel.setBackground(new Color(255, 222, 173));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(298, 23, 588, 71);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField.setBackground(new Color(255, 222, 173));
		textField.setBounds(453, 299, 772, 53);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton(" Search");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
		
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?useSSL=false&allowPublicKeyRetrieval=true","root","Gayatri17#");
					Statement st=conn.createStatement();
					String query="select *from books where bookname='"+textField_1.getText()+"'";
					ResultSet rs=st.executeQuery(query);
					if(rs.next())
					{
						textField.setText(rs.getString(1));
						textField_2.setText(rs.getString(2));
						textField_3.setText(rs.getString(3));
						textField_4.setText(Integer.toString(rs.getInt(4)));
						textField_5.setText(rs.getString(5));
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"OOPS!!  No book found");
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnNewButton.setBounds(501, 212, 211, 56);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 222, 173));
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField_1.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_1.setBounds(720, 133, 485, 56);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("   Type book name to search   ->");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel_1.setBackground(new Color(238, 130, 238));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(68, 131, 422, 56);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("  Issue book");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
		  		{
		  			Class.forName("com.mysql.jdbc.Driver");
		  			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?useSSL=false&allowPublicKeyRetrieval=true","root","Gayatri17#");
		  			String query="select *from records where username='"+u+"'";
		  			Statement st= conn.createStatement();
		  			ResultSet rs=st.executeQuery(query);
		  			if( textField_1.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please enter details ,all fields are mandatory");
					}
		  			if(rs.next())
		  			{
		  				if(rs.getInt(7)<5)
		  				{
		  					String p=textField_1.getText();
		  					JOptionPane.showMessageDialog(null,"Book issued successfully to the user");
		  					String query1="update records set noofbooksissued=noofbooksissued+1 where username='"+u+"'";
		  					String query2="update records set bookissued='"+p+"' where username='"+u+"'";
		  					String query3="insert into dashboard(username,bookname,issuedate,returndate,bookcondition)values(?,?,?,?,? )";
		  					java.sql.PreparedStatement pst=conn.prepareStatement(query3);
							pst.setString(1,u);
							pst.setString(2,textField.getText());
							pst.setString(3,rs.getString(6));
							pst.setString(4,rs.getString(8));
							pst.setString(5,rs.getString(9));
		  					Statement st1= conn.createStatement();
				  			Statement st2= conn.createStatement();
				  			int rs1=st1.executeUpdate(query1);
				  			int rs2=st2.executeUpdate(query2);
							pst.executeUpdate(); 
							pst.close();
		  				
		  				}
		  				else
		  				{
		  					JOptionPane.showMessageDialog(null,"OOPS!! Book cannot be issued, User already possesses 5 books");
		  				}
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
		btnNewButton_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1.setBounds(911, 696, 217, 51);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("    Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                if (a == JOptionPane.YES_OPTION)
                {
                    dispose();
                    login obj = new login();
                    obj.setVisible(true);
                }
			}
		});
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_2.setBounds(193, 706, 203, 51);
		contentPane.add(btnNewButton_2);
		
		JLabel bookname = new JLabel("Book name:");
		bookname.setOpaque(true);
		bookname.setFont(new Font("Tahoma", Font.BOLD, 25));
		bookname.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		bookname.setBackground(new Color(238, 130, 238));
		bookname.setBounds(68, 291, 163, 56);
		contentPane.add(bookname);
		
		JLabel author = new JLabel("   Author:");
		author.setOpaque(true);
		author.setFont(new Font("Tahoma", Font.BOLD, 25));
		author.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		author.setBackground(new Color(238, 130, 238));
		author.setBounds(68, 367, 163, 56);
		contentPane.add(author);
		
		JLabel publication = new JLabel("Publication:");
		publication.setOpaque(true);
		publication.setFont(new Font("Tahoma", Font.BOLD, 25));
		publication.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		publication.setBackground(new Color(238, 130, 238));
		publication.setBounds(68, 445, 163, 56);
		contentPane.add(publication);
		
		JLabel price = new JLabel("     Price:");
		price.setOpaque(true);
		price.setFont(new Font("Tahoma", Font.BOLD, 25));
		price.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		price.setBackground(new Color(238, 130, 238));
		price.setBounds(68, 523, 163, 56);
		contentPane.add(price);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_2.setBackground(new Color(255, 222, 173));
		textField_2.setBounds(453, 375, 772, 53);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_3.setBackground(new Color(255, 222, 173));
		textField_3.setBounds(453, 453, 772, 53);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_4.setBackground(new Color(255, 222, 173));
		textField_4.setBounds(453, 531, 772, 53);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_5.setBackground(new Color(255, 222, 173));
		textField_5.setBounds(453, 613, 772, 53);
		contentPane.add(textField_5);
		
		JLabel category = new JLabel(" Category:");
		category.setOpaque(true);
		category.setFont(new Font("Tahoma", Font.BOLD, 25));
		category.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		category.setBackground(new Color(238, 130, 238));
		category.setBounds(68, 613, 163, 56);
		contentPane.add(category);
		
		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				searchbooks s=new searchbooks();
				s.setVisible(false);
				dispose();
				Dashboard d1=new Dashboard();
				d1.setVisible(true);
				
				
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_2_1.setBounds(539, 706, 203, 51);
		contentPane.add(btnNewButton_2_1);
	}
}