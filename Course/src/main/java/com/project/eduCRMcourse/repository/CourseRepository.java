package com.project.eduCRMcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.eduCRMcourse.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
