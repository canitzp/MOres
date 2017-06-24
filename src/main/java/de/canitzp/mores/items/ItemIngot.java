package de.canitzp.mores.items;

import de.canitzp.mores.MOres;
import de.ellpeck.rockbottom.api.item.ItemBasic;
import de.ellpeck.rockbottom.api.render.item.IItemRenderer;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import org.newdawn.slick.Color;

/**
 * @author canitzp
 */
public class ItemIngot extends ItemBasic {

    private IResourceName texture = MOres.createResource("ingot");
    private Color color;

    public ItemIngot(String name, Color color) {
        super(MOres.createResource(name.concat("_ingot")));
        this.color = color;
    }

    public ItemIngot setResourceName(IResourceName name) {
        this.texture = name;
        return this;
    }

    public IItemRenderer getRenderer() {
        return (game, manager, g, item, instance, x, y, scale, filter) -> {
            manager.getTexture(this.texture).draw(x, y, 1.0F * scale, 1.0F * scale, this.color);
        };
    }

    public ItemIngot register() {
        return (ItemIngot)super.register();
    }

}
