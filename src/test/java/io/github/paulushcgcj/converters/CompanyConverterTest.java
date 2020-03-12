package io.github.paulushcgcj.converters;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.paulushcgcj.models.dtos.CompanyData;
import io.github.paulushcgcj.models.entities.CompanyEntity;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit Test | Company Converter Test Suite")
public class CompanyConverterTest {

  private CompanyConverter converter = new CompanyConverter();

  @DisplayName("Happy Path Conversion from Entity to Data")
  @Test
  public void shouldConvertAtoB() {

    CompanyData data =
        converter.toA(
            CompanyEntity.builder()
                .id(1)
                .name("TestName")
                .homepageUrl("http://url.com")
                .blogUrl("http://blog.url.com")
                .twitterUsername("twiter")
                .categoryCode("cat3")
                .foundedYear("2020")
                .emailAddress("email@email.com")
                .phoneNumber("1234")
                .description("1234")
                .updatedAt(LocalDate.now())
                .build());

    assertThat(data)
        .isNotNull()
        .hasFieldOrPropertyWithValue("name", "TestName")
        .hasFieldOrPropertyWithValue("homepageUrl", "http://url.com")
        .hasFieldOrPropertyWithValue("blogUrl", "http://blog.url.com")
        .hasFieldOrPropertyWithValue("twitterUsername", "twiter")
        .hasFieldOrPropertyWithValue("categoryCode", "cat3")
        .hasFieldOrPropertyWithValue("foundedYear", "2020")
        .hasFieldOrPropertyWithValue("emailAddress", "email@email.com")
        .hasFieldOrPropertyWithValue("phoneNumber", "1234")
        .hasFieldOrPropertyWithValue("description", "1234");
  }

  @DisplayName("Happy Path Conversion from Data to Entity")
  @Test
  public void shouldConvertBtoA() {

    CompanyEntity data =
        converter.toB(
            CompanyData.builder()
                .name("TestName")
                .homepageUrl("http://url.com")
                .blogUrl("http://blog.url.com")
                .twitterUsername("twiter")
                .categoryCode("cat3")
                .foundedYear("2020")
                .emailAddress("email@email.com")
                .phoneNumber("1234")
                .description("1234")
                .build());

    assertThat(data)
        .isNotNull()
        .hasFieldOrPropertyWithValue("name", "TestName")
        .hasFieldOrPropertyWithValue("homepageUrl", "http://url.com")
        .hasFieldOrPropertyWithValue("blogUrl", "http://blog.url.com")
        .hasFieldOrPropertyWithValue("twitterUsername", "twiter")
        .hasFieldOrPropertyWithValue("categoryCode", "cat3")
        .hasFieldOrPropertyWithValue("foundedYear", "2020")
        .hasFieldOrPropertyWithValue("emailAddress", "email@email.com")
        .hasFieldOrPropertyWithValue("phoneNumber", "1234")
        .hasFieldOrPropertyWithValue("description", "1234");
  }
}
