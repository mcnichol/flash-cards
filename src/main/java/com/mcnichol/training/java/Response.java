package com.mcnichol.training.java;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Value
public class Response {
    private boolean isCorrect;
}
