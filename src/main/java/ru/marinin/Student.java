package ru.marinin;




import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@ToString
public class Student implements Compare, Cloneable {
    private String name;
    private List<Integer> grades = new ArrayList<>();
    private Deque<Action> actions = new ArrayDeque<>();
    private int undoCounter = -1;

    public Student(String name, Integer... args) {
        this.name = name;
        this.grades = new ArrayList<>(Arrays.asList(args));
    }
    public Student(String name, Predicate<Integer> gradesRange, Integer... args) {
        for (int grade : args) {
            if (gradesRange.test(grade)==false) throw new IllegalArgumentException("grades not correct");
        }
        this.name = name;
        this.grades = new ArrayList<>(Arrays.asList(args));
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        String tmp = this.name;
        actions.push(()->this.name=tmp);
        undoCounter++;
        this.name = name;
    }

    public List<Integer> getGrades() {
        return new ArrayList(grades);
    }
    public void removeGrade(int index) {
        int grade = grades.get(index);
        actions.push(()->grades.add(index,grade));
        undoCounter++;
        grades.remove(index);
    }

//    public void addGrade(int... grades) {
//        int count = grades.length;
//        for (int i=0; i<count; i++) {
//            this.grades.add(grades[i]);
//        }
//        actions.push(()-> {
//            for (int i = 0; i < count; i++)
//                this.grades.removeLast();
//        });
//        undoCounter++;
//    }



    public void undo() {
        if (undoCounter>=0) {
            actions.pop().make();
            undoCounter--;
        }
    }
    public Save getSave() {
        return new SaveImpl();
    }

    public class SaveImpl implements Save {
        String name = Student.this.name;
        List<Integer> grades = new ArrayList<>(Student.this.grades);

        @Override
        public void load() {
            Student.this.name = name;
            Student.this.grades = new ArrayList<>(grades);
            Student.this.actions.clear();
            Student.this.undoCounter = -1;
        }
    }

    public double getMiddleGrade() {
        int sum = 0;
        if (grades.isEmpty())
            return 0;
        for (int i=0; i<grades.size(); i++) {
            sum += grades.get(i);
        }
        return (double) sum/grades.size();
    }
    public boolean isExcellentStudent() {
        if (this.grades.isEmpty())
            return false;
        if (this.grades.contains(1) || this.grades.contains(2) || this.grades.contains(3) || this.grades.contains(4))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return name + ": " + grades;
    }
    @Override
    public int compare(Object obj) {
        double diff = this.getMiddleGrade() - ((Student) obj).getMiddleGrade();
        if (diff>0) return 1;
        if (diff<0) return -1;
        return 0;
    }

}
