package system.pos.factory.bar;

import system.pos.entity.OrderMenuItems;

public class SushiBar implements Bar{
    @Override
    public void showMessage(OrderMenuItems item) {
        System.out.println("Printed on paper");
        System.out.println(item.getMenuItem() + " : "+item.getQuantity());
    }
}
