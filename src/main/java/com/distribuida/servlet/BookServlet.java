package com.distribuida.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.distribuida.model.Book;
import com.distribuida.rest.BookService;


@WebServlet(urlPatterns = "/books")
public class BookServlet  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	@RestClient
	BookService bookService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Book> books = bookService.list();

		req.setAttribute("books", books);	

        req.getRequestDispatcher("/books.jsp").forward(req, resp);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String method = req.getParameter("method");
		
		if(method.equals("show")) {

			Long id = Long.parseLong(req.getParameter("id"));
			Book book= bookService.getBook(id);
			
			req.setAttribute("book", book);

	        req.getRequestDispatcher("/book.jsp").forward(req, resp);
			
		}
		
		if(method.equals("delete")) {

			Long id = Long.parseLong(req.getParameter("id"));
			
			bookService.delete(id);
			
			this.doGet(req, resp);
			
			
		}
		
		if(method.equals("edit")) {

			Long id = Long.parseLong(req.getParameter("id"));
			Book book= bookService.getBook(id);
			
			req.setAttribute("book", book);

	        req.getRequestDispatcher("/book-edit.jsp").forward(req, resp);
			
			
		}
		
		if(method.equals("put")) {

			Long id = Long.parseLong(req.getParameter("id"));
			Book book= new Book();
			book.setAuthor_id(Long.parseLong(req.getParameter("author_id")));
			book.setIsbn(req.getParameter("isbn"));
			book.setTitle(req.getParameter("title"));
			
			bookService.update(id, book);

			this.doGet(req, resp);
			
			
		}
		
		if(method.equals("create")) {


	        req.getRequestDispatcher("/book-create.jsp").forward(req, resp);
			
			
		}
		
		if(method.equals("store")) {

			Book book= new Book();
			book.setAuthor_id(Long.parseLong(req.getParameter("author_id")));
			book.setIsbn(req.getParameter("isbn"));
			book.setTitle(req.getParameter("title"));
			
			bookService.add(book);

			this.doGet(req, resp);
			
		}
		
		
		
	}
	
	
}