package ua.kyiv.app.service;

import ua.kyiv.app.domain.User;
import ua.kyiv.app.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
	public User getUserByEmail(String email);
}
