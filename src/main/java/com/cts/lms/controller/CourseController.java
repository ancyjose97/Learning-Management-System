package com.cts.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.lms.dto.CourseDto;
import com.cts.lms.entity.Course;
import com.cts.lms.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/lms/courses")
public class CourseController {

	private CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	// To learn
	@PostMapping("/add/{coursename}")
	public ResponseEntity<CourseDto> addCourse(@Valid @RequestBody CourseDto courseDto,
			@PathVariable("coursename") String coursename) {

		return new ResponseEntity<>(courseService.addCourse(courseDto, coursename), HttpStatus.CREATED);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<CourseDto>> getAllCourses() {

		return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
	}

	@GetMapping("/{coursename}")
	public ResponseEntity<CourseDto> getCourse(@PathVariable("coursename") String courseName) {

		return new ResponseEntity<>(courseService.getCourse(courseName), HttpStatus.OK);
	}

	// To learn
	@DeleteMapping("/{coursename}")
	public ResponseEntity<Void> deleteCourse(@PathVariable("coursename") String courseName) {

		courseService.deleteCourse(courseName);

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/info/{technology}")
	public ResponseEntity<List<CourseDto>> listCoursesByTechnology(@PathVariable("technology") String technology) {

		return new ResponseEntity<>(courseService.listCoursesByTechnology(technology), HttpStatus.OK);
	}

	//To learn
	@GetMapping("/get/{technology}/{durationFromRange}/{durationToRange}")
	public ResponseEntity<List<Map<String, Object>>> listCoursesByDuration(@PathVariable("technology") String technology, @PathVariable("durationFromRange") int durationFromRange,
			@PathVariable("durationToRange") int durationToRange) {

		
		return new ResponseEntity<>(courseService.listCoursesByDuration(technology, durationFromRange, durationToRange), HttpStatus.OK);
	}

}
