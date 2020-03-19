package io.github.paulushcgcj.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import io.github.paulushcgcj.models.dtos.EmployeeData;
import io.github.paulushcgcj.models.entities.CampusEntity;
import io.github.paulushcgcj.models.entities.CompanyEntity;
import io.github.paulushcgcj.models.entities.EmployeeEntity;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit Test | Employee Converter Test Suite")
public class EmployeeConverterTest {

  private EmployeeConverter converter = new EmployeeConverter();

  @DisplayName("Happy Path Conversion from Entity to Data")
  @Test
  public void shouldConvertAtoB() {

    EmployeeData data =
        converter.toA(
            EmployeeEntity.builder()
                .id(1)
                .firstName("Jhon")
                .lastName("Doe")
                .email("jdoe@email.com")
                .username("jdoe")
                .phone("1111111111")
                .jobTitle("Software Architect")
                .department("R&D")
                .ein("123456")
                .gender("Male")
                .dob(LocalDate.now())
                .machineIp("127.0.0.1")
                .campus(
                    CampusEntity.builder()
                        .campusName("TheCampus")
                        .company(CompanyEntity.builder().name("TheCompany").build())
                        .build())
                .build());

    assertThat(data)
        .isNotNull()
        .hasFieldOrPropertyWithValue("firstName", "Jhon")
        .hasFieldOrPropertyWithValue("lastName", "Doe")
        .hasFieldOrPropertyWithValue("email", "jdoe@email.com")
        .hasFieldOrPropertyWithValue("username", "jdoe")
        .hasFieldOrPropertyWithValue("phone", "1111111111")
        .hasFieldOrPropertyWithValue("jobTitle", "Software Architect")
        .hasFieldOrPropertyWithValue("department", "R&D")
        .hasFieldOrPropertyWithValue("ein", "123456")
        .hasFieldOrPropertyWithValue("gender", "Male")
        .hasFieldOrPropertyWithValue("dob", LocalDate.now())
        .hasFieldOrPropertyWithValue("machineIp", "127.0.0.1")
        .hasFieldOrPropertyWithValue("campus", "TheCampus")
        .hasFieldOrPropertyWithValue("company", "TheCompany");
  }

  @DisplayName("Happy Path Conversion from Data to Entity")
  @Test
  public void shouldConvertBtoA() {

    EmployeeEntity data =
        converter.toB(
            EmployeeData.builder()
                .firstName("Jhon")
                .lastName("Doe")
                .email("jdoe@email.com")
                .username("jdoe")
                .phone("1111111111")
                .jobTitle("Software Architect")
                .department("R&D")
                .ein("123456")
                .gender("Male")
                .dob(LocalDate.now())
                .machineIp("127.0.0.1")
                .campus("TheCampus")
                .company("TheCompany")
                .build());

    assertThat(data)
        .isNotNull()
        .hasFieldOrPropertyWithValue("firstName", "Jhon")
        .hasFieldOrPropertyWithValue("lastName", "Doe")
        .hasFieldOrPropertyWithValue("email", "jdoe@email.com")
        .hasFieldOrPropertyWithValue("username", "jdoe")
        .hasFieldOrPropertyWithValue("phone", "1111111111")
        .hasFieldOrPropertyWithValue("jobTitle", "Software Architect")
        .hasFieldOrPropertyWithValue("department", "R&D")
        .hasFieldOrPropertyWithValue("ein", "123456")
        .hasFieldOrPropertyWithValue("gender", "Male")
        .hasFieldOrPropertyWithValue("dob", LocalDate.now())
        .hasFieldOrPropertyWithValue("machineIp", "127.0.0.1")
        .hasFieldOrPropertyWithValue("campus.campusName", "TheCampus")
        .hasFieldOrPropertyWithValue("campus.company.name", "TheCompany");
  }
}
