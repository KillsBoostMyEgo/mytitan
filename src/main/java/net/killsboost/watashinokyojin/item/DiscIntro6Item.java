
package net.killsboost.watashinokyojin.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.killsboost.watashinokyojin.MyTitanModElements;

@MyTitanModElements.ModElement.Tag
public class DiscIntro6Item extends MyTitanModElements.ModElement {
	@ObjectHolder("my_titan:disc_intro_6")
	public static final Item block = null;
	public DiscIntro6Item(MyTitanModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, MyTitanModElements.sounds.get(new ResourceLocation("my_titan:s4intro")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("disc_intro_6");
		}
	}
}
