package io.github.paulushcgcj.repositories;

import io.github.paulushcgcj.models.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository
    extends PagingAndSortingRepository<CompanyEntity, Integer>,
        JpaSpecificationExecutor<CompanyEntity> {}
