package by.project.trucking_v2.model;

public enum Status {
    AVALIABLE,
    NOT_AVALIABLE,
    BUSY,
    UNDEFINED;

    public static Status getByOrdinal(int ordinal) {
        Status[] values = Status.values();
        if(ordinal >= values.length || ordinal < 0) {
            return UNDEFINED;
        }
        return values[ordinal];
    }
}