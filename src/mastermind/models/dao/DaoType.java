package mastermind.models.dao;

public enum DaoType {
    DB,
    FILE;

    public static DaoType parser(String string) {
        for (DaoType frameType : DaoType.values()) {
            if (frameType.name().equalsIgnoreCase(string)) {
                return frameType;
            }
        }
        return DaoType.FILE;
    }
}