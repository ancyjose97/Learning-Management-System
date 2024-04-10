package com.cts.lms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cts.lms.dto.CourseDto;
import com.cts.lms.entity.Course;
import com.cts.lms.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	private CourseRepository courseRepository;
	
	private ModelMapper modelMapper;
	
	

	public CourseServiceImpl(CourseRepository courseRepository, ModelMapper modelMapper) {
		this.courseRepository = courseRepository;
		this.modelMapper = modelMapper;
	}


	// To learn
	@Override
	public CourseDto addCourse(CourseDto courseDto, String coursename) {
		
		Course course = modelMapper.map(courseDto, Course.class);
		
		course.setCourseName(coursename);
		
		Course newCourse = courseRepository.save(course);
		
		return modelMapper.map(newCourse, CourseDto.class);
	}


	// To learn
	@Override
	public List<CourseDto> getAllCourses() {
		
		List<Course> courseList = courseRepository.findAll();
		
	return courseList.stream().map(course -> modelMapper.map(course, CourseDto.class)).toList();
	}



	@Override
	public CourseDto getCourse(String courseName) {
		
		Course course = courseRepository.findByCourseName(courseName);
		
		return modelMapper.map(course, CourseDto.class);
	}


	// To learn
	@Override
	public void deleteCourse(String courseName) {
		
		courseRepository.deleteByCourseName(courseName);
		
	}


	@Override
	public List<CourseDto> listCoursesByTechnology(String technology) {
		
	List<Course> courses = courseRepository.findAllByTechnology(technology);
		
		return courses.stream().map(course -> modelMapper.map(course, CourseDto.class)).toList();
	}

	//To learn

	@Override
	public List<Map<String, Object>> listCoursesByDuration(String technology, int durationFromRange, int durationToRange) {
		
		List<Course> courses = courseRepository.listCoursesByDuration(technology, durationFromRange, durationToRange);
		
		List<Map<String, Object>> responseList = new ArrayList<>();
		
		for(Course course : courses) {
			
			Map<String, Object> responseMap = new HashMap<>();
			
			responseMap.put("courseName", course.getCourseName());
			responseMap.put("courseDuration", course.getCourseDuration());
			responseMap.put("courseDescription", course.getCourseDescription());
			responseMap.put("Technology", course.getTechnology());
			
			responseList.add(responseMap);
		}
		
		
		return responseList;
		
		
		}
		
		
	

}
