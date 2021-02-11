package ua.kyiv.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.kyiv.app.domain.Product;
import ua.kyiv.app.service.ProductService;
import ua.kyiv.app.service.impl.ProductServiceImpl;


public class ProductController extends HttpServlet {

	private ProductService productService = ProductServiceImpl.getProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("id");
		
		Product product = productService.read(Integer.parseInt(productId));
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("singleProduct.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		
		Product product  = new Product(name, description, getValidatedPrice(price));
		
		productService.create(product);
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
	
	private double getValidatedPrice(String price) {
		if(price == null || price.isEmpty()) {
			return 0;
		}
		else
		return Double.parseDouble(price);
	}

}
