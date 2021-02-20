package net.killsboost.watashinokyojin.procedures;

import net.minecraft.entity.Entity;

import net.killsboost.watashinokyojin.MyTitanModVariables;
import net.killsboost.watashinokyojin.MyTitanModElements;

import java.util.Map;

@MyTitanModElements.ModElement.Tag
public class ColossalTitan2ndAbilityStopProcedure extends MyTitanModElements.ModElement {
	public ColossalTitan2ndAbilityStopProcedure(MyTitanModElements instance) {
		super(instance, 46);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ColossalTitan2ndAbilityStop!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (boolean) (false);
			entity.getCapability(MyTitanModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.isColossalAbilityOn = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
