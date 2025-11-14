package net.lighter3000.vinebound.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lighter3000.vinebound.block.ModBlocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSS_STONE, 1)
                        .pattern("M")
                        .pattern("C")
                        .input('M', Items.MOSS_CARPET)
                        .input('C', Items.COBBLESTONE)
                        .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                        .offerTo(exporter);

                /*
                createStairsRecipe(ModBlocks.MOSS_STONE_STAIRS, Ingredient.ofItem(ModBlocks.MOSS_STONE));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSS_STONE_SLAB, Ingredient.ofItem(ModBlocks.MOSS_STONE));
                createButtonRecipe(ModBlocks.MOSS_STONE_BUTTON, Ingredient.ofItem(ModBlocks.MOSS_STONE));
                createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSS_STONE_PRESSURE_PLATE, Ingredient.ofItem(ModBlocks.MOSS_STONE));
                // wall recipe method missing?

                 */
            }
        };
    }

    @Override
    public String getName() {
        return "Vinebound Recipes";
    }
}
