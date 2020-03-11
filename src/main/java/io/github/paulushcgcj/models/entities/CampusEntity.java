package io.github.paulushcgcj.models;

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
    @Column(length = 50)
    private String campus_name;
    @Column(length = 50)
    private String city;
    @Column(length = 400)
    private String address;

    @ManyToOne
    @JoinColumn(name = "company_id",nullable = false)
    private CompanyEntity company;
}
