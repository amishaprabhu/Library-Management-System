package library;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;


public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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

	private JTable table;
	public Dashboard(String username)
	{
		this();
		u=username;
	}
	
	public Dashboard() {
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1245, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblPassword = new JLabel("    Your status  ");
		lblPassword.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblPassword.setOpaque(true);
		lblPassword.setBackground(new Color(250, 235, 215));
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPassword.setBounds(470, 10, 257, 80);
		contentPane.add(lblPassword);
		
		JButton btnSearchBooks = new JButton(" Search Books");
		btnSearchBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Dashboard d1=new Dashboard();
				d1.setVisible(false);
				dispose();
				searchbooks s=new searchbooks(u);
				s.setVisible(true);
			}
		});
		btnSearchBooks.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSearchBooks.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSearchBooks.setBackground(new Color(250, 240, 230));
		btnSearchBooks.setBounds(125, 580, 221, 55);
		contentPane.add(btnSearchBooks);
		
		
		JButton btnYourBooks = new JButton(" Fetch Data ");
		btnYourBooks.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
		  			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?useSSL=false&allowPublicKeyRetrieval=true","root","Gayatri17#");
		  			String query="select *from dashboard where username='"+u+"'";
		  			java.sql.PreparedStatement pst = conn.prepareStatement(query);
		  			ResultSet rs = pst.executeQuery();
		  			table.setModel(DbUtils.resultSetToTableModel(rs));
		  			
		  			
		            /*
		             * while (rs.next()) 
		            {
		           
		            }
		  				String d = rs.getString(1);
		  				String c=rs.getString(2);
		  				p=rs.getString(2);
		            	String a = rs.getString(3);
		            	String f = rs.getString(4);
		            	String g = rs.getString(5);
		  				lblNewLabel.setText(d);
		  				lblNewLabel.setText(lblNewLabel.getText()+c);
		  				lblNewLabel.setText(lblNewLabel.getText()+a);
		  				lblNewLabel.setText(lblNewLabel.getText()+f);
		  				lblNewLabel.setText(lblNewLabel.getText()+g);
		              }*/
		            pst.close();
		            rs.close();
				} 
				catch (Exception e1)
				{
		        	JOptionPane.showMessageDialog(null, e1);

		        }

		    }
			
		});
		btnYourBooks.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnYourBooks.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnYourBooks.setBackground(new Color(250, 240, 230));
		btnYourBooks.setBounds(483, 483, 173, 55);
		contentPane.add(btnYourBooks);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2));
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setBounds(28, 126, 1179, 327);
		contentPane.add(scrollPane);
		
		table = new JTable();
		 DefaultTableModel tblmodel= (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Username", "Book name", "Issue date", "Return Date", "Book condtion"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(94);
		table.getColumnModel().getColumn(1).setPreferredWidth(276);
		table.getColumnModel().getColumn(2).setPreferredWidth(84);
		table.getColumnModel().getColumn(3).setPreferredWidth(88);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		table.setBackground(new Color(255, 222, 173));
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int a = JOptionPane.showConfirmDialog(btnLogout, "Are you sure?");
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
		btnLogout.setBackground(new Color(250, 240, 230));
		btnLogout.setBounds(1000, 596, 221, 55);
		contentPane.add(btnLogout);
		
		
		  
	}
}
