package com.test.microservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marks {
    private int minMarks;
    private int maxMarks;
}
