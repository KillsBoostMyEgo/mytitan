
package net.killsboost.watashinokyojin.entity;

import software.bernie.geckolib.manager.EntityAnimationManager;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.controller.EntityAnimationController;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.killsboost.watashinokyojin.procedures.EntityControllableCartTitanOnInitialEntitySpawnProcedure;
import net.killsboost.watashinokyojin.itemgroup.CreativeTabMyTitanItemGroup;
import net.killsboost.watashinokyojin.MyTitanModElements;

import java.util.Map;
import java.util.HashMap;

@MyTitanModElements.ModElement.Tag
public class EntityControllableAttackTitanEntity extends MyTitanModElements.ModElement {
	public static EntityType entity = null;
	public EntityControllableAttackTitanEntity(MyTitanModElements instance) {
		super(instance, 4);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(1f, 1f))
						.build("entity_controllable_attack_titan").setRegistryName("entity_controllable_attack_titan");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16711681, -16764160, new Item.Properties().group(CreativeTabMyTitanItemGroup.tab))
				.setRegistryName("entity_controllable_attack_titan_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelattack_titan(), 5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("my_titan:textures/titan_skin.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity implements IAnimatedEntity {
		EntityAnimationManager manager = new EntityAnimationManager();
		EntityAnimationController controller = new EntityAnimationController(this, "controller", 1, this::animationPredicate);
		private <E extends Entity> boolean animationPredicate(AnimationTestEvent<E> event) {
			controller.transitionLengthTicks = 1;
			controller.markNeedsReload();
			return true;
		}

		@Override
		public EntityAnimationManager getAnimationManager() {
			return manager;
		}

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			manager.addAnimationController(controller);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public double getMountedYOffset() {
			return super.getMountedYOffset() + 10;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public boolean processInteract(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			boolean retval = true;
			super.processInteract(sourceentity, hand);
			sourceentity.startRiding(this);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			return retval;
		}

		@Override
		public void onCollideWithPlayer(PlayerEntity sourceentity) {
			super.onCollideWithPlayer(sourceentity);
			Entity entity = this;
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("sourceentity", sourceentity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				EntityControllableCartTitanOnInitialEntitySpawnProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(250);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS);
		@Override
		public void addTrackingPlayer(ServerPlayerEntity player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(ServerPlayerEntity player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void updateAITasks() {
			super.updateAITasks();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}

		@Override
		public void travel(Vec3d dir) {
			Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
			if (this.isBeingRidden()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
				this.renderYawOffset = entity.rotationYaw;
				this.rotationYawHead = entity.rotationYaw;
				this.stepHeight = 1.0F;
				if (entity instanceof LivingEntity) {
					this.setAIMoveSpeed((float) this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
					float forward = ((LivingEntity) entity).moveForward;
					float strafe = ((LivingEntity) entity).moveStrafing;
					super.travel(new Vec3d(strafe, 0, forward));
				}
				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.getPosX() - this.prevPosX;
				double d0 = this.getPosZ() - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F)
					f1 = 1.0F;
				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
				return;
			}
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.travel(dir);
		}
	}

	// Made with Blockbench 3.6.6
	public static class Modelattack_titan extends AnimatedEntityModel {
		private final AnimatedModelRenderer all;
		private final AnimatedModelRenderer MAMADISIMOMOMENTO;
		private final AnimatedModelRenderer MAMADOTE0;
		private final AnimatedModelRenderer MAMADISIMO9_r1;
		private final AnimatedModelRenderer MAMADISIMO8_r1;
		private final AnimatedModelRenderer MAMADISIMO7_r1;
		private final AnimatedModelRenderer MAMADISIMO6_r1;
		private final AnimatedModelRenderer MAMADISIMO5_r1;
		private final AnimatedModelRenderer MAMADISIMO4_r1;
		private final AnimatedModelRenderer MAMADISIMO3_r1;
		private final AnimatedModelRenderer MAMADISIMO2_r1;
		private final AnimatedModelRenderer MAMADISIMO1_r1;
		private final AnimatedModelRenderer MAMADISIMO10_r1;
		private final AnimatedModelRenderer MAMADISIMO9_r2;
		private final AnimatedModelRenderer MAMADISIMO8_r2;
		private final AnimatedModelRenderer MAMADISIMO7_r2;
		private final AnimatedModelRenderer MAMADISIMO6_r2;
		private final AnimatedModelRenderer MAMADISIMO5_r2;
		private final AnimatedModelRenderer MAMADISIMO4_r2;
		private final AnimatedModelRenderer MAMADOTE1;
		private final AnimatedModelRenderer MAMADISIMO4_r3;
		private final AnimatedModelRenderer MAMADISIMO3_r2;
		private final AnimatedModelRenderer MAMADISIMO2_r2;
		private final AnimatedModelRenderer MAMADISIMO5_r3;
		private final AnimatedModelRenderer MINIMAMADISIMO;
		private final AnimatedModelRenderer MAMADISIMO7_r3;
		private final AnimatedModelRenderer MAMADISIMO12_r1;
		private final AnimatedModelRenderer MAMADISIMO10_r2;
		private final AnimatedModelRenderer MAMADISIMO8_r3;
		private final AnimatedModelRenderer MAMADISIMO6_r3;
		private final AnimatedModelRenderer MAMADISIMO5_r4;
		private final AnimatedModelRenderer shoulders;
		private final AnimatedModelRenderer shoulderarea2;
		private final AnimatedModelRenderer cube_r1;
		private final AnimatedModelRenderer cube_r2;
		private final AnimatedModelRenderer cube_r20;
		private final AnimatedModelRenderer cube_r13_r1;
		private final AnimatedModelRenderer cube_r12_r1;
		private final AnimatedModelRenderer cube_r13;
		private final AnimatedModelRenderer cube_r20_r1;
		private final AnimatedModelRenderer cube_r20_r2;
		private final AnimatedModelRenderer cube_r19_r1;
		private final AnimatedModelRenderer cube_r18_r1;
		private final AnimatedModelRenderer cube_r17_r1;
		private final AnimatedModelRenderer cube_r11;
		private final AnimatedModelRenderer cube_r21_r1;
		private final AnimatedModelRenderer cube_r21_r2;
		private final AnimatedModelRenderer cube_r20_r3;
		private final AnimatedModelRenderer cube_r20_r4;
		private final AnimatedModelRenderer cube_r19_r2;
		private final AnimatedModelRenderer cube_r18_r2;
		private final AnimatedModelRenderer cube_r12;
		private final AnimatedModelRenderer cube_r22_r1;
		private final AnimatedModelRenderer cube_r22_r2;
		private final AnimatedModelRenderer cube_r21_r3;
		private final AnimatedModelRenderer cube_r21_r4;
		private final AnimatedModelRenderer cube_r20_r5;
		private final AnimatedModelRenderer cube_r19_r3;
		private final AnimatedModelRenderer cube_r14;
		private final AnimatedModelRenderer cube_r23_r1;
		private final AnimatedModelRenderer cube_r23_r2;
		private final AnimatedModelRenderer cube_r22_r3;
		private final AnimatedModelRenderer cube_r21_r5;
		private final AnimatedModelRenderer cube_r20_r6;
		private final AnimatedModelRenderer arms;
		private final AnimatedModelRenderer cube_r3;
		private final AnimatedModelRenderer cube_r4;
		private final AnimatedModelRenderer cube_r5;
		private final AnimatedModelRenderer cube_r6;
		private final AnimatedModelRenderer larm;
		private final AnimatedModelRenderer lshoulderarm;
		private final AnimatedModelRenderer lforearm;
		private final AnimatedModelRenderer lforearm_r1;
		private final AnimatedModelRenderer rarm;
		private final AnimatedModelRenderer rshoulderarm;
		private final AnimatedModelRenderer rforearm;
		private final AnimatedModelRenderer lforearm_r2;
		private final AnimatedModelRenderer lforearm_r3;
		private final AnimatedModelRenderer lforearm_r4;
		private final AnimatedModelRenderer rightleg;
		private final AnimatedModelRenderer upperrightleg;
		private final AnimatedModelRenderer rihgtlowerlegs;
		private final AnimatedModelRenderer rfoot;
		private final AnimatedModelRenderer rfoot_r1;
		private final AnimatedModelRenderer rfoot_r2;
		private final AnimatedModelRenderer rfoot_r3;
		private final AnimatedModelRenderer rfoot_r4;
		private final AnimatedModelRenderer lfoot;
		private final AnimatedModelRenderer lfoot_r1;
		private final AnimatedModelRenderer lfoot_r2;
		private final AnimatedModelRenderer lfoot_r3;
		private final AnimatedModelRenderer lfoot_r4;
		private final AnimatedModelRenderer leftleg;
		private final AnimatedModelRenderer upperleftleg;
		private final AnimatedModelRenderer leftlowerlegs;
		private final AnimatedModelRenderer torso;
		private final AnimatedModelRenderer movy;
		private final AnimatedModelRenderer movy_r1;
		private final AnimatedModelRenderer movy_r2;
		private final AnimatedModelRenderer yes_r1;
		private final AnimatedModelRenderer yes_r2;
		private final AnimatedModelRenderer yes_r3;
		private final AnimatedModelRenderer yes_r4;
		private final AnimatedModelRenderer yes_r5;
		private final AnimatedModelRenderer yes_r6;
		private final AnimatedModelRenderer yes_r7;
		private final AnimatedModelRenderer yes_r8;
		private final AnimatedModelRenderer movy2;
		private final AnimatedModelRenderer movy_r3;
		private final AnimatedModelRenderer movy_r4;
		private final AnimatedModelRenderer yes_r9;
		private final AnimatedModelRenderer yes_r10;
		private final AnimatedModelRenderer yes_r11;
		private final AnimatedModelRenderer yes_r12;
		private final AnimatedModelRenderer yes_r13;
		private final AnimatedModelRenderer yes_r14;
		private final AnimatedModelRenderer yes_r15;
		private final AnimatedModelRenderer yes_r16;
		private final AnimatedModelRenderer yesr_17;
		public Modelattack_titan() {
			textureWidth = 256;
			textureHeight = 256;
			all = new AnimatedModelRenderer(this);
			all.setRotationPoint(0.0F, -16.3011F, 0.5F);
			all.setModelRendererName("all");
			this.registerModelRenderer(all);
			MAMADISIMOMOMENTO = new AnimatedModelRenderer(this);
			MAMADISIMOMOMENTO.setRotationPoint(0.0F, 0.0F, 0.0F);
			all.addChild(MAMADISIMOMOMENTO);
			MAMADISIMOMOMENTO.setModelRendererName("MAMADISIMOMOMENTO");
			this.registerModelRenderer(MAMADISIMOMOMENTO);
			MAMADOTE0 = new AnimatedModelRenderer(this);
			MAMADOTE0.setRotationPoint(-0.7329F, -26.5F, -3.4885F);
			MAMADISIMOMOMENTO.addChild(MAMADOTE0);
			MAMADOTE0.setTextureOffset(89, 68).addBox(-32.2671F, -144.1023F, -10.5115F, 30.0F, 21.0F, 12.0F, 0.0F, false);
			MAMADOTE0.setModelRendererName("MAMADOTE0");
			this.registerModelRenderer(MAMADOTE0);
			MAMADISIMO9_r1 = new AnimatedModelRenderer(this);
			MAMADISIMO9_r1.setRotationPoint(-24.0685F, -88.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO9_r1);
			setRotationAngle(MAMADISIMO9_r1, 1.2217F, 0.0F, 1.5708F);
			MAMADISIMO9_r1.setTextureOffset(177, 14).addBox(-7.4486F, -4.4966F, -0.7844F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO9_r1.setModelRendererName("MAMADISIMO9_r1");
			this.registerModelRenderer(MAMADISIMO9_r1);
			MAMADISIMO8_r1 = new AnimatedModelRenderer(this);
			MAMADISIMO8_r1.setRotationPoint(-18.0685F, -70.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO8_r1);
			setRotationAngle(MAMADISIMO8_r1, 1.2217F, 0.0F, 1.5708F);
			MAMADISIMO8_r1.setTextureOffset(177, 132).addBox(-7.4486F, -4.4966F, -0.7844F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO8_r1.setModelRendererName("MAMADISIMO8_r1");
			this.registerModelRenderer(MAMADISIMO8_r1);
			MAMADISIMO7_r1 = new AnimatedModelRenderer(this);
			MAMADISIMO7_r1.setRotationPoint(2.9315F, -70.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO7_r1);
			setRotationAngle(MAMADISIMO7_r1, 1.2217F, 0.0F, 1.5708F);
			MAMADISIMO7_r1.setTextureOffset(178, 18).addBox(-7.4486F, -4.4966F, -0.7844F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO7_r1.setModelRendererName("MAMADISIMO7_r1");
			this.registerModelRenderer(MAMADISIMO7_r1);
			MAMADISIMO6_r1 = new AnimatedModelRenderer(this);
			MAMADISIMO6_r1.setRotationPoint(2.9315F, -88.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO6_r1);
			setRotationAngle(MAMADISIMO6_r1, 1.2217F, 0.0F, 1.5708F);
			MAMADISIMO6_r1.setTextureOffset(178, 22).addBox(-7.4486F, -4.4966F, -0.7844F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO6_r1.setModelRendererName("MAMADISIMO6_r1");
			this.registerModelRenderer(MAMADISIMO6_r1);
			MAMADISIMO5_r1 = new AnimatedModelRenderer(this);
			MAMADISIMO5_r1.setRotationPoint(2.9315F, -109.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO5_r1);
			setRotationAngle(MAMADISIMO5_r1, 1.2217F, 0.0F, 1.5708F);
			MAMADISIMO5_r1.setTextureOffset(178, 35).addBox(-7.4486F, -4.4966F, -0.7844F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO5_r1.setModelRendererName("MAMADISIMO5_r1");
			this.registerModelRenderer(MAMADISIMO5_r1);
			MAMADISIMO4_r1 = new AnimatedModelRenderer(this);
			MAMADISIMO4_r1.setRotationPoint(-27.0685F, -109.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO4_r1);
			setRotationAngle(MAMADISIMO4_r1, 1.2217F, 0.0F, 1.5708F);
			MAMADISIMO4_r1.setTextureOffset(178, 76).addBox(-7.4486F, -4.4966F, -0.7844F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO4_r1.setModelRendererName("MAMADISIMO4_r1");
			this.registerModelRenderer(MAMADISIMO4_r1);
			MAMADISIMO3_r1 = new AnimatedModelRenderer(this);
			MAMADISIMO3_r1.setRotationPoint(-33.0685F, -133.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO3_r1);
			setRotationAngle(MAMADISIMO3_r1, 1.2217F, 0.0F, 1.5708F);
			MAMADISIMO3_r1.setTextureOffset(173, 10).addBox(-10.4486F, -4.4966F, -0.7844F, 21.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO3_r1.setModelRendererName("MAMADISIMO3_r1");
			this.registerModelRenderer(MAMADISIMO3_r1);
			MAMADISIMO2_r1 = new AnimatedModelRenderer(this);
			MAMADISIMO2_r1.setRotationPoint(-17.2671F, -117.8523F, -3.0115F);
			MAMADOTE0.addChild(MAMADISIMO2_r1);
			setRotationAngle(MAMADISIMO2_r1, 0.9599F, 0.0F, 0.0F);
			MAMADISIMO2_r1.setTextureOffset(152, 76).addBox(-15.0F, -9.0F, 0.0F, 30.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO2_r1.setModelRendererName("MAMADISIMO2_r1");
			this.registerModelRenderer(MAMADISIMO2_r1);
			MAMADISIMO1_r1 = new AnimatedModelRenderer(this);
			MAMADISIMO1_r1.setRotationPoint(-17.2671F, -144.1023F, -10.5115F);
			MAMADOTE0.addChild(MAMADISIMO1_r1);
			setRotationAngle(MAMADISIMO1_r1, -0.9599F, 0.0F, 0.0F);
			MAMADISIMO1_r1.setTextureOffset(153, 125).addBox(-15.0F, -9.0F, 0.0F, 30.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO1_r1.setModelRendererName("MAMADISIMO1_r1");
			this.registerModelRenderer(MAMADISIMO1_r1);
			MAMADISIMO10_r1 = new AnimatedModelRenderer(this);
			MAMADISIMO10_r1.setRotationPoint(28.5342F, -106.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO10_r1);
			setRotationAngle(MAMADISIMO10_r1, 1.2217F, 0.0F, -1.5708F);
			MAMADISIMO10_r1.setTextureOffset(126, 62).addBox(-4.5514F, -4.4966F, -0.7844F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO10_r1.setModelRendererName("MAMADISIMO10_r1");
			this.registerModelRenderer(MAMADISIMO10_r1);
			MAMADISIMO9_r2 = new AnimatedModelRenderer(this);
			MAMADISIMO9_r2.setRotationPoint(25.5342F, -85.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO9_r2);
			setRotationAngle(MAMADISIMO9_r2, 1.2217F, 0.0F, -1.5708F);
			MAMADISIMO9_r2.setTextureOffset(158, 129).addBox(-4.5514F, -4.4966F, -0.7844F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO9_r2.setModelRendererName("MAMADISIMO9_r2");
			this.registerModelRenderer(MAMADISIMO9_r2);
			MAMADISIMO8_r2 = new AnimatedModelRenderer(this);
			MAMADISIMO8_r2.setRotationPoint(19.5342F, -67.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO8_r2);
			setRotationAngle(MAMADISIMO8_r2, 1.2217F, 0.0F, -1.5708F);
			MAMADISIMO8_r2.setTextureOffset(173, 149).addBox(-4.5514F, -4.4966F, -0.7844F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO8_r2.setModelRendererName("MAMADISIMO8_r2");
			this.registerModelRenderer(MAMADISIMO8_r2);
			MAMADISIMO7_r2 = new AnimatedModelRenderer(this);
			MAMADISIMO7_r2.setRotationPoint(-1.4658F, -67.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO7_r2);
			setRotationAngle(MAMADISIMO7_r2, 1.2217F, 0.0F, -1.5708F);
			MAMADISIMO7_r2.setTextureOffset(175, 31).addBox(-4.5514F, -4.4966F, -0.7844F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO7_r2.setModelRendererName("MAMADISIMO7_r2");
			this.registerModelRenderer(MAMADISIMO7_r2);
			MAMADISIMO6_r2 = new AnimatedModelRenderer(this);
			MAMADISIMO6_r2.setRotationPoint(-1.4658F, -85.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO6_r2);
			setRotationAngle(MAMADISIMO6_r2, 1.2217F, 0.0F, -1.5708F);
			MAMADISIMO6_r2.setTextureOffset(175, 166).addBox(-4.5514F, -4.4966F, -0.7844F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO6_r2.setModelRendererName("MAMADISIMO6_r2");
			this.registerModelRenderer(MAMADISIMO6_r2);
			MAMADISIMO5_r2 = new AnimatedModelRenderer(this);
			MAMADISIMO5_r2.setRotationPoint(-1.4658F, -106.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO5_r2);
			setRotationAngle(MAMADISIMO5_r2, 1.2217F, 0.0F, -1.5708F);
			MAMADISIMO5_r2.setTextureOffset(176, 55).addBox(-4.5514F, -4.4966F, -0.7844F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO5_r2.setModelRendererName("MAMADISIMO5_r2");
			this.registerModelRenderer(MAMADISIMO5_r2);
			MAMADISIMO4_r2 = new AnimatedModelRenderer(this);
			MAMADISIMO4_r2.setRotationPoint(-1.4658F, -133.6023F, -5.9771F);
			MAMADOTE0.addChild(MAMADISIMO4_r2);
			setRotationAngle(MAMADISIMO4_r2, 1.2217F, 0.0F, -1.5708F);
			MAMADISIMO4_r2.setTextureOffset(170, 27).addBox(-10.5514F, -4.4966F, -0.7844F, 21.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO4_r2.setModelRendererName("MAMADISIMO4_r2");
			this.registerModelRenderer(MAMADISIMO4_r2);
			MAMADOTE1 = new AnimatedModelRenderer(this);
			MAMADOTE1.setRotationPoint(11.2671F, -26.5F, -3.4885F);
			MAMADISIMOMOMENTO.addChild(MAMADOTE1);
			MAMADOTE1.setTextureOffset(85, 89).addBox(-8.2671F, -144.1023F, -10.5115F, 30.0F, 21.0F, 12.0F, 0.0F, false);
			MAMADOTE1.setModelRendererName("MAMADOTE1");
			this.registerModelRenderer(MAMADOTE1);
			MAMADISIMO4_r3 = new AnimatedModelRenderer(this);
			MAMADISIMO4_r3.setRotationPoint(-9.0685F, -133.6023F, -5.9771F);
			MAMADOTE1.addChild(MAMADISIMO4_r3);
			setRotationAngle(MAMADISIMO4_r3, 1.2217F, 0.0F, 1.5708F);
			MAMADISIMO4_r3.setTextureOffset(53, 77).addBox(-10.4486F, -4.4966F, -0.7844F, 21.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO4_r3.setModelRendererName("MAMADISIMO4_r3");
			this.registerModelRenderer(MAMADISIMO4_r3);
			MAMADISIMO3_r2 = new AnimatedModelRenderer(this);
			MAMADISIMO3_r2.setRotationPoint(6.7329F, -117.8523F, -3.0115F);
			MAMADOTE1.addChild(MAMADISIMO3_r2);
			setRotationAngle(MAMADISIMO3_r2, 0.9599F, 0.0F, 0.0F);
			MAMADISIMO3_r2.setTextureOffset(116, 118).addBox(-15.0F, -9.0F, 0.0F, 30.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO3_r2.setModelRendererName("MAMADISIMO3_r2");
			this.registerModelRenderer(MAMADISIMO3_r2);
			MAMADISIMO2_r2 = new AnimatedModelRenderer(this);
			MAMADISIMO2_r2.setRotationPoint(6.7329F, -144.1023F, -10.5115F);
			MAMADOTE1.addChild(MAMADISIMO2_r2);
			setRotationAngle(MAMADISIMO2_r2, -0.9599F, 0.0F, 0.0F);
			MAMADISIMO2_r2.setTextureOffset(145, 140).addBox(-15.0F, -9.0F, 0.0F, 30.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO2_r2.setModelRendererName("MAMADISIMO2_r2");
			this.registerModelRenderer(MAMADISIMO2_r2);
			MAMADISIMO5_r3 = new AnimatedModelRenderer(this);
			MAMADISIMO5_r3.setRotationPoint(22.5342F, -133.6023F, -5.9771F);
			MAMADOTE1.addChild(MAMADISIMO5_r3);
			setRotationAngle(MAMADISIMO5_r3, 1.2217F, 0.0F, -1.5708F);
			MAMADISIMO5_r3.setTextureOffset(167, 96).addBox(-10.5514F, -4.4966F, -0.7844F, 21.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO5_r3.setModelRendererName("MAMADISIMO5_r3");
			this.registerModelRenderer(MAMADISIMO5_r3);
			MINIMAMADISIMO = new AnimatedModelRenderer(this);
			MINIMAMADISIMO.setRotationPoint(0.0F, 40.3011F, -0.5F);
			MAMADISIMOMOMENTO.addChild(MINIMAMADISIMO);
			MINIMAMADISIMO.setTextureOffset(100, 57).addBox(3.0F, -183.9034F, -13.5F, 24.0F, 15.0F, 15.0F, 0.0F, false);
			MINIMAMADISIMO.setTextureOffset(89, 79).addBox(-27.0F, -183.9034F, -13.5F, 24.0F, 15.0F, 15.0F, 0.0F, false);
			MINIMAMADISIMO.setTextureOffset(121, 52).addBox(-24.0F, -162.9034F, -13.5F, 21.0F, 15.0F, 15.0F, 0.0F, false);
			MINIMAMADISIMO.setTextureOffset(117, 67).addBox(3.0F, -162.9034F, -13.5F, 21.0F, 15.0F, 15.0F, 0.0F, false);
			MINIMAMADISIMO.setTextureOffset(138, 125).addBox(3.0F, -144.9034F, -13.5F, 15.0F, 15.0F, 15.0F, 0.0F, false);
			MINIMAMADISIMO.setTextureOffset(24, 138).addBox(-18.0F, -144.9034F, -13.5F, 15.0F, 15.0F, 15.0F, 0.0F, false);
			MINIMAMADISIMO.setModelRendererName("MINIMAMADISIMO");
			this.registerModelRenderer(MINIMAMADISIMO);
			MAMADISIMO7_r3 = new AnimatedModelRenderer(this);
			MAMADISIMO7_r3.setRotationPoint(-3.0F, -124.6534F, -6.0F);
			MINIMAMADISIMO.addChild(MAMADISIMO7_r3);
			setRotationAngle(MAMADISIMO7_r3, 0.9599F, 0.0F, 0.0F);
			MAMADISIMO7_r3.setTextureOffset(178, 90).addBox(-15.0F, -9.0F, 0.0F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO7_r3.setTextureOffset(63, 179).addBox(6.0F, -9.0F, 0.0F, 15.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO7_r3.setModelRendererName("MAMADISIMO7_r3");
			this.registerModelRenderer(MAMADISIMO7_r3);
			MAMADISIMO12_r1 = new AnimatedModelRenderer(this);
			MAMADISIMO12_r1.setRotationPoint(12.0F, -189.0F, -6.0F);
			MINIMAMADISIMO.addChild(MAMADISIMO12_r1);
			setRotationAngle(MAMADISIMO12_r1, -0.9599F, 0.0F, 0.0F);
			MAMADISIMO12_r1.setTextureOffset(64, 21).addBox(-9.0F, 6.0F, 0.0F, 24.0F, 3.0F, 3.0F, 0.0F, false);
			MAMADISIMO12_r1.setTextureOffset(87, 0).addBox(-39.0F, 6.0F, 0.0F, 24.0F, 3.0F, 3.0F, 0.0F, false);
			MAMADISIMO12_r1.setModelRendererName("MAMADISIMO12_r1");
			this.registerModelRenderer(MAMADISIMO12_r1);
			MAMADISIMO10_r2 = new AnimatedModelRenderer(this);
			MAMADISIMO10_r2.setRotationPoint(-15.0F, -168.0F, -6.0F);
			MINIMAMADISIMO.addChild(MAMADISIMO10_r2);
			setRotationAngle(MAMADISIMO10_r2, -0.9599F, 0.0F, 0.0F);
			MAMADISIMO10_r2.setTextureOffset(76, 68).addBox(-9.0F, 6.0F, 0.0F, 21.0F, 3.0F, 3.0F, 0.0F, false);
			MAMADISIMO10_r2.setTextureOffset(105, 0).addBox(18.0F, 6.0F, 0.0F, 21.0F, 3.0F, 3.0F, 0.0F, false);
			MAMADISIMO10_r2.setModelRendererName("MAMADISIMO10_r2");
			this.registerModelRenderer(MAMADISIMO10_r2);
			MAMADISIMO8_r3 = new AnimatedModelRenderer(this);
			MAMADISIMO8_r3.setRotationPoint(12.0F, -150.0F, -6.0F);
			MINIMAMADISIMO.addChild(MAMADISIMO8_r3);
			setRotationAngle(MAMADISIMO8_r3, -0.9599F, 0.0F, 0.0F);
			MAMADISIMO8_r3.setTextureOffset(33, 82).addBox(-9.0F, 6.0F, 0.0F, 15.0F, 3.0F, 3.0F, 0.0F, false);
			MAMADISIMO8_r3.setTextureOffset(148, 50).addBox(-30.0F, 6.0F, 0.0F, 15.0F, 3.0F, 3.0F, 0.0F, false);
			MAMADISIMO8_r3.setModelRendererName("MAMADISIMO8_r3");
			this.registerModelRenderer(MAMADISIMO8_r3);
			MAMADISIMO6_r3 = new AnimatedModelRenderer(this);
			MAMADISIMO6_r3.setRotationPoint(-9.0F, -142.6534F, -6.0F);
			MINIMAMADISIMO.addChild(MAMADISIMO6_r3);
			setRotationAngle(MAMADISIMO6_r3, 0.9599F, 0.0F, 0.0F);
			MAMADISIMO6_r3.setTextureOffset(53, 81).addBox(-15.0F, -9.0F, 0.0F, 21.0F, 6.0F, 3.0F, 0.0F, false);
			MAMADISIMO6_r3.setTextureOffset(70, 152).addBox(12.0F, -9.0F, 0.0F, 21.0F, 6.0F, 3.0F, 0.0F, false);
			MAMADISIMO6_r3.setModelRendererName("MAMADISIMO6_r3");
			this.registerModelRenderer(MAMADISIMO6_r3);
			MAMADISIMO5_r4 = new AnimatedModelRenderer(this);
			MAMADISIMO5_r4.setRotationPoint(-12.0F, -163.6534F, -6.0F);
			MINIMAMADISIMO.addChild(MAMADISIMO5_r4);
			setRotationAngle(MAMADISIMO5_r4, 0.9599F, 0.0F, 0.0F);
			MAMADISIMO5_r4.setTextureOffset(103, 40).addBox(-15.0F, -9.0F, 0.0F, 24.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO5_r4.setTextureOffset(111, 23).addBox(15.0F, -9.0F, 0.0F, 24.0F, 9.0F, 3.0F, 0.0F, false);
			MAMADISIMO5_r4.setModelRendererName("MAMADISIMO5_r4");
			this.registerModelRenderer(MAMADISIMO5_r4);
			shoulders = new AnimatedModelRenderer(this);
			shoulders.setRotationPoint(0.0F, 0.3011F, -0.5F);
			all.addChild(shoulders);
			shoulders.setModelRendererName("shoulders");
			this.registerModelRenderer(shoulders);
			shoulderarea2 = new AnimatedModelRenderer(this);
			shoulderarea2.setRotationPoint(-0.05F, -75.25F, 1.45F);
			shoulders.addChild(shoulderarea2);
			shoulderarea2.setTextureOffset(57, 0).addBox(-18.7F, -111.25F, -7.45F, 36.0F, 3.0F, 18.0F, 0.0F, false);
			shoulderarea2.setModelRendererName("shoulderarea2");
			this.registerModelRenderer(shoulderarea2);
			cube_r1 = new AnimatedModelRenderer(this);
			cube_r1.setRotationPoint(26.3F, -105.25F, 1.55F);
			shoulderarea2.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, 0.48F);
			cube_r1.setTextureOffset(117, 40).addBox(-10.5F, -1.5F, -9.0F, 21.0F, 3.0F, 18.0F, 0.0F, false);
			cube_r1.setModelRendererName("cube_r1");
			this.registerModelRenderer(cube_r1);
			cube_r2 = new AnimatedModelRenderer(this);
			cube_r2.setRotationPoint(-27.7F, -105.25F, 1.55F);
			shoulderarea2.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, -0.48F);
			cube_r2.setTextureOffset(122, 111).addBox(-10.5F, -1.5F, -9.0F, 21.0F, 3.0F, 18.0F, 0.0F, false);
			cube_r2.setModelRendererName("cube_r2");
			this.registerModelRenderer(cube_r2);
			cube_r20 = new AnimatedModelRenderer(this);
			cube_r20.setRotationPoint(-2.35F, 1.225F, 4.7F);
			shoulderarea2.addChild(cube_r20);
			setRotationAngle(cube_r20, -2.3126F, 0.0F, 0.0F);
			cube_r20.setModelRendererName("cube_r20");
			this.registerModelRenderer(cube_r20);
			cube_r13_r1 = new AnimatedModelRenderer(this);
			cube_r13_r1.setRotationPoint(3.6F, -280.597F, 113.735F);
			cube_r20.addChild(cube_r13_r1);
			setRotationAngle(cube_r13_r1, 1.7453F, 0.0F, 0.0F);
			cube_r13_r1.setTextureOffset(122, 47).addBox(-18.75F, -249.5206F, -326.4897F, 36.0F, 12.0F, 3.0F, 0.0F, false);
			cube_r13_r1.setModelRendererName("cube_r13_r1");
			this.registerModelRenderer(cube_r13_r1);
			cube_r12_r1 = new AnimatedModelRenderer(this);
			cube_r12_r1.setRotationPoint(1.2F, -307.3075F, 104.5539F);
			cube_r20.addChild(cube_r12_r1);
			setRotationAngle(cube_r12_r1, -0.1745F, 0.0F, 0.0F);
			cube_r12_r1.setTextureOffset(133, 84).addBox(-18.0F, 393.6891F, -122.9028F, 36.0F, 12.0F, 3.0F, 0.0F, false);
			cube_r12_r1.setModelRendererName("cube_r12_r1");
			this.registerModelRenderer(cube_r12_r1);
			cube_r13 = new AnimatedModelRenderer(this);
			cube_r13.setRotationPoint(-8.2134F, 39.7747F, 3.8493F);
			shoulderarea2.addChild(cube_r13);
			cube_r13.setModelRendererName("cube_r13");
			this.registerModelRenderer(cube_r13);
			cube_r20_r1 = new AnimatedModelRenderer(this);
			cube_r20_r1.setRotationPoint(-14.1062F, -143.2409F, -10.2907F);
			cube_r13.addChild(cube_r20_r1);
			setRotationAngle(cube_r20_r1, -0.4363F, 0.2618F, 0.0F);
			cube_r20_r1.setTextureOffset(57, 2).addBox(1.5508F, -6.1685F, -2.623F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r20_r1.setTextureOffset(57, 4).addBox(-0.9132F, -4.4553F, -2.6392F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r20_r1.setModelRendererName("cube_r20_r1");
			this.registerModelRenderer(cube_r20_r1);
			cube_r20_r2 = new AnimatedModelRenderer(this);
			cube_r20_r2.setRotationPoint(-23.8562F, -137.2409F, -10.2907F);
			cube_r13.addChild(cube_r20_r2);
			setRotationAngle(cube_r20_r2, -0.4363F, 0.2618F, 0.0F);
			cube_r20_r2.setTextureOffset(57, 0).addBox(-0.9132F, -4.4553F, -2.6392F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r20_r2.setModelRendererName("cube_r20_r2");
			this.registerModelRenderer(cube_r20_r2);
			cube_r19_r1 = new AnimatedModelRenderer(this);
			cube_r19_r1.setRotationPoint(-14.8562F, -143.2409F, -9.5407F);
			cube_r13.addChild(cube_r19_r1);
			setRotationAngle(cube_r19_r1, -0.4363F, 0.2618F, 0.0F);
			cube_r19_r1.setTextureOffset(47, 60).addBox(-3.5323F, -2.7164F, -2.575F, 9.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r19_r1.setModelRendererName("cube_r19_r1");
			this.registerModelRenderer(cube_r19_r1);
			cube_r18_r1 = new AnimatedModelRenderer(this);
			cube_r18_r1.setRotationPoint(-12.6062F, -143.9909F, -10.2907F);
			cube_r13.addChild(cube_r18_r1);
			setRotationAngle(cube_r18_r1, -0.4363F, 0.2618F, 0.0F);
			cube_r18_r1.setTextureOffset(66, 41).addBox(-3.5323F, -2.7164F, -2.575F, 9.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r18_r1.setModelRendererName("cube_r18_r1");
			this.registerModelRenderer(cube_r18_r1);
			cube_r17_r1 = new AnimatedModelRenderer(this);
			cube_r17_r1.setRotationPoint(-14.1062F, -142.4909F, -10.2907F);
			cube_r13.addChild(cube_r17_r1);
			setRotationAngle(cube_r17_r1, -0.4363F, 0.2618F, 0.0F);
			cube_r17_r1.setTextureOffset(175, 170).addBox(-8.2881F, -0.9984F, -2.7889F, 15.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r17_r1.setModelRendererName("cube_r17_r1");
			this.registerModelRenderer(cube_r17_r1);
			cube_r11 = new AnimatedModelRenderer(this);
			cube_r11.setRotationPoint(8.3134F, 39.7747F, 3.8493F);
			shoulderarea2.addChild(cube_r11);
			cube_r11.setModelRendererName("cube_r11");
			this.registerModelRenderer(cube_r11);
			cube_r21_r1 = new AnimatedModelRenderer(this);
			cube_r21_r1.setRotationPoint(13.3562F, -143.2409F, -9.5407F);
			cube_r11.addChild(cube_r21_r1);
			setRotationAngle(cube_r21_r1, -0.4363F, -0.2618F, 0.0F);
			cube_r21_r1.setTextureOffset(45, 25).addBox(-7.5508F, -6.1685F, -2.623F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r21_r1.setModelRendererName("cube_r21_r1");
			this.registerModelRenderer(cube_r21_r1);
			cube_r21_r2 = new AnimatedModelRenderer(this);
			cube_r21_r2.setRotationPoint(23.8562F, -137.2409F, -10.2907F);
			cube_r11.addChild(cube_r21_r2);
			setRotationAngle(cube_r21_r2, -0.4363F, -0.2618F, 0.0F);
			cube_r21_r2.setTextureOffset(45, 27).addBox(-5.0868F, -4.4553F, -2.6392F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r21_r2.setModelRendererName("cube_r21_r2");
			this.registerModelRenderer(cube_r21_r2);
			cube_r20_r3 = new AnimatedModelRenderer(this);
			cube_r20_r3.setRotationPoint(13.3562F, -143.2409F, -10.2907F);
			cube_r11.addChild(cube_r20_r3);
			setRotationAngle(cube_r20_r3, -0.4363F, -0.2618F, 0.0F);
			cube_r20_r3.setTextureOffset(26, 57).addBox(-5.0868F, -4.4553F, -2.6392F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r20_r3.setModelRendererName("cube_r20_r3");
			this.registerModelRenderer(cube_r20_r3);
			cube_r20_r4 = new AnimatedModelRenderer(this);
			cube_r20_r4.setRotationPoint(14.1062F, -143.2409F, -9.5407F);
			cube_r11.addChild(cube_r20_r4);
			setRotationAngle(cube_r20_r4, -0.4363F, -0.2618F, 0.0F);
			cube_r20_r4.setTextureOffset(35, 49).addBox(-5.4677F, -2.7164F, -2.575F, 9.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r20_r4.setModelRendererName("cube_r20_r4");
			this.registerModelRenderer(cube_r20_r4);
			cube_r19_r2 = new AnimatedModelRenderer(this);
			cube_r19_r2.setRotationPoint(12.6062F, -143.9909F, -10.2907F);
			cube_r11.addChild(cube_r19_r2);
			setRotationAngle(cube_r19_r2, -0.4363F, -0.2618F, 0.0F);
			cube_r19_r2.setTextureOffset(47, 57).addBox(-5.4677F, -2.7164F, -2.575F, 9.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r19_r2.setModelRendererName("cube_r19_r2");
			this.registerModelRenderer(cube_r19_r2);
			cube_r18_r2 = new AnimatedModelRenderer(this);
			cube_r18_r2.setRotationPoint(13.3562F, -142.4909F, -10.2907F);
			cube_r11.addChild(cube_r18_r2);
			setRotationAngle(cube_r18_r2, -0.4363F, -0.2618F, 0.0F);
			cube_r18_r2.setTextureOffset(149, 33).addBox(-6.7119F, -0.9984F, -2.7889F, 15.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r18_r2.setModelRendererName("cube_r18_r2");
			this.registerModelRenderer(cube_r18_r2);
			cube_r12 = new AnimatedModelRenderer(this);
			cube_r12.setRotationPoint(7.5414F, 42.1496F, 2.5522F);
			shoulderarea2.addChild(cube_r12);
			cube_r12.setModelRendererName("cube_r12");
			this.registerModelRenderer(cube_r12);
			cube_r22_r1 = new AnimatedModelRenderer(this);
			cube_r22_r1.setRotationPoint(14.1282F, -145.6158F, 6.9893F);
			cube_r12.addChild(cube_r22_r1);
			setRotationAngle(cube_r22_r1, 0.4363F, 0.2618F, 0.0F);
			cube_r22_r1.setTextureOffset(0, 48).addBox(-4.5508F, -6.1685F, -0.377F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r22_r1.setModelRendererName("cube_r22_r1");
			this.registerModelRenderer(cube_r22_r1);
			cube_r22_r2 = new AnimatedModelRenderer(this);
			cube_r22_r2.setRotationPoint(24.6282F, -139.6158F, 6.9893F);
			cube_r12.addChild(cube_r22_r2);
			setRotationAngle(cube_r22_r2, 0.4363F, 0.2618F, 0.0F);
			cube_r22_r2.setTextureOffset(0, 23).addBox(-5.0868F, -4.4553F, -0.3608F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r22_r2.setModelRendererName("cube_r22_r2");
			this.registerModelRenderer(cube_r22_r2);
			cube_r21_r3 = new AnimatedModelRenderer(this);
			cube_r21_r3.setRotationPoint(11.1282F, -147.1158F, 6.9893F);
			cube_r12.addChild(cube_r21_r3);
			setRotationAngle(cube_r21_r3, 0.4363F, 0.2618F, 0.0F);
			cube_r21_r3.setTextureOffset(0, 25).addBox(-5.0868F, -4.4553F, -0.3608F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r21_r3.setModelRendererName("cube_r21_r3");
			this.registerModelRenderer(cube_r21_r3);
			cube_r21_r4 = new AnimatedModelRenderer(this);
			cube_r21_r4.setRotationPoint(17.8782F, -145.6158F, 6.2393F);
			cube_r12.addChild(cube_r21_r4);
			setRotationAngle(cube_r21_r4, 0.4363F, 0.2618F, 0.0F);
			cube_r21_r4.setTextureOffset(0, 27).addBox(-5.4677F, -2.7164F, -0.425F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r21_r4.setModelRendererName("cube_r21_r4");
			this.registerModelRenderer(cube_r21_r4);
			cube_r20_r5 = new AnimatedModelRenderer(this);
			cube_r20_r5.setRotationPoint(14.1282F, -146.3658F, 6.9893F);
			cube_r12.addChild(cube_r20_r5);
			setRotationAngle(cube_r20_r5, 0.4363F, 0.2618F, 0.0F);
			cube_r20_r5.setTextureOffset(0, 0).addBox(-5.4677F, -2.7164F, -0.425F, 6.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r20_r5.setModelRendererName("cube_r20_r5");
			this.registerModelRenderer(cube_r20_r5);
			cube_r19_r3 = new AnimatedModelRenderer(this);
			cube_r19_r3.setRotationPoint(14.8782F, -144.1158F, 6.9893F);
			cube_r12.addChild(cube_r19_r3);
			setRotationAngle(cube_r19_r3, 0.4363F, 0.2618F, 0.0F);
			cube_r19_r3.setTextureOffset(109, 127).addBox(-6.7119F, -0.9984F, -0.2111F, 15.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r19_r3.setModelRendererName("cube_r19_r3");
			this.registerModelRenderer(cube_r19_r3);
			cube_r14 = new AnimatedModelRenderer(this);
			cube_r14.setRotationPoint(-8.2134F, 39.7747F, -4.4993F);
			shoulderarea2.addChild(cube_r14);
			cube_r14.setModelRendererName("cube_r14");
			this.registerModelRenderer(cube_r14);
			cube_r23_r1 = new AnimatedModelRenderer(this);
			cube_r23_r1.setRotationPoint(-14.1062F, -143.2409F, 14.7907F);
			cube_r14.addChild(cube_r23_r1);
			setRotationAngle(cube_r23_r1, 0.4363F, -0.2618F, 0.0F);
			cube_r23_r1.setTextureOffset(0, 46).addBox(1.5508F, -6.1685F, -0.377F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r23_r1.setTextureOffset(0, 5).addBox(-0.9132F, -4.4553F, -0.3608F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r23_r1.setModelRendererName("cube_r23_r1");
			this.registerModelRenderer(cube_r23_r1);
			cube_r23_r2 = new AnimatedModelRenderer(this);
			cube_r23_r2.setRotationPoint(-23.8562F, -137.2409F, 14.7907F);
			cube_r14.addChild(cube_r23_r2);
			setRotationAngle(cube_r23_r2, 0.4363F, -0.2618F, 0.0F);
			cube_r23_r2.setTextureOffset(0, 3).addBox(-0.9132F, -4.4553F, -0.3608F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r23_r2.setModelRendererName("cube_r23_r2");
			this.registerModelRenderer(cube_r23_r2);
			cube_r22_r3 = new AnimatedModelRenderer(this);
			cube_r22_r3.setRotationPoint(-14.8562F, -143.2409F, 14.0407F);
			cube_r14.addChild(cube_r22_r3);
			setRotationAngle(cube_r22_r3, 0.4363F, -0.2618F, 0.0F);
			cube_r22_r3.setTextureOffset(45, 23).addBox(-3.5323F, -2.7164F, -0.425F, 9.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r22_r3.setModelRendererName("cube_r22_r3");
			this.registerModelRenderer(cube_r22_r3);
			cube_r21_r5 = new AnimatedModelRenderer(this);
			cube_r21_r5.setRotationPoint(-12.6062F, -143.9909F, 14.7907F);
			cube_r14.addChild(cube_r21_r5);
			setRotationAngle(cube_r21_r5, 0.4363F, -0.2618F, 0.0F);
			cube_r21_r5.setTextureOffset(35, 46).addBox(-3.5323F, -2.7164F, -0.425F, 9.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r21_r5.setModelRendererName("cube_r21_r5");
			this.registerModelRenderer(cube_r21_r5);
			cube_r20_r6 = new AnimatedModelRenderer(this);
			cube_r20_r6.setRotationPoint(-14.1062F, -142.4909F, 14.7907F);
			cube_r14.addChild(cube_r20_r6);
			setRotationAngle(cube_r20_r6, 0.4363F, -0.2618F, 0.0F);
			cube_r20_r6.setTextureOffset(47, 119).addBox(-8.2881F, -0.9984F, -0.2111F, 15.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r20_r6.setModelRendererName("cube_r20_r6");
			this.registerModelRenderer(cube_r20_r6);
			arms = new AnimatedModelRenderer(this);
			arms.setRotationPoint(0.0F, 31.0F, 0.0F);
			shoulders.addChild(arms);
			arms.setModelRendererName("arms");
			this.registerModelRenderer(arms);
			cube_r3 = new AnimatedModelRenderer(this);
			cube_r3.setRotationPoint(-50.9602F, -180.5346F, 9.0F);
			arms.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.0F, -1.309F);
			cube_r3.setTextureOffset(64, 7).addBox(-3.0F, -15.0F, -15.0F, 24.0F, 24.0F, 18.0F, 0.0F, false);
			cube_r3.setModelRendererName("cube_r3");
			this.registerModelRenderer(cube_r3);
			cube_r4 = new AnimatedModelRenderer(this);
			cube_r4.setRotationPoint(50.9602F, -180.5346F, 9.0F);
			arms.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, 1.309F);
			cube_r4.setTextureOffset(75, 35).addBox(-21.0F, -15.0F, -15.0F, 24.0F, 24.0F, 18.0F, 0.0F, false);
			cube_r4.setModelRendererName("cube_r4");
			this.registerModelRenderer(cube_r4);
			cube_r5 = new AnimatedModelRenderer(this);
			cube_r5.setRotationPoint(-37.4602F, -200.7846F, 7.5F);
			arms.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, -0.2182F);
			cube_r5.setTextureOffset(0, 46).addBox(-21.0F, -9.0F, -12.0F, 45.0F, 18.0F, 15.0F, 0.0F, false);
			cube_r5.setModelRendererName("cube_r5");
			this.registerModelRenderer(cube_r5);
			cube_r6 = new AnimatedModelRenderer(this);
			cube_r6.setRotationPoint(37.4602F, -200.7846F, 7.5F);
			arms.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.0F, 0.2182F);
			cube_r6.setTextureOffset(40, 46).addBox(-24.0F, -9.0F, -12.0F, 45.0F, 18.0F, 15.0F, 0.0F, false);
			cube_r6.setModelRendererName("cube_r6");
			this.registerModelRenderer(cube_r6);
			larm = new AnimatedModelRenderer(this);
			larm.setRotationPoint(7.0F, -14.25F, 0.0F);
			arms.addChild(larm);
			larm.setModelRendererName("larm");
			this.registerModelRenderer(larm);
			lshoulderarm = new AnimatedModelRenderer(this);
			lshoulderarm.setRotationPoint(50.2823F, -147.2452F, 4.809F);
			larm.addChild(lshoulderarm);
			setRotationAngle(lshoulderarm, 0.0F, 0.0F, -0.0873F);
			lshoulderarm.setTextureOffset(87, 16).addBox(-10.6471F, -18.6224F, -8.5791F, 21.0F, 33.0F, 15.0F, 0.0F, false);
			lshoulderarm.setTextureOffset(0, 155).addBox(-12.1471F, -15.8099F, -7.0791F, 3.0F, 33.0F, 15.0F, 0.0F, false);
			lshoulderarm.setTextureOffset(176, 47).addBox(-7.3027F, -15.0599F, -10.4439F, 15.0F, 21.0F, 3.0F, 0.0F, false);
			lshoulderarm.setTextureOffset(41, 174).addBox(-12.8971F, -17.3099F, -6.3291F, 3.0F, 21.0F, 14.0F, 0.0F, false);
			lshoulderarm.setTextureOffset(173, 155).addBox(9.6961F, -9.7731F, -5.5791F, 3.0F, 21.0F, 12.0F, 0.0F, false);
			lshoulderarm.setTextureOffset(51, 176).addBox(-7.3027F, -13.3724F, 7.5561F, 15.0F, 21.0F, 3.0F, 0.0F, false);
			lshoulderarm.setTextureOffset(160, 101).addBox(-8.8027F, -15.8099F, 6.0561F, 18.0F, 33.0F, 3.0F, 0.0F, false);
			lshoulderarm.setTextureOffset(154, 17).addBox(8.8529F, -15.8099F, -7.0791F, 3.0F, 33.0F, 15.0F, 0.0F, false);
			lshoulderarm.setTextureOffset(136, 62).addBox(-10.6471F, 15.1276F, -7.0791F, 21.0F, 6.0F, 15.0F, 0.0F, false);
			lshoulderarm.setTextureOffset(175, 124).addBox(-7.3027F, -15.0599F, -10.4439F, 15.0F, 21.0F, 3.0F, 0.0F, false);
			lshoulderarm.setModelRendererName("lshoulderarm");
			this.registerModelRenderer(lshoulderarm);
			lforearm = new AnimatedModelRenderer(this);
			lforearm.setRotationPoint(7.8118F, -34.9902F, 0.8324F);
			larm.addChild(lforearm);
			lforearm.setTextureOffset(12, 158).addBox(32.5734F, -89.69F, -3.062F, 3.0F, 30.0F, 15.0F, 0.0F, false);
			lforearm.setTextureOffset(119, 150).addBox(53.5734F, -89.8775F, -3.062F, 3.0F, 33.0F, 15.0F, 0.0F, false);
			lforearm.setTextureOffset(173, 138).addBox(54.3234F, -83.5025F, -1.562F, 3.0F, 21.0F, 12.0F, 0.0F, false);
			lforearm.setTextureOffset(174, 116).addBox(37.4178F, -87.44F, 11.5528F, 15.0F, 21.0F, 3.0F, 0.0F, false);
			lforearm.setTextureOffset(174, 108).addBox(37.4178F, -84.6275F, -5.6972F, 15.0F, 21.0F, 3.0F, 0.0F, false);
			lforearm.setTextureOffset(172, 79).addBox(31.8234F, -85.19F, -1.562F, 3.0F, 21.0F, 12.0F, 0.0F, false);
			lforearm.setTextureOffset(160, 113).addBox(35.9178F, -89.69F, -4.1972F, 18.0F, 30.0F, 3.0F, 0.0F, false);
			lforearm.setTextureOffset(147, 93).addBox(40.0734F, -65.8775F, -3.1025F, 15.0F, 9.0F, 15.0F, 0.0F, false);
			lforearm.setTextureOffset(154, 84).addBox(43.0734F, -56.8775F, -3.1025F, 12.0F, 12.0F, 15.0F, 0.0F, false);
			lforearm.setTextureOffset(135, 118).addBox(34.0734F, -92.1275F, -3.1025F, 21.0F, 6.0F, 15.0F, 0.0F, false);
			lforearm.setTextureOffset(98, 44).addBox(34.0734F, -86.8775F, -3.1025F, 21.0F, 24.0F, 15.0F, 0.0F, false);
			lforearm.setModelRendererName("lforearm");
			this.registerModelRenderer(lforearm);
			lforearm_r1 = new AnimatedModelRenderer(this);
			lforearm_r1.setRotationPoint(43.0734F, -51.6275F, 4.3975F);
			lforearm.addChild(lforearm_r1);
			setRotationAngle(lforearm_r1, 0.0F, 0.0F, -0.4363F);
			lforearm_r1.setTextureOffset(159, 5).addBox(-3.0F, -15.0F, -7.5F, 6.0F, 21.0F, 15.0F, 0.0F, false);
			lforearm_r1.setModelRendererName("lforearm_r1");
			this.registerModelRenderer(lforearm_r1);
			rarm = new AnimatedModelRenderer(this);
			rarm.setRotationPoint(-17.0F, -14.0F, 0.0F);
			arms.addChild(rarm);
			rarm.setModelRendererName("rarm");
			this.registerModelRenderer(rarm);
			rshoulderarm = new AnimatedModelRenderer(this);
			rshoulderarm.setRotationPoint(-4.9382F, -32.4902F, 0.8324F);
			rarm.addChild(rshoulderarm);
			setRotationAngle(rshoulderarm, 0.0F, 0.0F, 0.0873F);
			rshoulderarm.setTextureOffset(63, 150).addBox(-57.2344F, -127.5436F, -3.1025F, 3.0F, 33.0F, 15.0F, 0.0F, false);
			rshoulderarm.setTextureOffset(148, 102).addBox(-36.2344F, -127.5436F, -3.1025F, 3.0F, 33.0F, 15.0F, 0.0F, false);
			rshoulderarm.setTextureOffset(172, 36).addBox(-35.4844F, -129.0436F, -2.3525F, 3.0F, 21.0F, 14.0F, 0.0F, false);
			rshoulderarm.setTextureOffset(30, 175).addBox(-51.64F, -125.2936F, -6.4673F, 12.0F, 24.0F, 3.0F, 0.0F, false);
			rshoulderarm.setTextureOffset(174, 100).addBox(-52.39F, -120.6061F, 11.5327F, 15.0F, 21.0F, 3.0F, 0.0F, false);
			rshoulderarm.setTextureOffset(151, 171).addBox(-58.1431F, -122.2539F, -1.6025F, 3.0F, 21.0F, 12.0F, 0.0F, false);
			rshoulderarm.setTextureOffset(159, 144).addBox(-53.89F, -127.5436F, 10.0327F, 18.0F, 33.0F, 3.0F, 0.0F, false);
			rshoulderarm.setTextureOffset(135, 10).addBox(-55.7344F, -96.6061F, -3.1025F, 21.0F, 6.0F, 15.0F, 0.0F, false);
			rshoulderarm.setTextureOffset(76, 52).addBox(-55.7344F, -130.3561F, -4.6025F, 21.0F, 33.0F, 15.0F, 0.0F, false);
			rshoulderarm.setModelRendererName("rshoulderarm");
			this.registerModelRenderer(rshoulderarm);
			rforearm = new AnimatedModelRenderer(this);
			rforearm.setRotationPoint(-2.5799F, -15.7045F, 1.7513F);
			rarm.addChild(rforearm);
			rforearm.setTextureOffset(75, 156).addBox(-51.2849F, -109.0114F, -3.9809F, 3.0F, 30.0F, 15.0F, 0.0F, false);
			rforearm.setTextureOffset(51, 147).addBox(-30.2849F, -109.1989F, -3.9809F, 3.0F, 33.0F, 15.0F, 0.0F, false);
			rforearm.setTextureOffset(169, 169).addBox(-29.5349F, -102.8239F, -2.4809F, 3.0F, 21.0F, 12.0F, 0.0F, false);
			rforearm.setTextureOffset(174, 68).addBox(-46.4405F, -100.0114F, 10.6339F, 15.0F, 21.0F, 3.0F, 0.0F, false);
			rforearm.setTextureOffset(174, 60).addBox(-46.4405F, -99.4489F, -6.6161F, 15.0F, 21.0F, 3.0F, 0.0F, false);
			rforearm.setTextureOffset(20, 169).addBox(-52.0349F, -104.5114F, -2.4809F, 3.0F, 21.0F, 12.0F, 0.0F, false);
			rforearm.setTextureOffset(160, 62).addBox(-47.9405F, -109.0114F, -5.1161F, 18.0F, 30.0F, 3.0F, 0.0F, false);
			rforearm.setTextureOffset(133, 77).addBox(-49.7849F, -111.4489F, -4.0214F, 21.0F, 6.0F, 15.0F, 0.0F, false);
			rforearm.setTextureOffset(111, 11).addBox(-49.7849F, -106.1989F, -4.0214F, 21.0F, 21.0F, 15.0F, 0.0F, false);
			rforearm.setTextureOffset(145, 161).addBox(68.3503F, -108.6364F, 9.1138F, 18.0F, 27.0F, 3.0F, 0.0F, false);
			rforearm.setTextureOffset(154, 41).addBox(-49.8053F, -76.4131F, -4.0214F, 12.0F, 12.0F, 15.0F, 0.0F, false);
			rforearm.setTextureOffset(125, 23).addBox(-49.8053F, -85.4131F, -4.0214F, 21.0F, 9.0F, 15.0F, 0.0F, false);
			rforearm.setModelRendererName("rforearm");
			this.registerModelRenderer(rforearm);
			lforearm_r2 = new AnimatedModelRenderer(this);
			lforearm_r2.setRotationPoint(-37.8053F, -71.1631F, 3.4786F);
			rforearm.addChild(lforearm_r2);
			setRotationAngle(lforearm_r2, 0.0F, 0.0F, 0.4363F);
			lforearm_r2.setTextureOffset(161, 28).addBox(-3.0F, -6.0F, -7.5F, 6.0F, 12.0F, 15.0F, 0.0F, false);
			lforearm_r2.setModelRendererName("lforearm_r2");
			this.registerModelRenderer(lforearm_r2);
			lforearm_r3 = new AnimatedModelRenderer(this);
			lforearm_r3.setRotationPoint(73.9651F, -78.4131F, 3.4786F);
			rforearm.addChild(lforearm_r3);
			setRotationAngle(lforearm_r3, 0.0F, 0.0F, -1.0036F);
			lforearm_r3.setTextureOffset(13, 75).addBox(-3.0F, -6.0F, -7.5F, 6.0F, 6.0F, 15.0F, 0.0F, true);
			lforearm_r3.setModelRendererName("lforearm_r3");
			this.registerModelRenderer(lforearm_r3);
			lforearm_r4 = new AnimatedModelRenderer(this);
			lforearm_r4.setRotationPoint(-35.5553F, -75.6631F, 3.4786F);
			rforearm.addChild(lforearm_r4);
			setRotationAngle(lforearm_r4, 0.0F, 0.0F, 1.0036F);
			lforearm_r4.setTextureOffset(13, 75).addBox(-3.0F, -6.0F, -7.5F, 6.0F, 6.0F, 15.0F, 0.0F, false);
			lforearm_r4.setModelRendererName("lforearm_r4");
			this.registerModelRenderer(lforearm_r4);
			rightleg = new AnimatedModelRenderer(this);
			rightleg.setRotationPoint(-4.0F, 40.3011F, -0.5F);
			all.addChild(rightleg);
			rightleg.setModelRendererName("rightleg");
			this.registerModelRenderer(rightleg);
			upperrightleg = new AnimatedModelRenderer(this);
			upperrightleg.setRotationPoint(-11.3728F, -124.1613F, 5.8027F);
			rightleg.addChild(upperrightleg);
			setRotationAngle(upperrightleg, 0.0F, 0.0F, 0.0873F);
			upperrightleg.setTextureOffset(0, 135).addBox(-11.992F, 4.9113F, -8.0728F, 3.0F, 45.0F, 15.0F, 0.0F, false);
			upperrightleg.setTextureOffset(74, 132).addBox(9.008F, 4.9113F, -8.0728F, 3.0F, 45.0F, 15.0F, 0.0F, false);
			upperrightleg.setTextureOffset(55, 163).addBox(9.758F, 4.9113F, -7.3228F, 3.0F, 27.0F, 14.0F, 0.0F, false);
			upperrightleg.setTextureOffset(129, 169).addBox(-6.3976F, 7.9113F, -11.4376F, 12.0F, 33.0F, 3.0F, 0.0F, false);
			upperrightleg.setTextureOffset(168, 0).addBox(-7.1476F, 16.1613F, 6.5624F, 15.0F, 27.0F, 3.0F, 0.0F, false);
			upperrightleg.setTextureOffset(45, 161).addBox(-13.0968F, 9.4596F, -6.5728F, 3.0F, 27.0F, 12.0F, 0.0F, false);
			upperrightleg.setTextureOffset(145, 145).addBox(-8.6476F, 4.9113F, 5.0624F, 18.0F, 45.0F, 3.0F, 0.0F, false);
			upperrightleg.setTextureOffset(128, 99).addBox(-10.492F, 46.1613F, -8.0728F, 21.0F, 9.0F, 15.0F, 0.0F, false);
			upperrightleg.setTextureOffset(28, 57).addBox(-10.492F, 1.1613F, -9.5728F, 21.0F, 45.0F, 15.0F, 0.0F, false);
			upperrightleg.setModelRendererName("upperrightleg");
			this.registerModelRenderer(upperrightleg);
			rihgtlowerlegs = new AnimatedModelRenderer(this);
			rihgtlowerlegs.setRotationPoint(-8.9382F, -34.4902F, 0.8324F);
			rightleg.addChild(rihgtlowerlegs);
			rihgtlowerlegs.setTextureOffset(39, 143).addBox(-18.9266F, -20.2598F, -3.062F, 3.0F, 39.0F, 15.0F, 0.0F, false);
			rihgtlowerlegs.setTextureOffset(62, 130).addBox(2.0734F, -22.5098F, -3.062F, 3.0F, 45.0F, 15.0F, 0.0F, false);
			rihgtlowerlegs.setTextureOffset(107, 158).addBox(2.8234F, -12.0098F, -3.062F, 3.0F, 27.0F, 15.0F, 0.0F, false);
			rihgtlowerlegs.setTextureOffset(164, 50).addBox(-14.0822F, -7.5098F, -5.6972F, 15.0F, 27.0F, 3.0F, 0.0F, false);
			rihgtlowerlegs.setTextureOffset(86, 132).addBox(-19.6766F, -14.2598F, -1.562F, 3.0F, 27.0F, 12.0F, 0.0F, false);
			rihgtlowerlegs.setTextureOffset(131, 155).addBox(-15.5822F, -20.2598F, -4.1972F, 18.0F, 39.0F, 3.0F, 0.0F, false);
			rihgtlowerlegs.setTextureOffset(128, 90).addBox(-17.4266F, -25.5098F, -3.1025F, 21.0F, 9.0F, 15.0F, 0.0F, false);
			rihgtlowerlegs.setTextureOffset(116, 0).addBox(-17.4266F, -37.5098F, -6.1025F, 21.0F, 12.0F, 18.0F, 0.0F, false);
			rihgtlowerlegs.setTextureOffset(92, 2).addBox(-17.4266F, -16.5098F, -3.1025F, 21.0F, 27.0F, 15.0F, 0.0F, false);
			rihgtlowerlegs.setTextureOffset(86, 145).addBox(-15.5822F, -21.7598F, 10.0327F, 18.0F, 45.0F, 3.0F, 0.0F, false);
			rihgtlowerlegs.setModelRendererName("rihgtlowerlegs");
			this.registerModelRenderer(rihgtlowerlegs);
			rfoot = new AnimatedModelRenderer(this);
			rfoot.setRotationPoint(2.5666F, 33.9902F, -9.5891F);
			rihgtlowerlegs.addChild(rfoot);
			rfoot.setTextureOffset(104, 104).addBox(-19.9932F, -23.5F, 6.4866F, 21.0F, 24.0F, 15.0F, 0.0F, false);
			rfoot.setTextureOffset(141, 69).addBox(-19.9932F, -8.5F, -9.2634F, 21.0F, 9.0F, 18.0F, 0.0F, false);
			rfoot.setTextureOffset(162, 93).addBox(1.0068F, -5.5F, -14.5134F, 0.0F, 3.0F, 6.0F, 0.0F, false);
			rfoot.setTextureOffset(162, 93).addBox(-19.9932F, -5.5F, -13.0134F, 0.0F, 3.0F, 6.0F, 0.0F, false);
			rfoot.setTextureOffset(159, 156).addBox(-19.9932F, -2.5F, -9.2634F, 21.0F, 3.0F, 6.0F, 0.0F, false);
			rfoot.setTextureOffset(157, 80).addBox(-10.9932F, -2.5F, -15.2634F, 12.0F, 3.0F, 6.0F, 0.0F, false);
			rfoot.setTextureOffset(155, 37).addBox(-19.9932F, -2.5F, -18.2634F, 21.0F, 3.0F, 9.0F, 0.0F, false);
			rfoot.setTextureOffset(155, 37).addBox(-10.9932F, -2.5F, -21.2634F, 12.0F, 3.0F, 6.0F, 0.0F, false);
			rfoot.setModelRendererName("rfoot");
			this.registerModelRenderer(rfoot);
			rfoot_r1 = new AnimatedModelRenderer(this);
			rfoot_r1.setRotationPoint(-20.7432F, -1.0F, -17.5134F);
			rfoot.addChild(rfoot_r1);
			setRotationAngle(rfoot_r1, 0.0F, 0.3491F, 0.0F);
			rfoot_r1.setTextureOffset(155, 37).addBox(1.5F, -1.5F, 0.0F, 9.0F, 3.0F, 3.0F, 0.0F, false);
			rfoot_r1.setModelRendererName("rfoot_r1");
			this.registerModelRenderer(rfoot_r1);
			rfoot_r2 = new AnimatedModelRenderer(this);
			rfoot_r2.setRotationPoint(-9.4932F, -4.0F, -14.5134F);
			rfoot.addChild(rfoot_r2);
			setRotationAngle(rfoot_r2, 0.5672F, 0.0F, 0.0F);
			rfoot_r2.setTextureOffset(145, 57).addBox(-1.5F, -1.5F, -6.0F, 12.0F, 3.0F, 12.0F, 0.0F, false);
			rfoot_r2.setModelRendererName("rfoot_r2");
			this.registerModelRenderer(rfoot_r2);
			rfoot_r3 = new AnimatedModelRenderer(this);
			rfoot_r3.setRotationPoint(-0.4932F, -4.0F, -18.2433F);
			rfoot.addChild(rfoot_r3);
			setRotationAngle(rfoot_r3, 0.5672F, 0.3491F, 0.0F);
			rfoot_r3.setTextureOffset(145, 57).addBox(-16.5F, -1.5F, -6.0201F, 9.0F, 3.0F, 12.0F, 0.0F, false);
			rfoot_r3.setModelRendererName("rfoot_r3");
			this.registerModelRenderer(rfoot_r3);
			rfoot_r4 = new AnimatedModelRenderer(this);
			rfoot_r4.setRotationPoint(-9.4932F, -4.0F, -13.0134F);
			rfoot.addChild(rfoot_r4);
			setRotationAngle(rfoot_r4, 0.5672F, 0.0F, 0.0F);
			rfoot_r4.setTextureOffset(145, 57).addBox(-10.5F, -1.5F, -6.0F, 6.0F, 3.0F, 12.0F, 0.0F, false);
			rfoot_r4.setModelRendererName("rfoot_r4");
			this.registerModelRenderer(rfoot_r4);
			lfoot = new AnimatedModelRenderer(this);
			lfoot.setRotationPoint(23.3098F, 33.9902F, -9.5891F);
			rihgtlowerlegs.addChild(lfoot);
			lfoot.setTextureOffset(104, 104).addBox(-1.0068F, -23.5F, 6.4866F, 21.0F, 24.0F, 15.0F, 0.0F, true);
			lfoot.setTextureOffset(141, 69).addBox(-1.0068F, -8.5F, -9.2634F, 21.0F, 9.0F, 18.0F, 0.0F, true);
			lfoot.setTextureOffset(162, 93).addBox(-1.0068F, -5.5F, -14.5134F, 0.0F, 3.0F, 6.0F, 0.0F, true);
			lfoot.setTextureOffset(162, 93).addBox(19.9932F, -5.5F, -13.0134F, 0.0F, 3.0F, 6.0F, 0.0F, true);
			lfoot.setTextureOffset(159, 156).addBox(-1.0068F, -2.5F, -9.2634F, 21.0F, 3.0F, 6.0F, 0.0F, true);
			lfoot.setTextureOffset(157, 80).addBox(-1.0068F, -2.5F, -15.2634F, 12.0F, 3.0F, 6.0F, 0.0F, true);
			lfoot.setTextureOffset(155, 37).addBox(-1.0068F, -2.5F, -18.2634F, 21.0F, 3.0F, 9.0F, 0.0F, true);
			lfoot.setTextureOffset(155, 37).addBox(-1.0068F, -2.5F, -21.2634F, 12.0F, 3.0F, 6.0F, 0.0F, true);
			lfoot.setModelRendererName("lfoot");
			this.registerModelRenderer(lfoot);
			lfoot_r1 = new AnimatedModelRenderer(this);
			lfoot_r1.setRotationPoint(20.7432F, -1.0F, -17.5134F);
			lfoot.addChild(lfoot_r1);
			setRotationAngle(lfoot_r1, 0.0F, -0.3491F, 0.0F);
			lfoot_r1.setTextureOffset(155, 37).addBox(-10.5F, -1.5F, 0.0F, 9.0F, 3.0F, 3.0F, 0.0F, true);
			lfoot_r1.setModelRendererName("lfoot_r1");
			this.registerModelRenderer(lfoot_r1);
			lfoot_r2 = new AnimatedModelRenderer(this);
			lfoot_r2.setRotationPoint(9.4932F, -4.0F, -14.5134F);
			lfoot.addChild(lfoot_r2);
			setRotationAngle(lfoot_r2, 0.5672F, 0.0F, 0.0F);
			lfoot_r2.setTextureOffset(145, 57).addBox(-10.5F, -1.5F, -6.0F, 12.0F, 3.0F, 12.0F, 0.0F, true);
			lfoot_r2.setModelRendererName("lfoot_r2");
			this.registerModelRenderer(lfoot_r2);
			lfoot_r3 = new AnimatedModelRenderer(this);
			lfoot_r3.setRotationPoint(0.4932F, -4.0F, -18.2433F);
			lfoot.addChild(lfoot_r3);
			setRotationAngle(lfoot_r3, 0.5672F, -0.3491F, 0.0F);
			lfoot_r3.setTextureOffset(145, 57).addBox(7.5F, -1.5F, -6.0201F, 9.0F, 3.0F, 12.0F, 0.0F, true);
			lfoot_r3.setModelRendererName("lfoot_r3");
			this.registerModelRenderer(lfoot_r3);
			lfoot_r4 = new AnimatedModelRenderer(this);
			lfoot_r4.setRotationPoint(9.4932F, -4.0F, -13.0134F);
			lfoot.addChild(lfoot_r4);
			setRotationAngle(lfoot_r4, 0.5672F, 0.0F, 0.0F);
			lfoot_r4.setTextureOffset(145, 57).addBox(4.5F, -1.5F, -6.0F, 6.0F, 3.0F, 12.0F, 0.0F, true);
			lfoot_r4.setModelRendererName("lfoot_r4");
			this.registerModelRenderer(lfoot_r4);
			leftleg = new AnimatedModelRenderer(this);
			leftleg.setRotationPoint(-6.0F, 40.3011F, -0.5F);
			all.addChild(leftleg);
			leftleg.setModelRendererName("leftleg");
			this.registerModelRenderer(leftleg);
			upperleftleg = new AnimatedModelRenderer(this);
			upperleftleg.setRotationPoint(10.924F, -124.1613F, 1.5447F);
			leftleg.addChild(upperleftleg);
			setRotationAngle(upperleftleg, 0.0F, 0.0F, -0.0873F);
			upperleftleg.setTextureOffset(52, 57).addBox(-0.7888F, 1.1613F, -5.3148F, 21.0F, 45.0F, 15.0F, 0.0F, false);
			upperleftleg.setTextureOffset(12, 138).addBox(-2.2888F, 4.9113F, -3.8148F, 3.0F, 45.0F, 15.0F, 0.0F, false);
			upperleftleg.setTextureOffset(99, 172).addBox(2.5556F, 7.9113F, -7.1796F, 15.0F, 27.0F, 3.0F, 0.0F, false);
			upperleftleg.setTextureOffset(167, 129).addBox(-3.0388F, 4.9113F, -3.0648F, 3.0F, 27.0F, 14.0F, 0.0F, false);
			upperleftleg.setTextureOffset(119, 166).addBox(19.4515F, 22.2264F, -2.3148F, 3.0F, 27.0F, 12.0F, 0.0F, false);
			upperleftleg.setTextureOffset(87, 172).addBox(2.5556F, 10.1613F, 10.8204F, 15.0F, 27.0F, 3.0F, 0.0F, false);
			upperleftleg.setTextureOffset(24, 148).addBox(1.0556F, 4.9113F, 9.3204F, 18.0F, 45.0F, 3.0F, 0.0F, false);
			upperleftleg.setTextureOffset(133, 135).addBox(18.7112F, 4.9113F, -3.8148F, 3.0F, 45.0F, 15.0F, 0.0F, false);
			upperleftleg.setTextureOffset(107, 95).addBox(-0.7888F, 46.1613F, -4.8148F, 21.0F, 9.0F, 16.0F, 0.0F, false);
			upperleftleg.setTextureOffset(139, 171).addBox(2.5556F, 7.9113F, -7.1796F, 15.0F, 27.0F, 3.0F, 0.0F, false);
			upperleftleg.setModelRendererName("upperleftleg");
			this.registerModelRenderer(upperleftleg);
			leftlowerlegs = new AnimatedModelRenderer(this);
			leftlowerlegs.setRotationPoint(12.4097F, -21.6364F, 1.4896F);
			leftleg.addChild(leftlowerlegs);
			leftlowerlegs.setTextureOffset(100, 145).addBox(0.7255F, -33.1136F, -3.7192F, 3.0F, 39.0F, 15.0F, 0.0F, false);
			leftlowerlegs.setTextureOffset(112, 135).addBox(21.7255F, -35.3636F, -3.7192F, 3.0F, 45.0F, 15.0F, 0.0F, false);
			leftlowerlegs.setTextureOffset(33, 161).addBox(22.4755F, -24.8636F, -3.7192F, 3.0F, 27.0F, 15.0F, 0.0F, false);
			leftlowerlegs.setTextureOffset(75, 171).addBox(5.5699F, -30.1136F, 10.8956F, 15.0F, 27.0F, 3.0F, 0.0F, false);
			leftlowerlegs.setTextureOffset(75, 171).addBox(-33.4301F, -30.1136F, 10.8956F, 15.0F, 27.0F, 3.0F, 0.0F, false);
			leftlowerlegs.setTextureOffset(0, 171).addBox(5.5699F, -26.3636F, -6.3544F, 15.0F, 27.0F, 3.0F, 0.0F, false);
			leftlowerlegs.setTextureOffset(65, 166).addBox(-0.0245F, -27.1136F, -2.2192F, 3.0F, 27.0F, 12.0F, 0.0F, false);
			leftlowerlegs.setTextureOffset(159, 159).addBox(4.0699F, -33.1136F, -4.8544F, 18.0F, 39.0F, 3.0F, 0.0F, false);
			leftlowerlegs.setTextureOffset(130, 31).addBox(2.2255F, -38.3636F, -3.7597F, 21.0F, 9.0F, 15.0F, 0.0F, false);
			leftlowerlegs.setTextureOffset(96, 117).addBox(2.2255F, -50.3636F, -6.7597F, 21.0F, 12.0F, 18.0F, 0.0F, false);
			leftlowerlegs.setTextureOffset(80, 100).addBox(2.2255F, -29.3636F, -3.7597F, 21.0F, 27.0F, 15.0F, 0.0F, false);
			leftlowerlegs.setModelRendererName("leftlowerlegs");
			this.registerModelRenderer(leftlowerlegs);
			torso = new AnimatedModelRenderer(this);
			torso.setRotationPoint(0.0F, 0.3011F, -0.5F);
			all.addChild(torso);
			torso.setTextureOffset(0, 0).addBox(-37.5F, -177.0F, -6.0F, 75.0F, 49.0F, 21.0F, 0.0F, false);
			torso.setTextureOffset(0, 23).addBox(-28.5F, -128.0F, -6.0F, 57.0F, 48.0F, 21.0F, 0.0F, false);
			torso.setModelRendererName("torso");
			this.registerModelRenderer(torso);
			movy = new AnimatedModelRenderer(this);
			movy.setRotationPoint(-3.0F, -8.5F, -4.75F);
			torso.addChild(movy);
			movy.setTextureOffset(0, 57).addBox(-14.25F, -168.5F, -7.25F, 36.0F, 49.0F, 6.0F, 0.0F, false);
			movy.setTextureOffset(50, 127).addBox(-1.5F, -122.5F, 16.75F, 9.0F, 51.0F, 9.0F, 0.0F, false);
			movy.setTextureOffset(50, 127).addBox(-1.5F, -122.5F, -8.25F, 9.0F, 51.0F, 9.0F, 0.0F, false);
			movy.setModelRendererName("movy");
			this.registerModelRenderer(movy);
			movy_r1 = new AnimatedModelRenderer(this);
			movy_r1.setRotationPoint(29.25F, -143.5F, 0.25F);
			movy.addChild(movy_r1);
			setRotationAngle(movy_r1, 0.0F, -0.2618F, 0.0F);
			movy_r1.setTextureOffset(115, 77).addBox(-10.5F, -25.0F, -4.5F, 21.0F, 49.0F, 6.0F, 0.0F, false);
			movy_r1.setModelRendererName("movy_r1");
			this.registerModelRenderer(movy_r1);
			movy_r2 = new AnimatedModelRenderer(this);
			movy_r2.setRotationPoint(-23.25F, -143.5F, 0.25F);
			movy.addChild(movy_r2);
			setRotationAngle(movy_r2, 0.0F, 0.2618F, 0.0F);
			movy_r2.setTextureOffset(0, 117).addBox(-10.5F, -25.0F, -4.5F, 21.0F, 49.0F, 6.0F, 0.0F, false);
			movy_r2.setModelRendererName("movy_r2");
			this.registerModelRenderer(movy_r2);
			yes_r1 = new AnimatedModelRenderer(this);
			yes_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			movy.addChild(yes_r1);
			setRotationAngle(yes_r1, 0.0F, 0.1309F, -0.1745F);
			yes_r1.setTextureOffset(96, 127).addBox(6.7871F, -121.9878F, -4.9741F, 15.0F, 45.0F, 9.0F, 0.0F, false);
			yes_r1.setTextureOffset(96, 127).addBox(-4.1816F, -123.8976F, -4.6531F, 15.0F, 45.0F, 9.0F, 0.0F, false);
			yes_r1.setModelRendererName("yes_r1");
			this.registerModelRenderer(yes_r1);
			yes_r2 = new AnimatedModelRenderer(this);
			yes_r2.setRotationPoint(4.75F, -0.25F, 0.0F);
			movy.addChild(yes_r2);
			setRotationAngle(yes_r2, 0.0F, -0.1309F, 0.1745F);
			yes_r2.setTextureOffset(34, 119).addBox(-17.6818F, -120.5182F, -3.7865F, 15.0F, 48.0F, 9.0F, 0.0F, false);
			yes_r2.setTextureOffset(34, 119).addBox(-7.9179F, -122.2543F, -5.072F, 15.0F, 48.0F, 9.0F, 0.0F, false);
			yes_r2.setModelRendererName("yes_r2");
			this.registerModelRenderer(yes_r2);
			yes_r3 = new AnimatedModelRenderer(this);
			yes_r3.setRotationPoint(5.75F, -1.25F, 6.25F);
			movy.addChild(yes_r3);
			setRotationAngle(yes_r3, 0.0F, 0.0F, 0.1745F);
			yes_r3.setTextureOffset(40, 77).addBox(4.9109F, -122.5182F, -7.5F, 9.0F, 48.0F, 21.0F, 0.0F, false);
			yes_r3.setModelRendererName("yes_r3");
			this.registerModelRenderer(yes_r3);
			yes_r4 = new AnimatedModelRenderer(this);
			yes_r4.setRotationPoint(10.75F, 0.0F, 1.25F);
			movy.addChild(yes_r4);
			setRotationAngle(yes_r4, 0.0F, -0.2618F, 0.1745F);
			yes_r4.setTextureOffset(40, 100).addBox(-11.5068F, -120.0182F, -1.077F, 21.0F, 48.0F, 9.0F, 0.0F, false);
			yes_r4.setModelRendererName("yes_r4");
			this.registerModelRenderer(yes_r4);
			yes_r5 = new AnimatedModelRenderer(this);
			yes_r5.setRotationPoint(-4.75F, 0.0F, 1.25F);
			movy.addChild(yes_r5);
			setRotationAngle(yes_r5, 0.0F, 0.2618F, -0.1745F);
			yes_r5.setTextureOffset(20, 100).addBox(-9.1578F, -121.9878F, -0.9871F, 21.0F, 48.0F, 9.0F, 0.0F, false);
			yes_r5.setModelRendererName("yes_r5");
			this.registerModelRenderer(yes_r5);
			yes_r6 = new AnimatedModelRenderer(this);
			yes_r6.setRotationPoint(-4.75F, -0.25F, 6.25F);
			movy.addChild(yes_r6);
			setRotationAngle(yes_r6, 0.0F, 0.0F, -0.1745F);
			yes_r6.setTextureOffset(20, 77).addBox(-8.5637F, -122.4878F, -7.5F, 9.0F, 48.0F, 21.0F, 0.0F, false);
			yes_r6.setModelRendererName("yes_r6");
			this.registerModelRenderer(yes_r6);
			yes_r7 = new AnimatedModelRenderer(this);
			yes_r7.setRotationPoint(8.0F, 7.5F, 2.75F);
			movy.addChild(yes_r7);
			setRotationAngle(yes_r7, 0.0F, -0.2618F, 0.0F);
			yes_r7.setTextureOffset(140, 135).addBox(-3.5F, -85.0F, -8.5F, 27.0F, 6.0F, 9.0F, 0.0F, false);
			yes_r7.setModelRendererName("yes_r7");
			this.registerModelRenderer(yes_r7);
			yes_r8 = new AnimatedModelRenderer(this);
			yes_r8.setRotationPoint(-2.0F, 7.5F, 2.75F);
			movy.addChild(yes_r8);
			setRotationAngle(yes_r8, 0.0F, 0.2618F, 0.0F);
			yes_r8.setTextureOffset(140, 52).addBox(-23.5F, -85.0F, -8.5F, 27.0F, 6.0F, 9.0F, 0.0F, false);
			yes_r8.setModelRendererName("yes_r8");
			this.registerModelRenderer(yes_r8);
			movy2 = new AnimatedModelRenderer(this);
			movy2.setRotationPoint(15.0F, -8.5F, 37.25F);
			torso.addChild(movy2);
			setRotationAngle(movy2, 0.0F, 3.1416F, 0.0F);
			movy2.setTextureOffset(52, 23).addBox(-2.25F, -168.5F, 16.75F, 36.0F, 49.0F, 6.0F, 0.0F, false);
			movy2.setTextureOffset(33, 77).addBox(10.5F, -77.3713F, 40.799F, 9.0F, 6.0F, 9.0F, 0.0F, false);
			movy2.setTextureOffset(87, 161).addBox(10.5F, -122.3713F, 40.049F, 9.0F, 24.0F, 9.0F, 0.0F, false);
			movy2.setModelRendererName("movy2");
			this.registerModelRenderer(movy2);
			movy_r3 = new AnimatedModelRenderer(this);
			movy_r3.setRotationPoint(41.25F, -143.5F, 24.25F);
			movy2.addChild(movy_r3);
			setRotationAngle(movy_r3, 0.0F, -0.2618F, 0.0F);
			movy_r3.setTextureOffset(60, 112).addBox(-10.5F, -25.0F, -4.5F, 21.0F, 49.0F, 6.0F, 0.0F, false);
			movy_r3.setModelRendererName("movy_r3");
			this.registerModelRenderer(movy_r3);
			movy_r4 = new AnimatedModelRenderer(this);
			movy_r4.setRotationPoint(-11.25F, -143.5F, 24.25F);
			movy2.addChild(movy_r4);
			setRotationAngle(movy_r4, 0.0F, 0.2618F, 0.0F);
			movy_r4.setTextureOffset(78, 114).addBox(-10.5F, -25.0F, -4.5F, 21.0F, 49.0F, 6.0F, 0.0F, false);
			movy_r4.setModelRendererName("movy_r4");
			this.registerModelRenderer(movy_r4);
			yes_r9 = new AnimatedModelRenderer(this);
			yes_r9.setRotationPoint(0.0F, 0.0F, 0.0F);
			movy2.addChild(yes_r9);
			setRotationAngle(yes_r9, 0.0F, 0.1309F, -0.1745F);
			yes_r9.setTextureOffset(122, 122).addBox(15.1694F, -118.5694F, 18.5496F, 15.0F, 45.0F, 9.0F, 0.0F, false);
			yes_r9.setModelRendererName("yes_r9");
			this.registerModelRenderer(yes_r9);
			yes_r10 = new AnimatedModelRenderer(this);
			yes_r10.setRotationPoint(4.75F, -0.25F, 0.0F);
			movy2.addChild(yes_r10);
			setRotationAngle(yes_r10, 0.0F, -0.1309F, 0.1745F);
			yes_r10.setTextureOffset(18, 119).addBox(-4.7259F, -122.835F, 15.0445F, 15.0F, 48.0F, 9.0F, 0.0F, false);
			yes_r10.setModelRendererName("yes_r10");
			this.registerModelRenderer(yes_r10);
			yes_r11 = new AnimatedModelRenderer(this);
			yes_r11.setRotationPoint(5.75F, -1.25F, 6.25F);
			movy2.addChild(yes_r11);
			setRotationAngle(yes_r11, 0.0F, 0.0F, 0.1745F);
			yes_r11.setTextureOffset(0, 75).addBox(16.5637F, -124.4878F, 16.5F, 9.0F, 48.0F, 21.0F, 0.0F, false);
			yes_r11.setModelRendererName("yes_r11");
			this.registerModelRenderer(yes_r11);
			yes_r12 = new AnimatedModelRenderer(this);
			yes_r12.setRotationPoint(10.75F, 0.0F, 1.25F);
			movy2.addChild(yes_r12);
			setRotationAngle(yes_r12, 0.0F, -0.2618F, 0.1745F);
			yes_r12.setTextureOffset(0, 98).addBox(5.0049F, -123.2031F, 14.4672F, 21.0F, 48.0F, 9.0F, 0.0F, false);
			yes_r12.setModelRendererName("yes_r12");
			this.registerModelRenderer(yes_r12);
			yes_r13 = new AnimatedModelRenderer(this);
			yes_r13.setRotationPoint(-4.75F, 0.0F, 1.25F);
			movy2.addChild(yes_r13);
			setRotationAngle(yes_r13, 0.0F, 0.2618F, -0.1745F);
			yes_r13.setTextureOffset(60, 93).addBox(-4.1256F, -120.2487F, 20.3694F, 21.0F, 48.0F, 9.0F, 0.0F, false);
			yes_r13.setModelRendererName("yes_r13");
			this.registerModelRenderer(yes_r13);
			yes_r14 = new AnimatedModelRenderer(this);
			yes_r14.setRotationPoint(-4.75F, -0.25F, 6.25F);
			movy2.addChild(yes_r14);
			setRotationAngle(yes_r14, 0.0F, 0.0F, -0.1745F);
			yes_r14.setTextureOffset(69, 70).addBox(4.0739F, -120.3445F, 16.5F, 9.0F, 48.0F, 21.0F, 0.0F, false);
			yes_r14.setModelRendererName("yes_r14");
			this.registerModelRenderer(yes_r14);
			yes_r15 = new AnimatedModelRenderer(this);
			yes_r15.setRotationPoint(8.0F, 7.5F, 2.75F);
			movy2.addChild(yes_r15);
			setRotationAngle(yes_r15, 0.0F, -0.2618F, 0.0F);
			yes_r15.setTextureOffset(136, 0).addBox(6.9471F, -85.0F, 9.7044F, 27.0F, 6.0F, 9.0F, 0.0F, false);
			yes_r15.setModelRendererName("yes_r15");
			this.registerModelRenderer(yes_r15);
			yes_r16 = new AnimatedModelRenderer(this);
			yes_r16.setRotationPoint(-2.0F, 7.5F, 2.75F);
			movy2.addChild(yes_r16);
			setRotationAngle(yes_r16, 0.0F, 0.2618F, 0.0F);
			yes_r16.setTextureOffset(135, 17).addBox(-11.5F, -85.0F, 15.5F, 27.0F, 6.0F, 9.0F, 0.0F, false);
			yes_r16.setModelRendererName("yes_r16");
			this.registerModelRenderer(yes_r16);
			yesr_17 = new AnimatedModelRenderer(this);
			yesr_17.setRotationPoint(23.0F, -69.5F, 28.75F);
			movy2.addChild(yesr_17);
			yesr_17.setTextureOffset(18, 119).addBox(-14.9759F, -51.585F, -13.7055F, 15.0F, 48.0F, 9.0F, 0.0F, false);
			yesr_17.setModelRendererName("yesr_17");
			this.registerModelRenderer(yesr_17);
			this.rootBones.add(all);
		}

		@Override
		public ResourceLocation getAnimationFileLocation() {
			return new ResourceLocation("my_titan", "animations/myanim.json");
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
