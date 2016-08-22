package entity;

import java.io.Serializable;

public enum Role implements Serializable{
    CLIENT, ADMIN;

    public static Role getRole(User user) {
        long roleId = user.getRoleId();
        return Role.values()[(int) roleId];
    }

    public String getName() {
        return name().toLowerCase();
    }

}


