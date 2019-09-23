package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

	DoctorEntity findBySpeciality(String disease);
}
