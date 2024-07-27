package bg.softuni.healthcare.doctors.model.dto;

import bg.softuni.healthcare.doctors.model.enums.DepartmentEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserAppointmentDTO {

    private Long doctorId;
    private DepartmentEnum department;
    private String dateTime;
    private String reason;
}
