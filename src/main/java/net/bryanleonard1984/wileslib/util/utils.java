package net.bryanleonard1984.wileslib.util;

import net.minecraft.item.ItemStack;

public class utils
{
    public static ItemStack setDamageOnCraft(ItemStack stack)
    {
        if(stack.getDamage() < stack.getMaxDamage() - 1)
        {
            ItemStack moreDamaged = stack.copy();
            moreDamaged.setDamage(stack.getDamage() + 1);
            return moreDamaged;
        }
        return ItemStack.EMPTY;
    }
}
