package by.project.trucking_v2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    private String model;
    private VehicleType vehicle_type;
    private double carrying_capacity;
    private String number_plate;
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "legal_entity_id", nullable = false)
    private LegalEntity legalEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
    private Set<CompletedOrder> completedOrder = new HashSet<>();
}
