package data;

import data.entity.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserSort {

    public static final Comparator<User> SORT_NAME = new Comparator<User>() {
        public int compare(User user1, User user2) {
            String name1 = user1.getName();
            String name2 = user2.getName();
            int res = String.CASE_INSENSITIVE_ORDER.compare(name1, name2);
            if (res == 0) {
                res = name1.compareTo(name2);
            }
            return res;
        }
    };

    public static final Comparator<User> SORT_EMAIL = new Comparator<User>() {
        public int compare(User user1, User user2) {
            int res = String.CASE_INSENSITIVE_ORDER.compare(user1.getEmail(), user2.getEmail());
            if (res == 0) {
                res = user1.getEmail().compareTo(user2.getEmail());
            }
            return res;
        }
    };

    public static final Comparator<User> SORT_PHONE_NUMBER = new Comparator<User>() {
        public int compare(User user1, User user2) {
            int res = String.CASE_INSENSITIVE_ORDER.compare(user1.getPhoneNumber(), user2.getPhoneNumber());
            if (res == 0) {
                res = user1.getPhoneNumber().compareTo(user2.getPhoneNumber());
            }
            return res;
        }
    };

}
