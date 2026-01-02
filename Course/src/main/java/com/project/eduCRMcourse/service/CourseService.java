package com.project.eduCRMcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.eduCRMcourse.dto.CourseRequestDto;
import com.project.eduCRMcourse.dto.CourseResponseDto;
import com.project.eduCRMcourse.mapper.CourseMapper;
import com.project.eduCRMcourse.model.Course;
import com.project.eduCRMcourse.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	public CourseResponseDto createCourse(CourseRequestDto request) {
		Course savedCourse = courseRepo.save(CourseMapper.toCourse(request));
		return null;
	}
}
