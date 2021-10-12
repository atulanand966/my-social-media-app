package com.socialmedia.mysocialmediaapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.socialmedia.mysocialmediaapp.entities.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private List<User> users;
	private static int id;
	
	static {
		id = 0;
	}

	public UserDAOImpl() {
		users = new ArrayList<User>();
		users.add(new User(++id, "Leanne Graham", "Bret", "Sincere@april.biz", "1-770-736-8031 x56442", "hildegard.org"));
		users.add(new User(++id, "Ervin Howell", "Antonette", "Shanna@melissa.tv", "010-692-6593 x09125", "anastasia.net"));
		users.add(new User(++id, "Clementine Bauch", "Samantha", "Nathan@yesenia.net", "1-463-123-4447", "ramiro.info"));
	}



	@Override
	public List<User> findAll() {
		
		return users;
	}



	@Override
	public User findOne(int id) {
		
		for(User user :users) {
			if(user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}

}
