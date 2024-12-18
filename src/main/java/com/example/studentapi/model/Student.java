package com.example.studentapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Студент")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_студента")
    private Long id;

    @Column(name = "id_группы")
    private Integer groupId;

    @Column(name = "Имя")
    private String firstName;

    @Column(name = "Отчество")
    private String middleName;

    @Column(name = "Фамилия")
    private String lastName;

    @Column(name = "СНИЛС")
    private String snils;

    @Column(name = "Адрес_проживания")
    private String address;

    @Column(name = "Возраст")
    private Integer age;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}