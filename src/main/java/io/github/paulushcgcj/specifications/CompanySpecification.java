package io.github.paulushcgcj.specifications;

import io.github.paulushcgcj.models.entities.CompanyEntity;

import java.util.Arrays;
import java.util.List;

public class CompanySpecification extends GenericSpecification<CompanyEntity> {

    @Override
    List<String> getParameterNames() {
        return Arrays.asList(
            "id",
            "name",
            "homepageUrl",
            "blogUrl",
            "twitterUsername",
            "categoryCode",
            "foundedYear",
            "emailAddress",
            "phoneNumber",
            "description",
            "updatedAt"
        );
    }

}
