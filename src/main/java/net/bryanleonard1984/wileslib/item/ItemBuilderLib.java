package net.bryanleonard1984.wileslib.item;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

public class ItemBuilderLib
{
    protected Logger logger;
    protected String id;

    public ItemBuilderLib(Logger logger, String id)
    {
        this.logger = logger;
        this.id = id;
    }

    public Logger getLogger() {return logger;}
    public String getId() {return id;}
    public void setLogger(Logger logger) {this.logger = logger;}
    public void setId(String id) {this.id = id;}

    /*The id parameter must be equal to "minecraft" in order to override vanilla items.
     * Otherwise, use the getId() method to choose the id for the particular mod.*/

    private static Item registerItem(String id, String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(id, name), item);
    }

    public void registerModItems()
    {
        getLogger().info("Registering Mod Items for " + getId());
    }

    public Item createAxeItem(String id, String name, ToolMaterial material,
                                     float baseAttack, float attackSpeed)
    {
        return registerItem(id, name, new AxeItem(material, new Item.Settings().attributeModifiers(
                AxeItem.createAttributeModifiers(material, baseAttack, attackSpeed))));
    }

    public Item createHoeItem(String id, String name, ToolMaterial material,
                              float baseAttack, float attackSpeed)
    {
        return registerItem(id, name, new HoeItem(material, new Item.Settings().attributeModifiers(
                HoeItem.createAttributeModifiers(material, baseAttack, attackSpeed))));
    }

    public Item createPickaxeItem(String id, String name, ToolMaterial material,
                                  float baseAttack, float attackSpeed)
    {
        return registerItem(id, name, new PickaxeItem(material, new Item.Settings().attributeModifiers(
                PickaxeItem.createAttributeModifiers(material, baseAttack, attackSpeed))));
    }

    public Item createShovelItem(String id, String name, ToolMaterial material,
                                 float baseAttack, float attackSpeed)
    {
        return registerItem(id, name, new ShovelItem(material, new Item.Settings().attributeModifiers(
                ShovelItem.createAttributeModifiers(material, baseAttack, attackSpeed))));
    }

    public Item createSwordItem(String id, String name, ToolMaterial material,
                                int baseAttack, float attackSpeed)
    {
        return registerItem(id, name, new SwordItem(material, new Item.Settings().attributeModifiers(
                SwordItem.createAttributeModifiers(material, baseAttack, attackSpeed))));
    }

    public Item createArmorItem(String id, String name, RegistryEntry<ArmorMaterial> material,
                                       ArmorItem.Type type, int maxDamage)
    {
        return registerItem(id, name, new ArmorItem(material, type, new Item.Settings()
                .maxDamage(type.getMaxDamage(maxDamage))));
    }

    public Item createSimpleItem(String id, String name)
    {
        return registerItem(id, name, new Item(new Item.Settings()));
    }
}
