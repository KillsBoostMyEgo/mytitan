
package net.killsboost.watashinokyojin.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.killsboost.watashinokyojin.itemgroup.CreativeTabMyTitanItemGroup;
import net.killsboost.watashinokyojin.MyTitanModElements;

@MyTitanModElements.ModElement.Tag
public class ItemSaddleCartTitanItem extends MyTitanModElements.ModElement {
	@ObjectHolder("my_titan:item_saddle_cart_titan")
	public static final Item block = null;
	public ItemSaddleCartTitanItem(MyTitanModElements instance) {
		super(instance, 51);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(CreativeTabMyTitanItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("item_saddle_cart_titan");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
