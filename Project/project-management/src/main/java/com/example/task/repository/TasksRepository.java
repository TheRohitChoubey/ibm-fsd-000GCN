package com.example.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task.data.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
	Tasks findByTaskName(String taskName);
}
