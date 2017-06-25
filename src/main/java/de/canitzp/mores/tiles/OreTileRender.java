package de.canitzp.mores.tiles;

import de.canitzp.mores.MOres;
import de.ellpeck.rockbottom.api.GameContent;
import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.render.tile.ITileRenderer;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * @author canitzp
 */
public class OreTileRender<T extends TileOre> implements ITileRenderer<T> {
    private Color color;
    private static final IResourceName OVERLAY = MOres.createResource("ore_overlay");

    public OreTileRender(Color color) {
        this.color = color;
    }

    @Override
    public void render(IGameInstance game, IAssetManager manager, Graphics g, IWorld world, T tile, int x, int y, float renderX, float renderY, float scale, Color[] light) {
        GameContent.TILE_ROCK.getRenderer().render(game, manager, g, world, tile, x, y, renderX, renderY, scale, light);
        manager.getTexture(OVERLAY).drawWithLight(renderX, renderY, scale, scale, light, this.color);
    }

    @Override
    public void renderItem(IGameInstance game, IAssetManager manager, Graphics g, T tile, int meta, float x, float y, float scale, Color filter) {
        GameContent.TILE_ROCK.getRenderer().renderItem(game, manager, g, tile, meta, x, y, scale, filter);
        manager.getTexture(OVERLAY).draw(x, y, scale, scale, this.color);
    }

    @Override
    public Image getParticleTexture(IGameInstance game, IAssetManager manager, Graphics g, T tile, int meta) {
        return GameContent.TILE_ROCK.getRenderer().getParticleTexture(game, manager, g, tile, meta);
    }
}
