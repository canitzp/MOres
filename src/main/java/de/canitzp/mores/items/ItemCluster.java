package de.canitzp.mores.items;

import de.canitzp.mores.MOres;
import de.ellpeck.rockbottom.api.GameContent;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.construction.SeparatorRecipe;
import de.ellpeck.rockbottom.api.item.Item;
import de.ellpeck.rockbottom.api.item.ItemBasic;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.render.item.IItemRenderer;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import org.newdawn.slick.Color;

/**
 * @author canitzp
 */
public class ItemCluster extends ItemBasic {

    private static final IResourceName UNDERLAY = MOres.createResource("cluster_underlay");
    private static final IResourceName OVERLAY = MOres.createResource("cluster_overlay");
    private Color color;
    private IResourceName locMatTypeName;

    public ItemCluster(String name, Item grit, Color color) {
        super(MOres.createResource(name.concat("_cluster")));
        this.color = color;
        this.locMatTypeName = MOres.createResource(name);
        RockBottomAPI.SEPARATOR_RECIPES.add(new SeparatorRecipe(new ItemInstance(grit), new ItemInstance(this), 600, new ItemInstance(GameContent.ITEM_SLAG), 0.8F));
    }

    @Override
    public IItemRenderer getRenderer() {
        return (game, manager, g, item, instance, x, y, scale, filter) -> {
            manager.getTexture(UNDERLAY).draw(x, y, 1.0F * scale, 1.0F * scale, filter);
            manager.getTexture(OVERLAY).draw(x, y, 1.0F * scale, 1.0F * scale, this.color);
        };
    }

    @Override
    public String getLocalizedName(ItemInstance item){
        IAssetManager assets = RockBottomAPI.getGame().getAssetManager();
        return assets.localize(this.locMatTypeName.addPrefix("material.")) + " " + assets.localize(MOres.createResource("material.cluster"));
    }

    @Override
    public ItemCluster register() {
        return (ItemCluster)super.register();
    }

}
