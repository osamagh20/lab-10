package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/job-application")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;


    @GetMapping("/get")
    public ResponseEntity getJobApplications() {
        List<JobApplication> jobApplicationList = jobApplicationService.getAllJobApplications();
        return ResponseEntity.status(200).body(jobApplicationList);
    }
}
