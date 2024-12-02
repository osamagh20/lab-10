package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Enter the user id")
    @Column(columnDefinition = "int not null")
    private Integer user_id;
    @NotNull(message = "Enter the job post id")
    @Column(columnDefinition = "int not null")
    private Integer job_post_id;
}
