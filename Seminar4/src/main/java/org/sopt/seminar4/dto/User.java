package org.sopt.seminar4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int idx;
    private String name;
    private String part;
}
