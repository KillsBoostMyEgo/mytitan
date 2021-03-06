package net.killsboost.watashinokyojin.procedures;

import net.minecraft.entity.Entity;

import net.killsboost.watashinokyojin.MyTitanModVariables;
import net.killsboost.watashinokyojin.MyTitanModElements;

import java.util.Map;

@MyTitanModElements.ModElement.Tag
public class AutoUnlockTitanArmoredRightClickedInAirProcedure extends MyTitanModElements.ModElement {
	public AutoUnlockTitanArmoredRightClickedInAirProcedure(MyTitanModElements instance) {
		super(instance, 61);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AutoUnlockTitanArmoredRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (boolean) (true);
			entity.getCapability(MyTitanModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.hasTitanArmored = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
