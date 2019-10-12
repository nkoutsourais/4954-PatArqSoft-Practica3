package mastermind.distributed.dispatchers;

public enum FrameType {
    START,
    NEW_GAME,
    STATE,
    PROPOSE,
    UNDO,
    REDO,
    UNDOABLE,
    REDOABLE,
    IS_LOOSER,
    IS_WINNER,
    GET_ATTEMPTS,
    GET_COLORS,
    GET_BLAKS,
    GET_WHITES,
    WIDTH,
    CLOSE;

    public static FrameType parser(String string) {
        for (FrameType frameType : FrameType.values()) {
            if (frameType.name().equals(string)) {
                return frameType;
            }
        }
        return null;
    }
}
