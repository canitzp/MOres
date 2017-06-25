package de.canitzp.mores.items;

import de.canitzp.mores.MOres;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.construction.SmelterRecipe;
import de.ellpeck.rockbottom.api.item.Item;
import de.ellpeck.rockbottom.api.item.ItemBasic;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.render.item.IItemRenderer;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import org.newdawn.slick.Color;

/**
 * @author canitzp
 */
public class ItemGrit extends ItemBasic {

    private static final IResourceName TEXTURE = MOres.createResource("grit");
    private Color color;
    private IResourceName locMatTypeName;

    public ItemGrit(String name, Item ingot, Color color) {
        super(MOres.createResource(name.concat("_grit")));
        this.color = color;
        this.locMatTypeName = MOres.createResource(name);
        RockBottomAPI.SMELTER_RECIPES.add(new SmelterRecipe(new ItemInstance(ingot), new ItemInstance(this), 1000));
    }

    @Override
    public IItemRenderer getRenderer() {
        return (game, manager, g, item, instance, x, y, scale, filter) -> manager.getTexture(TEXTURE).draw(x, y, 1.0F * scale, 1.0F * scale, this.color);
    }

    @Override
    public String getLocalizedName(ItemInstance item){
        IAssetManager assets = RockBottomAPI.getGame().getAssetManager();
        return assets.localize(this.locMatTypeName.addPrefix("material.")) + " " + assets.localize(MOres.createResource("material.cluster"));
    }

    @Override
    public ItemGrit register() {
        return (ItemGrit)super.register();
    }

}
