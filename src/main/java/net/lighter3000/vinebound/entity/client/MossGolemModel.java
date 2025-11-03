package net.lighter3000.vinebound.entity.client;

import net.lighter3000.vinebound.Vinebound;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.function.Function;

public class MossGolemModel extends EntityModel<MossGolemRenderState> {
    public static final EntityModelLayer MOSS_GOLEM = new EntityModelLayer(Identifier.of(Vinebound.MOD_ID, "moss_golem"), "main");

    private final ModelPart root;
    private final ModelPart golem;
    private final ModelPart eyes;

    private final ModelPart body;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart left_foot;
    private final ModelPart right_foot;
    private final ModelPart right_eye;
    private final ModelPart left_eye;


    private final Animation walkingAnimation;
    //private final Animation idlingAnimation;


    public MossGolemModel(ModelPart root) {
        super(root);
        this.root = root;
        this.golem = this.root.getChild("golem");
        this.eyes = this.golem.getChild("eyes");

        this.body = this.golem.getChild("body");
        this.left_arm = this.golem.getChild("left_arm");
        this.right_arm = this.golem.getChild("right_arm");
        this.left_foot = this.golem.getChild("left_foot");
        this.right_foot = this.golem.getChild("right_foot");
        this.right_eye = this.eyes.getChild("right_eye");
        this.left_eye = this.eyes.getChild("left_eye");

        this.walkingAnimation = MossGolemAnimation.WALKING.createAnimation(root);
        //this.idlingAnimation = MossGolemAnimation.IDLE.createAnimation(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData golem = modelPartData.addChild("golem", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 24.0F, 0.0F));

        ModelPartData body = golem.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -8.0F, -6.0F, 12.0F, 12.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 52).cuboid(-5.95F, 2.0F, -5.95F, 12.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 52).cuboid(-6.05F, 2.0F, -6.05F, 12.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(20, 32).cuboid(-1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -8.0F, 0.0F));

        ModelPartData left_arm = golem.addChild("left_arm", ModelPartBuilder.create().uv(16, 20).cuboid(-4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(-6.0F, -10.0F, -1.0F));

        ModelPartData right_arm = golem.addChild("right_arm", ModelPartBuilder.create().uv(0, 20).cuboid(0.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(6.0F, -10.0F, -1.0F));

        ModelPartData left_foot = golem.addChild("left_foot", ModelPartBuilder.create().uv(16, 32).cuboid(-1.5F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(-4.0F, -4.0F, -2.0F));

        ModelPartData right_foot = golem.addChild("right_foot", ModelPartBuilder.create().uv(0, 32).cuboid(-2.5F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(4.0F, -4.0F, -2.0F));

        ModelPartData eyes = golem.addChild("eyes", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 0.0F, 0.0F));

        ModelPartData right_eye = eyes.addChild("right_eye", ModelPartBuilder.create().uv(1, 1).cuboid(-2.0F, -11.0F, 1.05F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.0F));

        ModelPartData left_eye = eyes.addChild("left_eye", ModelPartBuilder.create().uv(1, 1).cuboid(1.0F, -11.0F, 1.05F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(MossGolemRenderState state) {
        super.setAngles(state);


        this.walkingAnimation.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
        //this.idlingAnimation.apply(state.idleAnimationState, state.age, 1f);

        this.setEyeDirection(state.relativeHeadYaw, state.pitch);
        //this.setEyeDirection(eyes.originX, eyes.originY);
    }

    private void setEyeDirection(float eyeX, float eyeY) {
        eyeX = MathHelper.clamp(eyeX, -0.3f, 0.7f);
        eyeY = MathHelper.clamp(eyeY, -0.3f, 1f);


        this.eyes.originX = eyeX;
        this.eyes.originY = eyeY;

        //this.eyes.originY =
        //this.

    }

}
