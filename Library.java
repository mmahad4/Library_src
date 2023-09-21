//Author :Jaya_Nakka_678202920
//Main function of the application - loads the first login page 
import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Library extends JFrame {
	static Library frame;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new Library();
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
	public Library() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000,1000,1000,1000);
		setSize(2000,2000);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new ImagePanel("C:/Users/pravi/Desktop/JAVA ASSIGNEMNT-5/Picture1.jpg");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        
     //Sets the template of the login page for the application    
        
		JLabel lblLibraryManagement = new JLabel("Library Genius");
		lblLibraryManagement.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblLibraryManagement.setForeground(Color.WHITE);
		setContentPane(contentPane);
		
		JButton btnAdminLogin = new JButton("Admin Login"); //Admin login
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminLogin.main(new String[]{});
			//frame.dispose();
			}
		});
		btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdminLogin.setBackground(Color.white); // change background color
		btnAdminLogin.setForeground(Color.DARK_GRAY); // change foreground color
		
		JButton btnLibrarianLogin = new JButton("Librarian Login"); //Librarian Login
		btnLibrarianLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LibrarianLogin.main(new String[]{});
			}
		});
		btnLibrarianLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLibrarianLogin.setBackground(Color.white); // change background color
	    btnLibrarianLogin.setForeground(Color.DARK_GRAY); // change foreground color
	    //GroupLayout gl_contentPane = new GroupLayout(contentPane);
	    
	    JButton btnStudentLogin = new JButton("Student Login"); //StudentLogin
		btnStudentLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentLogin.main(new String[]{});  
			}
		});
		btnStudentLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStudentLogin.setBackground(Color.white); // change background color
		btnStudentLogin.setForeground(Color.DARK_GRAY); // change foreground color
	    //GroupLayout gl_contentPane = new GroupLayout(contentPane);
	    
	    GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setAutoCreateContainerGaps(true);
		gl_contentPane.setAutoCreateGaps(true);
		contentPane.setLayout(gl_contentPane);
	    gl_contentPane.setHorizontalGroup(
	        gl_contentPane.createParallelGroup(Alignment.CENTER)
	            .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
	                .addComponent(lblLibraryManagement)
	                .addGap(0, 50, Short.MAX_VALUE))
	            .addGroup(gl_contentPane.createSequentialGroup()
	                .addGap(100)
	                .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
	                    .addComponent(btnAdminLogin, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(btnLibrarianLogin, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(btnStudentLogin, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
	                .addGap(50))
	    );
	    gl_contentPane.setVerticalGroup(
	        gl_contentPane.createParallelGroup(Alignment.CENTER)
	            .addGroup(gl_contentPane.createSequentialGroup()
	                .addGap(50)
	                .addComponent(lblLibraryManagement)
	                .addGap(50)
	                .addComponent(btnAdminLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
	                .addGap(30)
	                .addComponent(btnLibrarianLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
	                .addGap(30)
	                .addComponent(btnStudentLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
	                .addGap(50))
	    );

		contentPane.setLayout(gl_contentPane);
		contentPane.setBackground(Color.DARK_GRAY);
	}
	

	public class ImagePanel extends JPanel {

	    private Image image;

	    public ImagePanel(String imagePath) {
	        ImageIcon icon = new ImageIcon(imagePath);
	        image = icon.getImage();
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	    }

	}

}
//Jaya_Nakka_678202920