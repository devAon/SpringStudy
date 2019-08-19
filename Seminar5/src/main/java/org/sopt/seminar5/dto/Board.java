package org.sopt.seminar5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {
    private int idx;
    private String title;
    private String contents;
    private String profileUrl;
}
