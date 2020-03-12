package io.github.paulushcgcj.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import io.github.paulushcgcj.exceptions.CompanyHubException;
import io.github.paulushcgcj.models.dtos.CompanyData;
import io.github.paulushcgcj.services.CompanyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping(value = "/company")
@CrossOrigin
@Tag(name = "Company API", description = "Manage companies API")
public class CompanyHandler {

    @Autowired
    private CompanyService service;

    @GetMapping(value = "**/")
    public ResponseEntity<?> listCompanies(
        Pageable page,
        @RequestParam Map<String, String> parameters
    ) {
        return
            ResponseEntity
                .ok(
                    service.listCompanies(page, parameters)
                );
    }

    @PostMapping(value = "**/")
    public ResponseEntity<?> createEmployee(@RequestBody CompanyData companyData) {
        CompanyData createdData = service.createCompany(companyData);
        return
            ResponseEntity
                .created(
                    UriComponentsBuilder
                        .fromPath("/company/{id}")
                        .buildAndExpand(createdData.getId())
                        .toUri()

                )
                .build();
    }

    @GetMapping(value = "/{companyId}")
    public ResponseEntity<?> getCompanyDetails(@PathVariable Integer companyId) {
        try {
            return ResponseEntity.ok(service.getCompanyById(companyId));
        } catch (CompanyHubException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @PatchMapping(value = "/{companyId}")
    public ResponseEntity<?> updateCompanyPatch(@PathVariable Integer companyId,@RequestBody JsonPatch company) {
        try {
            return ResponseEntity
                .ok(
                    service.updateCompany(companyId,company)
                );
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (CompanyHubException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{companyId}")
    public ResponseEntity<?> updateCompany(@PathVariable Integer companyId,@RequestBody CompanyData company) {
        try {
            return ResponseEntity
                .ok(
                    service.updateCompany(companyId,company)
                );
        } catch (CompanyHubException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{companyId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer companyId) {
        try{
            service.removeCompany(companyId);
            return ResponseEntity.noContent().build();
        } catch (CompanyHubException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

}
