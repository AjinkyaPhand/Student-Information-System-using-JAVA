import java.sql.*;
public class DB {
private PreparedStatement stmt;
private Connection conn;
 private ResultSet rs;
	DB() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/mysql", "root", "root123");
	}
	public boolean insertRecord(String fname, String cont, String year, String course, String email, String pass) throws SQLException {
	 stmt=conn.prepareStatement("insert into register_details values('0',?,?,?,?,?,?)");
	 stmt.setString(1, fname);
	 stmt.setString(2, cont);
	 stmt.setString(3, year);
	 stmt.setString(4, course);
	 stmt.setString(5, email);
	 stmt.setString(6, pass);
	 
	 int b=stmt.executeUpdate();
	 if(b>0)
		 return true;
	 else
		 return false;
	 
	}
	public ResultSet checkUser(String user, String pass) throws SQLException {
		stmt=conn.prepareStatement("select * from register_details where Email=? and Password=?");
		stmt.setString(1, user);
		stmt.setString(2, pass);
		rs=stmt.executeQuery();
			return rs;
	
	}
	public ResultSet getMyOwnRecord(int id) throws SQLException {
		stmt=conn.prepareStatement("select * from register_details where ID=?");
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		return rs;
		
	}
	public boolean updateMyOwnRecord(int id,String fname, String cont, String year, String course, String email,
			String pass1) throws SQLException {
		stmt=conn.prepareStatement("update register_details set First_Name=?, Contact=?, Year=?,Course=?,Email=?,Password=? where ID=?");
		stmt.setString(1,fname);
		stmt.setString(2, cont);
		stmt.setString(3, year);
		stmt.setString(4, course);
		stmt.setString(5, email);
		stmt.setString(6, pass1);
		stmt.setInt(7, id);
		int b=stmt.executeUpdate();
		if(b>0)
		return true;
		else
			return false;
	}
	public ResultSet getAllRecords() throws SQLException {
		stmt=conn.prepareStatement("select * from register_details");
		rs=stmt.executeQuery();
		return rs;
	}
	public boolean delRecord(String n) throws SQLException {
		stmt=conn.prepareStatement("delete from register_details where ID=?");
		stmt.setString(1, n);
		int b=stmt.executeUpdate();
		if(b>0)
			return true;
		else
			return false;
	}
	
	
}
