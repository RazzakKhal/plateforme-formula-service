package com.bookNDrive.formula_service.repositories;

import com.bookNDrive.formula_service.entities.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OutboxRepository extends JpaRepository<Outbox, UUID> {
}
