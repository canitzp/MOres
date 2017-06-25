package de.canitzp.mores.items;

import com.sun.org.apache.xpath.internal.operations.Mod;
import de.canitzp.mores.MOres;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.item.ItemBasic;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.render.item.IItemRenderer;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import org.newdawn.slick.Color;

/**
 * @author canitzp
 */
public class ItemIngot extends ItemBasic {

    private IResourceName texture = MOres.createResource("ingot");
    private IResourceName locMatTypeName;
    private IResourceName locMaterialName = MOres.createResource("material.ingot");
    private Color color;

    public ItemIngot(String name, Color color) {
        super(MOres.createResource(name.concat("_ingot")));
        this.locMatTypeName = MOres.createResource(name);
        this.color = color;
    }

    public ItemIngot setResourceName(IResourceName name) {
        this.texture = name;
        return this;
    }

    public ItemIngot setCustomMaterialName(IResourceName name){
        this.locMaterialName = name;
        return this;
    }

    @Override
    public String getLocalizedName(ItemInstance item){
        IAssetManager assets = RockBottomAPI.getGame().getAssetManager();
        return assets.localize(this.locMatTypeName.addPrefix("material.")) + (this.locMaterialName != null ? " " + assets.localize(this.locMaterialName) : "");
    }

    @Override
    public IItemRenderer getRenderer() {
        return (game, manager, g, item, instance, x, y, scale, filter) -> manager.getTexture(this.texture).draw(x, y, 1.0F * scale, 1.0F * scale, this.color);
    }

    @Override
    public ItemIngot register() {
        return (ItemIngot)super.register();
    }

}
