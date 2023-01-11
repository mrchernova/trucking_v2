package by.project.trucking_v2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", vehicleType=" + vehicleType +
                ", carryingCapacity=" + carryingCapacity +
                ", numberPlate='" + numberPlate + '\'' +
                ", status=" + status +
                '}';
    }

    //    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
//    private Set<CompletedOrder> completedOrder = new HashSet<>();
}