import lombok.Value;

import java.util.List;

@Value
public class Quiz {
    List<Question> collection;
}