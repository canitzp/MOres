package de.canitzp.mores;

import de.canitzp.mores.tiles.TileOre;
import org.newdawn.slick.Color;

/**
 * @author canitzp
 */
public class Registry {

    public static TileOre TILE_IRON_ORE = new TileOre("iron", 24, 2, new Color(14838066), new Color(11314080))
            .addWorldGeneration(-7, -4, 5, 192).register();
    public static TileOre TILE_DIAMOND_ORE = new TileOre("diamond", 48, 3, new Color(40596), new Color(-2145791290))
            .addWorldGeneration(-10, -6, 2, 190).register();

    public static void preInit() {
        TILE_DIAMOND_ORE.ingot.setResourceName(MOres.createResource("diamond"));
    }

}
