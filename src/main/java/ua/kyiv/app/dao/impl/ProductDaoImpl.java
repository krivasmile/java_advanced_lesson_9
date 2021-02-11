package ua.kyiv.app.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.kyiv.app.dao.ProductDao;
import ua.kyiv.app.domain.Bucket;
import ua.kyiv.app.domain.Product;
import ua.kyiv.app.utils.ConnectionUtil;

public class ProductDaoImpl implements ProductDao {
	private static String READ_ALL = "select * from product";
	private static String CREATE = "insert into product(name, description, price) value(?,?,?)";
	private static String READ_BY_ID = "select * from product where id =?";
	private static String UPDATE_BY_ID = "update product set name=?, description =?, price=? where id =?";
	private static String DELETE_BY_ID = "delete from product where id =?";

	private Connection connection;
	private PreparedStatement preparedStatemant;
	private static Logger LOG = Logger.getLogger(ProductDaoImpl.class);

	public ProductDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtil.openConnection();
	}

	@Override
	public Product create(Product product) {
		try {
			preparedStatemant = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatemant.setString(1, product.getName());
			preparedStatemant.setString(2, product.getDescription());
			preparedStatemant.setDouble(3, product.getPrice());
			preparedStatemant.executeUpdate();

			ResultSet resultSet = preparedStatemant.getGeneratedKeys();
			resultSet.next();
			product.setId(resultSet.getInt(1));
		} catch (SQLException e) {
			LOG.error(e);
		}
		return product;
	}

	@Override
	public Product read(int id) {
		Product product = null;
		try {
			preparedStatemant = connection.prepareStatement(READ_BY_ID);
			preparedStatemant.setInt(1, id);
			ResultSet result = preparedStatemant.executeQuery();
			result.next();

			String name = result.getString("name");
			String description = result.getString("description");
			Double price = result.getDouble("price");
			product = new Product(id, name, description, price);
		} catch (SQLException e) {
			LOG.error(e);
		}

		return product;
	}

	@Override
	public Product update(Product product) {
		try {
			preparedStatemant = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatemant.setString(1, product.getName());
			preparedStatemant.setString(2, product.getDescription());
			preparedStatemant.setDouble(3, product.getPrice());
			preparedStatemant.setInt(4, product.getId());
			preparedStatemant.executeUpdate();
		} catch (SQLException e) {
			LOG.error(e);
		}

		return product;
	}

	@Override
	public void delete(int id) {
		try {
			preparedStatemant = connection.prepareStatement(DELETE_BY_ID);
			preparedStatemant.setInt(1, id);
			preparedStatemant.executeUpdate();
		} catch (SQLException e) {
			LOG.error(e);
		}
	}

	@Override
	public List<Product> readAll() {
		List<Product> list = new ArrayList<>();
		try {
			preparedStatemant = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatemant.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				Double price = result.getDouble("price");
				list.add(new Product(id, name, description, price));
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		return list;
	}

}
