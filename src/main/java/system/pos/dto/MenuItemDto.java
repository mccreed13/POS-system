package system.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuItemDto {
    private String name;
    private double price;
    private String description;
    private double quantity;
    private double totalCost;
}
