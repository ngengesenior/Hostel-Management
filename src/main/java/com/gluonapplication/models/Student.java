package com.gluonapplication.models;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Student extends RecursiveTreeObject<Student> {

    public StringProperty firstName;
    public StringProperty lastName;
    public StringProperty studentId;
    public StringProperty dob;
    public StringProperty hostel;

    public Student(String firstName, String lastName,
                   String dob, String hostel) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.dob = new SimpleStringProperty(dob);
        this.hostel = new SimpleStringProperty(hostel);
    }


    public static ObservableList<Student> getSampleStudents() {
        ObservableList<Student> students = FXCollections.observableArrayList();

        students.add(new Student("Ngenge",
                "Senior", "18/11/1997", "Saint Jude"));

        students.add(new Student("Molinge",
                "Junior", "18/11/1997", "Saint Anne"));
        students.add(new Student("Hapi",
                "Yvan", "18/11/1997", "Einstein Hostel"));

        students.add(new Student("Eugen",
                "Bleck", "18/11/1997", "Saint Jude"));
        students.add(new Student("Buma",
                "La Classe", "18/11/1997", "De Matrix"));
        students.add(new Student("Rene",
                "Dembele", "18/11/1997", "Star Light"));
        students.add(new Student("John",
                "Walker", "18/11/1997", "Saint Jude"));
        students.add(new Student("Mary",
                "J.Field", "18/11/1997", "Saint Jude"));

        return students;

    }
}