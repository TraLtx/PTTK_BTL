package logic_application.shoeDAO;

import java.sql.SQLException;

import model.shoe.*;

public interface ShoeDAO {
	
	public void ShoeDAO();
	
	public boolean addShoe(Shoe shoe) throws SQLException;
	
	public boolean updateShoe(Shoe shoe) throws SQLException;
	
	public boolean deleteShoe(Shoe shoe) throws SQLException;
}
