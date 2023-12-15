package system.pos.bill;

import system.pos.entity.OrderMenuItems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BillFormer {
    public static String form(Collection<OrderMenuItems> itemsList){
        double totalPrice = 0;
        StringBuilder sb = new StringBuilder();
        for (OrderMenuItems o: itemsList) {
            sb.append(o.toString()).append("\n");
            totalPrice += o.getQuantity()*o.getMenuItem().getPrice();
        }
        sb.append("\n\n");
        sb.append("Total price: \t").append(totalPrice);
        return sb.toString();
    }
}
