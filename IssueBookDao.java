//Author:Madhangi_Mahadevan_660416598

import java.sql.*;
public class IssueBookDao {
	
public static boolean checkBook(String title){
	boolean status=false;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from books where title=?");
		ps.setString(1,title);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static int save(String title,String studentid,String studentname,String studentcontact){
	int status=0;
	try{
		Connection con=DB.getConnection();
		
		status=updatebook(title);//updating quantity and issue
		
		if(status>0){
		PreparedStatement ps=con.prepareStatement("insert into issuebooks(title,studentid,studentname,studentcontact) values(?,?,?,?)");
		ps.setString(1,title);
		ps.setString(2,studentid);
		ps.setString(3,studentname);
		ps.setString(4,studentcontact);
		status=ps.executeUpdate();
		}
		
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int updatebook(String title){
	int status=0;
	int quantity=0,issued=0;
	try{
		Connection con=DB.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select quantity,issued from books where title=?");
		ps.setString(1,title);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			quantity=rs.getInt("quantity");
			issued=rs.getInt("issued");
		}
		
		if(quantity>0){
		PreparedStatement ps2=con.prepareStatement("update books set quantity=?,issued=? where title=?");
		ps2.setInt(1,quantity-1); //Quantity of the book decreases by 1
		ps2.setInt(2,issued+1); //Issue value increments by 1 
		ps2.setString(3,title);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
//Author:Madhangi_Mahadevan_660416598