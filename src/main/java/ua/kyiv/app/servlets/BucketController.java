package ua.kyiv.app.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.kyiv.app.domain.Bucket;
import ua.kyiv.app.service.BucketService;
import ua.kyiv.app.service.impl.BucketServiceImpl;

public class BucketController extends HttpServlet {
	
	private	BucketService bucketService = BucketServiceImpl.getBucketServiceImpl();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		LocalDate lt = LocalDate.now(); 
		java.sql.Date sqlDate = java.sql.Date.valueOf(lt);
		
		Bucket bucket = new Bucket(userId, Integer.parseInt(productId), sqlDate);
		bucketService.create(bucket);
		
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
