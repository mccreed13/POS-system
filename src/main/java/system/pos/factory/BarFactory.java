package system.pos.factory;

import org.yaml.snakeyaml.util.EnumUtils;
import system.pos.entity.MenuItem;
import system.pos.factory.bar.Bar;
import system.pos.factory.bar.DrinkBar;
import system.pos.factory.bar.Kitchen;
import system.pos.factory.bar.SushiBar;
import system.pos.factory.typeItems.DrinkItems;
import system.pos.factory.typeItems.KitchenItems;
import system.pos.factory.typeItems.SushiItems;

public class BarFactory {
    public Bar getBar(MenuItem menuItem){
        String name = menuItem.getName();
        if(contains(SushiItems.class, name)){
            return new SushiBar();
        }
        if(contains(KitchenItems.class, name)){
            return new Kitchen();
        }
        if(contains(DrinkItems.class, name)){
            return new DrinkBar();
        }
        return null;
    }

    private boolean contains(Class e, String name){
        return EnumUtils.findEnumInsensitiveCase(e, name) != null;
    }
}
