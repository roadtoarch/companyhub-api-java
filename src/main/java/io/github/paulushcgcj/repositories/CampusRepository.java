package io.github.paulushcgcj.repositories;

import io.github.paulushcgcj.models.entities.CampusEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepository extends PagingAndSortingRepository<CampusEntity, Integer> {}
