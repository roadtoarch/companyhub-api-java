package io.github.paulushcgcj.repositories;

import io.github.paulushcgcj.models.entities.EmployeeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity,Integer> { }
