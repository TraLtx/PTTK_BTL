package logic_application.employeeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import logic_application.bookDAO.BookDAO;
import model.book.Book;
import model.book.BookItem;
import model.employee.Employee;

public class EmployeeImpl implements EmployeeDAO{
	private String jdbcURL = "jdbc:mysql://localhost:3306/shopping_onl?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";
	
	public void EmployeeImpl(){	
	}
	
	protected Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public boolean login(Employee emp) throws SQLException{
		 boolean login = false;
	        String sql = "SELECT * FROM employee WHERE username = ? AND password = ?";
	        
	        Connection con = getConnection();
	        try {
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, emp.getUsername());
	            ps.setString(2, emp.getPassword());
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()) {
	                login = true;
	            }
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
	        return login;
	}

	@Override
	public void EmployeeDAO() {
		// TODO Auto-generated method stub
		
	}


}
