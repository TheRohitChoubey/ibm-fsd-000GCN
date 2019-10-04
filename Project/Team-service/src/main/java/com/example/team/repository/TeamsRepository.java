package com.example.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.team.data.Teams;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Long> {

}
