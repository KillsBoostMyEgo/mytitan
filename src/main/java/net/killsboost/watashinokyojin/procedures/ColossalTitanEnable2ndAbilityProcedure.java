package net.killsboost.watashinokyojin.procedures;

import net.minecraft.entity.Entity;

import net.killsboost.watashinokyojin.MyTitanModVariables;
import net.killsboost.watashinokyojin.MyTitanModElements;

import java.util.Map;

@MyTitanModElements.ModElement.Tag
public class ColossalTitanEnable2ndAbilityProcedure extends MyTitanModElements.ModElement {
	public ColossalTitanEnable2ndAbilityProcedure(MyTitanModElements instance) {
		super(instance, 45);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ColossalTitanEnable2ndAbility!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (boolean) (true);
			entity.getCapability(MyTitanModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.isColossalAbilityOn = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
