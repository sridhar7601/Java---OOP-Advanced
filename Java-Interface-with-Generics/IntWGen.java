public class IntWGen implements GenericInterface<String> {

    @Override
    public String performOperation(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        IntWGen reverser = new IntWGen();
        System.out.println("Reversed String: " + reverser.performOperation("Generics"));
    }
}

