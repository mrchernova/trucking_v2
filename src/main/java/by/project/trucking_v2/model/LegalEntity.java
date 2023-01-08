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


    /**
     * mappedBy = «legalEntity» — это имя поля в классе Transport
     * FetchType.LAZY - не подтягивать весь транспорт пока не попросят
     * new HashSet<>(); - если у юр.л нет транспорта, то не получаем null
     */
//    @OneToMany(mappedBy = "legalEntity",cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Transport> transports = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "legalEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transport> transports = new ArrayList<>();
//
//    @Override
//    public String toString() {
//        return "LegalEntity{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", contact=" + contact +
//                ", transports=" + transports +
//                '}';
//    }



//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "legalEntity")
//    private List<Driver> drivers = new ArrayList<>();
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "legalEntity")
//    private List<Order> orders = new ArrayList<>();
}