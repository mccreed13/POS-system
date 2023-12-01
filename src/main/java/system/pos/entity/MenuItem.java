package system.pos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "menuItem")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 50)
    private String name;
    @NotNull
    private double price;
    @Length(max = 250)
    private String description;

    private boolean status;

    @OneToMany(mappedBy = "menuItem")
    private Set<OrderMenuItems> orderMenuItems;
}


