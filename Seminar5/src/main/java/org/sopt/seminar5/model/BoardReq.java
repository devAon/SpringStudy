package org.sopt.seminar5.model;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BoardReq {
    private int idx;
    private String title;
    private String contents;
    private MultipartFile profile;
    private String profileUrl;

}
