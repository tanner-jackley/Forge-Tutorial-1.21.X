package net.taanmann.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.taanmann.tutorialmod.TutorialMod;
import net.taanmann.tutorialmod.block.ModBlocks;

import java.rmi.registry.Registry;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockwithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockwithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);

        blockwithItem(ModBlocks.ALEXANDRITE_ORE);
        blockwithItem(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE);

        blockwithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(ModBlocks.ALEXANDRITE_STAIRS.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        slabBlock(ModBlocks.ALEXANDRITE_SLAB.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        buttonBlock(ModBlocks.ALEXANDRITE_BUTTON.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        pressurePlateBlock(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        fenceBlock(ModBlocks.ALEXANDRITE_FENCE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        fenceGateBlock(ModBlocks.ALEXANDRITE_FENCE_GATE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        wallBlock(ModBlocks.ALEXANDRITE_WALL.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.ALEXANDRITE_DOOR.get(), modLoc("block/alexandrite_door_bottom"), modLoc("block/alexandrite_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.ALEXANDRITE_TRAPDOOR.get(), modLoc("block/alexandrite_trapdoor"), true,"cutout");

        blockItem(ModBlocks.ALEXANDRITE_STAIRS);
        blockItem(ModBlocks.ALEXANDRITE_SLAB);
        blockItem(ModBlocks.ALEXANDRITE_PRESSURE_PLATE);
        blockItem(ModBlocks.ALEXANDRITE_FENCE_GATE);
        blockItem(ModBlocks.ALEXANDRITE_TRAPDOOR, "_bottom");
    }

    private void blockwithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
