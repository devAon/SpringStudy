package org.sopt.seminar5.service;

import org.sopt.seminar5.model.CommentReq;
import org.sopt.seminar5.model.DefaultRes;

public interface CommentService {
    DefaultRes getAllComment();
    DefaultRes postComment(CommentReq commentReq);
    DefaultRes updateComment(final int idx, CommentReq commentReq);
    DefaultRes deleteByCommentIdx(final int idx);
}
