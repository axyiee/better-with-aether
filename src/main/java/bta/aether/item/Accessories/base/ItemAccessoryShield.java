package bta.aether.item.Accessories.base;

import bta.aether.item.ItemToolAccessory;
import net.minecraft.core.item.ItemStack;

public class ItemAccessoryShield extends ItemToolAccessory {

    public ItemAccessoryShield(String name, int id) {
        super(name, id);
    }

    @Override
    public String[] getAccessoryTypes(ItemStack itemStack) {
        return new String[]{"shield"};
    }
}
