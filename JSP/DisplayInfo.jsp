<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>

	<%@	page import="java.io.*" %>
	<%@	page import="javax.servlet.*" %>
	<%@	page import="javax.servlet.annotation.WebServlet" %>
	<%@	page import="javax.servlet.http.*" %>
	<%@	page import="java.sql.*" %>
	
	<% 
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql:// localhost:3306/";
		String dbName = "WT_Assignment_No_6";
		String dbUsername = "root";
		String dbPassword = "Omkhedkar@123";
		
		String city = request.getParameter("city");
		out.println("<strong> You have Requested for details of students having city =>" + city);
			
		try 
		{
			Class.forName(dbDriver);
			Connection conn = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
			Statement s = conn.createStatement();
			
			String query = "", stud_name = "", classs = "";
			int stud_id = 0, division = 0;
			
			query = "SELECT * FROM Student WHERE city = '"+ city + "'";
			ResultSet rs  = s.executeQuery(query);
			
			out.println("<table border='2px' style='border-collapse: collapse; ' >  <tr style='background-color: #96D4D4;'> <td>ID</td> <td>NAME</td> <td>CLASS</td> <td>DIVISION</td> <td>CITY</td> </tr>  <br>");
			boolean flag = false;
			
			while(rs.next())
			{
				stud_id = rs.getInt("stud_id");
				stud_name = rs.getString("stud_name");
				classs = rs.getString("class");
				division = rs.getInt("division");
				city = rs.getString("city");
				if(!flag)
				{
					out.println("<tr> <td>"+ stud_id + "</td> <td> "+ stud_name +"</td> <td> " + classs +"</td> <td>" + division +"</td> <td>" + city +"</td> </tr>  <br>");
					flag = true;
				}
				else
				{
					out.println("<tr style='background-color: #96D4D4;'> <td>"+ stud_id + "</td> <td> "+ stud_name +"</td> <td> " + classs +"</td> <td>" + division +"</td> <td>" + city +"</td> </tr>  <br>");
					flag = false;
				}
			}
        }
        catch (Exception e) 
		{
            e.printStackTrace();
        }			
	%>
</body>
</html>