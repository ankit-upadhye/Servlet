package com.ankit.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ankit.entity.LoginDetails;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		
		String checkUser=request.getParameter("username");
		String checkPassword=request.getParameter("password");
		LoginService service;
		
		try {
			service = new LoginService();
			List<LoginDetails> list=service.getDetails();
			boolean b=false;
			for(LoginDetails l: list)
			{
				if(checkUser.equals(l.getUsername()))
				{
					if(checkPassword.equals(l.getPassword()))
					{
						pw.println("<html><h1 style=\"color:green\">Login Successfull</h1></html>");
						b=true;
					}
				}
			}
			if(b==false)
			{
				pw.println("<html><h1 style=\"color:red\">Invalid Username or Password</h1></html>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
