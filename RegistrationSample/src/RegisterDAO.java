import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	private String dburl = "jdbc:mysql://localhost:3306/registerdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String dbname = "root";
	private String dbpassword = "";
	private String dbdriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbdriver)
	{
		try {
			Class.forName(dbdriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try
		{
			con =  DriverManager.getConnection(dburl,dbname,dbpassword);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Connection failed!!!");
		}
		return con;
	}
	
//	entering data
	
	public String insert(Member member)
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result = "data Entered Successfully!!";
		String sql = "insert into member values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, member.getUsername());
			ps.setString(2, member.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "data not entered!!";
		}
		return result;
	}
	
}
