package by.project.trucking_v2.model;

public enum Role {
    ADMINISTRATOR,
    CLIENT,
    CARRIER,
    UNDEFINED;


    public static Role getByOrdinal(int ordinal) {
        Role[] values = Role.values();
        if (ordinal >= values.length || ordinal < 0) {
            return UNDEFINED;
        }
        return values[ordinal];
    }

}

