package by.project.trucking_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @GeneratedValue
    private Integer id;
    private String model;
    private VehicleType vehicleType;
    private Double carryingCapacity;
    private String numberPlate;
    private Status status;

    @ManyToOne()
    @JoinColumn(name = "legal_entity_id")
    private LegalEntity legalEntity;


    @JsonIgnore
    @OneToMany(mappedBy = "transport")
    private List<CompletedOrder> CompletedOrders = new ArrayList<>();
}