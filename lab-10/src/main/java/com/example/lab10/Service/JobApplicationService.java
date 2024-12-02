package com.example.lab10.Service;

import com.example.lab10.Model.JobApplication;
import com.example.lab10.Repository.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;


    public List<JobApplication> getAllJobApplications(){
        return jobApplicationRepository.findAll();
    }

}
