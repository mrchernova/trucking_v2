package by.project.trucking_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "legal_entity")
public class LegalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Contact contact;

    //!! nenenen
    @JsonIgnore
@OneToOne(mappedBy = "legalEntity")
    private User user;

//    @JsonIgnore
//    @OneToMany(mappedBy = "legalEntity", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Transport> transports = new ArrayList<>();







//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "legalEntity")
//    private List<Driver> drivers = new ArrayList<>();
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "legalEntity")
//    private List<Order> orders = new ArrayList<>();
}