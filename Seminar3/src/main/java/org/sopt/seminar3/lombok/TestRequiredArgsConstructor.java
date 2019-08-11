package org.sopt.seminar3.lombok;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestRequiredArgsConstructor {
    private int userIdx;
    @NonNull
    private String name;
    private String email;
}
