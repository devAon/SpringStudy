package org.sopt.seminar1.service;

import org.sopt.seminar1.model.Department;

public interface DepartmentService {
    Department getByDepartmentName(final String DepartmentName);
}
