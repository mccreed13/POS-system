package system.pos.facade;

import system.pos.entity.OrderMenuItems;
import system.pos.factory.bar.Bar;
import system.pos.factory.BarFactory;

public class MenuItemFacade {
    final static BarFactory barFactory = new BarFactory();

    public static void sendMessagesToProcess(OrderMenuItems item) {
        Bar bar = barFactory.getBar(item.getMenuItem());
        bar.showMessage(item);
    }
}
