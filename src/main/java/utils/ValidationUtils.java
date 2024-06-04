package utils;

public class ValidationUtils {
    public static boolean validNo(int no) {
        if (no <= 9 && no >= 0) {
            return true;
        }
        return false;
    }
}
