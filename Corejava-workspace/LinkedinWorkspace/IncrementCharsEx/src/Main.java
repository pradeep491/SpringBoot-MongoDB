import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(incrementCharacters("bHz"));
    }

    private static String incrementCharacters(String input) {
        return input.chars().map(c -> {
                    if (c >= 'a' && c <= 'z') {
                        return (c == 'z') ? 'a' : c + 1;
                    } else if (c >= 'A' && c <= 'Z') {
                        return (c == 'Z') ? 'A' : c + 1;
                    } else {
                        return c;
                    }
                }).mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}