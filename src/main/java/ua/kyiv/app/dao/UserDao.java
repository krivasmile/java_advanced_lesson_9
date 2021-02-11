package ua.kyiv.app.dao;

import ua.kyiv.app.domain.User;
import ua.kyiv.app.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User> {
	public User getUserByEmail(String email);
}
