package com.mcnichol.training.java;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Response {
    private boolean isCorrect;
}
