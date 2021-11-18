package logic_application.customerDAO;

import java.sql.SQLException;

import model.customer.Account;
import model.customer.Customer;

public interface CustomerDAO {
	
	public void CustomerDAO();
	
	public boolean login(Account acc);
	
	public Customer getCustomer(Account acc) throws SQLException;
	
	public boolean addCustomer(Customer cus) throws SQLException;
	
	public boolean updateCustomer();
	
	public boolean deleteCustomer();
	
	public boolean viewOrder();
}
