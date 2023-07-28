public class CheckedVsUnchecked {
    public static void validateString( String string) throws EmptyStringException{
        if (string.isEmpty()) {
            throw new EmptyStringException("String is empty");
        }
    }
}
