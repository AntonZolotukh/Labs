import java.util.List;
import java.util.stream.Collectors;

public class TransformProcessor {
    @DataProcessor
    public List<String> toUpperCase(List<String> input) {
        return input.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
    @DataProcessor
    public List<String> addPrefix(List<String> input) {
        return input.stream().map(s -> "DATA: " + s).collect(Collectors.toList());
    }
}
