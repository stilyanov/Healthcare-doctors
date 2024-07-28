package bg.softuni.healthcare.appointments.service;

import bg.softuni.healthcare.appointments.model.dto.AddAppointmentDTO;
import bg.softuni.healthcare.appointments.model.dto.FullAppointmentsInfoDTO;
import bg.softuni.healthcare.appointments.model.dto.UserAppointmentDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {

    void bookAppointment(AddAppointmentDTO appointmentDTO);

    List<UserAppointmentDTO> getUserAppointments(Long userId);

    List<LocalDateTime> getAvailableAppointmentTimes(Long doctorId, LocalDate date);

    void deleteAppointment(Long id);

    List<FullAppointmentsInfoDTO> getAllUsersAppointments();

}