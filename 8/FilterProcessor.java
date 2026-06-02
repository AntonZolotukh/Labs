import java.util.List;
import java.util.stream.Collectors;

public class FilterProcessor {
    @DataProcessor
    public List<String> filterLongWords(List<String> input) {
        return input.stream().filter(w -> w.length() <= 10).collect(Collectors.toList());
    }
    @DataProcessor
    public List<String> filterEmpty(List<String> input) {
        return input.stream().filter(l -> l != null && !l.trim().isEmpty()).collect(Collectors.toList());
    }
}
