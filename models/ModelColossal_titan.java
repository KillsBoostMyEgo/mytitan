// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelColossal_titan extends EntityModel<Entity> {
	private final ModelRenderer all;
	private final ModelRenderer bodyc;
	private final ModelRenderer frontc;
	private final ModelRenderer movy_r1;
	private final ModelRenderer movy_r2;
	private final ModelRenderer yes_r1;
	private final ModelRenderer yes_r2;
	private final ModelRenderer yes_r3;
	private final ModelRenderer yes_r4;
	private final ModelRenderer yes_r5;
	private final ModelRenderer yes_r6;
	private final ModelRenderer yes_r7;
	private final ModelRenderer yes_r8_r1;
	private final ModelRenderer yes_r8;
	private final ModelRenderer yes_r9_r1;
	private final ModelRenderer extensions2;
	private final ModelRenderer movy_r7;
	private final ModelRenderer movy_r8;
	private final ModelRenderer extensions3;
	private final ModelRenderer movy_r9;
	private final ModelRenderer movy_r10;
	private final ModelRenderer backc;
	private final ModelRenderer movy_r3;
	private final ModelRenderer movy_r4;
	private final ModelRenderer yes_r9;
	private final ModelRenderer yes_r10;
	private final ModelRenderer yes_r11;
	private final ModelRenderer yes_r12;
	private final ModelRenderer yes_r13;
	private final ModelRenderer yes_r14;
	private final ModelRenderer yes_r15;
	private final ModelRenderer yes_r16;
	private final ModelRenderer extensions;
	private final ModelRenderer movy_r5;
	private final ModelRenderer movy_r6;
	private final ModelRenderer shouldersc;
	private final ModelRenderer shoulderarea;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r19;
	private final ModelRenderer arms;
	private final ModelRenderer hands;
	private final ModelRenderer lforearm_r1;
	private final ModelRenderer lforearm_r2;
	private final ModelRenderer lforearm_r3;
	private final ModelRenderer lforearm_r4;
	private final ModelRenderer larm;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer upperleftleg3;
	private final ModelRenderer rihgtlowerlegs3;
	private final ModelRenderer rarm;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer upperrightleg;
	private final ModelRenderer rihgtlowerlegs2;
	private final ModelRenderer leftlegc;
	private final ModelRenderer upperleftlegc;
	private final ModelRenderer leftlowerlegsc;
	private final ModelRenderer lfoot;
	private final ModelRenderer lfoot_r1;
	private final ModelRenderer lfoot_r2;
	private final ModelRenderer lfoot_r3;
	private final ModelRenderer lfoot_r4;
	private final ModelRenderer rightlegc;
	private final ModelRenderer upperrightlegc;
	private final ModelRenderer rihgtlowerlegsc;
	private final ModelRenderer rfoot;
	private final ModelRenderer rfoot_r1;
	private final ModelRenderer rfoot_r2;
	private final ModelRenderer rfoot_r3;
	private final ModelRenderer rfoot_r4;
	private final ModelRenderer neck_head;
	private final ModelRenderer neck;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer headarea;
	private final ModelRenderer head3;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer head2;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer cube_r40;
	private final ModelRenderer cube_r41;
	private final ModelRenderer cube_r42;
	private final ModelRenderer cube_r43;
	private final ModelRenderer head;
	private final ModelRenderer cube_r44;
	private final ModelRenderer cube_r45;
	private final ModelRenderer cube_r46;
	private final ModelRenderer cube_r47;
	private final ModelRenderer cube_r48;
	private final ModelRenderer cube_r49;
	private final ModelRenderer cube_r50;
	private final ModelRenderer cube_r51;
	private final ModelRenderer cube_r52;
	private final ModelRenderer cube_r53;
	private final ModelRenderer cube_r54;
	private final ModelRenderer cube_r55;

	public ModelColossal_titan() {
		textureWidth = 4896;
		textureHeight = 4896;

		all = new ModelRenderer(this);
		all.setRotationPoint(0.0F, 24.0F, 0.0F);

		bodyc = new ModelRenderer(this);
		bodyc.setRotationPoint(0.0F, -480.0F, 0.0F);
		all.addChild(bodyc);
		bodyc.setTextureOffset(0, 0).addBox(-150.0F, -486.0F, -24.0F, 300.0F, 294.0F, 84.0F, 0.0F, false);
		bodyc.setTextureOffset(768, 0).addBox(-114.0F, -192.0F, -24.0F, 228.0F, 192.0F, 84.0F, 0.0F, false);

		frontc = new ModelRenderer(this);
		frontc.setRotationPoint(-36.0F, -102.0F, -57.0F);
		bodyc.addChild(frontc);
		frontc.setTextureOffset(720, 378).addBox(-33.0F, -285.0F, 9.0F, 144.0F, 195.0F, 36.0F, 0.0F, false);
		frontc.setTextureOffset(360, 378).addBox(-33.0F, -285.0F, 9.0F, 144.0F, 195.0F, 36.0F, 0.0F, false);
		frontc.setTextureOffset(720, 2737).addBox(18.0F, -102.0F, 105.0F, 36.0F, 204.0F, 36.0F, 0.0F, false);
		frontc.setTextureOffset(576, 2737).addBox(18.0F, -102.0F, 105.0F, 36.0F, 204.0F, 36.0F, 0.0F, false);

		movy_r1 = new ModelRenderer(this);
		movy_r1.setRotationPoint(141.0F, -186.0F, 39.0F);
		frontc.addChild(movy_r1);
		setRotationAngle(movy_r1, 0.0F, -0.2618F, 0.0F);
		movy_r1.setTextureOffset(1440, 1490).addBox(-56.4889F, -99.0F, -14.1177F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		movy_r1.setTextureOffset(1200, 1490).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);

		movy_r2 = new ModelRenderer(this);
		movy_r2.setRotationPoint(-69.0F, -186.0F, 39.0F);
		frontc.addChild(movy_r2);
		setRotationAngle(movy_r2, 0.0F, 0.2618F, 0.0F);
		movy_r2.setTextureOffset(960, 1490).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		movy_r2.setTextureOffset(720, 1490).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);

		yes_r1 = new ModelRenderer(this);
		yes_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		frontc.addChild(yes_r1);
		setRotationAngle(yes_r1, 0.0F, 0.1309F, -0.1745F);
		yes_r1.setTextureOffset(1152, 2269).addBox(-18.0F, -96.0F, 9.0F, 60.0F, 180.0F, 36.0F, 0.0F, false);
		yes_r1.setTextureOffset(960, 2269).addBox(-18.0F, -96.0F, 9.0F, 60.0F, 180.0F, 36.0F, 0.0F, false);

		yes_r2 = new ModelRenderer(this);
		yes_r2.setRotationPoint(57.0F, -3.0F, 0.0F);
		frontc.addChild(yes_r2);
		setRotationAngle(yes_r2, 0.0F, -0.1309F, 0.1745F);
		yes_r2.setTextureOffset(384, 2269).addBox(-18.0F, -96.0F, 6.0F, 60.0F, 192.0F, 36.0F, 0.0F, false);
		yes_r2.setTextureOffset(192, 2269).addBox(-18.0F, -96.0F, 6.0F, 60.0F, 192.0F, 36.0F, 0.0F, false);

		yes_r3 = new ModelRenderer(this);
		yes_r3.setRotationPoint(69.0F, -15.0F, 75.0F);
		frontc.addChild(yes_r3);
		setRotationAngle(yes_r3, 0.0F, 0.0F, 0.1745F);
		yes_r3.setTextureOffset(1200, 655).addBox(66.0F, -96.0F, -42.0F, 36.0F, 192.0F, 84.0F, 0.0F, false);
		yes_r3.setTextureOffset(960, 655).addBox(66.0F, -96.0F, -42.0F, 36.0F, 192.0F, 84.0F, 0.0F, false);

		yes_r4 = new ModelRenderer(this);
		yes_r4.setRotationPoint(129.0F, 0.0F, 15.0F);
		frontc.addChild(yes_r4);
		setRotationAngle(yes_r4, 0.0F, -0.2618F, 0.1745F);
		yes_r4.setTextureOffset(0, 1949).addBox(-42.0F, -96.0F, 6.0F, 84.0F, 192.0F, 36.0F, 0.0F, false);
		yes_r4.setTextureOffset(1824, 1721).addBox(-42.0F, -96.0F, 6.0F, 84.0F, 192.0F, 36.0F, 0.0F, false);

		yes_r5 = new ModelRenderer(this);
		yes_r5.setRotationPoint(-57.0F, 0.0F, 15.0F);
		frontc.addChild(yes_r5);
		setRotationAngle(yes_r5, 0.0F, 0.2618F, -0.1745F);
		yes_r5.setTextureOffset(1584, 1721).addBox(-42.0F, -96.0F, 6.0F, 84.0F, 192.0F, 36.0F, 0.0F, false);
		yes_r5.setTextureOffset(1344, 1721).addBox(-42.0F, -96.0F, 6.0F, 84.0F, 192.0F, 36.0F, 0.0F, false);

		yes_r6 = new ModelRenderer(this);
		yes_r6.setRotationPoint(-57.0F, -3.0F, 75.0F);
		frontc.addChild(yes_r6);
		setRotationAngle(yes_r6, 0.0F, 0.0F, -0.1745F);
		yes_r6.setTextureOffset(720, 655).addBox(-42.0F, -96.0F, -42.0F, 36.0F, 192.0F, 84.0F, 0.0F, false);
		yes_r6.setTextureOffset(480, 655).addBox(-42.0F, -96.0F, -42.0F, 36.0F, 192.0F, 84.0F, 0.0F, false);

		yes_r7 = new ModelRenderer(this);
		yes_r7.setRotationPoint(105.0F, 79.0F, 4.0F);
		frontc.addChild(yes_r7);
		setRotationAngle(yes_r7, 0.0F, -0.1745F, 0.0F);

		yes_r8_r1 = new ModelRenderer(this);
		yes_r8_r1.setRotationPoint(-60.0F, 492.0F, 24.0F);
		yes_r7.addChild(yes_r8_r1);
		setRotationAngle(yes_r8_r1, 0.1745F, 0.0F, 0.0F);
		yes_r8_r1.setTextureOffset(1096, 4153).addBox(6.0001F, -484.2592F, 70.1044F, 108.0F, 24.0F, 18.0F, 0.0F, false);
		yes_r8_r1.setTextureOffset(1096, 4111).addBox(6.0001F, -484.2592F, 70.1044F, 108.0F, 24.0F, 18.0F, 0.0F, false);

		yes_r8 = new ModelRenderer(this);
		yes_r8.setRotationPoint(-24.0F, 90.0F, 33.0F);
		frontc.addChild(yes_r8);
		setRotationAngle(yes_r8, 0.0F, 0.2618F, 0.0F);

		yes_r9_r1 = new ModelRenderer(this);
		yes_r9_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		yes_r8.addChild(yes_r9_r1);
		setRotationAngle(yes_r9_r1, 0.1745F, 0.0F, 0.0F);
		yes_r9_r1.setTextureOffset(1096, 4069).addBox(-54.2743F, -11.3605F, -14.2245F, 108.0F, 24.0F, 18.0F, 0.0F,
				false);
		yes_r9_r1.setTextureOffset(1096, 4027).addBox(-54.2743F, -11.3605F, -14.2245F, 108.0F, 24.0F, 18.0F, 0.0F,
				false);

		extensions2 = new ModelRenderer(this);
		extensions2.setRotationPoint(0.0F, 0.0F, 0.0F);
		frontc.addChild(extensions2);
		extensions2.setTextureOffset(480, 1490).addBox(-111.0F, -285.0F, 21.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		extensions2.setTextureOffset(240, 1490).addBox(-111.0F, -285.0F, 21.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		extensions2.setTextureOffset(0, 1490).addBox(99.0F, -285.0F, 21.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		extensions2.setTextureOffset(1680, 1259).addBox(99.0F, -285.0F, 21.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		extensions2.setTextureOffset(432, 2737).addBox(18.0F, -102.0F, 105.0F, 36.0F, 204.0F, 36.0F, 0.0F, false);
		extensions2.setTextureOffset(288, 2737).addBox(18.0F, -102.0F, 105.0F, 36.0F, 204.0F, 36.0F, 0.0F, false);
		extensions2.setTextureOffset(0, 378).addBox(-33.0F, -285.0F, 9.0F, 144.0F, 195.0F, 36.0F, 0.0F, false);
		extensions2.setTextureOffset(2112, 0).addBox(-33.0F, -285.0F, 9.0F, 144.0F, 195.0F, 36.0F, 0.0F, false);

		movy_r7 = new ModelRenderer(this);
		movy_r7.setRotationPoint(141.0F, -186.0F, 39.0F);
		extensions2.addChild(movy_r7);
		setRotationAngle(movy_r7, 0.0F, -0.2618F, 0.0F);
		movy_r7.setTextureOffset(1440, 1259).addBox(-56.4889F, -99.0F, -14.1177F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		movy_r7.setTextureOffset(1200, 1259).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);

		movy_r8 = new ModelRenderer(this);
		movy_r8.setRotationPoint(-69.0F, -186.0F, 39.0F);
		extensions2.addChild(movy_r8);
		setRotationAngle(movy_r8, 0.0F, 0.2618F, 0.0F);
		movy_r8.setTextureOffset(960, 1259).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		movy_r8.setTextureOffset(720, 1259).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);

		extensions3 = new ModelRenderer(this);
		extensions3.setRotationPoint(0.0F, -195.0F, 0.0F);
		frontc.addChild(extensions3);
		extensions3.setTextureOffset(720, 3113).addBox(-111.0F, -190.0F, 21.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);
		extensions3.setTextureOffset(480, 3113).addBox(-111.0F, -190.0F, 21.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);
		extensions3.setTextureOffset(240, 3113).addBox(99.0F, -190.0F, 21.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);
		extensions3.setTextureOffset(0, 3113).addBox(99.0F, -190.0F, 21.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);
		extensions3.setTextureOffset(360, 931).addBox(18.0F, -190.0F, 105.0F, 36.0F, 292.0F, 36.0F, 0.0F, false);
		extensions3.setTextureOffset(0, 4202).addBox(18.0F, 2.0F, 105.0F, 36.0F, 100.0F, 36.0F, 0.0F, false);
		extensions3.setTextureOffset(0, 1067).addBox(-33.0F, -190.0F, 9.0F, 144.0F, 100.0F, 36.0F, 0.0F, false);
		extensions3.setTextureOffset(0, 931).addBox(-33.0F, -190.0F, 9.0F, 144.0F, 100.0F, 36.0F, 0.0F, false);

		movy_r9 = new ModelRenderer(this);
		movy_r9.setRotationPoint(141.0F, -186.0F, 39.0F);
		extensions3.addChild(movy_r9);
		setRotationAngle(movy_r9, 0.0F, -0.2618F, 0.0F);
		movy_r9.setTextureOffset(2160, 2977).addBox(-56.4889F, -4.0F, -14.1177F, 84.0F, 100.0F, 36.0F, 0.0F, false);
		movy_r9.setTextureOffset(1920, 2977).addBox(-42.0F, -4.0F, -18.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);

		movy_r10 = new ModelRenderer(this);
		movy_r10.setRotationPoint(-69.0F, -186.0F, 39.0F);
		extensions3.addChild(movy_r10);
		setRotationAngle(movy_r10, 0.0F, 0.2618F, 0.0F);
		movy_r10.setTextureOffset(1680, 2977).addBox(-42.0F, -4.0F, -18.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);
		movy_r10.setTextureOffset(1440, 2977).addBox(-42.0F, -4.0F, -18.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);

		backc = new ModelRenderer(this);
		backc.setRotationPoint(36.0F, -102.0F, 87.0F);
		bodyc.addChild(backc);
		setRotationAngle(backc, 0.0F, 3.1416F, 0.0F);
		backc.setTextureOffset(1752, 0).addBox(-33.0F, -285.0F, 9.0F, 144.0F, 195.0F, 36.0F, 0.0F, false);
		backc.setTextureOffset(1392, 0).addBox(-33.0F, -285.0F, 9.0F, 144.0F, 195.0F, 36.0F, 0.0F, false);
		backc.setTextureOffset(240, 1949).addBox(12.0F, -386.0F, 105.0F, 36.0F, 284.0F, 36.0F, 0.0F, false);
		backc.setTextureOffset(144, 2737).addBox(12.0F, -102.0F, 105.0F, 36.0F, 204.0F, 36.0F, 0.0F, false);

		movy_r3 = new ModelRenderer(this);
		movy_r3.setRotationPoint(141.0F, -186.0F, 39.0F);
		backc.addChild(movy_r3);
		setRotationAngle(movy_r3, 0.0F, -0.2618F, 0.0F);
		movy_r3.setTextureOffset(480, 1259).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		movy_r3.setTextureOffset(240, 1259).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		movy_r3.setTextureOffset(0, 1259).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		movy_r3.setTextureOffset(1464, 931).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);

		movy_r4 = new ModelRenderer(this);
		movy_r4.setRotationPoint(-69.0F, -186.0F, 39.0F);
		backc.addChild(movy_r4);
		setRotationAngle(movy_r4, 0.0F, 0.2618F, 0.0F);
		movy_r4.setTextureOffset(1224, 931).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		movy_r4.setTextureOffset(984, 931).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		movy_r4.setTextureOffset(744, 931).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);
		movy_r4.setTextureOffset(504, 931).addBox(-42.0F, -99.0F, -18.0F, 84.0F, 195.0F, 36.0F, 0.0F, false);

		yes_r9 = new ModelRenderer(this);
		yes_r9.setRotationPoint(0.0F, 0.0F, 0.0F);
		backc.addChild(yes_r9);
		setRotationAngle(yes_r9, 0.0F, 0.1309F, -0.1745F);
		yes_r9.setTextureOffset(768, 2269).addBox(-18.0F, -96.0F, 9.0F, 60.0F, 180.0F, 36.0F, 0.0F, false);
		yes_r9.setTextureOffset(576, 2269).addBox(-18.0F, -96.0F, 9.0F, 60.0F, 180.0F, 36.0F, 0.0F, false);

		yes_r10 = new ModelRenderer(this);
		yes_r10.setRotationPoint(57.0F, -3.0F, 0.0F);
		backc.addChild(yes_r10);
		setRotationAngle(yes_r10, 0.0F, -0.1309F, 0.1745F);
		yes_r10.setTextureOffset(0, 2269).addBox(-18.0F, -96.0F, 6.0F, 60.0F, 192.0F, 36.0F, 0.0F, false);
		yes_r10.setTextureOffset(1704, 1949).addBox(-18.0F, -96.0F, 6.0F, 60.0F, 192.0F, 36.0F, 0.0F, false);

		yes_r11 = new ModelRenderer(this);
		yes_r11.setRotationPoint(69.0F, -15.0F, 75.0F);
		backc.addChild(yes_r11);
		setRotationAngle(yes_r11, 0.0F, 0.0F, 0.1745F);
		yes_r11.setTextureOffset(240, 655).addBox(66.0F, -96.0F, -42.0F, 36.0F, 192.0F, 84.0F, 0.0F, false);
		yes_r11.setTextureOffset(0, 655).addBox(66.0F, -96.0F, -42.0F, 36.0F, 192.0F, 84.0F, 0.0F, false);

		yes_r12 = new ModelRenderer(this);
		yes_r12.setRotationPoint(129.0F, 0.0F, 15.0F);
		backc.addChild(yes_r12);
		setRotationAngle(yes_r12, 0.0F, -0.2618F, 0.1745F);
		yes_r12.setTextureOffset(1104, 1721).addBox(-42.0F, -96.0F, 6.0F, 84.0F, 192.0F, 36.0F, 0.0F, false);
		yes_r12.setTextureOffset(864, 1721).addBox(-42.0F, -96.0F, 6.0F, 84.0F, 192.0F, 36.0F, 0.0F, false);

		yes_r13 = new ModelRenderer(this);
		yes_r13.setRotationPoint(-57.0F, 0.0F, 15.0F);
		backc.addChild(yes_r13);
		setRotationAngle(yes_r13, 0.0F, 0.2618F, -0.1745F);
		yes_r13.setTextureOffset(624, 1721).addBox(-42.0F, -96.0F, 6.0F, 84.0F, 192.0F, 36.0F, 0.0F, false);
		yes_r13.setTextureOffset(384, 1721).addBox(-42.0F, -96.0F, 6.0F, 84.0F, 192.0F, 36.0F, 0.0F, false);

		yes_r14 = new ModelRenderer(this);
		yes_r14.setRotationPoint(-57.0F, -3.0F, 75.0F);
		backc.addChild(yes_r14);
		setRotationAngle(yes_r14, 0.0F, 0.0F, -0.1745F);
		yes_r14.setTextureOffset(1896, 378).addBox(-42.0F, -96.0F, -42.0F, 36.0F, 192.0F, 84.0F, 0.0F, false);
		yes_r14.setTextureOffset(1656, 378).addBox(-42.0F, -96.0F, -42.0F, 36.0F, 192.0F, 84.0F, 0.0F, false);

		yes_r15 = new ModelRenderer(this);
		yes_r15.setRotationPoint(96.0F, 90.0F, 33.0F);
		backc.addChild(yes_r15);
		setRotationAngle(yes_r15, 0.0F, -0.2618F, 0.0F);
		yes_r15.setTextureOffset(0, 3599).addBox(-54.0F, -12.0F, -18.0F, 108.0F, 24.0F, 36.0F, 0.0F, false);
		yes_r15.setTextureOffset(1272, 3494).addBox(-54.0F, -12.0F, -18.0F, 108.0F, 24.0F, 36.0F, 0.0F, false);

		yes_r16 = new ModelRenderer(this);
		yes_r16.setRotationPoint(-24.0F, 90.0F, 33.0F);
		backc.addChild(yes_r16);
		setRotationAngle(yes_r16, 0.0F, 0.2618F, 0.0F);
		yes_r16.setTextureOffset(1272, 3434).addBox(-54.0F, -12.0F, -18.0F, 108.0F, 24.0F, 36.0F, 0.0F, false);
		yes_r16.setTextureOffset(1272, 3374).addBox(-54.0F, -12.0F, -18.0F, 108.0F, 24.0F, 36.0F, 0.0F, false);

		extensions = new ModelRenderer(this);
		extensions.setRotationPoint(0.0F, -194.0F, 0.0F);
		backc.addChild(extensions);
		extensions.setTextureOffset(1440, 791).addBox(-33.0F, -190.0F, 9.0F, 144.0F, 100.0F, 36.0F, 0.0F, false);
		extensions.setTextureOffset(1440, 655).addBox(-33.0F, -190.0F, 9.0F, 144.0F, 100.0F, 36.0F, 0.0F, false);

		movy_r5 = new ModelRenderer(this);
		movy_r5.setRotationPoint(-69.0F, -186.0F, 39.0F);
		extensions.addChild(movy_r5);
		setRotationAngle(movy_r5, 0.0F, 0.2618F, 0.0F);
		movy_r5.setTextureOffset(1200, 2977).addBox(-42.0F, -4.0F, -18.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);
		movy_r5.setTextureOffset(960, 2977).addBox(-42.0F, -4.0F, -18.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);
		movy_r5.setTextureOffset(720, 2977).addBox(-42.0F, -4.0F, -18.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);
		movy_r5.setTextureOffset(480, 2977).addBox(-42.0F, -4.0F, -18.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);

		movy_r6 = new ModelRenderer(this);
		movy_r6.setRotationPoint(141.0F, -186.0F, 39.0F);
		extensions.addChild(movy_r6);
		setRotationAngle(movy_r6, 0.0F, -0.2618F, 0.0F);
		movy_r6.setTextureOffset(240, 2977).addBox(-42.0F, -4.0F, -18.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);
		movy_r6.setTextureOffset(0, 2977).addBox(-42.0F, -4.0F, -18.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);
		movy_r6.setTextureOffset(1536, 2737).addBox(-42.0F, -4.0F, -18.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);
		movy_r6.setTextureOffset(1296, 2737).addBox(-42.0F, -4.0F, -18.0F, 84.0F, 100.0F, 36.0F, 0.0F, false);

		shouldersc = new ModelRenderer(this);
		shouldersc.setRotationPoint(0.0F, 490.0F, 0.0F);
		bodyc.addChild(shouldersc);

		shoulderarea = new ModelRenderer(this);
		shoulderarea.setRotationPoint(-0.5F, -1007.5F, 17.0F);
		shouldersc.addChild(shoulderarea);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-23.5F, 12.25F, 47.0F);
		shoulderarea.addChild(cube_r14);
		setRotationAngle(cube_r14, -2.3126F, 0.0F, 0.0F);
		cube_r14.setTextureOffset(150, 4579).addBox(-12.0F, -21.0F, 0.0F, 72.0F, 42.0F, 12.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-23.5F, 12.25F, -50.0F);
		shoulderarea.addChild(cube_r11);
		setRotationAngle(cube_r11, -0.829F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(150, 4525).addBox(-12.0F, -21.0F, 0.0F, 72.0F, 42.0F, 12.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(48.5F, 39.5F, 36.25F);
		shoulderarea.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.7854F, 0.0F, 0.2618F);
		cube_r15.setTextureOffset(318, 4609).addBox(-24.0411F, -25.9541F, 14.1186F, 81.0F, 16.0F, 12.0F, 0.0F, false);
		cube_r15.setTextureOffset(0, 4684).addBox(-19.8939F, -10.2272F, 13.4053F, 66.0F, 6.0F, 12.0F, 0.0F, false);
		cube_r15.setTextureOffset(124, 4792).addBox(-18.6242F, -4.431F, 13.6195F, 50.0F, 6.0F, 12.0F, 0.0F, false);
		cube_r15.setTextureOffset(398, 4774).addBox(-16.8376F, 1.2798F, 13.5655F, 33.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-47.5F, 39.5F, -35.25F);
		shoulderarea.addChild(cube_r17);
		setRotationAngle(cube_r17, -0.7854F, 0.0F, -0.2618F);
		cube_r17.setTextureOffset(318, 4581).addBox(-56.9589F, -25.9541F, -26.1186F, 81.0F, 16.0F, 12.0F, 0.0F, false);
		cube_r17.setTextureOffset(0, 4666).addBox(-46.1061F, -10.2272F, -25.4053F, 66.0F, 6.0F, 12.0F, 0.0F, false);
		cube_r17.setTextureOffset(124, 4774).addBox(-31.3758F, -4.431F, -25.6195F, 50.0F, 6.0F, 12.0F, 0.0F, false);
		cube_r17.setTextureOffset(398, 4756).addBox(-16.1624F, 1.2798F, -25.5655F, 33.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-47.5F, 39.5F, 36.25F);
		shoulderarea.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.7854F, 0.0F, -0.2618F);
		cube_r16.setTextureOffset(318, 4553).addBox(-56.9589F, -25.9541F, 14.1186F, 81.0F, 16.0F, 12.0F, 0.0F, false);
		cube_r16.setTextureOffset(0, 4648).addBox(-46.1061F, -10.2272F, 13.4053F, 66.0F, 6.0F, 12.0F, 0.0F, false);
		cube_r16.setTextureOffset(124, 4756).addBox(-31.3758F, -4.431F, 13.6195F, 50.0F, 6.0F, 12.0F, 0.0F, false);
		cube_r16.setTextureOffset(308, 4834).addBox(-16.1624F, 1.2798F, 13.5655F, 33.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(48.5F, 39.5F, -35.25F);
		shoulderarea.addChild(cube_r18);
		setRotationAngle(cube_r18, -0.7854F, 0.0F, 0.2618F);
		cube_r18.setTextureOffset(318, 4525).addBox(-24.0411F, -25.9541F, -26.1186F, 81.0F, 16.0F, 12.0F, 0.0F, false);
		cube_r18.setTextureOffset(1262, 4600).addBox(-19.8939F, -10.2272F, -25.4053F, 66.0F, 6.0F, 12.0F, 0.0F, false);
		cube_r18.setTextureOffset(0, 4828).addBox(-18.6242F, -4.431F, -25.6195F, 50.0F, 6.0F, 12.0F, 0.0F, false);
		cube_r18.setTextureOffset(308, 4816).addBox(-16.8376F, 1.2798F, -25.5655F, 33.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(90.0308F, 18.8911F, -5.0F);
		shoulderarea.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, 0.2618F);
		cube_r12.setTextureOffset(0, 1721).addBox(-60.0F, -6.0F, -30.0F, 120.0F, 12.0F, 72.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-89.9692F, 18.8911F, -5.0F);
		shoulderarea.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, -0.2618F);
		cube_r13.setTextureOffset(1680, 1490).addBox(-60.0F, -6.0F, -30.0F, 120.0F, 12.0F, 72.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(0.0F, 0.0F, 0.0F);
		shoulderarea.addChild(cube_r19);
		cube_r19.setTextureOffset(480, 3374).addBox(-34.5F, -3.0F, -35.5F, 69.0F, 6.0F, 71.0F, 0.0F, false);

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, -113.25F, 0.0F);
		shouldersc.addChild(arms);

		hands = new ModelRenderer(this);
		hands.setRotationPoint(0.0F, 103.25F, 0.0F);
		arms.addChild(hands);
		hands.setTextureOffset(0, 4525).addBox(217.1556F, -346.353F, -1.0534F, 36.0F, 36.0F, 39.0F, 0.0F, false);
		hands.setTextureOffset(1408, 4359).addBox(-252.1556F, -342.353F, -1.0534F, 36.0F, 36.0F, 39.0F, 0.0F, false);

		lforearm_r1 = new ModelRenderer(this);
		lforearm_r1.setRotationPoint(-209.4056F, -340.103F, 28.1966F);
		hands.addChild(lforearm_r1);
		setRotationAngle(lforearm_r1, 0.0F, 0.0F, 1.0036F);
		lforearm_r1.setTextureOffset(270, 4648).addBox(-9.0F, -18.0F, -29.25F, 18.0F, 18.0F, 39.0F, 0.0F, false);

		lforearm_r2 = new ModelRenderer(this);
		lforearm_r2.setRotationPoint(210.4056F, -344.103F, 28.1966F);
		hands.addChild(lforearm_r2);
		setRotationAngle(lforearm_r2, 0.0F, 0.0F, -1.0036F);
		lforearm_r2.setTextureOffset(156, 4648).addBox(-9.0F, -18.0F, -29.25F, 18.0F, 18.0F, 39.0F, 0.0F, false);

		lforearm_r3 = new ModelRenderer(this);
		lforearm_r3.setRotationPoint(-216.1556F, -326.603F, 28.1966F);
		hands.addChild(lforearm_r3);
		setRotationAngle(lforearm_r3, 0.0F, 0.0F, 0.4363F);
		lforearm_r3.setTextureOffset(1262, 4525).addBox(-9.0F, -18.0F, -29.25F, 18.0F, 36.0F, 39.0F, 0.0F, false);

		lforearm_r4 = new ModelRenderer(this);
		lforearm_r4.setRotationPoint(217.1556F, -330.603F, 28.1966F);
		hands.addChild(lforearm_r4);
		setRotationAngle(lforearm_r4, 0.0F, 0.0F, -0.4363F);
		lforearm_r4.setTextureOffset(1148, 4525).addBox(-9.0F, -18.0F, -29.25F, 18.0F, 36.0F, 39.0F, 0.0F, false);

		larm = new ModelRenderer(this);
		larm.setRotationPoint(134.625F, -407.9375F, 8.0F);
		arms.addChild(larm);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(45.2813F, -413.0625F, 6.75F);
		larm.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.3927F);
		cube_r1.setTextureOffset(966, 3113).addBox(-45.5F, -31.0F, -27.75F, 67.0F, 68.0F, 56.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(68.4063F, -375.8125F, 5.1875F);
		larm.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 1.0036F);
		cube_r2.setTextureOffset(1010, 3831).addBox(-45.5F, -37.0F, -23.5F, 50.0F, 74.0F, 47.0F, 0.0F, false);

		upperleftleg3 = new ModelRenderer(this);
		upperleftleg3.setRotationPoint(11.5688F, -94.9118F, -0.5084F);
		larm.addChild(upperleftleg3);
		setRotationAngle(upperleftleg3, 0.0F, 0.0F, -0.0873F);
		upperleftleg3.setTextureOffset(1392, 3599).addBox(108.3068F, -273.1507F, -12.3019F, 9.0F, 180.0F, 45.0F, 0.0F,
				false);
		upperleftleg3.setTextureOffset(1284, 3599).addBox(45.3068F, -273.1507F, -12.3019F, 9.0F, 180.0F, 45.0F, 0.0F,
				false);
		upperleftleg3.setTextureOffset(280, 4359).addBox(43.0568F, -273.1507F, -10.0519F, 9.0F, 108.0F, 41.0F, 0.0F,
				false);
		upperleftleg3.setTextureOffset(1102, 4359).addBox(64.5236F, -261.1507F, -22.3963F, 36.0F, 132.0F, 9.0F, 0.0F,
				false);
		upperleftleg3.setTextureOffset(1300, 4359).addBox(57.7736F, -228.1507F, 31.6037F, 45.0F, 108.0F, 9.0F, 0.0F,
				false);
		upperleftleg3.setTextureOffset(496, 4202).addBox(110.5568F, -275.1507F, -13.8019F, 9.0F, 110.0F, 47.0F, 0.0F,
				false);
		upperleftleg3.setTextureOffset(884, 3831).addBox(53.2736F, -273.1507F, 27.1037F, 54.0F, 180.0F, 9.0F, 0.0F,
				false);
		upperleftleg3.setTextureOffset(882, 4107).addBox(49.8068F, -108.1507F, -12.3019F, 63.0F, 36.0F, 44.0F, 0.0F,
				false);
		upperleftleg3.setTextureOffset(1176, 1949).addBox(49.8068F, -288.1507F, -16.8019F, 63.0F, 180.0F, 45.0F, 0.0F,
				false);

		rihgtlowerlegs3 = new ModelRenderer(this);
		rihgtlowerlegs3.setRotationPoint(123.3188F, -89.9118F, -0.5084F);
		larm.addChild(rihgtlowerlegs3);
		rihgtlowerlegs3.setTextureOffset(396, 3599).addBox(-8.6932F, -7.1808F, -12.1804F, 9.0F, 187.0F, 45.0F, 0.0F,
				false);
		rihgtlowerlegs3.setTextureOffset(1320, 3113).addBox(-71.6932F, -18.1808F, -12.1804F, 9.0F, 216.0F, 45.0F, 0.0F,
				false);
		rihgtlowerlegs3.setTextureOffset(1456, 4027).addBox(-73.9432F, 31.8192F, -12.1804F, 9.0F, 130.0F, 45.0F, 0.0F,
				false);
		rihgtlowerlegs3.setTextureOffset(704, 4359).addBox(-59.2264F, 49.8192F, 31.664F, 45.0F, 130.0F, 9.0F, 0.0F,
				false);
		rihgtlowerlegs3.setTextureOffset(596, 4359).addBox(-59.2264F, 53.4192F, -20.086F, 45.0F, 130.0F, 9.0F, 0.0F,
				false);
		rihgtlowerlegs3.setTextureOffset(90, 4359).addBox(-6.4432F, 21.0192F, -7.6804F, 9.0F, 130.0F, 36.0F, 0.0F,
				false);
		rihgtlowerlegs3.setTextureOffset(126, 3831).addBox(-63.7264F, -7.1808F, -15.586F, 54.0F, 187.0F, 9.0F, 0.0F,
				false);
		rihgtlowerlegs3.setTextureOffset(1080, 2737).addBox(-67.1932F, 140.4192F, -12.3019F, 63.0F, 115.0F, 45.0F, 0.0F,
				false);
		rihgtlowerlegs3.setTextureOffset(216, 4027).addBox(-67.1932F, -32.3808F, -12.3019F, 63.0F, 43.0F, 45.0F, 0.0F,
				false);
		rihgtlowerlegs3.setTextureOffset(504, 3708).addBox(-67.1932F, -90.5808F, -13.8019F, 63.0F, 58.0F, 51.0F, 0.0F,
				false);
		rihgtlowerlegs3.setTextureOffset(216, 2497).addBox(-67.1932F, 10.2192F, -12.3019F, 63.0F, 130.0F, 45.0F, 0.0F,
				false);
		rihgtlowerlegs3.setTextureOffset(886, 3374).addBox(-63.7264F, -14.5808F, 27.1037F, 54.0F, 216.0F, 9.0F, 0.0F,
				false);

		rarm = new ModelRenderer(this);
		rarm.setRotationPoint(-65.3594F, -354.8125F, 7.0469F);
		arms.addChild(rarm);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-112.7969F, -466.1875F, 7.7031F);
		rarm.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.3927F);
		cube_r3.setTextureOffset(720, 3249).addBox(-21.5F, -31.0F, -27.75F, 67.0F, 68.0F, 56.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-135.9219F, -428.9375F, 6.1406F);
		rarm.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, -1.0036F);
		cube_r4.setTextureOffset(690, 3831).addBox(-4.5F, -37.0F, -23.5F, 50.0F, 74.0F, 47.0F, 0.0F, false);

		upperrightleg = new ModelRenderer(this);
		upperrightleg.setRotationPoint(-79.0844F, -148.0368F, 0.4447F);
		rarm.addChild(upperrightleg);
		setRotationAngle(upperrightleg, 0.0F, 0.0F, 0.0873F);
		upperrightleg.setTextureOffset(1176, 3599).addBox(-117.3068F, -273.1507F, -12.3019F, 9.0F, 180.0F, 45.0F, 0.0F,
				false);
		upperrightleg.setTextureOffset(1068, 3599).addBox(-54.3068F, -273.1507F, -12.3019F, 9.0F, 180.0F, 45.0F, 0.0F,
				false);
		upperrightleg.setTextureOffset(180, 4359).addBox(-52.0568F, -273.1507F, -10.0519F, 9.0F, 108.0F, 41.0F, 0.0F,
				false);
		upperrightleg.setTextureOffset(1012, 4359).addBox(-100.5236F, -261.1507F, -22.3963F, 36.0F, 132.0F, 9.0F, 0.0F,
				false);
		upperrightleg.setTextureOffset(1192, 4359).addBox(-102.7736F, -228.1507F, 31.6037F, 45.0F, 108.0F, 9.0F, 0.0F,
				false);
		upperrightleg.setTextureOffset(384, 4202).addBox(-119.5568F, -275.1507F, -13.8019F, 9.0F, 110.0F, 47.0F, 0.0F,
				false);
		upperrightleg.setTextureOffset(564, 3831).addBox(-107.2736F, -273.1507F, 27.1037F, 54.0F, 180.0F, 9.0F, 0.0F,
				false);
		upperrightleg.setTextureOffset(882, 4027).addBox(-112.8068F, -108.1507F, -12.3019F, 63.0F, 36.0F, 44.0F, 0.0F,
				false);
		upperrightleg.setTextureOffset(960, 1949).addBox(-112.8068F, -288.1507F, -16.8019F, 63.0F, 180.0F, 45.0F, 0.0F,
				false);

		rihgtlowerlegs2 = new ModelRenderer(this);
		rihgtlowerlegs2.setRotationPoint(-190.8344F, -139.0368F, 0.4447F);
		rarm.addChild(rihgtlowerlegs2);
		rihgtlowerlegs2.setTextureOffset(288, 3599).addBox(-0.3068F, -7.1808F, -12.1804F, 9.0F, 187.0F, 45.0F, 0.0F,
				false);
		rihgtlowerlegs2.setTextureOffset(1212, 3113).addBox(62.6932F, -18.1808F, -12.1804F, 9.0F, 216.0F, 45.0F, 0.0F,
				false);
		rihgtlowerlegs2.setTextureOffset(1348, 4027).addBox(64.9432F, 31.8192F, -12.1804F, 9.0F, 130.0F, 45.0F, 0.0F,
				false);
		rihgtlowerlegs2.setTextureOffset(488, 4359).addBox(14.2264F, 49.8192F, 31.664F, 45.0F, 130.0F, 9.0F, 0.0F,
				false);
		rihgtlowerlegs2.setTextureOffset(380, 4359).addBox(14.2264F, 53.4192F, -20.086F, 45.0F, 130.0F, 9.0F, 0.0F,
				false);
		rihgtlowerlegs2.setTextureOffset(0, 4359).addBox(-2.5568F, 21.0192F, -7.6804F, 9.0F, 130.0F, 36.0F, 0.0F,
				false);
		rihgtlowerlegs2.setTextureOffset(0, 3831).addBox(9.7264F, -7.1808F, -15.586F, 54.0F, 187.0F, 9.0F, 0.0F, false);
		rihgtlowerlegs2.setTextureOffset(864, 2737).addBox(4.1932F, 140.4192F, -12.3019F, 63.0F, 115.0F, 45.0F, 0.0F,
				false);
		rihgtlowerlegs2.setTextureOffset(0, 4027).addBox(4.1932F, -32.3808F, -12.3019F, 63.0F, 43.0F, 45.0F, 0.0F,
				false);
		rihgtlowerlegs2.setTextureOffset(504, 3599).addBox(4.1932F, -90.5808F, -13.8019F, 63.0F, 58.0F, 51.0F, 0.0F,
				false);
		rihgtlowerlegs2.setTextureOffset(0, 2497).addBox(4.1932F, 10.2192F, -12.3019F, 63.0F, 130.0F, 45.0F, 0.0F,
				false);
		rihgtlowerlegs2.setTextureOffset(760, 3374).addBox(9.7264F, -14.5808F, 27.1037F, 54.0F, 216.0F, 9.0F, 0.0F,
				false);

		leftlegc = new ModelRenderer(this);
		leftlegc.setRotationPoint(-72.0F, 0.0F, 0.0F);
		all.addChild(leftlegc);

		upperleftlegc = new ModelRenderer(this);
		upperleftlegc.setRotationPoint(122.0F, -485.0F, 9.9888F);
		leftlegc.addChild(upperleftlegc);
		setRotationAngle(upperleftlegc, 0.0F, 0.0F, -0.0873F);
		upperleftlegc.setTextureOffset(1080, 378).addBox(-33.4592F, -7.0F, -25.0692F, 84.0F, 217.0F, 60.0F, 0.0F,
				false);
		upperleftlegc.setTextureOffset(0, 2737).addBox(-39.4592F, 8.0F, -19.0692F, 12.0F, 180.0F, 60.0F, 0.0F, false);
		upperleftlegc.setTextureOffset(1736, 4202).addBox(-20.0816F, 20.0F, -32.5284F, 60.0F, 108.0F, 12.0F, 0.0F,
				false);
		upperleftlegc.setTextureOffset(750, 4027).addBox(-42.4592F, 8.0F, -16.0692F, 12.0F, 108.0F, 54.0F, 0.0F, false);
		upperleftlegc.setTextureOffset(1636, 3831).addBox(47.5408F, 8.0F, -19.0692F, 12.0F, 108.0F, 60.0F, 0.0F, false);
		upperleftlegc.setTextureOffset(1592, 4202).addBox(-20.0816F, 29.0F, 39.4716F, 60.0F, 108.0F, 12.0F, 0.0F,
				false);
		upperleftlegc.setTextureOffset(312, 3374).addBox(-26.0816F, 8.0F, 33.4716F, 72.0F, 180.0F, 12.0F, 0.0F, false);
		upperleftlegc.setTextureOffset(1872, 2497).addBox(44.5408F, 8.0F, -19.0692F, 12.0F, 180.0F, 60.0F, 0.0F, false);
		upperleftlegc.setTextureOffset(1448, 4202).addBox(-20.0816F, 20.0F, -32.5284F, 60.0F, 108.0F, 12.0F, 0.0F,
				false);

		leftlowerlegsc = new ModelRenderer(this);
		leftlowerlegsc.setRotationPoint(141.9583F, -285.0F, 15.9734F);
		leftlegc.addChild(leftlowerlegsc);
		leftlowerlegsc.setTextureOffset(168, 3374).addBox(-41.4175F, 66.0F, -24.8918F, 12.0F, 156.0F, 60.0F, 0.0F,
				false);
		leftlowerlegsc.setTextureOffset(1728, 2497).addBox(42.5825F, 57.0F, -24.8918F, 12.0F, 180.0F, 60.0F, 0.0F,
				false);
		leftlowerlegsc.setTextureOffset(1492, 3831).addBox(45.5825F, 99.0F, -24.8918F, 12.0F, 108.0F, 60.0F, 0.0F,
				false);
		leftlowerlegsc.setTextureOffset(1304, 4202).addBox(-22.0399F, 78.0F, 33.5674F, 60.0F, 108.0F, 12.0F, 0.0F,
				false);
		leftlowerlegsc.setTextureOffset(1160, 4202).addBox(-22.0399F, 93.0F, -35.4326F, 60.0F, 108.0F, 12.0F, 0.0F,
				false);
		leftlowerlegsc.setTextureOffset(264, 4202).addBox(-44.4175F, 90.0F, -18.8918F, 12.0F, 108.0F, 48.0F, 0.0F,
				false);
		leftlowerlegsc.setTextureOffset(900, 3599).addBox(-28.0399F, 66.0F, -29.4326F, 72.0F, 156.0F, 12.0F, 0.0F,
				false);
		leftlowerlegsc.setTextureOffset(1440, 2497).addBox(-35.4175F, 45.0F, -25.0538F, 84.0F, 36.0F, 60.0F, 0.0F,
				false);
		leftlowerlegsc.setTextureOffset(1392, 2069).addBox(-35.4175F, -3.0F, -37.0538F, 84.0F, 48.0F, 72.0F, 0.0F,
				false);
		leftlowerlegsc.setTextureOffset(672, 1949).addBox(-35.4175F, 81.0F, -25.0538F, 84.0F, 108.0F, 60.0F, 0.0F,
				false);

		lfoot = new ModelRenderer(this);
		lfoot.setRotationPoint(-62.8367F, 284.5F, -24.7301F);
		leftlowerlegsc.addChild(lfoot);
		lfoot.setTextureOffset(1584, 2269).addBox(34.8444F, -112.5F, 1.1897F, 70.0F, 113.0F, 50.0F, 0.0F, false);
		lfoot.setTextureOffset(1012, 3464).addBox(34.8444F, -29.5F, -51.3103F, 70.0F, 30.0F, 60.0F, 0.0F, false);
		lfoot.setTextureOffset(216, 4858).addBox(34.8444F, -19.5F, -68.8103F, 0.0F, 10.0F, 20.0F, 0.0F, false);
		lfoot.setTextureOffset(176, 4858).addBox(104.8444F, -19.5F, -63.8103F, 0.0F, 10.0F, 20.0F, 0.0F, false);
		lfoot.setTextureOffset(684, 4575).addBox(34.8444F, -9.5F, -51.3103F, 70.0F, 10.0F, 20.0F, 0.0F, false);
		lfoot.setTextureOffset(0, 4756).addBox(34.8444F, -9.5F, -71.3103F, 40.0F, 10.0F, 20.0F, 0.0F, false);
		lfoot.setTextureOffset(812, 4399).addBox(34.8444F, -9.5F, -81.3103F, 70.0F, 10.0F, 30.0F, 0.0F, false);
		lfoot.setTextureOffset(1068, 4648).addBox(34.8444F, -9.5F, -91.3103F, 40.0F, 10.0F, 20.0F, 0.0F, false);

		lfoot_r1 = new ModelRenderer(this);
		lfoot_r1.setRotationPoint(107.3444F, -4.5F, -78.8103F);
		lfoot.addChild(lfoot_r1);
		setRotationAngle(lfoot_r1, 0.0F, -0.3491F, 0.0F);
		lfoot_r1.setTextureOffset(572, 4776).addBox(-35.0F, -5.0F, 0.0F, 30.0F, 10.0F, 10.0F, 0.0F, false);

		lfoot_r2 = new ModelRenderer(this);
		lfoot_r2.setRotationPoint(69.8444F, -14.5F, -68.8103F);
		lfoot.addChild(lfoot_r2);
		setRotationAngle(lfoot_r2, 0.5672F, 0.0F, 0.0F);
		lfoot_r2.setTextureOffset(684, 4525).addBox(-35.0F, -5.0F, -20.0F, 40.0F, 10.0F, 40.0F, 0.0F, false);

		lfoot_r3 = new ModelRenderer(this);
		lfoot_r3.setRotationPoint(39.8444F, -14.5F, -81.2433F);
		lfoot.addChild(lfoot_r3);
		setRotationAngle(lfoot_r3, 0.5672F, -0.3491F, 0.0F);
		lfoot_r3.setTextureOffset(1008, 4575).addBox(25.0F, -5.0F, -20.067F, 30.0F, 10.0F, 40.0F, 0.0F, false);

		lfoot_r4 = new ModelRenderer(this);
		lfoot_r4.setRotationPoint(69.8444F, -14.5F, -63.8103F);
		lfoot.addChild(lfoot_r4);
		setRotationAngle(lfoot_r4, 0.5672F, 0.0F, 0.0F);
		lfoot_r4.setTextureOffset(390, 4648).addBox(15.0F, -5.0F, -20.0F, 20.0F, 10.0F, 40.0F, 0.0F, false);

		rightlegc = new ModelRenderer(this);
		rightlegc.setRotationPoint(-48.0F, 0.0F, 0.0F);
		all.addChild(rightlegc);

		upperrightlegc = new ModelRenderer(this);
		upperrightlegc.setRotationPoint(-2.0F, -485.0F, 9.9888F);
		rightlegc.addChild(upperrightlegc);
		setRotationAngle(upperrightlegc, 0.0F, 0.0F, 0.0873F);
		upperrightlegc.setTextureOffset(1296, 2497).addBox(-60.4592F, 8.0F, -19.0692F, 12.0F, 180.0F, 60.0F, 0.0F,
				false);
		upperrightlegc.setTextureOffset(1152, 2497).addBox(23.5408F, 8.0F, -19.0692F, 12.0F, 180.0F, 60.0F, 0.0F,
				false);
		upperrightlegc.setTextureOffset(618, 4027).addBox(26.5408F, 8.0F, -16.0692F, 12.0F, 108.0F, 54.0F, 0.0F, false);
		upperrightlegc.setTextureOffset(1040, 4202).addBox(-38.0816F, 20.0F, -32.5284F, 48.0F, 132.0F, 12.0F, 0.0F,
				false);
		upperrightlegc.setTextureOffset(896, 4202).addBox(-41.0816F, 53.0F, 39.4716F, 60.0F, 108.0F, 12.0F, 0.0F,
				false);
		upperrightlegc.setTextureOffset(1348, 3831).addBox(-63.4592F, 8.0F, -19.0692F, 12.0F, 108.0F, 60.0F, 0.0F,
				false);
		upperrightlegc.setTextureOffset(0, 3374).addBox(-47.0816F, 8.0F, 33.4716F, 72.0F, 180.0F, 12.0F, 0.0F, false);
		upperrightlegc.setTextureOffset(864, 2497).addBox(-54.4592F, 173.0F, -19.0692F, 84.0F, 36.0F, 60.0F, 0.0F,
				false);
		upperrightlegc.setTextureOffset(1368, 378).addBox(-54.4592F, -7.0F, -25.0692F, 84.0F, 180.0F, 60.0F, 0.0F,
				false);

		rihgtlowerlegsc = new ModelRenderer(this);
		rihgtlowerlegsc.setRotationPoint(-24.3784F, -285.0F, 18.764F);
		rightlegc.addChild(rihgtlowerlegsc);
		rihgtlowerlegsc.setTextureOffset(1596, 3113).addBox(-55.0808F, 66.0F, -27.6824F, 12.0F, 156.0F, 60.0F, 0.0F,
				false);
		rihgtlowerlegsc.setTextureOffset(720, 2497).addBox(28.9192F, 57.0F, -27.6824F, 12.0F, 180.0F, 60.0F, 0.0F,
				false);
		rihgtlowerlegsc.setTextureOffset(1204, 3831).addBox(31.9192F, 99.0F, -27.6824F, 12.0F, 108.0F, 60.0F, 0.0F,
				false);
		rihgtlowerlegsc.setTextureOffset(752, 4202).addBox(-35.7032F, 114.0F, 30.7768F, 60.0F, 108.0F, 12.0F, 0.0F,
				false);
		rihgtlowerlegsc.setTextureOffset(608, 4202).addBox(-35.7032F, 117.0F, -38.2232F, 60.0F, 108.0F, 12.0F, 0.0F,
				false);
		rihgtlowerlegsc.setTextureOffset(144, 4202).addBox(-58.0808F, 90.0F, -21.6824F, 12.0F, 108.0F, 48.0F, 0.0F,
				false);
		rihgtlowerlegsc.setTextureOffset(732, 3599).addBox(-41.7032F, 66.0F, -32.2232F, 72.0F, 156.0F, 12.0F, 0.0F,
				false);
		rihgtlowerlegsc.setTextureOffset(432, 2497).addBox(-49.0808F, 45.0F, -27.8444F, 84.0F, 36.0F, 60.0F, 0.0F,
				false);
		rihgtlowerlegsc.setTextureOffset(1392, 1949).addBox(-49.0808F, -3.0F, -39.8444F, 84.0F, 48.0F, 72.0F, 0.0F,
				false);
		rihgtlowerlegsc.setTextureOffset(384, 1949).addBox(-49.0808F, 81.0F, -27.8444F, 84.0F, 108.0F, 60.0F, 0.0F,
				false);
		rihgtlowerlegsc.setTextureOffset(1428, 3113).addBox(-41.7032F, 60.0F, 24.6964F, 72.0F, 180.0F, 12.0F, 0.0F,
				false);

		rfoot = new ModelRenderer(this);
		rfoot.setRotationPoint(62.0068F, 284.5F, -27.5207F);
		rihgtlowerlegsc.addChild(rfoot);
		rfoot.setTextureOffset(1344, 2269).addBox(-104.8444F, -112.5F, 1.1897F, 70.0F, 113.0F, 50.0F, 0.0F, false);
		rfoot.setTextureOffset(1012, 3374).addBox(-104.8444F, -29.5F, -51.3103F, 70.0F, 30.0F, 60.0F, 0.0F, false);
		rfoot.setTextureOffset(136, 4858).addBox(-34.8444F, -19.5F, -68.8103F, 0.0F, 10.0F, 20.0F, 0.0F, false);
		rfoot.setTextureOffset(96, 4858).addBox(-104.8444F, -19.5F, -63.8103F, 0.0F, 10.0F, 20.0F, 0.0F, false);
		rfoot.setTextureOffset(504, 4575).addBox(-104.8444F, -9.5F, -51.3103F, 70.0F, 10.0F, 20.0F, 0.0F, false);
		rfoot.setTextureOffset(942, 4726).addBox(-74.8444F, -9.5F, -71.3103F, 40.0F, 10.0F, 20.0F, 0.0F, false);
		rfoot.setTextureOffset(812, 4359).addBox(-104.8444F, -9.5F, -81.3103F, 70.0F, 10.0F, 30.0F, 0.0F, false);
		rfoot.setTextureOffset(942, 4696).addBox(-74.8444F, -9.5F, -91.3103F, 40.0F, 10.0F, 20.0F, 0.0F, false);

		rfoot_r1 = new ModelRenderer(this);
		rfoot_r1.setRotationPoint(-107.3444F, -4.5F, -78.8103F);
		rfoot.addChild(rfoot_r1);
		setRotationAngle(rfoot_r1, 0.0F, 0.3491F, 0.0F);
		rfoot_r1.setTextureOffset(572, 4756).addBox(5.0F, -5.0F, 0.0F, 30.0F, 10.0F, 10.0F, 0.0F, false);

		rfoot_r2 = new ModelRenderer(this);
		rfoot_r2.setRotationPoint(-69.8444F, -14.5F, -68.8103F);
		rfoot.addChild(rfoot_r2);
		setRotationAngle(rfoot_r2, 0.5672F, 0.0F, 0.0F);
		rfoot_r2.setTextureOffset(504, 4525).addBox(-5.0F, -5.0F, -20.0F, 40.0F, 10.0F, 40.0F, 0.0F, false);

		rfoot_r3 = new ModelRenderer(this);
		rfoot_r3.setRotationPoint(-39.8444F, -14.5F, -81.2433F);
		rfoot.addChild(rfoot_r3);
		setRotationAngle(rfoot_r3, 0.5672F, 0.3491F, 0.0F);
		rfoot_r3.setTextureOffset(1008, 4525).addBox(-55.0F, -5.0F, -20.067F, 30.0F, 10.0F, 40.0F, 0.0F, false);

		rfoot_r4 = new ModelRenderer(this);
		rfoot_r4.setRotationPoint(-69.8444F, -14.5F, -63.8103F);
		rfoot.addChild(rfoot_r4);
		setRotationAngle(rfoot_r4, 0.5672F, 0.0F, 0.0F);
		rfoot_r4.setTextureOffset(270, 4705).addBox(-35.0F, -5.0F, -20.0F, 20.0F, 10.0F, 40.0F, 0.0F, false);

		neck_head = new ModelRenderer(this);
		neck_head.setRotationPoint(2.0F, 2127.0F, 178.0F);
		all.addChild(neck_head);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(4.7126F, -210.1197F, -168.3109F);
		neck_head.addChild(neck);
		neck.setTextureOffset(432, 4027).addBox(-33.5626F, -2985.8803F, -11.1391F, 51.0F, 69.0F, 42.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-39.6166F, -2912.771F, -16.5242F);
		neck.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.384F, 0.0F, 0.384F);
		cube_r5.setTextureOffset(400, 4858).addBox(-2.55F, -21.0F, -3.45F, 6.0F, 27.0F, 6.0F, 0.0F, false);
		cube_r5.setTextureOffset(376, 4858).addBox(-2.55F, -21.0F, -3.45F, 6.0F, 27.0F, 6.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(22.7414F, -2912.771F, -16.5242F);
		neck.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.384F, 0.0F, -0.384F);
		cube_r6.setTextureOffset(352, 4858).addBox(-2.55F, -21.0F, -3.45F, 6.0F, 27.0F, 6.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-33.3211F, -2926.2395F, 29.1883F);
		neck.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.384F, 0.0F, 0.384F);
		cube_r7.setTextureOffset(328, 4858).addBox(-2.55F, -6.0F, -3.45F, 6.0F, 27.0F, 6.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-37.6304F, -2925.2104F, -0.7891F);
		neck.addChild(cube_r8);
		setRotationAngle(cube_r8, 2.0944F, -1.5708F, 0.0F);
		cube_r8.setTextureOffset(942, 4672).addBox(-10.95F, -1.5F, -12.075F, 42.0F, 3.0F, 21.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(20.7552F, -2925.2104F, -0.7891F);
		neck.addChild(cube_r9);
		setRotationAngle(cube_r9, 2.0944F, 1.5708F, 0.0F);
		cube_r9.setTextureOffset(942, 4648).addBox(-31.65F, -1.5F, -12.075F, 42.0F, 3.0F, 21.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-8.4376F, -2925.2104F, 33.5787F);
		neck.addChild(cube_r10);
		setRotationAngle(cube_r10, 2.0944F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(390, 4722).addBox(-25.125F, -1.5F, -10.35F, 51.0F, 3.0F, 21.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-8.4376F, -2925.2104F, -14.4569F);
		neck.addChild(cube_r20);
		setRotationAngle(cube_r20, -2.0944F, 0.0F, 0.0F);
		cube_r20.setTextureOffset(390, 4698).addBox(-25.125F, -1.5F, -10.35F, 51.0F, 3.0F, 21.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(16.4459F, -2926.2395F, 29.1883F);
		neck.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.384F, 0.0F, -0.384F);
		cube_r21.setTextureOffset(304, 4858).addBox(-2.55F, -6.0F, -3.45F, 6.0F, 27.0F, 6.0F, 0.0F, false);

		headarea = new ModelRenderer(this);
		headarea.setRotationPoint(-9.0F, -247.0F, 1.0F);
		neck_head.addChild(headarea);
		setRotationAngle(headarea, -0.2618F, 3.1416F, 0.0F);

		head3 = new ModelRenderer(this);
		head3.setRotationPoint(-8.25F, -1007.0824F, 29.8526F);
		headarea.addChild(head3);
		setRotationAngle(head3, 3.1416F, 0.0F, 0.0F);
		head3.setTextureOffset(730, 4831).addBox(-8.0F, 1856.746F, 650.2216F, 21.0F, 3.0F, 18.0F, 0.0F, false);
		head3.setTextureOffset(730, 4810).addBox(-8.0F, 1855.996F, 650.2216F, 21.0F, 3.0F, 18.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(13.0F, -488.909F, -37.9781F);
		head3.addChild(cube_r22);
		setRotationAngle(cube_r22, -2.3562F, 0.0F, 0.0F);
		cube_r22.setTextureOffset(48, 4858).addBox(-23.25F, -2191.7771F, 1291.897F, 21.0F, 21.0F, 3.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(-18.5F, -503.159F, 16.0219F);
		head3.addChild(cube_r23);
		setRotationAngle(cube_r23, -0.8727F, 1.309F, 0.0F);
		cube_r23.setTextureOffset(534, 4729).addBox(-621.1118F, 1392.5886F, 1912.3771F, 63.0F, 24.0F, 3.0F, 0.0F,
				false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(25.6191F, -518.0968F, -13.3022F);
		head3.addChild(cube_r24);
		setRotationAngle(cube_r24, -0.829F, -1.309F, 0.0F);
		cube_r24.setTextureOffset(534, 4702).addBox(585.5F, 1476.6527F, 1867.7908F, 63.0F, 24.0F, 3.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(7.75F, -506.159F, 33.9562F);
		head3.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.8727F, -0.7854F, 0.0F);
		cube_r25.setTextureOffset(730, 4783).addBox(410.8114F, 1869.5489F, -1517.6099F, 33.0F, 24.0F, 3.0F, 0.0F,
				false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(4.75F, -506.159F, 33.9562F);
		head3.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.8727F, 0.7854F, 0.0F);
		cube_r26.setTextureOffset(730, 4756).addBox(-448.054F, 1866.2988F, -1520.3371F, 33.0F, 24.0F, 3.0F, 0.0F,
				false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(23.5F, -503.159F, 24.9562F);
		head3.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.8727F, 0.0F, 0.0F);
		cube_r27.setTextureOffset(652, 4825).addBox(-37.5F, 2009.6672F, -1397.5866F, 33.0F, 24.0F, 3.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(10.0F, -525.659F, 21.9562F);
		head3.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, -0.7854F, 0.0F);
		cube_r28.setTextureOffset(488, 4828).addBox(419.8118F, 2382.4049F, 453.8333F, 27.0F, 3.0F, 15.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(2.5F, -525.659F, 21.9562F);
		head3.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.7854F, 0.0F);
		cube_r29.setTextureOffset(488, 4810).addBox(-451.0545F, 2382.4049F, 449.5907F, 27.0F, 3.0F, 15.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(-0.5F, -512.159F, -42.5438F);
		head3.addChild(cube_r30);
		setRotationAngle(cube_r30, -0.5236F, 0.0F, 0.5236F);
		cube_r30.setTextureOffset(0, 4858).addBox(1179.0554F, 1458.8696F, 1582.1198F, 12.0F, 24.0F, 12.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(13.0F, -512.159F, -42.5438F);
		head3.addChild(cube_r31);
		setRotationAngle(cube_r31, -0.5236F, 0.0F, -0.5236F);
		cube_r31.setTextureOffset(856, 4756).addBox(-1197.5505F, 1455.622F, 1580.2448F, 12.0F, 24.0F, 12.0F, 0.0F,
				false);

		head2 = new ModelRenderer(this);
		head2.setRotationPoint(21.0F, -23.4601F, 28.8698F);
		headarea.addChild(head2);
		setRotationAngle(head2, 0.0F, 3.1416F, 0.0F);
		head2.setTextureOffset(652, 4804).addBox(18.5F, -2961.0639F, 650.2216F, 21.0F, 3.0F, 18.0F, 0.0F, false);
		head2.setTextureOffset(652, 4783).addBox(18.5F, -2961.8139F, 650.2216F, 21.0F, 3.0F, 18.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(8.0F, -553.159F, 16.0219F);
		head2.addChild(cube_r32);
		setRotationAngle(cube_r32, -0.8727F, 1.309F, 0.0F);
		cube_r32.setTextureOffset(534, 4675).addBox(-621.1118F, -1672.1005F, -1739.9772F, 63.0F, 24.0F, 3.0F, 0.0F,
				false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(-49.6191F, -574.5797F, -12.6148F);
		head2.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, -0.2618F, 0.0F);
		cube_r33.setTextureOffset(0, 4786).addBox(227.2691F, -2385.4049F, 587.0886F, 12.0F, 3.0F, 39.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(37.1191F, -574.5797F, -12.6148F);
		head2.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.2618F, 0.0F);
		cube_r34.setTextureOffset(666, 4648).addBox(-169.7224F, -2385.4049F, 602.7235F, 12.0F, 3.0F, 42.0F, 0.0F,
				false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(52.1191F, -568.0968F, -13.3022F);
		head2.addChild(cube_r35);
		setRotationAngle(cube_r35, -1.5708F, 0.0F, 0.0F);
		cube_r35.setTextureOffset(488, 4756).addBox(-34.5F, -664.9528F, -2392.6378F, 21.0F, 51.0F, 3.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(52.1191F, -568.0968F, -13.3022F);
		head2.addChild(cube_r36);
		setRotationAngle(cube_r36, -0.829F, -1.309F, 0.0F);
		cube_r36.setTextureOffset(534, 4648).addBox(585.5F, -1744.433F, -1647.4074F, 63.0F, 24.0F, 3.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(34.25F, -556.159F, 33.9562F);
		head2.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.8727F, -0.7854F, 0.0F);
		cube_r37.setTextureOffset(652, 4756).addBox(410.8114F, -1195.1402F, 2134.7443F, 33.0F, 24.0F, 3.0F, 0.0F,
				false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(31.25F, -556.159F, 33.9562F);
		head2.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.8727F, 0.7854F, 0.0F);
		cube_r38.setTextureOffset(572, 4823).addBox(-449.2152F, -1197.604F, 2129.5865F, 33.0F, 24.0F, 3.0F, 0.0F,
				false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(50.0F, -553.159F, 24.9562F);
		head2.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.8727F, 0.0F, 0.0F);
		cube_r39.setTextureOffset(572, 4796).addBox(-37.5F, -1055.0219F, 2254.7676F, 33.0F, 24.0F, 3.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(36.5F, -575.659F, 21.9562F);
		head2.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0F, -0.7854F, 0.0F);
		cube_r40.setTextureOffset(398, 4810).addBox(419.8118F, -2385.4049F, 453.8333F, 27.0F, 3.0F, 15.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(29.0F, -575.659F, 21.9562F);
		head2.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.0F, 0.7854F, 0.0F);
		cube_r41.setTextureOffset(398, 4792).addBox(-451.0545F, -2385.4049F, 449.5907F, 27.0F, 3.0F, 15.0F, 0.0F,
				false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(26.0F, -562.159F, -42.5438F);
		head2.addChild(cube_r42);
		setRotationAngle(cube_r42, -0.5236F, 0.0F, 0.5236F);
		cube_r42.setTextureOffset(808, 4792).addBox(-1204.8496F, -2116.9878F, -482.4024F, 12.0F, 24.0F, 12.0F, 0.0F,
				false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(39.5F, -562.159F, -42.5438F);
		head2.addChild(cube_r43);
		setRotationAngle(cube_r43, -0.5236F, 0.0F, -0.5236F);
		cube_r43.setTextureOffset(808, 4756).addBox(1186.3544F, -2120.2354F, -484.2774F, 12.0F, 24.0F, 12.0F, 0.0F,
				false);

		head = new ModelRenderer(this);
		head.setRotationPoint(-2.5417F, -3.089F, 1.349F);
		headarea.addChild(head);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(18.1244F, -537.6495F, 78.9283F);
		head.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.0F, -0.7854F, 0.0F);
		cube_r44.setTextureOffset(278, 4756).addBox(-453.1753F, -2428.9049F, -454.6753F, 3.0F, 90.0F, 12.0F, 0.0F,
				false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setRotationPoint(-26.0411F, -537.6495F, 78.9283F);
		head.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0F, 0.7854F, 0.0F);
		cube_r45.setTextureOffset(248, 4756).addBox(450.1753F, -2428.9049F, -454.6753F, 3.0F, 90.0F, 12.0F, 0.0F,
				false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setRotationPoint(19.6244F, -537.6495F, -11.6263F);
		head.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.0F, 0.7854F, 0.0F);
		cube_r46.setTextureOffset(900, 4648).addBox(450.1753F, -2428.9049F, -460.6753F, 3.0F, 90.0F, 18.0F, 0.0F,
				false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setRotationPoint(-27.5411F, -537.6495F, -11.6263F);
		head.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0F, -0.7854F, 0.0F);
		cube_r47.setTextureOffset(858, 4648).addBox(-453.1753F, -2428.9049F, -460.6753F, 3.0F, 90.0F, 18.0F, 0.0F,
				false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setRotationPoint(31.6244F, -537.6495F, 0.3737F);
		head.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.0F, 0.7854F, 0.0F);
		cube_r48.setTextureOffset(816, 4648).addBox(450.1753F, -2428.9049F, -460.6753F, 3.0F, 90.0F, 18.0F, 0.0F,
				false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setRotationPoint(-39.5411F, -537.6495F, 0.3737F);
		head.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.0F, -0.7854F, 0.0F);
		cube_r49.setTextureOffset(774, 4648).addBox(-453.1753F, -2428.9049F, -460.6753F, 3.0F, 90.0F, 18.0F, 0.0F,
				false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setRotationPoint(30.5417F, -537.6495F, 33.6181F);
		head.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.0F, -0.2618F, 0.0F);
		cube_r50.setTextureOffset(408, 3831).addBox(-166.8247F, -2428.9049F, -645.5F, 3.0F, 90.0F, 75.0F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setRotationPoint(-38.4583F, -537.6495F, 33.6181F);
		head.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.0F, 0.2618F, 0.0F);
		cube_r51.setTextureOffset(252, 3831).addBox(163.8247F, -2428.9049F, -645.5F, 3.0F, 90.0F, 75.0F, 0.0F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setRotationPoint(-31.7083F, -537.6495F, 2.1181F);
		head.addChild(cube_r52);
		setRotationAngle(cube_r52, 0.0F, -1.5708F, 0.0F);
		cube_r52.setTextureOffset(936, 4525).addBox(-659.7654F, -2428.9049F, -45.0F, 3.0F, 90.0F, 33.0F, 0.0F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setRotationPoint(-3.2083F, -2866.0634F, -578.5703F);
		head.addChild(cube_r53);
		setRotationAngle(cube_r53, 2.3562F, 0.0F, 0.0F);
		cube_r53.setTextureOffset(256, 4858).addBox(-10.5F, 5.5F, -10.1603F, 21.0F, 18.0F, 3.0F, 0.0F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setRotationPoint(-6.2083F, -487.3995F, 78.6181F);
		head.addChild(cube_r54);
		setRotationAngle(cube_r54, 2.0071F, 0.0F, 0.0F);
		cube_r54.setTextureOffset(308, 4756).addBox(-7.5F, 381.1518F, 2432.0414F, 21.0F, 57.0F, 3.0F, 0.0F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setRotationPoint(-31.7083F, -537.6495F, 104.1181F);
		head.addChild(cube_r55);
		setRotationAngle(cube_r55, 0.0F, -1.5708F, 0.0F);
		cube_r55.setTextureOffset(864, 4525).addBox(-659.7654F, -2428.9049F, -45.0F, 3.0F, 90.0F, 33.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		all.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}