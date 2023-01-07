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
@Table(name = "legal_entity")
public class LegalEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private Contact contact;

//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    @JoinColumn(name="id")
//    private User user;



//                                                                    // mappedBy = "legalEntity" - указывает как замарлено в другой таблице
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "legalEntity")    //FetchType.LAZY - не подтягивать весь транспорт пока не попросят
//    private Set<Transport> transport = new HashSet<>();             //если у юр.л нет транспорта, то не получаем null
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "legalEntity")
//    private Set<Driver> drivers = new HashSet<>();
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "legalEntity")
//    private Set<Order> orders = new HashSet<>();
}