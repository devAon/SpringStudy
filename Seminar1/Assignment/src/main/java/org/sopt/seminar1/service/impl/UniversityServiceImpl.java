package org.sopt.seminar1.service.impl;

import org.sopt.seminar1.model.University;
import org.sopt.seminar1.model.builder.UniversityBuilder;
import org.sopt.seminar1.service.UniversityService;

public class UniversityServiceImpl implements UniversityService {
    @Override
    public University getByUnibersityName(String universityName) {
        final UniversityBuilder ub = new UniversityBuilder();
        final University university =
                ub.setAddress("seoul")
                .setId(1)
                .setName("Dongduk Women University")
                .setPhoneNum("02-940")
                .build();
        return university;
    }
}
