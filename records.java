package library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

public class records extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPasswordField passwordField;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					records frame = new records();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public records() {
		setTitle("records");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1336, 781);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("          Search student records");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(268, 63, 588, 71);
		contentPane.add(lblNewLabel);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("  UserName:");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  lblNewLabel_1.setBounds(170, 172, 208, 54);
		  lblNewLabel_1.setForeground(Color.RED);
		  lblNewLabel_1.setBackground(Color.ORANGE);
		  lblNewLabel_1.setOpaque(true);
		  contentPane.add(lblNewLabel_1);
		  lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		  
		  JTextField textField = new JTextField();
		  textField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		  textField.setBounds(666, 177, 320, 54);
		  textField.setBackground(new Color(255, 222, 173));
		  textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		  contentPane.add(textField);
		  textField.setColumns(10);
		  
		
		  
		  JButton btnNewButton = new JButton("  Search");
		  btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  btnNewButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) 
		  	{
		  		
		  		
				
				try
				{  
					String u=textField.getText();
					Class.forName("com.mysql.jdbc.Driver");
		  			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?useSSL=false&allowPublicKeyRetrieval=true","root","Gayatri17#");
		  			String query="select *from records where username='"+u+"'";
		  			java.sql.PreparedStatement pst=conn.prepareStatement(query);
		  			ResultSet rs=pst.executeQuery();
		  			if(textField .getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please enter details ,all fields are mandatory");
					}
					if(rs.next())
					{
						textField_1.setText(rs.getString(1));
						textField_2.setText(Long.toString(rs.getLong(2)));
						textField_3.setText(rs.getString(3));
						passwordField .setText(rs.getString(4));
						textField_4.setText(rs.getString(5));  
						textField_5.setText(rs.getString(6));
						textField_6.setText(Long.toString(rs.getLong(7)));
						textField_7.setText(rs.getString(8));
						textField_8.setText(rs.getString(9));
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"OOPS!!  No record found");
						textField.setText(null);
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
	  		
		  }
		  });
		  btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		  btnNewButton.setBounds(444, 269, 173, 44);
		  contentPane.add(btnNewButton);
		  
		  JLabel lblNewLabel_2 = new JLabel(" Records :");
		  lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		  lblNewLabel_2.setBackground(new Color(255, 222, 173));
		  lblNewLabel_2.setOpaque(true);
		  lblNewLabel_2.setBounds(40, 299, 142, 44);
		  contentPane.add(lblNewLabel_2);
		  
		  textField_1 = new JTextField();
		  textField_1.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		  textField_1.setBackground(new Color(255, 222, 173));
		  textField_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		  textField_1.setBounds(251, 389, 282, 44);
		  contentPane.add(textField_1);
		  textField_1.setColumns(10);
		  
		  JLabel studentname = new JLabel(" Student name:");
		  studentname.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  studentname.setOpaque(true);
		  studentname.setFont(new Font("Tahoma", Font.BOLD, 20));
		  studentname.setBackground(new Color(230, 230, 250));
		  studentname.setBounds(40, 390, 173, 44);
		  contentPane.add(studentname);
		  
		  JLabel phoneno = new JLabel("Phone no :");
		  phoneno.setOpaque(true);
		  phoneno.setFont(new Font("Tahoma", Font.BOLD, 20));
		  phoneno.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  phoneno.setBackground(new Color(230, 230, 250));
		  phoneno.setBounds(40, 458, 173, 44);
		  contentPane.add(phoneno);
		  
		  JLabel username = new JLabel(" Username :");
		  username.setOpaque(true);
		  username.setFont(new Font("Tahoma", Font.BOLD, 20));
		  username.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  username.setBackground(new Color(230, 230, 250));
		  username.setBounds(40, 531, 173, 44);
		  contentPane.add(username);
		  
		  JLabel password = new JLabel("Password :");
		  password.setOpaque(true);
		  password.setFont(new Font("Tahoma", Font.BOLD, 20));
		  password.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  password.setBackground(new Color(230, 230, 250));
		  password.setBounds(40, 599, 173, 44);
		  contentPane.add(password);
		  
		  JLabel bookissued = new JLabel("Book issued :");
		  bookissued.setOpaque(true);
		  bookissued.setFont(new Font("Tahoma", Font.BOLD, 20));
		  bookissued.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  bookissued.setBackground(new Color(230, 230, 250));
		  bookissued.setBounds(666, 390, 213, 44);
		  contentPane.add(bookissued);
		  
		  JLabel issuedate = new JLabel("Issue date :");
		  issuedate.setOpaque(true);
		  issuedate.setFont(new Font("Tahoma", Font.BOLD, 20));
		  issuedate.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  issuedate.setBackground(new Color(230, 230, 250));
		  issuedate.setBounds(666, 458, 213, 44);
		  contentPane.add(issuedate);
		  
		  JLabel noofbooksissued = new JLabel("no of books issued :");
		  noofbooksissued.setOpaque(true);
		  noofbooksissued.setFont(new Font("Tahoma", Font.BOLD, 20));
		  noofbooksissued.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  noofbooksissued.setBackground(new Color(230, 230, 250));
		  noofbooksissued.setBounds(666, 531, 213, 44);
		  contentPane.add(noofbooksissued);
		  
		  JLabel returndate = new JLabel("  Return date :");
		  returndate.setOpaque(true);
		  returndate.setFont(new Font("Tahoma", Font.BOLD, 20));
		  returndate.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  returndate.setBackground(new Color(230, 230, 250));
		  returndate.setBounds(666, 599, 213, 44);
		  contentPane.add(returndate);
		  
		  textField_2 = new JTextField();
		  textField_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		  textField_2.setColumns(10);
		  textField_2.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		  textField_2.setBackground(new Color(255, 222, 173));
		  textField_2.setBounds(251, 457, 282, 44);
		  contentPane.add(textField_2);
		  
		  textField_3 = new JTextField();
		  textField_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		  textField_3.setColumns(10);
		  textField_3.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		  textField_3.setBackground(new Color(255, 222, 173));
		  textField_3.setBounds(251, 530, 282, 44);
		  contentPane.add(textField_3);
		  
		  textField_4 = new JTextField();
		  textField_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		  textField_4.setColumns(10);
		  textField_4.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		  textField_4.setBackground(new Color(255, 222, 173));
		  textField_4.setBounds(940, 389, 282, 44);
		  contentPane.add(textField_4);
		  
		  textField_5 = new JTextField();
		  textField_5.setFont(new Font("Tahoma", Font.BOLD, 25));
		  textField_5.setColumns(10);
		  textField_5.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		  textField_5.setBackground(new Color(255, 222, 173));
		  textField_5.setBounds(940, 457, 282, 44);
		  contentPane.add(textField_5);
		  
		  textField_6 = new JTextField();
		  textField_6.setFont(new Font("Tahoma", Font.BOLD, 25));
		  textField_6.setColumns(10);
		  textField_6.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		  textField_6.setBackground(new Color(255, 222, 173));
		  textField_6.setBounds(940, 530, 282, 44);
		  contentPane.add(textField_6);
		  
		  textField_7 = new JTextField();
		  textField_7.setFont(new Font("Tahoma", Font.BOLD, 25));
		  textField_7.setColumns(10);
		  textField_7.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		  textField_7.setBackground(new Color(255, 222, 173));
		  textField_7.setBounds(940, 598, 282, 44);
		  contentPane.add(textField_7);
		  
		  passwordField = new JPasswordField();
		  passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		  passwordField.setBackground(new Color(255, 222, 173));
		  passwordField.setFont(new Font("Tahoma", Font.BOLD, 25));
		  passwordField.setBounds(251, 601, 282, 38);
		  contentPane.add(passwordField);
		  
		  JLabel bookcondition = new JLabel("  Condition  :");
		  bookcondition.setOpaque(true);
		  bookcondition.setFont(new Font("Tahoma", Font.BOLD, 20));
		  bookcondition.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  bookcondition.setBackground(new Color(230, 230, 250));
		  bookcondition.setBounds(40, 665, 173, 44);
		  contentPane.add(bookcondition);
		  
		  textField_8 = new JTextField();
		  textField_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		  textField_8.setColumns(10);
		  textField_8.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		  textField_8.setBackground(new Color(255, 222, 173));
		  textField_8.setBounds(251, 664, 282, 44);
		  contentPane.add(textField_8);
		  
		  JButton btnLogout = new JButton("  Logout");
		  btnLogout.addActionListener(new ActionListener() {
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
		  btnLogout.setFont(new Font("Tahoma", Font.BOLD, 25));
		  btnLogout.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  btnLogout.setBounds(813, 690, 173, 44);
		  contentPane.add(btnLogout);
		  
		  JButton btnSend = new JButton("Send");
		  btnSend.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) 
		  	{
		  		try
				{
		  			String u=textField.getText();
					Class.forName("com.mysql.jdbc.Driver");
		  			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?useSSL=false&allowPublicKeyRetrieval=true","root","Gayatri17#");
		  			Statement st=conn.createStatement();
		  			String query="select * from records where username='"+u+"'";
					ResultSet r=st.executeQuery(query);
					r.next();
					long mobileno=r.getLong(2);
					boolean b=Sendsms.sendsms("Due to book's unhealthy condition you are charged a fine of RS 500 generated at "+new Date(mobileno).toLocaleString(),Long.toString(mobileno));
					if(b==true)
					{
						JOptionPane.showMessageDialog(null, "message is successfully sended");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Some thing went wrong, try again");
					}
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
		  	}
		  });
		  btnSend.setFont(new Font("Tahoma", Font.BOLD, 25));
		  btnSend.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  btnSend.setBounds(552, 665, 81, 44);
		  contentPane.add(btnSend);
		  
		  JButton btnSend_1 = new JButton("Send");
		  btnSend_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e)
		  	{
		  		try
				{
		  			String u=textField.getText();
				Class.forName("com.mysql.jdbc.Driver");
	  			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?useSSL=false&allowPublicKeyRetrieval=true","root","Gayatri17#");
	  			Statement st=conn.createStatement();
	  			String query="select * from records where username='"+u+"'";
				ResultSet r=st.executeQuery(query);
				r.next();
				long mobileno=r.getLong(2);
				boolean b=Sendsms.sendsms("Books issued to you are now on a limit of 5. Please return the books before issuing any new book."+new Date(mobileno).toLocaleString(),Long.toString(mobileno));
				if(b==true)
				{
					JOptionPane.showMessageDialog(null, "message is successfully sended");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Some thing went wrong, try again");
				}
			}
		  	catch(Exception e1)
			{
				System.out.println(e1);
			}
		  	}
		  });
		  btnSend_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		  btnSend_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  btnSend_1.setBounds(1232, 531, 81, 44);
		  contentPane.add(btnSend_1);
		  
		  JButton btnSend_2 = new JButton("Send");
		  btnSend_2.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) 
		  	{
		  		try
				{
		  			String u=textField.getText();
				Class.forName("com.mysql.jdbc.Driver");
	  			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?useSSL=false&allowPublicKeyRetrieval=true","root","Gayatri17#");
	  			Statement st=conn.createStatement();
	  			String query="select * from records where username='"+u+"'";
				ResultSet r=st.executeQuery(query);
				r.next();
				long mobileno=r.getLong(2);
				boolean b=Sendsms.sendsms("Please return the books befor due date,Your books due date is near."+new Date(mobileno).toLocaleString(),Long.toString(mobileno));
				if(b==true)
				{
					JOptionPane.showMessageDialog(null, "message is successfully sended");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Some thing went wrong, try again");
				}
			}
		  	catch(Exception e1)
			{
				System.out.println(e1);
			}
		  	}
		  });
		  btnSend_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		  btnSend_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		  btnSend_2.setBounds(1232, 599, 81, 44);
		  contentPane.add(btnSend_2);
		  
		  
		
	}
}
