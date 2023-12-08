package system.pos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;


@Entity
@Table(name = "order_menu_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderMenuItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    @JoinColumn(name = "quantity")
    @NotNull
    private double quantity;

    @JoinColumn(name = "total_price")
    @NonNull
    private double totalPrice;

    @Override
    public String toString() {
        return menuItem.getName() + "\t"+quantity+"*"+menuItem.getPrice()+"="+(quantity* menuItem.getPrice());
    }
}
