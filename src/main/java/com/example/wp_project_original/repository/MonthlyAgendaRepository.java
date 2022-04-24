package com.example.wp_project_original.repository;

import com.example.wp_project_original.model.MonthlyAgenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyAgendaRepository extends JpaRepository<MonthlyAgenda, String> {
}
