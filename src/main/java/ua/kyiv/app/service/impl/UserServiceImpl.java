package ua.kyiv.app.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.kyiv.app.dao.UserDao;
import ua.kyiv.app.dao.impl.UserDaoImpl;
import ua.kyiv.app.domain.User;
import ua.kyiv.app.service.UserService;

public class UserServiceImpl implements UserService {
	private static Logger LOG = Logger.getLogger(UserServiceImpl.class);
	private UserDao userDao;
	private static UserServiceImpl userServiceImpl;

	private UserServiceImpl() {
		try {
			userDao = new UserDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOG.error(e);
		}
	}
	
	public static UserServiceImpl getUserServiceImpl() {
		if (userServiceImpl == null) {
			userServiceImpl = new UserServiceImpl();
		}
		return userServiceImpl;
	}

	@Override
	public User create(User t) {
		return userDao.create(t);
	}

	@Override
	public User read(int id) {
		return userDao.read(id);
	}

	@Override
	public User update(User t) {
		return userDao.update(t);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

}
