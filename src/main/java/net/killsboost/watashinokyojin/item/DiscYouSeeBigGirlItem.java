
package net.killsboost.watashinokyojin.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.killsboost.watashinokyojin.itemgroup.CreativeTabMyTitanItemGroup;
import net.killsboost.watashinokyojin.MyTitanModElements;

@MyTitanModElements.ModElement.Tag
public class DiscYouSeeBigGirlItem extends MyTitanModElements.ModElement {
	@ObjectHolder("my_titan:disc_you_see_big_girl")
	public static final Item block = null;
	public DiscYouSeeBigGirlItem(MyTitanModElements instance) {
		super(instance, 48);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, MyTitanModElements.sounds.get(new ResourceLocation("my_titan:useebiggirl")),
					new Item.Properties().group(CreativeTabMyTitanItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("disc_you_see_big_girl");
		}
	}
}
