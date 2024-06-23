package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Course {

    @Id
private String id;

private String title;

private String description;


}
