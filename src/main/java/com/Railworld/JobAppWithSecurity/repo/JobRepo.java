package com.Railworld.JobAppWithSecurity.repo;

import java.util.List;

import com.Railworld.JobAppWithSecurity.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
	List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);


}