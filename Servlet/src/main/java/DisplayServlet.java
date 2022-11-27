import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;


@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public DisplayServlet() 
    {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.println("<title> Book Details </title>");
		
		String id = request.getParameter("bid");
		pw.println("<strong> You have Requested for a book with Book Id =>" + id);
		
		try 
		{
            Connection conn = DatabaseConnection.initializeDatabase();
			String query = "", book_id="", book_title="", book_author="";
			int book_price=0, quantity=0;
			
			Statement s = conn.createStatement();
			query = "SELECT * FROM eBookShop WHERE book_id = '"+ id + "'";
			ResultSet rs  = s.executeQuery(query);
			pw.println("<table border='2px' style='border-collapse: collapse' >  <tr style='background-color: #96D4D4;'> <td>ID</td> <td>TITLE</td> <td>AUTHOR</td> <td>PRICE</td> <td>QUANTITY</td> </tr>  <br>");
			
			boolean flag = false;
			while(rs.next())
			{
				book_id = rs.getString("book_id");
				book_title = rs.getString("book_title");
				book_author = rs.getString("book_author");
				book_price = rs.getInt("book_price");
				quantity = rs.getInt("quantity");
				
				if(!flag)
				{
					pw.println("<tr> <td>"+ book_id + "</td> <td> "+ book_title +"</td> <td> " + book_author +"</td> <td>" + book_price +"</td> <td>" + quantity +"</td> </tr>  <br>");
					flag = true;
				}
				else
				{
					pw.println("<tr 'background-color: #96D4D4;'> <td>"+ book_id + "</td> <td> "+ book_title +"</td> <td> " + book_author +"</td> <td>" + book_price +"</td> <td>" + quantity +"</td> </tr>  <br>");
					flag = true;
				}
			}
        }
        catch (Exception e) 
		{
            e.printStackTrace();
        }
		
	}

}
