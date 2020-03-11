package io.github.paulushcgcj.converters;

import io.github.paulushcgcj.models.dtos.CampusData;
import io.github.paulushcgcj.models.entities.CampusEntity;

import java.util.HashMap;
import java.util.Map;

public class CampusConverter extends GenericConverter<CampusData, CampusEntity> {
    @Override
    Map<String, String> createMap() {
        Map<String,String> fields = new HashMap<>();

        fields.put("name","campusName");
        fields.put("company","company.name");

        return fields;
    }
}
