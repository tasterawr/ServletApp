package org.dao;

import org.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**Pseudo data access class*/
public class StudentDao {
    private static List<Student> students = new ArrayList<>();

    public static void addStudent(Student student){
        students.add(student);
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static List<Student> getStudentsBlockchain(){
        return students.stream().filter(x -> x.isKnowsBlockchain()).collect(Collectors.toList());
    }

    public static List<Student> getExcellentStudents(){
        return students.stream().filter(x -> x.getAverageMark() >= 4).collect(Collectors.toList());
    }

    public static void loadData(){
        students.add(new Student("Андреева Ирина", 3.48f, false));
        students.add(new Student("Анферова Анастасия", 3.42f, false));
        students.add(new Student("Беднов Андрей", 4.5f, true));
        students.add(new Student("Белозуб Яна", 4.98f, true));
        students.add(new Student("Белоус Алексей", 3.84f, true));
        students.add(new Student("Котума Андрей", 4.25f, true));
        students.add(new Student("Колодин Денис", 3.08f, false));
        students.add(new Student("Кузьмин Дмитрий", 4.69f, true));
    }
}
