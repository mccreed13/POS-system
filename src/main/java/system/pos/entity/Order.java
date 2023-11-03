package system.pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "table_id")
    private Long tableId;

    @JoinColumn(name = "number_people")
    private int people;

    @JoinColumn(name = "openTime")
    private Timestamp openTime;

    @JoinColumn(name = "closeTime")
    private Timestamp closeTime;

    @JoinColumn(name = "bill")
    private double bill;

    @ManyToOne(optional = false)
    @JoinColumn(name = "waiter_id")
    private Waiter waiter;
}
