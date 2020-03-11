package io.github.paulushcgcj.converters;

import io.github.paulushcgcj.models.CompanyData;
import io.github.paulushcgcj.models.CompanyEntity;
import java.util.HashMap;
import java.util.Map;

public class CompanyConverter extends GenericConverter<CompanyData, CompanyEntity> {

  @Override
  Map<String, String> createMap() {
    return new HashMap<>();
  }
}
