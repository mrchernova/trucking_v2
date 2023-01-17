package by.project.trucking_v2.model;

/**
 * AVALIABLE        - [transport]/[drivers]/[orders] статус доступен
 * NOT_AVALIABLE    - [transport]/[drivers]/[orders] недоступен (в ремонте, болеет или что-то пошло не так)
 * BUSY             - [transport]/[drivers] выполняется заказ
 * IN_PROGRESS      - [orders] выполняется заказ. Данные заносятся в [completed_orders]
 * SUCCESSFUL       - [orders] означает что заказ выполнен. Данные заносятся в [completed_orders]
 * UNDEFINED        - устанавливается в непредвиденных ситуациях
 * ACTIVE           - [users]
 * BANNED           - [users]
 */
public enum Status {
    AVALIABLE,
    NOT_AVALIABLE,
    BUSY,
    IN_PROGRESS,
    SUCCESSFUL,
    ACTIVE,
    BANNED,
    UNDEFINED;

    public static Status getByOrdinal(int ordinal) {
        Status[] values = Status.values();
        if(ordinal >= values.length || ordinal < 0) {
            return UNDEFINED;
        }
        return values[ordinal];
    }
}