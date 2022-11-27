package myPkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankexamp.BankTransactLocal;


@WebServlet("/transact")
public class transact extends HttpServlet 
{
	BankTransactLocal bankTransact =  lookupBankTransactLocal();
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{
		try(PrintWriter out = res.getWriter())
		{
			String selectType = req.getParameter("transaction");
			int amount = Integer.parseInt(req.getParameter("t1"));
			
			if(selectType.equals("deposit"))
			{
				int amt = bankTransact.deposit(amount);
				out.println(amount+" successfully withdrawn. Your balance is: Rs."+ amt);
			}
			if(selectType.equals("withdraw"))
			{
				int amt = bankTransact.withdraw(amount);
				out.println(amount+" successfully withdrawn. Your balance is: Rs."+ amt);
			}
		}
	}
	
	private BankTransactLocal lookupBankTransactLocal()
	{
		try
		{
			Context c = new InitialContext();
			return (BankTransactLocal) lookup("java:global/Bank/Bank-ejb/BankTransact!bankexmp.BankTransactLocal")
		}
		catch(NamingException ne)
		{
			Logger.getLogger(getClass().getName().log(Level.SERVE, "exception caught", ne));
			throw new RuntimeException(ne);
		}
	}
}
