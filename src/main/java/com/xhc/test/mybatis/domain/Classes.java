package com.xhc.test.mybatis.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mymac on 2017/11/29.
 */
public class Classes implements Serializable {

    private int id;
    private String name;
    private Teacher teacher;
    private List<Student> students;

    @Override
    public String toString() {
        return "(Class:[id="+id+", name="+name+", teacher="+teacher+", students="+students+"])";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
