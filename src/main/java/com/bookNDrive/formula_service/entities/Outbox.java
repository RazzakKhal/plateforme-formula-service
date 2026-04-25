package com.bookNDrive.formula_service.entities;

import com.bookNDrive.formula_service.enums.EventPublishStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "outbox")
public class Outbox extends BaseEntity {


    private String eventName;

    @Column(columnDefinition = "TEXT")
    private String payload;

    @Enumerated(EnumType.STRING)
    private EventPublishStatus status;

    private int retryCount;

    private LocalDateTime createdAt;

    private LocalDateTime publishedAt;

    private String lastError;

    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
