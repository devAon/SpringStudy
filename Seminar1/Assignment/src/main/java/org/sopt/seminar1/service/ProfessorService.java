package org.sopt.seminar1.service;

import org.sopt.seminar1.model.Professor;

public interface ProfessorService {
    Professor getByProfessorIdx(final int professorIdx);
}
