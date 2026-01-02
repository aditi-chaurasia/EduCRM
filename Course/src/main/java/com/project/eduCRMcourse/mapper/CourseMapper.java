package com.project.eduCRMcourse.mapper;

import com.project.eduCRMcourse.dto.CourseRequestDto;
import com.project.eduCRMcourse.dto.CourseResponseDto;
import com.project.eduCRMcourse.model.Course;

public class CourseMapper {
	
	public static Course toCourse(CourseRequestDto courseRequest) {
		Course course = new Course();
		course.setTitle(courseRequest.getTitle());
		course.setDescription(courseRequest.getDescription());
		course.setPrice(courseRequest.getPrice());
		course.setTrainerId(courseRequest.getTrainerId());
		return course;
	}
	
	public static CourseResponseDto toCourseResponse(Course course) {
		CourseResponseDto courseResponse = new CourseResponseDto();
		return null;
	}
}
