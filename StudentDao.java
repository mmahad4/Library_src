////Author:Pravishty_Maheshwari_665090173

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDao {
//successful student login
	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection(); // validates the connection
			PreparedStatement ps=con.prepareStatement("select * from student where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int save(String name,String password,String email,String address,String city,String contact){
		int status=0;
		try{
			Connection con=DB.getConnection(); //inserts into student table
			PreparedStatement ps=con.prepareStatement("insert into student(name,password,email,address,city,contact) values(?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,address);
			ps.setString(5,city);
			ps.setString(6,contact);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
		public static boolean checkUsername(String username) {  // change password for the student 
		    boolean exists = false;
		    try {
		        Connection con = DB.getConnection();
		        PreparedStatement ps = con.prepareStatement("select * from student where name=?");
		        ps.setString(1, username);
		        ResultSet rs = ps.executeQuery();
		        exists = rs.next();
		        con.close();
		    } catch (Exception e) {
		        System.out.println(e);
		    }
		    return exists;
	}
	
}

//Author:Pravishty_Maheshwari_665090173
