package org.sopt.seminar3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    private int idx;
    private String title;
    private String contents;

    @Override
    public String toString() {
        return
                "idx=" + idx +
                        ", title='" + title +
                        ", contents='" + contents + "\n";
    }
}
