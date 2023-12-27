package system.pos.factory.bar;

import system.pos.entity.OrderMenuItems;

public class DrinkBar implements Bar{
    @Override
    public void showMessage(OrderMenuItems item) {
        System.out.println("Shows on monitor");
        System.out.println(item.getMenuItem() + " : "+item.getQuantity());
    }
}
