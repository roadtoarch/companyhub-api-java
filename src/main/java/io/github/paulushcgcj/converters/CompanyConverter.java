package io.github.paulushcgcj.converters;

import io.github.paulushcgcj.models.dtos.CompanyData;
import io.github.paulushcgcj.models.entities.CompanyEntity;
import java.util.HashMap;
import java.util.Map;

public class CompanyConverter extends GenericConverter<CompanyData, CompanyEntity> {

  @Override
  Map<String, String> createMap() {
    return new HashMap<>();
  }
}
