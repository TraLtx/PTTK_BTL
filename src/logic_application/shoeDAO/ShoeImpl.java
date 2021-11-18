package logic_application.shoeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.shoe.Shoe;

public class ShoeImpl implements ShoeDAO{
	private String jdbcURL = "jdbc:mysql://localhost:3306/shopping_onl?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";
	
	public void ShoeImpl() {
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
	
	public boolean addShoe(Shoe shoe) throws SQLException{
		String sql = "INSERT INTO shoe (name,material,size,brand,color,summary,price,discriminator) "
				+ "VALUES (?,?,?,?,?,?,?,?,)";
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, shoe.getName());
		ps.setString(2, shoe.getMaterial());
		ps.setString(3, shoe.getSize());
		ps.setString(4, shoe.getBrand());
		ps.setString(5, shoe.getColor());
		ps.setString(6, shoe.getSummary());
		ps.setFloat(7, shoe.getPrice());
		ps.setString(8, shoe.getDiscriminator());
		
		boolean result = ps.executeUpdate() > 0;
		return result;
	}
	
	public boolean updateShoe(Shoe shoe) throws SQLException{
		String sql = "update shoe set name=?, material=?, size=?, brand=?, color=?, "
				+ "summary=?, price=?, discriminator=? where id = ?";
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, shoe.getName());
		ps.setString(2, shoe.getMaterial());
		ps.setString(3, shoe.getSize());
		ps.setString(4, shoe.getBrand());
		ps.setString(5, shoe.getColor());
		ps.setString(6, shoe.getSummary());
		ps.setFloat(7, shoe.getPrice());
		ps.setString(8, shoe.getDiscriminator());
		ps.setInt(9, shoe.getId());
		
		boolean result = ps.executeUpdate() > 0;
		return result;
	}

	public boolean deleteShoe(Shoe shoe) throws SQLException{
		String sql = "delete from shoe where id = ?";
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, shoe.getId());
		
		boolean result = ps.executeUpdate() > 0;
		return result;
	}

	@Override
	public void ShoeDAO() {
		// TODO Auto-generated method stub
		
	}
}