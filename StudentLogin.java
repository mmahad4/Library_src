//Author:Pravishty_Maheshwari_665090173

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class StudentLogin extends JFrame {
	static StudentLogin frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new StudentLogin();
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
	public StudentLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblStudentLoginForm = new JLabel("LOGIN: STUDENT");
		lblStudentLoginForm.setForeground(Color.black);
		lblStudentLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblName = new JLabel("Enter UserName:");
		
		JLabel lblPassword = new JLabel("Enter Password:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnLog = new JButton("Login");
		JButton btnForgotPass = new JButton ("Forgot Password");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			//System.out.println(name+" "+password);
			int sid = 1;
			if(StudentDao.validate(name, password)){
				try
				{
					Connection con = DB.getConnection();
		            PreparedStatement ps = con.prepareStatement("SELECT studentid FROM student WHERE name = ?",
		                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		            ps.setString(1, name);
			        ResultSet rs = ps.executeQuery();
			        if(rs.next())
			        	sid = rs.getInt("studentid");
			        else
			        	System.out.println(rs.getInt("studentid"));
				}
				catch(Exception e2)
				{
					System.out.println(e2);
				}
				StudentSuccess page = new StudentSuccess(sid);
				page.setVisible(true);
				//page.dispose();
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(StudentLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
				passwordField.setText("");
			}
			}
		});
		btnForgotPass.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String username = JOptionPane.showInputDialog(contentPane, "Please enter your username");
		        if (username != null && !username.isEmpty()) {
		            if (StudentDao.checkUsername(username)) { //calls the listener function from student dao file 
		                // TODO: Implement password reset logic and send email
		                JOptionPane.showMessageDialog(contentPane, "Password reset link has been sent to your email.");
		            } else {
		                JOptionPane.showMessageDialog(contentPane, "Username does not exist.Please contact admin","Please contact admin",JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }
		});
		
		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(lblStudentLoginForm))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblPassword))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(300, Short.MAX_VALUE)
					.addComponent(btnLog, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(btnForgotPass, GroupLayout.PREFERRED_SIZE,130,GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					
					)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblStudentLoginForm)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLog, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnForgotPass, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					//.addGap(18)
		);
		contentPane.setLayout(gl_contentPane);
	}
}
//Author:Pravishty_Maheshwari_665090173