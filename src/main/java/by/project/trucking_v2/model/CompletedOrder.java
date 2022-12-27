package by.project.trucking_v2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "completed_orders")
public class CompletedOrder {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    private String report;

    @OneToOne
    @JoinColumn(name = "order_id", unique = true, nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transport_id", nullable = false)
    private Transport transport;
}
