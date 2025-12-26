package com.neto.agendaservicos.service;

import com.neto.agendaservicos.domain.entity.Appointment;
import com.neto.agendaservicos.domain.entity.User;
import com.neto.agendaservicos.domain.enums.AppointmentStatus;
import com.neto.agendaservicos.domain.exception.BusinessException;
import com.neto.agendaservicos.repository.AppointmentRepository;
import com.neto.agendaservicos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    public Appointment create(Long clientId, Long providerId, LocalDateTime startTime, LocalDateTime endTime){
        if (startTime.isBefore(LocalDateTime.now())){
            throw new BusinessException("Agendamento deve ser para uma data futura");
        }

        boolean exists = appointmentRepository.existsByProviderIdAndStartTime(providerId,startTime);

        if(exists){
            throw new BusinessException("Horário indisponivel para esse prestador");
        }

        User client = userRepository.findById(clientId)
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));

        User provider = userRepository.findById(providerId)
                .orElseThrow(() -> new BusinessException("Prestador não encontrado"));

        Appointment appointment = Appointment.builder()
                .client(client)
                .provider(provider)
                .startTime(startTime)
                .endTime(endTime)
                .status(AppointmentStatus.SCHEDULED)
                .createdAt(LocalDateTime.now())
                .build();

        return appointmentRepository.save(appointment);


    }

}
