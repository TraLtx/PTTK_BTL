package logic_application.employeeDAO;

import java.sql.SQLException;

import model.employee.Employee;

public interface EmployeeDAO {
	
	public void EmployeeDAO();
	
	public boolean login(Employee emp) throws SQLException;
}
