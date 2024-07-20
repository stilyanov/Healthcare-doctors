package bg.softuni.healthcare.doctors.controller;

import bg.softuni.healthcare.doctors.model.dto.AddDoctorDTO;
import bg.softuni.healthcare.doctors.model.dto.DoctorDTO;
import bg.softuni.healthcare.doctors.model.dto.InfoDoctorDTO;
import bg.softuni.healthcare.doctors.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);
    private final DoctorService doctorService;

    @GetMapping("/all")
    public ResponseEntity<List<DoctorDTO>> getDoctors() {
        LOGGER.info("Get all doctors");
        List<DoctorDTO> doctors = doctorService.getAllDoctors();
        if (doctors.isEmpty()) {
            LOGGER.info("No doctors found");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/info/{doctorId}")
    public ResponseEntity<InfoDoctorDTO> getDoctorInfo(@PathVariable Long doctorId) {
        InfoDoctorDTO doctorInfo = doctorService.getDoctorInfo(doctorId);
        return ResponseEntity.ok(doctorInfo);
    }

//    @GetMapping("/find")
//    public ResponseEntity<List<DoctorDTO>> findDoctor(@RequestParam(required = false) String department,
//                                                      @RequestParam(required = false) String town,
//                                                      @RequestParam(required = false) String name) {
//        if (department != null && !department.isEmpty()) {
//            return ResponseEntity.ok(doctorService.findByDepartment(DepartmentEnum.valueOf(department)));
//        } else if (town != null && !town.isEmpty()) {
//            return ResponseEntity.ok(doctorService.findByTown(town));
//        } else if (name != null && !name.isEmpty()) {
//            return ResponseEntity.ok(doctorService.findByName(name));
//        } else {
//            return ResponseEntity.ok(List.of());
//        }
//    }

    @PostMapping("/add")
    public ResponseEntity<Void> addDoctor(@RequestBody @Valid AddDoctorDTO addDoctorDTO) {
        doctorService.addDoctor(addDoctorDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}