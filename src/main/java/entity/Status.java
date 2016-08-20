package entity;

import java.io.Serializable;

public enum Status implements Serializable{
    BLOCKED, UNBLOCKED, DELETED;

    public static Status getStatus(User entity) {
        long statusId = entity.getStatusId();
        return Status.values()[(int) statusId];
    }

    public static Status getStatus(Card entity) {
        long statusId = entity.getStatusId();
        return Status.values()[(int) statusId];
    }

    public static Status getStatus(Account entity) {
        long statusId = entity.getStatusId();
        return Status.values()[(int) statusId];
    }

    public String getName() {
        return name().toLowerCase();
    }
}
