package de.canitzp.mores;

import de.canitzp.mores.tiles.TileOre;
import org.newdawn.slick.Color;

/**
 * @author canitzp
 */
public class Registry {

    public static TileOre TILE_IRON_ORE = new TileOre("iron", 24, 2, new Color(0xCCA892), new Color(0xCAD1D7))
            .addWorldGeneration(-7, -4, 5, 192).register();
    public static TileOre TILE_DIAMOND_ORE = new TileOre("diamond", 48, 3, new Color(0x96A29F), new Color(0x3B7DA4))
            .addWorldGeneration(-10, -6, 2, 190).register();

    public static void preInit() {
        TILE_DIAMOND_ORE.ingot.setResourceName(MOres.createResource("diamond")).setCustomMaterialName(null);
    }

}
