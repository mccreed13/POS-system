package system.pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import system.pos.composite.Priced;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order implements Priced {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "table_id")
    private Long tableId;

    @JoinColumn(name = "number_people")
    private int people;

    @JoinColumn(name = "bill")
    private double bill;

    @JoinColumn(name = "isClosed")
    private boolean isClosed;

    @JoinColumn(name = "isPayed")
    private boolean isPayed;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private Set<OrderMenuItems> orderMenuItems;

    @Override
    public double getFullCost() {
        double fullCost = 0;
        for (OrderMenuItems item: orderMenuItems) {
            fullCost += item.getFullCost();
        }
        return fullCost;
    }
}
