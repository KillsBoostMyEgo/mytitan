package net.killsboost.watashinokyojin.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.PlayerModel;

import net.killsboost.watashinokyojin.MyTitanModElements;

import java.util.Map;
import java.util.HashMap;

import com.mrcrayfish.obfuscate.client.event.PlayerModelEvent;

@MyTitanModElements.ModElement.Tag
public class TransformBitingAnimationProcedure extends MyTitanModElements.ModElement {
	public TransformBitingAnimationProcedure(MyTitanModElements instance) {
		super(instance, 47);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure TransformBitingAnimation!");
			return;
		}
		if (dependencies.get("playerModel") == null) {
			if (!dependencies.containsKey("playerModel"))
				System.err.println("Failed to load dependency playerModel for procedure TransformBitingAnimation!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		PlayerModel playerModel = (PlayerModel) dependencies.get("playerModel");
		playerModel.bipedHead.rotationPointX = (float) 0;
	}

	@SubscribeEvent
	public void setupPlayerRotations(PlayerModelEvent.SetupAngles.Post event) {
		Entity entity = event.getEntity();
		PlayerModel playerModel = event.getModelPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("entity", entity);
		dependencies.put("playerModel", playerModel);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
