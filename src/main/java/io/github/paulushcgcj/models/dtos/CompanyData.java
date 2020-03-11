package io.github.paulushcgcj.models;

import lombok.*;

@Data
@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
public class CompanyData {
  private String name;
  private String homepageUrl;
  private String blogUrl;
  private String twitterUsername;
  private String categoryCode;
  private String foundedYear;
  private String emailAddress;
  private String phoneNumber;
  private String description;
}
