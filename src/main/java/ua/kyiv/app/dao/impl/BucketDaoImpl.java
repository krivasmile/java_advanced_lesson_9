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

import ua.kyiv.app.dao.BucketDao;
import ua.kyiv.app.domain.Bucket;
import ua.kyiv.app.utils.ConnectionUtil;

public class BucketDaoImpl implements BucketDao {
	private static String READ_ALL = "select * from bucket";
	private static String CREATE = "insert into bucket(user_id, product_id, purchase_date) value(?, ?, ?)";
	private static String READ_BY_ID = "select * from bucket where id =?";
	private static String DELETE_BY_ID = "delete from bucket where id =?";

	private Connection connection;
	private PreparedStatement preparedStatemant;
	private static Logger LOG = Logger.getLogger(BucketDaoImpl.class);

	public BucketDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtil.openConnection();
	}

	@Override
	public Bucket create(Bucket bucket) {
		try {
			preparedStatemant = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatemant.setInt(1, bucket.getUserId());
			preparedStatemant.setInt(2, bucket.getProductId());
			preparedStatemant.setDate(3, bucket.getPurcaseDate());
			preparedStatemant.executeUpdate();

			ResultSet resultSet = preparedStatemant.getGeneratedKeys();
			resultSet.next();
			bucket.setId(resultSet.getInt(1));
		} catch (SQLException e) {
			LOG.error(e);
		}
		return bucket;
	}

	@Override
	public Bucket read(int id) {
		Bucket bucket = null;
		try {
			preparedStatemant = connection.prepareStatement(READ_BY_ID);
			preparedStatemant.setInt(1, id);
			ResultSet result = preparedStatemant.executeQuery();
			result.next();

			int userId = result.getInt("user_id");
			int productId = result.getInt("product_id");
			Date purcaseDate = result.getDate("purchase_id");
			bucket = new Bucket(id, userId, productId, purcaseDate);
		} catch (SQLException e) {
			LOG.error(e);
		}
		return bucket;
	}

	@Override
	public Bucket update(Bucket t) {
		throw new IllegalStateException();
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
	public List<Bucket> readAll() {
		List<Bucket> list = new ArrayList<>();
		try {
			preparedStatemant = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatemant.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				int userId = result.getInt("user_id");
				int productId = result.getInt("product_id");
				Date purcaseDate = result.getDate("purchase_id");
				list.add(new Bucket(id, userId, productId, purcaseDate));
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		return list;
	}

}
