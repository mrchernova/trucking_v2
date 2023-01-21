package by.project.trucking_v2.model;

public enum Role {
    ADMINISTRATOR("Администратор"),
    CLIENT("Заказчик"),
    CARRIER("Перевозчик"),
    UNDEFINED("Неизвестно");

    String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public static Role getByOrdinal(int ordinal) {
        Role[] values = Role.values();
        if (ordinal >= values.length || ordinal < 0) {
            return UNDEFINED;
        }
        return values[ordinal];
    }

}

