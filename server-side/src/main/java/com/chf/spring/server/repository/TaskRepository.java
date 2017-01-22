package com.chf.spring.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chf.spring.server.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
