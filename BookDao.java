//Author : Shwetha_Puttamallegowda_654429387

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDao {
    public static int save(String Title,String Author,String Genre,String SubGenre,String Publisher,String quantity){
        int rowsInserted =0;
        try{
            Connection conn=DB.getConnection(); //establishes the db connection 
            //inserts the row in to DB 
            String sql = "INSERT INTO books (Title, Author, Genre, SubGenre, Publisher, quantity) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Title);
            ps.setString(2,Author);
            ps.setString(3,Genre);
            ps.setString(4,SubGenre);
            ps.setString(5,Publisher);
            ps.setString(6,quantity);
            rowsInserted=ps.executeUpdate();
            conn.close();
        }catch(Exception e){System.out.println(e);}
        return rowsInserted;
    }

	//public static int save(String title, String author, String genre, String subGenre, String publisher,String quantity) {
		// TODO Auto-generated method stub
		//return 0;
	//}
}//Author : Shwetha_Puttamallegowda_654429387