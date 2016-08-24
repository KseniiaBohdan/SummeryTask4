package data.entity;

import java.io.Serializable;

public enum Role implements Serializable {
    USER(1), ADMIN(2);

    private int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Role getRole(int roleId) {
        for (Role r : values()) {
            if (r.getId() == roleId) {
                return r;
            }
        }
        return USER;
    }
}


