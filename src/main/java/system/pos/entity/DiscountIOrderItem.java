package system.pos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "discount_order")
public class DiscountIOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Order order;

    private Discount discountId;

    private double oldPrice;

    private double newPrice;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
