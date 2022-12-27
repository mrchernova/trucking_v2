package by.project.trucking_v2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    private String description;
    private double weight;
    private String departure;
    private String destination;
    private double price;
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "legal_entity_id", nullable = false)
    private LegalEntity legalEntity;

    @OneToOne(mappedBy = "order")
    private CompletedOrder completedOrder;
}
