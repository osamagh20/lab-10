package com.example.lab10.Service;

import com.example.lab10.Model.JobApplication;
import com.example.lab10.Model.User;
import com.example.lab10.Repository.JobApplicationRepository;
import com.example.lab10.Repository.JobPostRepository;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;
    private final JobApplicationRepository jobApplicationRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void adduser(User user){
        userRepository.save(user);
    }

    public Boolean updateuser(Integer id,User user){
        User oldUser = userRepository.getById(id);
        if(oldUser != null){
            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());
            oldUser.setPassword(user.getPassword());
            oldUser.setRole(user.getRole());
            oldUser.setAge(user.getAge());
            userRepository.save(oldUser);
            return true;
        }
        return false;
    }

    public Boolean deleteuser(Integer id){
        User delUser = userRepository.getById(id);
        if(delUser != null){
            userRepository.delete(delUser);
            return true;
        }
        return false;
    }

    public void applyjob(Integer jobid, JobApplication jobApplication){
        for (int i = 0; i < jobPostRepository.findAll().size(); i++) {
            if(jobPostRepository.findAll().get(i).getId() == jobid){
                jobApplicationRepository.save(jobApplication);
            }
        }
    }

    public Boolean withdrawJobApplication(Integer id){
        JobApplication jobApplication = jobApplicationRepository.getById(id);
        if(jobApplication != null){
            jobApplicationRepository.delete(jobApplication);
            return true;
        }
        return false;
    }


}
