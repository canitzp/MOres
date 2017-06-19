package de.canitzp.mores;

import de.canitzp.mores.tiles.TileOre;

/**
 * @author canitzp
 */
public class Registry {

    public static TileOre TILE_IRON_ORE = new TileOre("iron", 24, 2).addWorldGeneration(-7, -4, 5, 192).register();

    public static void preInit(){

    }

}
