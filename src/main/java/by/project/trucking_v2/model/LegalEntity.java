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

    @JsonIgnore
    @OneToOne(mappedBy = "legalEntity")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "legalEntity", cascade = CascadeType.ALL)
    private List<Transport> transports = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "legalEntity", cascade = CascadeType.ALL)
    private List<Driver> drivers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "legalEntity", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}