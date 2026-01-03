package com.neto.agendaservicos.dto;

import com.neto.agendaservicos.domain.enums.AppointmentStatus;

import java.time.LocalDateTime;

public record AppointmentResponseDTO(
        Long id,
        Long clientId,
        Long providerId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        AppointmentStatus status
) {}
