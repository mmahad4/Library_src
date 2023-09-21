///Author : Shwetha_Puttamallegowda_654429387

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
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LibrarianLogin extends JFrame {
	static LibrarianLogin frame;
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
					frame = new LibrarianLogin();
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
	public LibrarianLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAdminLoginForm = new JLabel("LOGIN: LIBRARIAN");
		lblAdminLoginForm.setForeground(Color.black);
		lblAdminLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblEnterName = new JLabel("Enter Name:");  //label for name
		 
		JLabel lblEnterPassword = new JLabel("Enter Password:"); //label for password 
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");//login button
		JButton btnForgotPassword = new JButton ("Forgot Password"); //forgot password button
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword()); 
			//System.out.println(name+" "+password);
			if(LibrarianDao.validate(name, password)){ //calls the validate function
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(LibrarianLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
				passwordField.setText("");
			}
			}
		});
		
		//Forgot button usage 
		
		btnForgotPassword.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) { //asks for the user name
		        String username = JOptionPane.showInputDialog(contentPane, "Please enter your username");
		        if (username != null && !username.isEmpty()) {
		            if (LibrarianDao.checkUsername(username)) { //TODO : calls the check-user-name function in.dao
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
		                    .addComponent(lblAdminLoginForm))
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addGap(19)
		                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                        .addComponent(lblEnterName)
		                        .addComponent(lblEnterPassword))
		                    .addGap(47)
		                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
		                        .addComponent(passwordField)
		                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addGap(187)
		                    .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
		                    .addGap(18)
		                    .addComponent(btnForgotPassword, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
		            .addContainerGap(107, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
		    gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addComponent(lblAdminLoginForm)
		            .addGap(26)
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                .addComponent(lblEnterName)
		                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		            .addGap(28)
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                .addComponent(lblEnterPassword)
		                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		            .addGap(18)
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
		                .addComponent(btnForgotPassword, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
		            .addContainerGap(80, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
} //Author : Shwetha_Puttamallegowda_654429387