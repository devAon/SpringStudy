package org.sopt.seminar1.service.impl;

import org.sopt.seminar1.model.Professor;
import org.sopt.seminar1.model.builder.ProfessorBuilder;
import org.sopt.seminar1.service.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {
    @Override
    public Professor getByProfessorIdx(int professorIdx) {
        final ProfessorBuilder pb = new ProfessorBuilder();
        final Professor professor = pb
                .setId(1)
                .setName("Junghun Jun")
                .setPhoneNum("010-0000-0000")
                .setType("System Security")
                .build();
        return professor;
    }
}
