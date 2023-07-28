public class ThrowingExceptions {
    public static void validateNumber( int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
    }
}
