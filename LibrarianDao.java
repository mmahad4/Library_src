 //Author : Jaya_Nakka_678202920,

import java.sql.*;
public class LibrarianDao {

	
	public static int save(String name,String password,String email,String address,String city,String contact){
		int status=0;
		try{
			Connection con=DB.getConnection(); //inserts the librarian to the database 
			PreparedStatement ps=con.prepareStatement("insert into librarian(name,password,email,address,city,contact) values(?,?,?,?,?,?)");
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
	} //Author : Jaya_Nakka_678202920,
	
	////Author : Shwetha_Puttamallegowda_654429387
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getConnection(); // establishes the connection
			PreparedStatement ps=con.prepareStatement("delete from librarian where id=?"); //deletes the row with id 
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println("Enter valid id.");}
		return status;
	}
	//Author : Shwetha_Puttamallegowda_654429387
	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from librarian where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static boolean checkUsername(String username) {  // change
	    boolean exists = false;
	    try {
	        Connection con = DB.getConnection();
	        PreparedStatement ps = con.prepareStatement("select * from librarian where name=?");
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
//Author : Shwetha_Puttamallegowda_654429387