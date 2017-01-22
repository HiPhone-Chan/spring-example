package com.chf.spring.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chf.spring.server.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
