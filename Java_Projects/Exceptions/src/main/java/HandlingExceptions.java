public class HandlingExceptions {
    public static void main(String[] args) {
        try{
            ThrowingExceptions.validateNumber(-3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
