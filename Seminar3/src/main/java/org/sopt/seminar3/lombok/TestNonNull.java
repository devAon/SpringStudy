package org.sopt.seminar3.lombok;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class TestNonNull {
    private int userIdx;
    @NonNull
    private String name;
    private String email;
}
