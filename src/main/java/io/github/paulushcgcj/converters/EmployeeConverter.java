package io.github.paulushcgcj.converters;

import io.github.paulushcgcj.models.dtos.EmployeeData;
import io.github.paulushcgcj.models.entities.EmployeeEntity;

import java.util.HashMap;
import java.util.Map;

public class EmployeeConverter extends GenericConverter<EmployeeData, EmployeeEntity> {

    @Override
    Map<String, String> createMap() {
        Map<String,String> fields = new HashMap<>();

        fields.put("campus","campus.campusName");
        fields.put("company","campus.company.name");

        return fields;
    }

}
