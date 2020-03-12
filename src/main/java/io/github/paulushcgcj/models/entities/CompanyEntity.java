package io.github.paulushcgcj.models.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "companies")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String name;
    @Column(length = 1000)
    private String homepageUrl;
    @Column(length = 1000)
    private String blogUrl;
    @Column(length = 50)
    private String twitterUsername;
    @Column(length = 50)
    private String categoryCode;
    @Column(length = 50)
    private String foundedYear;
    @Column(length = 50)
    private String emailAddress;
    @Column(length = 50)
    private String phoneNumber;
    @Column(length = 50)
    private String description;
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "company")
    private Set<CampusEntity> campuses;


    @PrePersist
    @PreUpdate
    public void prePersistAndPreUpdate() {
        updatedAt = LocalDate.now();
    }

}
