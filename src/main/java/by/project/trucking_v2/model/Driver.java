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
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private Status status;


    @ManyToOne()
    @JoinColumn(name = "legal_entity_id")
    private LegalEntity legalEntity;

    @JsonIgnore
    @OneToMany(mappedBy = "driver")
    private List<CompletedOrder> CompletedOrders = new ArrayList<>();
}
