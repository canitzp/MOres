package de.canitzp.mores.items;

import de.ellpeck.rockbottom.api.item.Item;
import de.ellpeck.rockbottom.api.item.ItemBasic;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.item.ToolType;
import de.ellpeck.rockbottom.api.render.item.IItemRenderer;
import de.ellpeck.rockbottom.api.tile.Tile;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author canitzp
 */
public class ItemTool extends ItemBasic{

    private float miningSpeed;
    private Map<ToolType, Integer> toolTypes = new HashMap<>();
    private IItemRenderer<ItemTool> toolRenderer;

    public ItemTool(IResourceName name, float miningSpeed) {
        super(name);
        this.miningSpeed = miningSpeed;
        this.maxAmount = 1;
    }

    public ItemTool addToolType(ToolType type, int toolLevel){
        this.toolTypes.put(type, toolLevel);
        return this;
    }

    public ItemTool setRenderer(IItemRenderer<ItemTool> renderer){
        this.toolRenderer = renderer;
        return this;
    }

    @Override
    public IItemRenderer getRenderer() {
        return this.toolRenderer;
    }

    @Override
    public Map<ToolType, Integer> getToolTypes(ItemInstance instance){
        return this.toolTypes;
    }

    @Override
    public float getMiningSpeed(IWorld world, int x, int y, TileLayer layer, Tile tile, boolean isRightTool){
        return isRightTool ? this.miningSpeed : super.getMiningSpeed(world, x, y, layer, tile, isRightTool);
    }

    @Override
    public ItemTool register() {
        return (ItemTool) super.register();
    }
}
