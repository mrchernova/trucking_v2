package by.project.trucking_v2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
//    private VehicleType vehicleType;
//    private Double carryingCapacity;
//    private String numberPlate;
//    private Status status;



    @ManyToOne()    //fetch = FetchType.LAZY
    @JoinColumn(name = "legal_entity_id")
    private LegalEntity legalEntity;

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", model='" + model + '\'' +
//                ", legalEntity=" + legalEntity +
                '}';
    }


//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
//    private Set<CompletedOrder> completedOrder = new HashSet<>();
}

/**
 * Почти все работает кроме вывода ВСЕХ машин почему-то
 *
 * после добавления toString стало выводить ВСЁ, но теперь удаляет все
 * из legalEntity с ошибкой 500. УДАЛЯЕТ с ошибкой!!! мы не знаем что это такое...
 */