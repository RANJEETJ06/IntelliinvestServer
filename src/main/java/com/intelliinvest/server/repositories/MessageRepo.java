package com.intelliinvest.server.repositories;

import com.intelliinvest.server.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message,Integer> {
}
