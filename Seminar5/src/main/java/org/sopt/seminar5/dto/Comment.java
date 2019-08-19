package org.sopt.seminar5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
    private int idx;
    private int user_idx;
    private String content;
}
