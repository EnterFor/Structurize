package com.ldtteam.structurize.blocks.decorative;

import com.ldtteam.structurize.blocks.AbstractBlockStructurizeStairs;
import com.ldtteam.structurize.blocks.types.ShingleFaceType;
import com.ldtteam.structurize.blocks.types.ShingleWoodType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.BlockRenderLayer;
import org.jetbrains.annotations.NotNull;

/**
 * Class defining the general shingle.
 */
public class BlockShingle extends AbstractBlockStructurizeStairs<BlockShingle>
{
    /**
     * The hardness this block has.
     */
    private static final float BLOCK_HARDNESS = 3F;

    /**
     * The resistance this block has.
     */
    private static final float RESISTANCE = 1F;

    /**
     * Fields defining the registered block's wood and face types, these are used by the Data Generators
     */
    private final ShingleWoodType woodType;
    private final ShingleFaceType faceType;

    public BlockShingle(final BlockState modelState, final ShingleWoodType woodType, final ShingleFaceType faceType)
    {
        super(modelState, Properties.create(Material.GLASS).hardnessAndResistance(BLOCK_HARDNESS, RESISTANCE));
        setRegistryName(faceType.getName() + "_" + woodType.getName() + "_shingle");
        this.woodType = woodType;
        this.faceType = faceType;
    }

    @NotNull
    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    /**
     * Get the model type from a StairsShape object
     *
     * @param shape the StairsShape object
     * @return the model type for provided StairsShape
     */
    public static String getTypeFromShape(final StairsShape shape)
    {
        switch (shape)
        {
            case INNER_LEFT:
            case INNER_RIGHT:
                return "concave";
            case OUTER_LEFT:
            case OUTER_RIGHT:
                return "convex";
            default:
                return "straight";
        }
    }

    /**
     * Get the registered ShingleWoodType, used by the Data Generators
     *
     * @return the registered ShingleWoodType
     */
    public ShingleWoodType getWoodType()
    {
        return this.woodType;
    }

    /**
     * Get the registered ShingleFaceType, used by the Data Generators
     *
     * @return the registered ShingleFaceType
     */
    public ShingleFaceType getFaceType()
    {
        return this.faceType;
    }
}
