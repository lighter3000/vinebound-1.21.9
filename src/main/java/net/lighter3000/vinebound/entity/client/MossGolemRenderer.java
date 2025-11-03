package net.lighter3000.vinebound.entity.client;

import net.lighter3000.vinebound.Vinebound;
import net.lighter3000.vinebound.entity.custom.MossGolemEntity;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MossGolemRenderer extends MobEntityRenderer<MossGolemEntity, MossGolemRenderState, MossGolemModel> {

    public MossGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new MossGolemModel(context.getPart(MossGolemModel.MOSS_GOLEM)), 0.75f);
    }

    @Override
    public Identifier getTexture(MossGolemRenderState state) {
        return Identifier.of(Vinebound.MOD_ID, "textures/entity/moss_golem/moss_golem.png");
    }

    @Override
    protected void setupTransforms(MossGolemRenderState state, MatrixStack matrices, float bodyYaw, float baseHeight) {
        super.setupTransforms(state, matrices, bodyYaw, baseHeight);
        matrices.multiply(net.minecraft.util.math.RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
    }


    @Override
    public void render(MossGolemRenderState livingEntityRenderState, MatrixStack matrixStack,
                       OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        super.render(livingEntityRenderState, matrixStack, orderedRenderCommandQueue, cameraRenderState);
    }

    @Override
    public MossGolemRenderState createRenderState() {
        return new MossGolemRenderState();
    }

    @Override
    public void updateRenderState(MossGolemEntity livingEntity, MossGolemRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
    }
}
