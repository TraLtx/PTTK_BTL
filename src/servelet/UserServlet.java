package servelet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic_application.bookDAO.BookImpl;
import logic_application.customerDAO.CustomerImpl;
import logic_application.employeeDAO.EmployeeImpl;
import model.book.Book;
import model.book.BookItem;
import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.FullName;
import model.employee.Employee;


@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerImpl cusImpl;
	private BookImpl bookImpl;
	private EmployeeImpl empImpl;
	
	public void init(){
		cusImpl = new CustomerImpl();
		bookImpl = new BookImpl();
		empImpl = new EmployeeImpl();
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/loginresult"://Ket qua dang nhap, dung se vao MainPage cua customer
				loginResult(request, response);
				break;
			case "/register"://Cusomer dang ky (Form)
				showRegisterForm(request, response);
				break;
			case "/registerResult"://Ket qua dang ky, trang thong bao ket qua
				registerResult(request, response);
				break;
			case "/adminLogin"://Admin dang nhap (Form)
				showAdminLoginForm(request, response);
				break;
			case "/adminLoginResult"://Ket qua Admin dang nhap, dung se vao MainPage cua admin
				adminLoginResult(request, response);
				break;
			case "/book":
				showBookList(request, response);
				break;
//			case "/electronic":
//				registerResult(request, response);
//				break;
//			case "/shoe":
//				registerResult(request, response);
//				break;
//			case "/clothes":
//				registerResult(request, response);
//				break;
			case "/AdminBook":
				showBookListAdmin(request, response);
				break;
			case "/newBook":
				showFormAddBook(request, response);
				break;
			case "/addBook":
				addBook(request, response);
				break;
			//-------------------------------------------------------------
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/list":
				listUser(request, response);
				break;
			case "/login":
				showLoginForm(request, response);
				break;
			//------Start from here----------------------------
			default:
				index(request, response);//Login form + register button
				break;
			}
		} catch (SQLException | ParseException ex) {
			throw new ServletException(ex);
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void loginResult(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		boolean login = false;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Customer customer = new Customer();
		Account account = new Account();

		account.setUsername(username);
		account.setPassword(password);
		
		customer.setAccount(account);
		
		boolean r = false;
		try {
			r = cusImpl.login(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(r){
			RequestDispatcher dispatcher = request.getRequestDispatcher("customerMain.jsp");
			dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginFail.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void showAdminLoginForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminLogin.jsp");
		dispatcher.forward(request, response);

	}
	
	private void registerResult(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String midName = request.getParameter("midName");
		String lastName = request.getParameter("lastName");
		
		String numberHouse = request.getParameter("numberHouse");
		String street = request.getParameter("street");
		String district = request.getParameter("district");
		String city = request.getParameter("city");
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");
		
		Customer customer = new Customer();
		Account account = new Account();
		Address address = new Address();
		FullName fullName = new FullName();
		
		account.setUsername(username);
		account.setPassword(password);
		
		address.setNumberHouse(numberHouse);
		address.setStreet(street);
		address.setDistrict(district);
		address.setCity(city);
		
		fullName.setFirstName(firstName);
		fullName.setMidName(midName);
		fullName.setLastName(lastName);
		
		customer.setPhone(phone);
		customer.setMail(mail);
		customer.setAccount(account);
		customer.setAddress(address);
		customer.setFullName(fullName);
		
		try {
			cusImpl.addCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("registerSuccess.jsp");
		dispatcher.forward(request, response);

	}
	
	private void showRegisterForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);

	}
	private void adminLoginResult(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		boolean login = false;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Employee employee = new Employee();
		employee.setUsername(username);
		employee.setPassword(password);
		
		boolean r = false;
		try {
			r = empImpl.login(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(r){
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminMain.jsp");
			dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginFail.jsp");
			dispatcher.forward(request, response);
		}

	}
	
	private void showBookList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<BookItem> listBookItem = bookImpl.viewAllBooks();
        request.setAttribute("listBookItem", listBookItem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookList.jsp");
        dispatcher.forward(request, response);
	}
	
	private void showBookListAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<BookItem> listBookItem = bookImpl.viewAllBooks();
        request.setAttribute("listBookItem", listBookItem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookListAdmin.jsp");
        dispatcher.forward(request, response);
	}
	
	private void showFormAddBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("addBookForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ParseException {
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		
		String date1 = request.getParameter("publiccationDate");
		Date publiccationDate=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
		//SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		//sdf1.format(sd.getNgaybatdau());
		System.out.print("Date String: "+date1+"\n");
		System.out.print("Date Form: "+publiccationDate+"\n");
		
		int numPage = Integer.parseInt(request.getParameter("numPage"));
		String language = request.getParameter("language");
		String size = request.getParameter("size");
		String appearance = request.getParameter("appearance");
		float price = Float.parseFloat(request.getParameter("price"));
		String discount = request.getParameter("");
		
		Book book = new Book(isbn, title, summary, publiccationDate, numPage, language, size, appearance);
		BookItem bookItem = new BookItem(price, discount, book);

		bookImpl.addBook(bookItem);
//		userDAO.insertUser(newUser);
//		response.sendRedirect("list");
	}
	//----------------------
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
//		List<User> listUser = userDAO.selectAllUsers();
//		request.setAttribute("listUser", listUser);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
//		dispatcher.forward(request, response);
	}

	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		User existingUser = userDAO.selectUser(id);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//		request.setAttribute("user", existingUser);
//		dispatcher.forward(request, response);

	}

	

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String country = request.getParameter("country");
//
//		User book = new User(id, name, email, country);
//		userDAO.updateUser(book);
//		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		userDAO.deleteUser(id);
//		response.sendRedirect("list");

	}

	

	
	private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);

	}

}
