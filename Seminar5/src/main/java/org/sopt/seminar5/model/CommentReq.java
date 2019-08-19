package org.sopt.seminar5.model;

import lombok.Data;

@Data
public class CommentReq {
    private int idx;
    private int user_idx;
    private String content;
}
