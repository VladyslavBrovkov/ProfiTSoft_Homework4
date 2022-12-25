package repository;

import model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simple in-memory user repository with web-app users
 */
public class UserRepository {
    private static final List<User> users;

    static {
        users = Collections.synchronizedList(new ArrayList<>());
        users.add(new User(1, "admin@gmail.com", "admin", "admin", "Administrator"));
        users.add(new User(2, "firstUser@gmail.com", "firstUser", "user1", "Sergiy Dmytrenko"));
        users.add(new User(3, "secondUser@gmail.com", "secondUser", "user2", "Oleg Prokopenko"));
        users.add(new User(4, "thirdUser@gmail.com", "thirdUser", "user3", "Vasyl Boyko"));
    }

    public static boolean checkUserCredentials(String login, String password) {
        return users.stream()
                .anyMatch(user -> user.getLogin().equals(login) &&
                        user.getPassword().equals(password));
    }

    public static List<User> getAllUsers() {
        return users;
    }
}
