package com.cts.lms.service;

import java.util.List;
import java.util.Map;

import com.cts.lms.dto.CourseDto;


public interface CourseService {

	CourseDto addCourse(CourseDto courseDto, String coursename);

	List<CourseDto> getAllCourses();

	CourseDto getCourse(String courseName);

	void deleteCourse(String courseName);

	List<CourseDto> listCoursesByTechnology(String technology);

	List<Map<String, Object>> listCoursesByDuration(String technology, int durationFromRange, int durationToRange);

}
