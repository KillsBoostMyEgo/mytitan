
package net.killsboost.watashinokyojin.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import net.killsboost.watashinokyojin.procedures.AutoUnlockTitanFemaleRightClickedInAirProcedure;
import net.killsboost.watashinokyojin.itemgroup.CreativeTabMyTitanItemGroup;
import net.killsboost.watashinokyojin.MyTitanModElements;

import java.util.Map;
import java.util.HashMap;

@MyTitanModElements.ModElement.Tag
public class AutoUnlockTitanFemaleItem extends MyTitanModElements.ModElement {
	@ObjectHolder("my_titan:auto_unlock_titan_female")
	public static final Item block = null;
	public AutoUnlockTitanFemaleItem(MyTitanModElements instance) {
		super(instance, 37);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(CreativeTabMyTitanItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("auto_unlock_titan_female");
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

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				AutoUnlockTitanFemaleRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}
