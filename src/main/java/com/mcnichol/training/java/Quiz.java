package com.mcnichol.training.java;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class Quiz {
    List<Question> collection;
}