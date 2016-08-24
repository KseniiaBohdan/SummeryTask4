package data.entity;

import java.io.Serializable;

public enum Status implements Serializable {
    BLOCKED(1), ACTIVE(2), DELETED(3);

    private int id;

    Status(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Status getStatus(int statusId) {
        for (Status s : values()) {
            if (s.getId() == statusId) {
                return s;
            }
        }
        return BLOCKED;
    }
}
