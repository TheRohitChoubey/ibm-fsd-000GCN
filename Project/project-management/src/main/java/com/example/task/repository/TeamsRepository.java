package com.example.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task.data.Teams;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Long> {

}
