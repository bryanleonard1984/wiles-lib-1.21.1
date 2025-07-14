package net.bryanleonard1984.wileslib.mixin;


import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Item.Settings.class)
public class ItemMixin implements FabricItem.Settings
{
    @Unique
    protected int copperPoints = 0;

    @Unique
    public int getCopperPoints() {return copperPoints;}

    @Unique
    public void setCopperPoints(int copperPoints) {this.copperPoints = copperPoints;}
}
