package io.github.paulushcgcj.endpoints;

import io.github.paulushcgcj.models.dtos.EmployeeData;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/company")
@CrossOrigin
@Tag(name = "Employees API", description = "Manage Employees from company and Campus through this API")
public class EmployeeHandler {

    /*@GetMapping(value = "/{companyId}/{campusId}")
    public ResponseEntity<?> listEmployeesFromCampus(
        Pageable page
    ) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{companyId}")
    public ResponseEntity<?> listEmployeesFromCompany(Pageable page) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{companyId}/{campusId}")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeData employee) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{companyId}/{campusId}/{employeeId}")
    public ResponseEntity<?> getEmployeeDetails() {
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{companyId}/{campusId}/{employeeId}")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeData employee) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{companyId}/{campusId}/{employeeId}")
    public ResponseEntity<?> deleteEmployee() {
        return ResponseEntity.noContent().build();
    }*/

}
