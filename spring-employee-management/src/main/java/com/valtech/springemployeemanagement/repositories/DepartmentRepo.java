package com.valtech.springemployeemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.valtech.springemployeemanagement.entities.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
	@Query(value = "SELECT MIN(deptId) FROM Department")
	int findMinId();

	@Query(value = "SELECT MAX(deptId) FROM Department")
	int findMaxId();

	@Query(value = "SELECT MIN(deptId) FROM Department WHERE deptId > ?1")
	int findNextId(int id);

	@Query(value = "SELECT MAX(deptId) FROM Department WHERE deptId < ?1")
	int findPreviousId(int id);

}
