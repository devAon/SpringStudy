package org.sopt.seminar1.service.impl;

import org.sopt.seminar1.model.Student;
import org.sopt.seminar1.model.builder.StudentBuilder;
import org.sopt.seminar1.service.StudentService;

public class StudentServiceImpl implements StudentService {

    @Override
    public Student getByStudentIdx(int studentIdx) {
        final StudentBuilder sb = new StudentBuilder();
        final Student  st =
                sb.setAddress("seoul")
                .setAge(23)
                .setGrade(4)
                .seteMail("helloworld.gmail")
                .setId(1)
                .setMajor("Computer Science")
                .setName("Yewon Choi")
                .setState("in University")
                .build();

        return st;
    }
}
