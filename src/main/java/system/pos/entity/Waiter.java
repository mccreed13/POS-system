package system.pos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "waiter")
public class Waiter{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 50)
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "order")
    private List<Order> order;
}
