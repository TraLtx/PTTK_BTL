package logic_application.bookDAO;

import java.sql.SQLException;
import java.util.List;

import model.book.Book;
import model.book.BookItem;

public interface BookDAO {

	public void BookDAO();

	public boolean addBook(BookItem bookItem) throws SQLException;

	public boolean updateBook(Book book) throws SQLException;

	public boolean deleteBook(Book book) throws SQLException;

	public Book searchBook(int ID);

	public void viewBook(int ID);
	
	public List<BookItem> viewAllBooks() throws SQLException;

}