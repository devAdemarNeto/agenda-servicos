package com.neto.agendaservicos.controller;

import com.neto.agendaservicos.domain.entity.Appointment;
import com.neto.agendaservicos.dto.AppointmentRequestDTO;
import com.neto.agendaservicos.dto.AppointmentResponseDTO;
import com.neto.agendaservicos.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponseDTO create(@RequestBody @Valid AppointmentRequestDTO dto) {

        Appointment appointment = appointmentService.create(
                dto.clientId(),
                dto.providerId(),
                dto.startTime(),
                dto.endTime()
        );

        return new AppointmentResponseDTO(
                appointment.getId(),
                appointment.getClient().getId(),
                appointment.getProvider().getId(),
                appointment.getStartTime(),
                appointment.getEndTime(),
                appointment.getStatus()
        );
    }
}
