package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Enter the title")
    @Size(min = 4,message = "Enter more than 4 characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;
    @NotEmpty(message = "Enter the description")
    @Column(columnDefinition = "varchar(200) not null")
    private String description;
    @NotEmpty(message = "Enter the location")
    @Column(columnDefinition = "varchar(50) not null")
    private String location;
    @NotNull(message = "Enter the salary")
    @Positive
    @Column(columnDefinition = "double not null")
    private Double salary;
    @Column(columnDefinition = "date")
    private Date postingDate;
}
