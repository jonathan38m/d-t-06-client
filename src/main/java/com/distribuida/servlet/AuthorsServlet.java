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

import com.distribuida.model.Author;
import com.distribuida.model.Book;
import com.distribuida.rest.AuthorService;




@WebServlet(urlPatterns = {"/", ""})
public class AuthorsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	@RestClient
	AuthorService authorService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Author> authors = authorService.list();

		req.setAttribute("authors", authors);	

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String method = req.getParameter("method");
		
		if(method.equals("show")) {

			Long id = Long.parseLong(req.getParameter("id"));
			Author author = authorService.getAuthor(id);
			
			req.setAttribute("author", author);

	        req.getRequestDispatcher("/author.jsp").forward(req, resp);
			
		}
		
		if(method.equals("delete")) {

			Long id = Long.parseLong(req.getParameter("id"));
			
			authorService.delete(id);
			
			this.doGet(req, resp);
			
			
		}
		
		if(method.equals("edit")) {

			Long id = Long.parseLong(req.getParameter("id"));
			Author author = authorService.getAuthor(id);
			
			req.setAttribute("author", author);

	        req.getRequestDispatcher("/author-edit.jsp").forward(req, resp);
			
			
		}
		
		if(method.equals("put")) {

			Long id = Long.parseLong(req.getParameter("id"));
			Author author = new Author();
			author.setAge(Integer.parseInt(req.getParameter("age")));
			author.setGenre(req.getParameter("gender"));
			author.setName(req.getParameter("name"));
			
			authorService.update(id, author);

			this.doGet(req, resp);
			
			
		}
		
		if(method.equals("create")) {


	        req.getRequestDispatcher("/author-create.jsp").forward(req, resp);
			
			
		}
		
		if(method.equals("store")) {

			Author author = new Author();
			author.setAge(Integer.parseInt(req.getParameter("age")));
			author.setGenre(req.getParameter("gender"));
			author.setName(req.getParameter("name"));
			
			authorService.add(author);

			this.doGet(req, resp);
			
			
		}

		
		if(method.equals("getbooks")) {

			Long id = Long.parseLong(req.getParameter("id"));

			List<Book> books= authorService.getBooksByAuthor(id);

			req.setAttribute("books", books);	

	        req.getRequestDispatcher("/author-books.jsp").forward(req, resp);			
		}
		
		
		
	}
	
	
}
