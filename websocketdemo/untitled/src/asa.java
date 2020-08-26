import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class asa {
    public static void main(String[] args) {


        List<String> words = Arrays.asList(new String[]{"Ni", "Hao", "Lambda"});
        // lambda±Ì¥Ô Ω
        List<String> lowercaseWords2 = words.stream().map(word -> {
            return word.toLowerCase();
        }).collect(Collectors.toList());

        words.stream().map(word -> word.toLowerCase()).collect(Collectors.toList());

        
    }
}
