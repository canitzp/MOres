package de.canitzp.mores.items;

import de.canitzp.mores.MOres;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.construction.SmelterRecipe;
import de.ellpeck.rockbottom.api.item.Item;
import de.ellpeck.rockbottom.api.item.ItemBasic;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;

/**
 * @author canitzp
 */
public class ItemGrit extends ItemBasic {

    public ItemGrit(String name, Item ingot) {
        super(MOres.createResource(name.concat("_grit")));

        RockBottomAPI.SMELTER_RECIPES.add(new SmelterRecipe(new ItemInstance(ingot), new ItemInstance(this), 1000));
    }

}
