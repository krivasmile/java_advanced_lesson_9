package ua.kyiv.app.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.kyiv.app.dao.ProductDao;
import ua.kyiv.app.dao.impl.ProductDaoImpl;
import ua.kyiv.app.domain.Product;
import ua.kyiv.app.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private static Logger LOG = Logger.getLogger(ProductServiceImpl.class);
	private ProductDao productDao;
	private static ProductServiceImpl productServiceImpl;

	private ProductServiceImpl() {
		try {
			productDao = new ProductDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOG.error(e);
		}
	}
	
	public static ProductServiceImpl getProductServiceImpl() {
		if (productServiceImpl == null) {
			productServiceImpl = new ProductServiceImpl();
		}
		return productServiceImpl;
	}

	@Override
	public Product create(Product t) {
		return productDao.create(t);
	}

	@Override
	public Product read(int id) {
		return productDao.read(id);
	}

	@Override
	public Product update(Product t) {
		return productDao.update(t);
	}

	@Override
	public void delete(int id) {
		productDao.delete(id);
	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}

}
