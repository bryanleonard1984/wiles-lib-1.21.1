package net.bryanleonard1984.wileslib.util;

import net.minecraft.data.server.recipe.*;
import net.minecraft.item.*;
import net.minecraft.recipe.book.RecipeCategory;

import static net.minecraft.data.server.recipe.RecipeProvider.*;

public class RecipeBuilder
{
    public RecipeBuilder() {}

    public void AxeRecipes(ItemConvertible output, ItemConvertible input, RecipeExporter recipeExporter, String path)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("II ")
                .pattern("IS ")
                .pattern(" S ")
                .input('I', input).input('S', Items.STICK)
                .criterion(hasItem(input), conditionsFromItem(input)).offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern(" II")
                .pattern(" SI")
                .pattern(" S ")
                .input('I', input).input('S', Items.STICK)
                .criterion(hasItem(input), conditionsFromItem(input)).offerTo(recipeExporter, path + "_flipped");
    }

    public void HoeRecipes(ItemConvertible output, ItemConvertible input, RecipeExporter recipeExporter, String path)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("II ")
                .pattern(" S ")
                .pattern(" S ")
                .input('I', input).input('S', Items.STICK)
                .criterion(hasItem(input), conditionsFromItem(input)).offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern(" II")
                .pattern(" S ")
                .pattern(" S ")
                .input('I', input).input('S', Items.STICK)
                .criterion(hasItem(input), conditionsFromItem(input)).offerTo(recipeExporter, path + "_flipped");
    }

    public void PickaxeRecipes(ItemConvertible output, ItemConvertible input, RecipeExporter recipeExporter)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("III")
                .pattern(" S ")
                .pattern(" S ")
                .input('I', input).input('S', Items.STICK)
                .criterion(hasItem(input), conditionsFromItem(input)).offerTo(recipeExporter);
    }

    public void ShovelRecipes(ItemConvertible output, ItemConvertible input, RecipeExporter recipeExporter)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern(" I ")
                .pattern(" S ")
                .pattern(" S ")
                .input('I', input).input('S', Items.STICK)
                .criterion(hasItem(input), conditionsFromItem(input)).offerTo(recipeExporter);
    }

    public void SwordRecipes(ItemConvertible output, ItemConvertible input, RecipeExporter recipeExporter)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern(" I ")
                .pattern(" I ")
                .pattern(" S ")
                .input('I', input).input('S', Items.STICK)
                .criterion(hasItem(input), conditionsFromItem(input)).offerTo(recipeExporter);
    }

    public void BootsRecipes(ItemConvertible output, ItemConvertible input, RecipeExporter recipeExporter)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("I I")
                .pattern("I I")
                .input('I', input)
                .criterion(hasItem(input), conditionsFromItem(input)).offerTo(recipeExporter);
    }

    public void ChestplateRecipes(ItemConvertible output, ItemConvertible input, RecipeExporter recipeExporter)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .input('I', input)
                .criterion(hasItem(input), conditionsFromItem(input)).offerTo(recipeExporter);
    }

    public void HelmetRecipes(ItemConvertible output, ItemConvertible input, RecipeExporter recipeExporter)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("III")
                .pattern("I I")
                .input('I', input)
                .criterion(hasItem(input), conditionsFromItem(input)).offerTo(recipeExporter);
    }

    public void LeggingsRecipes(ItemConvertible output, ItemConvertible input, RecipeExporter recipeExporter)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .input('I', input)
                .criterion(hasItem(input), conditionsFromItem(input)).offerTo(recipeExporter);
    }

    public void compactingRecipeWithEightItems(ItemConvertible output, ItemConvertible input,
                                               String group, RecipeExporter recipeExporter)
    {
        offerShapelessRecipe(recipeExporter, output, input, group, 8);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, input)
                .input(output).input(output).input(output).input(output)
                .input(output).input(output).input(output).input(output)
                .criterion(hasItem(output), conditionsFromItem(output))
                .offerTo(recipeExporter);
    }

    public void eggRecipe(ItemConvertible output, ItemConvertible input, RecipeExporter recipeExporter)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .input('#', input).input('E', Items.EGG)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(recipeExporter);
    }

    public void horseArmorRecipes(ItemConvertible output, ItemConvertible input, RecipeExporter recipeExporter)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .pattern("#  ")
                .pattern("#S#")
                .pattern("# #")
                .input('#', input).input('S', Items.SADDLE)
                .criterion(hasItem(Items.SADDLE), conditionsFromItem(Items.SADDLE))
                .offerTo(recipeExporter);
    }
}
