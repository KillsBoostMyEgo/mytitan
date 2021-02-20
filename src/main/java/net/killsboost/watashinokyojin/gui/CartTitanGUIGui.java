
package net.killsboost.watashinokyojin.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.Minecraft;

import net.killsboost.watashinokyojin.procedures.CartTitanGUIWhileThisGUIIsOpenTickProcedure;
import net.killsboost.watashinokyojin.item.WeaponCartTitanMinigunItem;
import net.killsboost.watashinokyojin.item.ItemSaddleCartTitanItem;
import net.killsboost.watashinokyojin.MyTitanModElements;
import net.killsboost.watashinokyojin.MyTitanMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@MyTitanModElements.ModElement.Tag
public class CartTitanGUIGui extends MyTitanModElements.ModElement {
	public static HashMap guistate = new HashMap();
	private static ContainerType<GuiContainerMod> containerType = null;
	public CartTitanGUIGui(MyTitanModElements instance) {
		super(instance, 49);
		elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
				ButtonPressedMessage::handler);
		elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
				GUISlotChangedMessage::handler);
		containerType = new ContainerType<>(new GuiContainerModFactory());
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, GuiWindow::new));
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		PlayerEntity entity = event.player;
		if (event.phase == TickEvent.Phase.END && entity.openContainer instanceof GuiContainerMod) {
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				CartTitanGUIWhileThisGUIIsOpenTickProcedure.executeProcedure($_dependencies);
			}
		}
	}

	@SubscribeEvent
	public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().register(containerType.setRegistryName("cart_titan_gui"));
	}
	public static class GuiContainerModFactory implements IContainerFactory {
		public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
			return new GuiContainerMod(id, inv, extraData);
		}
	}

	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private World world;
		private PlayerEntity entity;
		private int x, y, z;
		private IItemHandler internal;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		private boolean bound = false;
		public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
			super(containerType, id);
			this.entity = inv.player;
			this.world = inv.player.world;
			this.internal = new ItemStackHandler(77);
			BlockPos pos = null;
			if (extraData != null) {
				pos = extraData.readBlockPos();
				this.x = pos.getX();
				this.y = pos.getY();
				this.z = pos.getZ();
			}
			if (pos != null) {
				if (extraData.readableBytes() == 1) { // bound to item
					byte hand = extraData.readByte();
					ItemStack itemstack;
					if (hand == 0)
						itemstack = this.entity.getHeldItemMainhand();
					else
						itemstack = this.entity.getHeldItemOffhand();
					itemstack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
				} else if (extraData.readableBytes() > 1) {
					extraData.readByte(); // drop padding
					Entity entity = world.getEntityByID(extraData.readVarInt());
					if (entity != null)
						entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							this.internal = capability;
							this.bound = true;
						});
				} else { // might be bound to block
					TileEntity ent = inv.player != null ? inv.player.world.getTileEntity(pos) : null;
					if (ent != null) {
						ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							this.internal = capability;
							this.bound = true;
						});
					}
				}
			}
			this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 10, 10) {
			}));
			this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 37, 10) {
			}));
			this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 64, 10) {
			}));
			this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 91, 10) {
			}));
			this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 118, 10) {
			}));
			this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 145, 10) {
			}));
			this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 172, 10) {
			}));
			this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 199, 10) {
			}));
			this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 226, 10) {
			}));
			this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 10, 37) {
			}));
			this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 37, 37) {
			}));
			this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 64, 37) {
			}));
			this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 91, 37) {
			}));
			this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 118, 37) {
			}));
			this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 145, 37) {
			}));
			this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 172, 37) {
			}));
			this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 199, 37) {
			}));
			this.customSlots.put(17, this.addSlot(new SlotItemHandler(internal, 17, 226, 37) {
			}));
			this.customSlots.put(18, this.addSlot(new SlotItemHandler(internal, 18, 10, 64) {
			}));
			this.customSlots.put(27, this.addSlot(new SlotItemHandler(internal, 27, 10, 91) {
			}));
			this.customSlots.put(36, this.addSlot(new SlotItemHandler(internal, 36, 10, 118) {
			}));
			this.customSlots.put(45, this.addSlot(new SlotItemHandler(internal, 45, 10, 145) {
			}));
			this.customSlots.put(54, this.addSlot(new SlotItemHandler(internal, 54, 10, 172) {
			}));
			this.customSlots.put(63, this.addSlot(new SlotItemHandler(internal, 63, 10, 199) {
			}));
			this.customSlots.put(19, this.addSlot(new SlotItemHandler(internal, 19, 37, 64) {
			}));
			this.customSlots.put(28, this.addSlot(new SlotItemHandler(internal, 28, 37, 91) {
			}));
			this.customSlots.put(37, this.addSlot(new SlotItemHandler(internal, 37, 37, 118) {
			}));
			this.customSlots.put(46, this.addSlot(new SlotItemHandler(internal, 46, 37, 145) {
			}));
			this.customSlots.put(55, this.addSlot(new SlotItemHandler(internal, 55, 37, 172) {
			}));
			this.customSlots.put(64, this.addSlot(new SlotItemHandler(internal, 64, 37, 199) {
			}));
			this.customSlots.put(20, this.addSlot(new SlotItemHandler(internal, 20, 64, 64) {
			}));
			this.customSlots.put(29, this.addSlot(new SlotItemHandler(internal, 29, 64, 91) {
			}));
			this.customSlots.put(38, this.addSlot(new SlotItemHandler(internal, 38, 64, 118) {
			}));
			this.customSlots.put(47, this.addSlot(new SlotItemHandler(internal, 47, 64, 145) {
			}));
			this.customSlots.put(56, this.addSlot(new SlotItemHandler(internal, 56, 64, 172) {
			}));
			this.customSlots.put(66, this.addSlot(new SlotItemHandler(internal, 66, 64, 199) {
			}));
			this.customSlots.put(21, this.addSlot(new SlotItemHandler(internal, 21, 91, 64) {
			}));
			this.customSlots.put(30, this.addSlot(new SlotItemHandler(internal, 30, 91, 91) {
			}));
			this.customSlots.put(39, this.addSlot(new SlotItemHandler(internal, 39, 91, 118) {
			}));
			this.customSlots.put(48, this.addSlot(new SlotItemHandler(internal, 48, 91, 145) {
			}));
			this.customSlots.put(57, this.addSlot(new SlotItemHandler(internal, 57, 91, 172) {
			}));
			this.customSlots.put(67, this.addSlot(new SlotItemHandler(internal, 67, 91, 199) {
			}));
			this.customSlots.put(22, this.addSlot(new SlotItemHandler(internal, 22, 118, 64) {
			}));
			this.customSlots.put(31, this.addSlot(new SlotItemHandler(internal, 31, 118, 91) {
			}));
			this.customSlots.put(40, this.addSlot(new SlotItemHandler(internal, 40, 118, 118) {
			}));
			this.customSlots.put(49, this.addSlot(new SlotItemHandler(internal, 49, 118, 145) {
			}));
			this.customSlots.put(58, this.addSlot(new SlotItemHandler(internal, 58, 118, 172) {
			}));
			this.customSlots.put(68, this.addSlot(new SlotItemHandler(internal, 68, 118, 199) {
			}));
			this.customSlots.put(23, this.addSlot(new SlotItemHandler(internal, 23, 145, 64) {
			}));
			this.customSlots.put(32, this.addSlot(new SlotItemHandler(internal, 32, 145, 91) {
			}));
			this.customSlots.put(41, this.addSlot(new SlotItemHandler(internal, 41, 145, 118) {
			}));
			this.customSlots.put(50, this.addSlot(new SlotItemHandler(internal, 50, 145, 145) {
			}));
			this.customSlots.put(59, this.addSlot(new SlotItemHandler(internal, 59, 145, 172) {
			}));
			this.customSlots.put(69, this.addSlot(new SlotItemHandler(internal, 69, 145, 199) {
			}));
			this.customSlots.put(24, this.addSlot(new SlotItemHandler(internal, 24, 172, 64) {
			}));
			this.customSlots.put(33, this.addSlot(new SlotItemHandler(internal, 33, 172, 91) {
			}));
			this.customSlots.put(42, this.addSlot(new SlotItemHandler(internal, 42, 172, 118) {
			}));
			this.customSlots.put(51, this.addSlot(new SlotItemHandler(internal, 51, 172, 145) {
			}));
			this.customSlots.put(60, this.addSlot(new SlotItemHandler(internal, 60, 172, 172) {
			}));
			this.customSlots.put(70, this.addSlot(new SlotItemHandler(internal, 70, 172, 199) {
			}));
			this.customSlots.put(25, this.addSlot(new SlotItemHandler(internal, 25, 199, 64) {
			}));
			this.customSlots.put(34, this.addSlot(new SlotItemHandler(internal, 34, 199, 91) {
			}));
			this.customSlots.put(43, this.addSlot(new SlotItemHandler(internal, 43, 199, 118) {
			}));
			this.customSlots.put(52, this.addSlot(new SlotItemHandler(internal, 52, 199, 145) {
			}));
			this.customSlots.put(61, this.addSlot(new SlotItemHandler(internal, 61, 199, 172) {
			}));
			this.customSlots.put(71, this.addSlot(new SlotItemHandler(internal, 71, 199, 199) {
			}));
			this.customSlots.put(26, this.addSlot(new SlotItemHandler(internal, 26, 226, 64) {
			}));
			this.customSlots.put(35, this.addSlot(new SlotItemHandler(internal, 35, 226, 91) {
			}));
			this.customSlots.put(44, this.addSlot(new SlotItemHandler(internal, 44, 226, 118) {
			}));
			this.customSlots.put(53, this.addSlot(new SlotItemHandler(internal, 53, 226, 145) {
			}));
			this.customSlots.put(62, this.addSlot(new SlotItemHandler(internal, 62, 226, 172) {
			}));
			this.customSlots.put(72, this.addSlot(new SlotItemHandler(internal, 72, 226, 199) {
			}));
			this.customSlots.put(73, this.addSlot(new SlotItemHandler(internal, 73, 388, 10) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return (new ItemStack(Items.DIAMOND_HELMET, (int) (1)).getItem() == stack.getItem());
				}
			}));
			this.customSlots.put(74, this.addSlot(new SlotItemHandler(internal, 74, 388, 46) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return (new ItemStack(Items.DIAMOND_CHESTPLATE, (int) (1)).getItem() == stack.getItem());
				}
			}));
			this.customSlots.put(75, this.addSlot(new SlotItemHandler(internal, 75, 388, 82) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return (new ItemStack(WeaponCartTitanMinigunItem.block, (int) (1)).getItem() == stack.getItem());
				}
			}));
			this.customSlots.put(76, this.addSlot(new SlotItemHandler(internal, 76, 388, 118) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return (new ItemStack(ItemSaddleCartTitanItem.block, (int) (1)).getItem() == stack.getItem());
				}
			}));
			int si;
			int sj;
			for (si = 0; si < 3; ++si)
				for (sj = 0; sj < 9; ++sj)
					this.addSlot(new Slot(inv, sj + (si + 1) * 9, 241 + 8 + sj * 18, 61 + 84 + si * 18));
			for (si = 0; si < 9; ++si)
				this.addSlot(new Slot(inv, si, 241 + 8 + si * 18, 61 + 142));
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(PlayerEntity player) {
			return true;
		}

		@Override
		public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
			ItemStack itemstack = ItemStack.EMPTY;
			Slot slot = (Slot) this.inventorySlots.get(index);
			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();
				if (index < 76) {
					if (!this.mergeItemStack(itemstack1, 76, this.inventorySlots.size(), true)) {
						return ItemStack.EMPTY;
					}
					slot.onSlotChange(itemstack1, itemstack);
				} else if (!this.mergeItemStack(itemstack1, 0, 76, false)) {
					if (index < 76 + 27) {
						if (!this.mergeItemStack(itemstack1, 76 + 27, this.inventorySlots.size(), true)) {
							return ItemStack.EMPTY;
						}
					} else {
						if (!this.mergeItemStack(itemstack1, 76, 76 + 27, false)) {
							return ItemStack.EMPTY;
						}
					}
					return ItemStack.EMPTY;
				}
				if (itemstack1.getCount() == 0) {
					slot.putStack(ItemStack.EMPTY);
				} else {
					slot.onSlotChanged();
				}
				if (itemstack1.getCount() == itemstack.getCount()) {
					return ItemStack.EMPTY;
				}
				slot.onTake(playerIn, itemstack1);
			}
			return itemstack;
		}

		@Override /**
					 * Merges provided ItemStack with the first avaliable one in the
					 * container/player inventor between minIndex (included) and maxIndex
					 * (excluded). Args : stack, minIndex, maxIndex, negativDirection. /!\ the
					 * Container implementation do not check if the item is valid for the slot
					 */
		protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
			boolean flag = false;
			int i = startIndex;
			if (reverseDirection) {
				i = endIndex - 1;
			}
			if (stack.isStackable()) {
				while (!stack.isEmpty()) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot = this.inventorySlots.get(i);
					ItemStack itemstack = slot.getStack();
					if (slot.isItemValid(itemstack) && !itemstack.isEmpty() && areItemsAndTagsEqual(stack, itemstack)) {
						int j = itemstack.getCount() + stack.getCount();
						int maxSize = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
						if (j <= maxSize) {
							stack.setCount(0);
							itemstack.setCount(j);
							slot.putStack(itemstack);
							flag = true;
						} else if (itemstack.getCount() < maxSize) {
							stack.shrink(maxSize - itemstack.getCount());
							itemstack.setCount(maxSize);
							slot.putStack(itemstack);
							flag = true;
						}
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			if (!stack.isEmpty()) {
				if (reverseDirection) {
					i = endIndex - 1;
				} else {
					i = startIndex;
				}
				while (true) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot1 = this.inventorySlots.get(i);
					ItemStack itemstack1 = slot1.getStack();
					if (itemstack1.isEmpty() && slot1.isItemValid(stack)) {
						if (stack.getCount() > slot1.getSlotStackLimit()) {
							slot1.putStack(stack.split(slot1.getSlotStackLimit()));
						} else {
							slot1.putStack(stack.split(stack.getCount()));
						}
						slot1.onSlotChanged();
						flag = true;
						break;
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			return flag;
		}

		@Override
		public void onContainerClosed(PlayerEntity playerIn) {
			super.onContainerClosed(playerIn);
			if (!bound && (playerIn instanceof ServerPlayerEntity)) {
				if (!playerIn.isAlive() || playerIn instanceof ServerPlayerEntity && ((ServerPlayerEntity) playerIn).hasDisconnected()) {
					for (int j = 0; j < internal.getSlots(); ++j) {
						if (j == 0)
							continue;
						if (j == 1)
							continue;
						if (j == 2)
							continue;
						if (j == 3)
							continue;
						if (j == 4)
							continue;
						if (j == 5)
							continue;
						if (j == 6)
							continue;
						if (j == 7)
							continue;
						if (j == 8)
							continue;
						if (j == 9)
							continue;
						if (j == 10)
							continue;
						if (j == 11)
							continue;
						if (j == 12)
							continue;
						if (j == 13)
							continue;
						if (j == 14)
							continue;
						if (j == 15)
							continue;
						if (j == 16)
							continue;
						if (j == 17)
							continue;
						if (j == 18)
							continue;
						if (j == 27)
							continue;
						if (j == 36)
							continue;
						if (j == 45)
							continue;
						if (j == 54)
							continue;
						if (j == 63)
							continue;
						if (j == 19)
							continue;
						if (j == 28)
							continue;
						if (j == 37)
							continue;
						if (j == 46)
							continue;
						if (j == 55)
							continue;
						if (j == 64)
							continue;
						if (j == 20)
							continue;
						if (j == 29)
							continue;
						if (j == 38)
							continue;
						if (j == 47)
							continue;
						if (j == 56)
							continue;
						if (j == 66)
							continue;
						if (j == 21)
							continue;
						if (j == 30)
							continue;
						if (j == 39)
							continue;
						if (j == 48)
							continue;
						if (j == 57)
							continue;
						if (j == 67)
							continue;
						if (j == 22)
							continue;
						if (j == 31)
							continue;
						if (j == 40)
							continue;
						if (j == 49)
							continue;
						if (j == 58)
							continue;
						if (j == 68)
							continue;
						if (j == 23)
							continue;
						if (j == 32)
							continue;
						if (j == 41)
							continue;
						if (j == 50)
							continue;
						if (j == 59)
							continue;
						if (j == 69)
							continue;
						if (j == 24)
							continue;
						if (j == 33)
							continue;
						if (j == 42)
							continue;
						if (j == 51)
							continue;
						if (j == 60)
							continue;
						if (j == 70)
							continue;
						if (j == 25)
							continue;
						if (j == 34)
							continue;
						if (j == 43)
							continue;
						if (j == 52)
							continue;
						if (j == 61)
							continue;
						if (j == 71)
							continue;
						if (j == 26)
							continue;
						if (j == 35)
							continue;
						if (j == 44)
							continue;
						if (j == 53)
							continue;
						if (j == 62)
							continue;
						if (j == 72)
							continue;
						if (j == 73)
							continue;
						if (j == 74)
							continue;
						if (j == 75)
							continue;
						if (j == 76)
							continue;
						playerIn.dropItem(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
					}
				} else {
					for (int i = 0; i < internal.getSlots(); ++i) {
						if (i == 0)
							continue;
						if (i == 1)
							continue;
						if (i == 2)
							continue;
						if (i == 3)
							continue;
						if (i == 4)
							continue;
						if (i == 5)
							continue;
						if (i == 6)
							continue;
						if (i == 7)
							continue;
						if (i == 8)
							continue;
						if (i == 9)
							continue;
						if (i == 10)
							continue;
						if (i == 11)
							continue;
						if (i == 12)
							continue;
						if (i == 13)
							continue;
						if (i == 14)
							continue;
						if (i == 15)
							continue;
						if (i == 16)
							continue;
						if (i == 17)
							continue;
						if (i == 18)
							continue;
						if (i == 27)
							continue;
						if (i == 36)
							continue;
						if (i == 45)
							continue;
						if (i == 54)
							continue;
						if (i == 63)
							continue;
						if (i == 19)
							continue;
						if (i == 28)
							continue;
						if (i == 37)
							continue;
						if (i == 46)
							continue;
						if (i == 55)
							continue;
						if (i == 64)
							continue;
						if (i == 20)
							continue;
						if (i == 29)
							continue;
						if (i == 38)
							continue;
						if (i == 47)
							continue;
						if (i == 56)
							continue;
						if (i == 66)
							continue;
						if (i == 21)
							continue;
						if (i == 30)
							continue;
						if (i == 39)
							continue;
						if (i == 48)
							continue;
						if (i == 57)
							continue;
						if (i == 67)
							continue;
						if (i == 22)
							continue;
						if (i == 31)
							continue;
						if (i == 40)
							continue;
						if (i == 49)
							continue;
						if (i == 58)
							continue;
						if (i == 68)
							continue;
						if (i == 23)
							continue;
						if (i == 32)
							continue;
						if (i == 41)
							continue;
						if (i == 50)
							continue;
						if (i == 59)
							continue;
						if (i == 69)
							continue;
						if (i == 24)
							continue;
						if (i == 33)
							continue;
						if (i == 42)
							continue;
						if (i == 51)
							continue;
						if (i == 60)
							continue;
						if (i == 70)
							continue;
						if (i == 25)
							continue;
						if (i == 34)
							continue;
						if (i == 43)
							continue;
						if (i == 52)
							continue;
						if (i == 61)
							continue;
						if (i == 71)
							continue;
						if (i == 26)
							continue;
						if (i == 35)
							continue;
						if (i == 44)
							continue;
						if (i == 53)
							continue;
						if (i == 62)
							continue;
						if (i == 72)
							continue;
						if (i == 73)
							continue;
						if (i == 74)
							continue;
						if (i == 75)
							continue;
						if (i == 76)
							continue;
						playerIn.inventory.placeItemBackInInventory(playerIn.world,
								internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
					}
				}
			}
		}

		private void slotChanged(int slotid, int ctype, int meta) {
			if (this.world != null && this.world.isRemote) {
				MyTitanMod.PACKET_HANDLER.sendToServer(new GUISlotChangedMessage(slotid, x, y, z, ctype, meta));
				handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class GuiWindow extends ContainerScreen<GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		public GuiWindow(GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 415;
			this.ySize = 225;
		}
		private static final ResourceLocation texture = new ResourceLocation("my_titan:textures/cart_titan_gui.png");
		@Override
		public void render(int mouseX, int mouseY, float partialTicks) {
			this.renderBackground();
			super.render(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1, 1, 1, 1);
			Minecraft.getInstance().getTextureManager().bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.blit(k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("my_titan:textures/thecarttitan.png"));
			this.blit(this.guiLeft + 252, this.guiTop + 9, 0, 0, 125, 108, 125, 108);
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
			this.font.drawString("Inventory", 261, 126, -205);
		}

		@Override
		public void removed() {
			super.removed();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
		}
	}

	public static class ButtonPressedMessage {
		int buttonID, x, y, z;
		public ButtonPressedMessage(PacketBuffer buffer) {
			this.buttonID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
		}

		public ButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.buttonID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
		}

		public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}

	public static class GUISlotChangedMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		public GUISlotChangedMessage(PacketBuffer buffer) {
			this.slotID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
			this.changeType = buffer.readInt();
			this.meta = buffer.readInt();
		}

		public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.slotID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
			buffer.writeInt(message.changeType);
			buffer.writeInt(message.meta);
		}

		public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}
	private static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}

	private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
