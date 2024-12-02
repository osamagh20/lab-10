package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Enter the name")
    @Size(min = 4,message = "Enter more than 4 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$",message = "Enter just characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @Email
    @Column(columnDefinition = "varchar(40) unique not null")
    private String email;
    @NotEmpty(message = "Enter your password")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;
    @NotNull(message = "Enter your age")
    @Positive
    @Min(21)
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty(message = "Enter your role")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$",message = "The role must be JOB_SEEKER or EMPLOYER")
    @Column(columnDefinition = "varchar(12) not null")
    private String role;
}
