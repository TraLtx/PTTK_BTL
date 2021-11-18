package logic_application.customerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.FullName;

public class CustomerImpl implements CustomerDAO{
	private String jdbcURL = "jdbc:mysql://localhost:3306/shopping_onl?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

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
	
	public void CustomerDAO(){
		
	}
	
	public boolean login(Account acc){
		 boolean login = false;
	        String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
	        
	        Connection con = getConnection();
	        try {
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, acc.getUsername());
	            ps.setString(2, acc.getPassword());
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()) {
	                login = true;
	            }
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
	        return login;
	}
	
	public Customer getCustomer(Account acc)throws SQLException{
		Customer cus = new Customer();
		String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
		
		Connection con = getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	cus.setId(rs.getInt("id"));
            	
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
		
		return cus;
	}
	
	public boolean addCustomer(Customer cus)throws SQLException{
		String sqlCustomer = "INSERT INTO customer (email, phone) VALUES (?,?)";
		String sqlAccount = "INSERT INTO account (customerId, username, password) VALUES (?,?,?)";
		String sqlAddress = "INSERT INTO address (customerId,numberHouse,street,district,city) VALUES (?,?,?,?,?)";
		String sqlFullName = "INSERT INTO fullname (customerId,firstName,midName,lastName) VALUES (?,?,?,?)";		
		
		int result = 0;
		Connection con = getConnection();
		//---------------------------
		//cus.setId(1);
		PreparedStatement ps = con.prepareStatement(sqlCustomer);
		ps.setString(1, cus.getMail());
		ps.setString(2, cus.getPhone());
		
		if(ps.executeUpdate() > 0) result++;
			String sqlGetId = "SELECT id FROM customer WHERE email = ? AND phone = ?";
			ps = con.prepareStatement(sqlGetId);
			ps.setString(1, cus.getMail());
			ps.setString(2, cus.getPhone());
			ResultSet rs = ps.executeQuery();
	        if(rs.next()) {
	        	cus.setId(rs.getInt("id"));
	        	
	        }
		
		//-----------------------------
		Account acc = cus.getAccount();
		ps = con.prepareStatement(sqlAccount);		
		ps.setInt(1, cus.getId());
		ps.setString(2, acc.getUsername());
		ps.setString(3, acc.getPassword());
		System.out.print("Acc: "+cus.getId()+"-"+acc.getUsername()+"-"+acc.getPassword()+"\n");
		if(ps.executeUpdate() > 0) result++;
		
		//----------------------------------
		Address add = cus.getAddress();
		ps = con.prepareStatement(sqlAddress);		
		ps.setInt(1, cus.getId());
		ps.setString(2, add.getNumberHouse());
		ps.setString(3, add.getStreet());
		ps.setString(4, add.getDistrict());
		ps.setString(5, add.getCity());		
		System.out.print("Add: "+cus.getId()+"-"+add.getNumberHouse()+"-"+add.getStreet()+"-"+add.getDistrict()+"-"+add.getCity()+"\n");
		if(ps.executeUpdate() > 0) result++;
		
		//------------------------------
		FullName fullN = cus.getFullName();
		System.out.print("FullName: "+fullN.getFirstName()+"-"+fullN.getMidName()+"-"+fullN.getLastName());
		ps = con.prepareStatement(sqlFullName);		
		ps.setInt(1, cus.getId());
		ps.setString(2, fullN.getFirstName());
		ps.setString(3, fullN.getMidName());
		ps.setString(4, fullN.getLastName());
		System.out.print("FullN: "+fullN.getFirstName()+"-"+fullN.getMidName()+"-"+fullN.getLastName()+"\n");
		if(ps.executeUpdate() > 0) result++;
		
		return result==4;
	}

	@Override
	public boolean updateCustomer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean viewOrder() {
		// TODO Auto-generated method stub
		return false;
	}
	
//	public boolean updateCustomer();
//	
//	public boolean deleteCustomer();
//	
//	public boolean viewOrder();
}
