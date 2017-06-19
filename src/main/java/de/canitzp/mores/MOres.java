package de.canitzp.mores;

import de.ellpeck.rockbottom.api.IApiHandler;
import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.event.IEventHandler;
import de.ellpeck.rockbottom.api.mod.IMod;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;


/**
 * @author canitzp
 */
public class MOres implements IMod {

    public static MOres INSTANCE;

    public MOres(){
        INSTANCE = this;
    }

    @Override
    public String getDisplayName() {
        return "MOres";
    }

    @Override
    public String getId() {
        return "mores";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getResourceLocation() {
        return "/assets/mores";
    }

    @Override
    public String getDescription() {
        return "This mod adds more ores to Rock Bottom";
    }

    @Override
    public void init(IGameInstance game, IAssetManager assetManager, IApiHandler apiHandler, IEventHandler eventHandler) {
        Registry.preInit();
    }

    public static IResourceName createResource(String name){
        return RockBottomAPI.createRes(INSTANCE, name);
    }
}
