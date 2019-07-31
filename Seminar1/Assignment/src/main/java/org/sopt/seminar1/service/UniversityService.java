package org.sopt.seminar1.service;

import org.sopt.seminar1.model.University;

public interface UniversityService {
    University getByUnibersityName(final String universityName);
}
