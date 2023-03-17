package com.example2.model;

import com.example2.entity.Student;

import java.util.*;
import java.util.stream.Collector;

public class StudentList {
    private ArrayList<Student> list;
    private int length;

    public ArrayList<Student> findByName(String name){
        boolean found = false;
        ArrayList<Student> matches = new ArrayList<Student>();
        for(Student s: list){
            String fullname = new String(s.getFirstName() + " " + s.getLastName()) .toLowerCase();

            if(fullname.matches("(.*)" + name.toLowerCase() + "(.*)" )){
                matches.add(s);
                found = true;
            }
        }
        if (found == false){
            System.out.println("Not found");
        }
        return matches;
    }
    public Student findById(int id){
        for(Student s: list){
            if(s.getId() == id ){
                return s;
            }
        }
        return null;
    }

    public void add(Student s){
        list.add(s);
    }
    public void remove(int id){
        boolean found = false;
        for (Student s: list){
            if (s.getId() == id){
                int choice;
                System.out.println("Are you sure deleting this student? (1.Yes  2.No");
                choice = new Scanner(System.in).nextInt();
                if (choice == 1)
                    list.remove(s);
                found = true;
            }
        }
        if (found == false){
            System.out.println("Can not find student with id " + id);
        }
    }
    public void sortByMarks(){
        Collections.sort(list, new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){
                return new Double(s2.getMark()).compareTo(s1.getMark());
            }
        });
    }
    public void showList(){
        for(Student s: list){
            s.printInfo();
        }
    }
    public void showList(ArrayList<Student> slist){
        for (Student s : slist){
            s.printInfo();
        }
    }
}

