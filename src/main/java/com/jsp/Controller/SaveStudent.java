package com.jsp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.Service.StudentService;
import com.jsp.dto.Student;
@WebServlet("/save")
public class SaveStudent extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String loc = req.getParameter("loc");

		Student student=new Student();
		student.setName(name);
		student.setEmail(email);
		student.setLoc(loc);

		StudentService studentService = new StudentService();
		studentService.saveStudent(student);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(req, resp);
	}

}
