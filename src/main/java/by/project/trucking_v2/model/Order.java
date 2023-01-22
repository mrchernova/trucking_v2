package by.project.trucking_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private Double weight;
    private String departure;
    private String destination;
    private Double price;
    private Status status;

    @ManyToOne()
    @JoinColumn(name = "legal_entity_id")
    private LegalEntity legalEntity;


    @JsonIgnore
    @OneToOne(mappedBy = "order")
    private CompletedOrder completedOrder;
}