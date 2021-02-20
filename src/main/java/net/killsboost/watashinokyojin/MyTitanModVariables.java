package net.killsboost.watashinokyojin;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class MyTitanModVariables {
	public MyTitanModVariables(MyTitanModElements elements) {
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}
	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;
	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("my_titan", "player_variables"), new PlayerVariablesProvider());
	}
	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);
		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("selectedTitan", instance.selectedTitan);
			nbt.putBoolean("hasTitanAttack", instance.hasTitanAttack);
			nbt.putBoolean("hasTitanColossus", instance.hasTitanColossus);
			nbt.putBoolean("hasTitanFemale", instance.hasTitanFemale);
			nbt.putBoolean("hasTitanArmored", instance.hasTitanArmored);
			nbt.putBoolean("hasTitanCart", instance.hasTitanCart);
			nbt.putBoolean("hasTitanBeast", instance.hasTitanBeast);
			nbt.putBoolean("hasTitanWarHammer", instance.hasTitanWarHammer);
			nbt.putBoolean("hasTitanJaw", instance.hasTitanJaw);
			nbt.putBoolean("hasTitanFounding", instance.hasTitanFounding);
			nbt.putBoolean("isColossalAbilityOn", instance.isColossalAbilityOn);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.selectedTitan = nbt.getDouble("selectedTitan");
			instance.hasTitanAttack = nbt.getBoolean("hasTitanAttack");
			instance.hasTitanColossus = nbt.getBoolean("hasTitanColossus");
			instance.hasTitanFemale = nbt.getBoolean("hasTitanFemale");
			instance.hasTitanArmored = nbt.getBoolean("hasTitanArmored");
			instance.hasTitanCart = nbt.getBoolean("hasTitanCart");
			instance.hasTitanBeast = nbt.getBoolean("hasTitanBeast");
			instance.hasTitanWarHammer = nbt.getBoolean("hasTitanWarHammer");
			instance.hasTitanJaw = nbt.getBoolean("hasTitanJaw");
			instance.hasTitanFounding = nbt.getBoolean("hasTitanFounding");
			instance.isColossalAbilityOn = nbt.getBoolean("isColossalAbilityOn");
		}
	}

	public static class PlayerVariables {
		public double selectedTitan = 0.0;
		public boolean hasTitanAttack = false;
		public boolean hasTitanColossus = false;
		public boolean hasTitanFemale = false;
		public boolean hasTitanArmored = false;
		public boolean hasTitanCart = false;
		public boolean hasTitanBeast = false;
		public boolean hasTitanWarHammer = false;
		public boolean hasTitanJaw = false;
		public boolean hasTitanFounding = false;
		public boolean isColossalAbilityOn = false;
		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				MyTitanMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}
	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.selectedTitan = original.selectedTitan;
		clone.hasTitanAttack = original.hasTitanAttack;
		clone.hasTitanColossus = original.hasTitanColossus;
		clone.hasTitanFemale = original.hasTitanFemale;
		clone.hasTitanArmored = original.hasTitanArmored;
		clone.hasTitanCart = original.hasTitanCart;
		clone.hasTitanBeast = original.hasTitanBeast;
		clone.hasTitanWarHammer = original.hasTitanWarHammer;
		clone.hasTitanJaw = original.hasTitanJaw;
		clone.hasTitanFounding = original.hasTitanFounding;
		if (!event.isWasDeath()) {
			clone.isColossalAbilityOn = original.isColossalAbilityOn;
		}
	}
	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;
		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.selectedTitan = message.data.selectedTitan;
					variables.hasTitanAttack = message.data.hasTitanAttack;
					variables.hasTitanColossus = message.data.hasTitanColossus;
					variables.hasTitanFemale = message.data.hasTitanFemale;
					variables.hasTitanArmored = message.data.hasTitanArmored;
					variables.hasTitanCart = message.data.hasTitanCart;
					variables.hasTitanBeast = message.data.hasTitanBeast;
					variables.hasTitanWarHammer = message.data.hasTitanWarHammer;
					variables.hasTitanJaw = message.data.hasTitanJaw;
					variables.hasTitanFounding = message.data.hasTitanFounding;
					variables.isColossalAbilityOn = message.data.isColossalAbilityOn;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
