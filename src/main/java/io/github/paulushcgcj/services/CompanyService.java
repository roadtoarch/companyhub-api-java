package io.github.paulushcgcj.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import io.github.paulushcgcj.converters.CompanyConverter;
import io.github.paulushcgcj.exceptions.CompanyNotFoundException;
import io.github.paulushcgcj.models.PagedResponse;
import io.github.paulushcgcj.models.dtos.CompanyData;
import io.github.paulushcgcj.models.entities.CompanyEntity;
import io.github.paulushcgcj.repositories.CompanyRepository;
import io.github.paulushcgcj.specifications.CompanySpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class CompanyService {

    @Autowired
    private CompanyRepository repository;
    private ObjectMapper mapper;
    private CompanySpecification specification;
    private CompanyConverter converter;

    public CompanyService() {
        specification = new CompanySpecification();
        converter = new CompanyConverter();
        mapper = new ObjectMapper();
    }

    public PagedResponse<CompanyData> listCompanies(Pageable pageable, Map<String, String> parameters) {

        Page<CompanyEntity> pageResponse = repository.findAll(specification.filter(parameters), pageable);

        return PagedResponse
            .<CompanyData>builder()
            .total(pageResponse.getTotalElements())
            .pages(pageResponse.getTotalPages())
            .first(pageResponse.isFirst())
            .last(pageResponse.isLast())
            .next(pageResponse.hasNext())
            .previous(pageResponse.hasPrevious())
            .data(pageResponse.map(converter::toA).getContent())
            .build();

    }

    public CompanyData getCompanyById(Integer id) throws CompanyNotFoundException {
        return converter.toA(repository.findById(id).orElseThrow(() -> new CompanyNotFoundException(id)));
    }

    public CompanyData createCompany(CompanyData companyData) {
        return converter.toA(repository.save(converter.toB(companyData)));
    }

    public void removeCompany(Integer id) throws CompanyNotFoundException {
        if(!repository.existsById(id))
            throw new CompanyNotFoundException(id);
        repository.deleteById(id);
    }

    public CompanyData updateCompany(Integer id, CompanyData companyData) throws CompanyNotFoundException {
        if(!repository.existsById(id))
            throw new CompanyNotFoundException(id);

        return converter.toA( repository.save( converter.toB( companyData.withId(id) ) ) );
    }

    public CompanyData updateCompany(Integer id, JsonPatch patch) throws CompanyNotFoundException, JsonPatchException, JsonProcessingException {
        return converter.toA(
            repository.save(
                applyPatch(
                    patch,
                    getCompanyById(id)
                )
            )
        );
    }

    private CompanyEntity applyPatch(
        JsonPatch patch, CompanyData targetCustomer) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(mapper.convertValue(targetCustomer, JsonNode.class));
        return mapper.treeToValue(patched, CompanyEntity.class);
    }

}
