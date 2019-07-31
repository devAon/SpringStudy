package org.sopt.seminar1;

import org.sopt.seminar1.model.Department;
import org.sopt.seminar1.model.Professor;
import org.sopt.seminar1.model.Student;
import org.sopt.seminar1.model.University;
import org.sopt.seminar1.service.impl.DepartmentServiceImpl;
import org.sopt.seminar1.service.impl.ProfessorServiceImpl;
import org.sopt.seminar1.service.impl.StudentServiceImpl;
import org.sopt.seminar1.service.impl.UniversityServiceImpl;


import java.util.ArrayList;

    public class Main {
        public static void main(String[] args) {
            final ArrayList<University> universityList = new ArrayList<>();
            final ArrayList<Department> departmentList = new ArrayList<>();
            final ArrayList<Professor> professorList = new ArrayList<>();
            final ArrayList<Student> studentList = new ArrayList<>();

            final University university1 = new University();
            final University university2 = new University();
            final University university3 = new UniversityServiceImpl().getByUnibersityName("동덕여자대학교");

            universityList.add(university1);
            universityList.add(university2);
            universityList.add(university3);

            for(final University uni : universityList){
                System.out.println(uni);
            }

            final Student student1 = new Student();
            final Student student2 = new Student();
            final Student student3 = new StudentServiceImpl().getByStudentIdx(1);

            studentList.add(student1);
            studentList.add(student2);
            studentList.add(student3);

            for(final Student stu : studentList){
                System.out.println(stu);
            }

            final Department department1 = new Department();
            final Department department2 = new Department();
            final Department department3 = new DepartmentServiceImpl().getByDepartmentName("Computer Science");

            departmentList.add(department1);
            departmentList.add(department2);
            departmentList.add(department3);

            for(final Department dep : departmentList){
                System.out.println(dep);
            }

            final Professor professor1 = new Professor();
            final Professor professor2 = new Professor();
            final Professor professor3 = new ProfessorServiceImpl().getByProfessorIdx(1);

            professorList.add(professor1);
            professorList.add(professor2);
            professorList.add(professor3);

            for(final Professor pro : professorList){
                System.out.println(pro);
            }
        }
}
