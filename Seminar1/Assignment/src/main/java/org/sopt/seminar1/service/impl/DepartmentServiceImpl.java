package org.sopt.seminar1.service.impl;

import org.sopt.seminar1.model.Department;
import org.sopt.seminar1.model.builder.DepartmentBuilder;
import org.sopt.seminar1.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public Department getByDepartmentName(String DepartmentName) {
        final DepartmentBuilder db = new DepartmentBuilder();
        final Department department =
                db.setDepId(1)
                .setName("Computer Science")
                .setPhoneNum("02-940")
                .setType("Engineering")
                .build();
        return department;
    }
}
