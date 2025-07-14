package net.bryanleonard1984.wileslib.item;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ItemBuilderLib
{
    public static Item createAxeItem(String id, String name, ToolMaterials material,
                                           float baseAttack, float attackSpeed)
    {
        return registerItem(id, name, new AxeItem(material, new Item.Settings().attributeModifiers(
                AxeItem.createAttributeModifiers(material, baseAttack, attackSpeed))));
    }

    public static Item createHoeItem(String id, String name, ToolMaterials material,
                              float baseAttack, float attackSpeed)
    {
        return registerItem(id, name, new HoeItem(material, new Item.Settings().attributeModifiers(
                HoeItem.createAttributeModifiers(material, baseAttack, attackSpeed))));
    }

    public static Item createPickaxeItem(String id, String name, ToolMaterials material,
                                  float baseAttack, float attackSpeed)
    {
        return registerItem(id, name, new PickaxeItem(material, new Item.Settings().attributeModifiers(
                PickaxeItem.createAttributeModifiers(material, baseAttack, attackSpeed))));
    }

    public static Item createShovelItem(String id, String name, ToolMaterials material,
                                 float baseAttack, float attackSpeed)
    {
        return registerItem(id, name, new ShovelItem(material, new Item.Settings().attributeModifiers(
                ShovelItem.createAttributeModifiers(material, baseAttack, attackSpeed))));
    }

    public static Item createSwordItem(String id, String name, ToolMaterials material,
                                int baseAttack, float attackSpeed)
    {
        return registerItem(id, name, new SwordItem(material, new Item.Settings().attributeModifiers(
                SwordItem.createAttributeModifiers(material, baseAttack, attackSpeed))));
    }

    public static Item createArmorItem(String id, String name, RegistryEntry<ArmorMaterial> material,
                                       ArmorItem.Type type, int maxDamage)
    {
        return registerItem(id, name, new ArmorItem(material, type, new Item.Settings()
                .maxDamage(type.getMaxDamage(maxDamage))));
    }
    private static Item registerItem(String id, String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(id, name), item);
    }
}
