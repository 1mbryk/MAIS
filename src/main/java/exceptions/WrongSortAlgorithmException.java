package exceptions;

public class WrongSortAlgorithmException extends RuntimeException {
    public WrongSortAlgorithmException(String algorithmName) {
        super("There is no \"" + algorithmName + "\" sort algorithm!\n" +
                "Provided algorithms:\n" +
                "quick\n" +
                "bubble\n" +
                "insertion\n");
    }
}
