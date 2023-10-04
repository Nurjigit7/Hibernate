package org.peaksoft.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fist_name", unique = true)
    private String fistName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    private String email;
    private int age;

    public Student(String fistName, String lastName, String email, int age) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
}
