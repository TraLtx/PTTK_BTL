package logic_application.bookDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.sql.Date;

import model.book.Book;
import model.book.BookItem;

public class BookImpl implements BookDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/shopping_onl?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	public void BookImpl() {
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

	public boolean addBook(BookItem bookItem) throws SQLException{
		
		Book book = bookItem.getBook();
		String sqlBook = "INSERT INTO book (isbn,title,summary,publicationDate,numPage,language,size,appearance) "
				+ "VALUES ( ?,?,?,?,?,?,?,?)";
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sqlBook);
		
		ps.setString(1, book.getIsbn());
		ps.setString(2, book.getTitle());
		ps.setString(3, book.getSize());
		
//		//String date = book.getPubliccationDate().toString();
//		Date date = book.getPubliccationDate();
//		System.out.print("Date: "+date+"\n");
//		//java.sql.Date sDate = new java.sql.Date(uDate.getTime());
//		java.sql.Date sDate = new java.sql.Date(date);
		
		//ps.setDate(4, sDate );
		ps.setInt(5,book.getNumPage());
		ps.setString(6, book.getLanguage());
		ps.setString(7, book.getSize());
		ps.setString(8, book.getAppearance());
		
		if(ps.executeUpdate() > 0){
			String sqlGetBookId = "SELECT id FROM customer WHERE isbn = ? AND title = ?";
			
			ps = con.prepareStatement(sqlGetBookId);
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
	        	book.setId(rs.getInt("id"));
	        }
		}

		String sqlBookItem = "INSERT INTO bookItem (bookId,price,discount) VALUES ( ?,?)";
		
		ps = con.prepareStatement(sqlBookItem);
		
		ps.setInt(1, book.getId());
		ps.setFloat(2, bookItem.getPrice());
		ps.setString(3, bookItem.getDiscount());
		
		boolean result = ps.executeUpdate() > 0;
		return result;
	}

	public boolean updateBook(Book book) throws SQLException{
		String sql = "update book set isbn=?,title=?,summary=?,publicationDate=?,"
				+ "numPage=?,language=?,size=?,appearance=? where id = ?";
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, book.getIsbn());
		ps.setString(2, book.getTitle());
		ps.setString(3, book.getSize());
		ps.setDate(4, (java.sql.Date)book.getPubliccationDate());
		ps.setInt(5,book.getNumPage());
		ps.setString(6, book.getLanguage());
		ps.setString(7, book.getSize());
		ps.setString(8, book.getAppearance());
		ps.setInt(9, book.getId());
		
		boolean result = ps.executeUpdate() > 0;
		return result;
		
	}

	public boolean deleteBook(Book book) throws SQLException{
		String sql = "delete from book where id = ?";
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, book.getId());
		
		boolean result = ps.executeUpdate() > 0;
		return result;
	}

	public Book searchBook(int ID) {
		// TODO - implement BookDAOImp.searchBook
		throw new UnsupportedOperationException();
	}

	public void viewBook(int ID) {
		// TODO - implement BookDAOImp.viewBook
		throw new UnsupportedOperationException();
	}
	
	public List<BookItem> viewAllBooks() throws SQLException{
		String sql = "SELECT * FROM bookitem";
		List<BookItem> listbook = new ArrayList<>();
		Book book = null;
		BookItem bookItem = null;
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			int id = rs.getInt("id");
			int bookId = rs.getInt("bookId");
			float price = rs.getFloat("price");
			String discount = rs.getString("discount");
			
			String sqlGetBook = "SELECT * FROM book WHERE id = ?";
			PreparedStatement ps2 = con.prepareStatement(sqlGetBook);
			ps2.setInt(1, bookId);
			ResultSet rs2 = ps2.executeQuery();
			
			if(rs2.next()){
				String title = rs2.getString("title");
				String summary = rs2.getString("summary");
				Date publiccationDate = rs2.getDate("publicationDate");
				int numPage = rs2.getInt("numPage");
				String language = rs2.getString("language");
				String size = rs2.getString("size");
				String appearance = rs2.getString("appearance");
				String isbn = rs2.getString("isbn");
				book = new Book(isbn,title,summary,publiccationDate,numPage,language,size,appearance);
			}
			bookItem = new BookItem(price,discount,book);
			bookItem.setId(id);
			listbook.add(bookItem);
		}
		return listbook;
	}
	
	public Book getBook(Book book) throws SQLException {
        String sql = "SELECT * FROM book WHERE id = ?";
        Book b = null;
        
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, book.getId());
         
        ResultSet rs = ps.executeQuery();
         
        if (rs.next()) {
        	String isbn = rs.getString("isbn");
			String title = rs.getString("title");
			String summary = rs.getString("summary");
			Date publiccationDate = rs.getDate("publiccationDate");
			int numPage = rs.getInt("numPage");
			String language = rs.getString("language");
			String size = rs.getString("size");
			String appearance = rs.getString("appearance");
			
			b = new Book(isbn,title,summary,publiccationDate,numPage,language,size,appearance);
        }
        //System.out.println(book.getName());
        return b;
    }

	@Override
	public void BookDAO() {
		// TODO Auto-generated method stub
		
	}

}