package net.taanmann.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    }

    private void blockwithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
