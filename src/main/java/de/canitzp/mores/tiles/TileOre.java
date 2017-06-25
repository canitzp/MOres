package de.canitzp.mores.tiles;

import de.canitzp.mores.MOres;
import de.canitzp.mores.gen.OreWorldGen;
import de.canitzp.mores.items.ItemCluster;
import de.canitzp.mores.items.ItemGrit;
import de.canitzp.mores.items.ItemIngot;
import de.canitzp.mores.items.ItemTool;
import de.canitzp.mores.items.renderer.ToolRenderer;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.entity.Entity;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.item.ItemTile;
import de.ellpeck.rockbottom.api.item.ToolType;
import de.ellpeck.rockbottom.api.render.tile.ITileRenderer;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;
import org.newdawn.slick.Color;

import java.util.Collections;
import java.util.List;

/**
 * @author canitzp
 */
public class TileOre extends TileBasic {

    public ItemIngot ingot;
    public ItemCluster cluster;
    public ItemGrit grit;
    public ItemTool pickaxe;
    private Color oreColor;
    private IResourceName locMatTypeName;

    public TileOre(String oreName, int hardness, int toolStrength, Color oreColor, Color ingotColor) {
        super(MOres.createResource(oreName.concat("_ore")));
        this.oreColor = oreColor;
        this.locMatTypeName = MOres.createResource(oreName);
        this.setHardness((float)hardness);
        this.addEffectiveTool(ToolType.PICKAXE, toolStrength);
        this.ingot = (new ItemIngot(oreName, ingotColor)).register();
        this.grit = (new ItemGrit(oreName, this.ingot, ingotColor)).register();
        this.cluster = (new ItemCluster(oreName, this.grit, oreColor)).register();
        this.pickaxe = new ItemTool(MOres.createResource(oreName.concat("_pickaxe")), toolStrength * toolStrength)
                .addToolType(ToolType.PICKAXE, toolStrength + 1).setRenderer(new ToolRenderer(ingotColor, ToolType.PICKAXE)).register();
    }

    @Override
    public ITileRenderer getRenderer() {
        return new OreTileRender(this.oreColor);
    }

    @Override
    public List<ItemInstance> getDrops(IWorld world, int x, int y, TileLayer layer, Entity destroyer) {
        return Collections.singletonList(new ItemInstance(this.cluster));
    }

    public TileOre addWorldGeneration(int minY, int maxY, int veinSize, int prio) {
        RockBottomAPI.WORLD_GENERATORS.add(new OreWorldGen(this, minY, maxY, veinSize, prio));
        return this;
    }

    @Override
    public TileOre register() {
        return (TileOre)super.register();
    }

    @Override
    protected ItemTile createItemTile() {
        return new ItemTile(this.getName()){
            @Override
            public String getLocalizedName(ItemInstance item){
                IAssetManager assets = RockBottomAPI.getGame().getAssetManager();
                return assets.localize(locMatTypeName.addPrefix("material.")) + " " + assets.localize(MOres.createResource("material.ore"));
            }
        };
    }
}
