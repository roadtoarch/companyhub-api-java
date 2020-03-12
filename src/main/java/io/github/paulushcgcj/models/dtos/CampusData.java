package io.github.paulushcgcj.models.dtos;

import lombok.*;

@Data
@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
public class CampusData {
  private Integer id;
  private String name;
  private String city;
  private String address;
  private String company;
}
