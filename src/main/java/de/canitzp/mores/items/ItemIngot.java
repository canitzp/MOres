package de.canitzp.mores.items;

import de.canitzp.mores.MOres;
import de.ellpeck.rockbottom.api.item.ItemBasic;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;

/**
 * @author canitzp
 */
public class ItemIngot extends ItemBasic {

    public ItemIngot(String name) {
        super(MOres.createResource(name.concat("_ingot")));
    }

}
