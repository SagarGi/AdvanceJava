package com.profilemanagement.all;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginRegisterController
 */
@WebServlet("/loginRegister")
public class LoginRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRegisterController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		logical section here
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		String education = request.getParameter("education");
		String profession = request.getParameter("profession");
		String gender= request.getParameter("gender");
		String submitType = request.getParameter("submit");
		UserDao userDao = new UserDaoImp();
		
//		
		UserPojo user = userDao.getUser(email, password);
		
		if(submitType.equals("login") && user!= null && user.getEmail() != null)
		{
			HttpSession mysession = request.getSession(); // setting a session
			mysession.setAttribute("email", email);
			request.setAttribute("email", user.getEmail()); // passing data
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
		else if(submitType.equals("register"))
		{
			user.setEmail(email);
			user.setPassword(password);
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setCity(city);
			user.setCountry(country);
			user.setPhone(phone);
			user.setEducation(education);
			user.setProfession(profession);
			user.setGender(gender);
			userDao.insertUser(user);
			request.setAttribute("successmessage", "Data Successfully Registered Please Login!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("message", "Data Not Found!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
