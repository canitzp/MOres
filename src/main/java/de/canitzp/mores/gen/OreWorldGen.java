package de.canitzp.mores.gen;

import de.canitzp.mores.tiles.TileOre;
import de.ellpeck.rockbottom.api.tile.Tile;
import de.ellpeck.rockbottom.api.world.gen.WorldGenOre;

/**
 * @author canitzp
 */
public class OreWorldGen extends WorldGenOre{

    private TileOre ore;
    private int minY, maxY, veinSize, prio;

    public OreWorldGen(TileOre ore, int minY, int maxY, int veinSize, int prio){
        this.ore = ore;
        this.minY = minY;
        this.maxY = maxY;
        this.veinSize = veinSize;
        this.prio = prio;
    }

    @Override
    public int getHighestGridPos() {
        return this.maxY;
    }

    @Override
    public int getMaxAmount() {
        return this.veinSize;
    }

    @Override
    public int getClusterRadiusX() {
        return this.veinSize;
    }

    @Override
    public int getClusterRadiusY() {
        return this.veinSize >= 4 ? this.veinSize / 4 : this.veinSize;
    }

    @Override
    public Tile getOreTile() {
        return this.ore;
    }

    @Override
    public int getOreMeta() {
        return 0;
    }

    @Override
    public int getPriority() {
        return this.prio;
    }

    @Override
    public int getLowestGridPos() {
        return this.minY;
    }
}
