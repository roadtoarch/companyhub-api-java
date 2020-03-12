package io.github.paulushcgcj.specifications;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class GenericSpecification<T> {

    abstract List<String> getParameterNames();

    private Map<String, String> filterParams(Map<String, String> parameters) {
        if (parameters != null)
            return
                parameters
                    .entrySet()
                    .stream()
                    .filter(entry -> getParameterNames().contains(entry.getKey()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return new HashMap<>();
    }

    private Predicate buildPredicate(CriteriaBuilder criteria, Predicate predicate1, Predicate predicate2) {
        if (predicate1 == null)
            return predicate2;
        return criteria.and(predicate1, predicate2);
    }

    public Specification<T> filter(Map<String, String> parameters) {
        return (root, query, criteriaBuilder) -> {

            Map<String, String> queryParams = filterParams(parameters);

            if (queryParams.isEmpty())
                return null;

            return queryParams
                .entrySet()
                .stream()
                .map(entry -> getPredicate(root, criteriaBuilder, entry.getKey(), entry.getValue()))
                .filter(Objects::nonNull)
                .reduce(null, (predicate, predicate2) -> buildPredicate(criteriaBuilder, predicate, predicate2));
        };
    }

    private Predicate getPredicate(
        Root<T> root,
        CriteriaBuilder criteria,
        String key,
        String value
    ) {
        if (root.get(key).getJavaType() == String.class)
            return criteria.like(root.<String>get(key), "%" + value + "%");
        if (root.get(key).getJavaType() == ZonedDateTime.class)
            return criteria.equal(root.get(key), LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME).atZone(ZoneId.systemDefault()));
        if (root.get(key).getJavaType() == LocalDateTime.class)
            return criteria.equal(root.get(key), LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        if (root.get(key).getJavaType() == LocalDate.class)
            return criteria.equal(root.get(key), LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE));
        if (root.get(key).getJavaType() == LocalTime.class)
            return criteria.equal(root.get(key), LocalTime.parse(value, DateTimeFormatter.ISO_LOCAL_TIME));
        return criteria.equal(root.get(key), value);
    }

}
