package system.pos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "order_menu_item")
@NoArgsConstructor
@AllArgsConstructor
public class OrderMenuItem {
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

}
