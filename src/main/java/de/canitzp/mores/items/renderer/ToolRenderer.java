package de.canitzp.mores.items.renderer;

import de.canitzp.mores.MOres;
import de.canitzp.mores.items.ItemTool;
import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.item.ToolType;
import de.ellpeck.rockbottom.api.render.item.IItemRenderer;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.Locale;

/**
 * @author canitzp
 */
public class ToolRenderer implements IItemRenderer<ItemTool> {

    private static IResourceName layerRod;
    private static IResourceName layerHandle;
    private static IResourceName layerHead;

    private Color color;

    public ToolRenderer(Color color, ToolType type){
        this.color = color;
        String toolName = type.name().toLowerCase(Locale.ENGLISH);
        layerRod = MOres.createResource("rod_" + toolName);
        layerHandle = MOres.createResource("handle_" + toolName);
        layerHead = MOres.createResource("head_" + toolName);
    }

    @Override
    public void render(IGameInstance game, IAssetManager manager, Graphics g, ItemTool item, ItemInstance instance, float x, float y, float scale, Color filter) {
        manager.getTexture(layerRod).draw(x, y, 1 * scale, 1 * scale, filter);
        manager.getTexture(layerHandle).draw(x, y, 1 * scale, 1 * scale, filter);
        manager.getTexture(layerHead).draw(x, y, 1 * scale, 1 * scale, this.color);
    }

    @Override
    public void renderOnMouseCursor(IGameInstance game, IAssetManager manager, Graphics g, ItemTool item, ItemInstance instance, float x, float y, float scale, Color filter) {
        this.render(game, manager, g, item, instance, x, y, scale, filter);
    }

}
