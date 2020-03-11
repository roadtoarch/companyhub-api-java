package io.github.paulushcgcj.converters;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.paulushcgcj.models.dtos.CampusData;
import io.github.paulushcgcj.models.entities.CampusEntity;
import io.github.paulushcgcj.models.entities.CompanyEntity;
import org.junit.jupiter.api.Test;

public class CampusConverterTest {

  private CampusConverter converter = new CampusConverter();

  @Test
  public void shouldConvertAtoB() {

    CampusData data =
        converter.toA(
            CampusEntity.builder()
                .id(1)
                .campusName("TestName")
                .address("City Address")
                .city("Citopolis")
                .company(CompanyEntity.builder().name("TheCompany").build())
                .build());

    assertThat(data)
        .isNotNull()
        .hasFieldOrPropertyWithValue("name", "TestName")
        .hasFieldOrPropertyWithValue("address", "City Address")
        .hasFieldOrPropertyWithValue("city", "Citopolis")
        .hasFieldOrPropertyWithValue("company", "TheCompany");
  }

  @Test
  public void shouldConvertBtoA() {

    CampusEntity data =
        converter.toB(
            CampusData.builder()
                .name("TestName")
                .address("City Address")
                .city("Citopolis")
                .company("TheCompany")
                .build());

    assertThat(data)
        .isNotNull()
        .hasFieldOrPropertyWithValue("campusName", "TestName")
        .hasFieldOrPropertyWithValue("address", "City Address")
        .hasFieldOrPropertyWithValue("city", "Citopolis")
        .hasFieldOrPropertyWithValue("company.name", "TheCompany");
  }
}
