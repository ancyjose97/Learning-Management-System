package com.cts.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.lms.entity.Course;

import jakarta.transaction.Transactional;

public interface CourseRepository extends JpaRepository<Course, Long> {

	
	Course findByCourseName(String courseName);
	
	// To learn
	
	@Modifying // Required for Insert, Update , delete and also DDL statements
	@Transactional // Operations in DB should execute completely or not at all
	// @Modifying requires @Transactional also for this method to work
	@Query(value = "DELETE FROM courses c WHERE " + "c.course_name = :courseName", nativeQuery = true)
	void deleteByCourseName(String courseName);
	
	
	List<Course> findAllByTechnology(String technology);
	
	//To learn
	@Query(value = "SELECT * FROM courses c WHERE " + "c.technology = :technology " + "AND c.course_duration BETWEEN :durationFromRange AND :durationToRange", nativeQuery = true)
	List<Course> listCoursesByDuration(String technology, int durationFromRange, int durationToRange);
}
