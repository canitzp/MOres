package de.canitzp.mores.tiles;

import de.canitzp.mores.MOres;
import de.canitzp.mores.gen.OreWorldGen;
import de.canitzp.mores.items.ItemCluster;
import de.canitzp.mores.items.ItemGrit;
import de.canitzp.mores.items.ItemIngot;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.entity.Entity;
import de.ellpeck.rockbottom.api.item.Item;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.item.ToolType;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;

import java.util.Collections;
import java.util.List;

/**
 * @author canitzp
 */
public class TileOre extends TileBasic {

    public Item ingot, cluster, grit;

    public TileOre(String oreName, int hardness, int toolStrenght) {
        super(MOres.createResource(oreName.concat("_ore")));
        this.setHardness(hardness);
        this.addEffectiveTool(ToolType.PICKAXE, toolStrenght);

        ingot = new ItemIngot(oreName).register();
        grit = new ItemGrit(oreName, ingot).register();
        cluster = new ItemCluster(oreName, grit).register();
    }

    @Override
    public List<ItemInstance> getDrops(IWorld world, int x, int y, TileLayer layer, Entity destroyer) {
        return Collections.singletonList(new ItemInstance(this.cluster));
    }

    public TileOre addWorldGeneration(int minY, int maxY, int veinSize, int prio){
        RockBottomAPI.WORLD_GENERATORS.add(new OreWorldGen(this, minY, maxY, veinSize, prio));
        return this;
    }

    @Override
    public TileOre register() {
        return (TileOre) super.register();
    }
}
