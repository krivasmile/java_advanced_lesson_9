package ua.kyiv.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.kyiv.app.dao.UserDao;
import ua.kyiv.app.domain.User;
import ua.kyiv.app.utils.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	private static String READ_ALL = "select * from user";
	private static String CREATE = "insert into user(firstName, lastName, email, role, password) value(?, ?, ?, ?, ?)";
	private static String READ_BY_ID = "select * from user where id =?";
	private static String READ_BY_EMAIL = "select * from user where email =?";
	private static String UPDATE_BY_ID = "update user set firstName=?, lastName =?, email=?, role=?, password=? where id =?";
	private static String DELETE_BY_ID = "delete from user where id =?";

	private Connection connection;
	private PreparedStatement preparedStatemant;
	private static Logger LOG = Logger.getLogger(UserDaoImpl.class);

	public UserDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtil.openConnection();
	}

	@Override
	public User create(User user) {
		try {
			preparedStatemant = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatemant.setString(1, user.getFirstName());
			preparedStatemant.setString(2, user.getLastName());
			preparedStatemant.setString(3, user.getEmail());
			preparedStatemant.setString(4, user.getRole());
			preparedStatemant.setString(5, user.getPassword());
			preparedStatemant.executeUpdate();

			ResultSet resultSet = preparedStatemant.getGeneratedKeys();
			resultSet.next();
			user.setId(resultSet.getInt(1));
		} catch (SQLException e) {
			LOG.error(e);
		}
		return user;
	}

	@Override
	public User read(int id) {
		User user = null;
		try {
			preparedStatemant = connection.prepareStatement(READ_BY_ID);
			preparedStatemant.setInt(1, id);
			ResultSet result = preparedStatemant.executeQuery();
			result.next();

			String firstName = result.getString("firstName");
			String lastName = result.getString("lastName");
			String email = result.getString("email");
			String role = result.getString("role");
			String password = result.getString("password");
			user = new User(id, firstName, lastName, email, role, password);
		} catch (SQLException e) {
			LOG.error(e);
		}

		return user;
	}

	@Override
	public User update(User user) {
		try {
			preparedStatemant = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatemant.setString(1, user.getFirstName());
			preparedStatemant.setString(2, user.getLastName());
			preparedStatemant.setString(3, user.getEmail());
			preparedStatemant.setString(4, user.getRole());
			preparedStatemant.setString(5, user.getPassword());
			preparedStatemant.setInt(6, user.getId());
			preparedStatemant.executeUpdate();
		} catch (SQLException e) {
			LOG.error(e);
		}

		return user;
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
	public List<User> readAll() {
		List<User> list = new ArrayList<>();
		try {
			preparedStatemant = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatemant.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String email = result.getString("email");
				String role = result.getString("role");
				String password = result.getString("password");
				list.add(new User(id, firstName, lastName, email, role, password));
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		return list;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		try {
			preparedStatemant = connection.prepareStatement(READ_BY_EMAIL);
			preparedStatemant.setString(1, email);
			ResultSet result = preparedStatemant.executeQuery();
			result.next();

			Integer id = result.getInt("id");
			String firstName = result.getString("firstName");
			String lastName = result.getString("lastName");
			String role = result.getString("role");
			String password = result.getString("password");
			user = new User(id, firstName, lastName, email, role, password);
		} catch (SQLException e) {
			LOG.error(e);
		}

		return user;
	}

}
