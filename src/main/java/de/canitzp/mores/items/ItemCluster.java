package de.canitzp.mores.items;

import de.canitzp.mores.MOres;
import de.ellpeck.rockbottom.ContentRegistry;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.construction.SeparatorRecipe;
import de.ellpeck.rockbottom.api.item.Item;
import de.ellpeck.rockbottom.api.item.ItemBasic;
import de.ellpeck.rockbottom.api.item.ItemInstance;

/**
 * @author canitzp
 */
public class ItemCluster extends ItemBasic {

    public ItemCluster(String name, Item grit) {
        super(MOres.createResource(name.concat("_cluster")));

        RockBottomAPI.SEPARATOR_RECIPES.add(new SeparatorRecipe(
                new ItemInstance(grit),
                new ItemInstance(this),
                600,
                new ItemInstance(ContentRegistry.ITEM_SLAG),
                0.8F
        ));
    }
}
