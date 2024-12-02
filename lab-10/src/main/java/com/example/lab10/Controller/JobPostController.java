package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/job-post")
public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getJobPosts(){
        List<JobPost> jobPostList = jobPostService.getAllJobPosts();
        return ResponseEntity.status(200).body(jobPostList);
    }

    @PostMapping("/add")
    public ResponseEntity addJobPost(@RequestBody @Valid JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("Job Post Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJobPost(@PathVariable Integer id, @RequestBody @Valid JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isUpdated = jobPostService.updateJobPost(id, jobPost);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Job Post Updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id Not Found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobPost(@PathVariable Integer id){
        Boolean isDeleted = jobPostService.deleteJobPost(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Job Post Deleted"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("id Not Found"));
    }

}
