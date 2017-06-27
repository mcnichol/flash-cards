import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class Question {
    int id;
    String category;
    List<String> keywords;

    String questionText;
    String questionImageUrl;

    List<String> responses;

    Integer answerIndex;
    String answerExplanation;
}