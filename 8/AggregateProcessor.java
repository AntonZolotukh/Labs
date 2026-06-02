import java.util.List;
import java.util.stream.Collectors;

public class AggregateProcessor {
    @DataProcessor
    public List<String> removeDuplicates(List<String> input) {
        return input.stream().distinct().collect(Collectors.toList());
    }
    @DataProcessor
    public List<String> sortAlphabetically(List<String> input) {
        return input.stream().sorted().collect(Collectors.toList());
    }
}
