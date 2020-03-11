package io.github.paulushcgcj.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "campuses")
public class CampusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50,nullable = false)
    private String campusName;
    @Column(length = 50,nullable = false)
    private String city;
    @Column(length = 400,nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "company_id",nullable = false)
    private CompanyEntity company;
}
