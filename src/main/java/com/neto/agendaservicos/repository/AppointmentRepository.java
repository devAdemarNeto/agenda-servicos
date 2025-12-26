package com.neto.agendaservicos.repository;

import com.neto.agendaservicos.domain.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    boolean existsByProviderIdAndStartTime(Long providerId, LocalDateTime startTime);
}
