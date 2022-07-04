package net.minecraft.src;

import me.bigratenthusiast.bingusware.Cosmetics;
import org.lwjgl.opengl.GL11;

/**
 * @created 7/2/22
 * @purpose 1.8 parity
 */
public class ModelPlayer extends ModelBiped {
//    public ModelRenderer bipedLeftArmwear;
//    public ModelRenderer bipedRightArmwear;
//    public ModelRenderer bipedLeftLegwear;
//    public ModelRenderer bipedRightLegwear;
//    public ModelRenderer bipedBodyWear;
    private String model = "UNKNOWN";
    private float modelSize;

    public ModelPlayer(float modelSize) {
        this.heldItemLeft = 0;
        this.heldItemRight = 0;
        this.isSneak = false;
        this.aimedBow = false;
        this.modelSize = modelSize;
        this.textureWidth = 64;
        /**
         * the reason the textureHeight is set to 32, the left side of the skin is mirrored and the outer layer
         * rendering is commented out is because of some godforsaken bug(? atleast i think its a bug) that makes
         * minecraft not accept skins with a height of 64. (and just online skins too, the bat texture which is 64x64
         * works displays fine) even though i tried looking for the source of the bug (hours of my life wasted: ~7)
         * it seemed to elude me BUT if you (the extremely cool and attractive person that you are) could; PLEASE
         * make a pull request. i would be eternally grateful <3333
         *                          - @bigratenthusiast
         */
        this.textureHeight = 32;

        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, modelSize);
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, modelSize + 0.5F);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, modelSize);
        this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.addArms(false);

        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize);
        this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);

        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize);
        this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);

        this.bipedEars = new ModelRenderer(this, 24, 0);
        this.bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, modelSize);
        this.bipedCloak = new ModelRenderer(this, 0, 0);
        this.bipedCloak.setTextureSize(64, 32);
        this.bipedCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, modelSize);

//        this.bipedBodyWear = new ModelRenderer(this, 16, 32);
//        this.bipedBodyWear.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, modelSize + 0.25F);
//        this.bipedBodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
//        this.bipedLeftArmwear = new ModelRenderer(this, 40, 48);
//        this.bipedLeftArmwear.addBox(-1.0F, -2.0F, -2.0F, useSmallArms ? 3 : 4, 12, 4, modelSize + 0.25F);
//        this.bipedLeftArmwear.setRotationPoint(5.0F, 2.5F, 0.0F);
//        this.bipedRightArmwear = new ModelRenderer(this, 48, 48);
//        this.bipedRightArmwear.addBox(-2.0F, -2.0F, -2.0F, useSmallArms ? 3 : 4, 12, 4, modelSize + 0.25F);
//        this.bipedRightArmwear.setRotationPoint(-5.0F, 2.5F, 10.0F);
//        this.bipedLeftLegwear = new ModelRenderer(this, 0, 32);
//        this.bipedLeftLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize + 0.25F);
//        this.bipedLeftLegwear.setRotationPoint(1.9F, 12.0F, 0.0F);
//        this.bipedRightLegwear = new ModelRenderer(this, 0, 48);
//        this.bipedRightLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize + 0.25F);
//        this.bipedRightLegwear.setRotationPoint(-1.9F, 12.0F, 0.0F);
    }

    // hack </3
    public void setSmallArms(String username) {
        if (this.model != "UNKNOWN") return;
        else {
            boolean flag = Cosmetics.hasSmallArms(username);
            this.model = flag ? "MHF_ALEX" : "MHF_STEVE";
            addArms(flag);
        }
    }
    public void addArms(boolean useSmallArms) {
        this.bipedLeftArm = new ModelRenderer(this, 40, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, useSmallArms ? 3 : 4, 12, 4, modelSize);
        this.bipedLeftArm.setRotationPoint(5.0F, 2.5F, 0.0F);

        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.addBox(-2.0F, -2.0F, -2.0F, useSmallArms ? 3 : 4, 12, 4, modelSize);
        this.bipedRightArm.setRotationPoint(-5.0F, 2.5F, 0.0F);
    }

    public void render(Entity entityIn, float par2, float par3, float par4, float par5, float par6, float scale) {

        this.setRotationAngles(par2, par3, par4, par5, par6, scale, entityIn);
        float var8 = 2.0F;
        if (this.isChild) {
            GL11.glPushMatrix();
            GL11.glScalef(1.5F / var8, 1.5F / var8, 1.5F / var8);
            GL11.glTranslatef(0.0F, 16.0F * scale, 0.0F);
        }
        this.bipedHead.render(scale);
        this.bipedHeadwear.render(scale);
        if (this.isChild) {
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
            GL11.glTranslatef(0.0F, 24.0F * scale, 0.0F);
        }
        this.bipedBody.render(scale);
        this.bipedRightArm.render(scale);
        this.bipedLeftArm.render(scale);
        this.bipedRightLeg.render(scale);
        this.bipedLeftLeg.render(scale);

//        this.bipedBodyWear.render(scale);
//        this.bipedRightArmwear.render(scale);
//        this.bipedLeftArmwear.render(scale);
//        this.bipedRightLegwear.render(scale);
//        this.bipedLeftLegwear.render(scale);

        if (this.isChild) GL11.glPopMatrix();

    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
//        copyModelAngles(this.bipedLeftLeg, this.bipedLeftLegwear);
//        copyModelAngles(this.bipedRightLeg, this.bipedRightLegwear);
//        copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
//        copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
//        copyModelAngles(this.bipedBody, this.bipedBodyWear);
    }

    public static void copyModelAngles(ModelRenderer source, ModelRenderer dest) {
        dest.rotateAngleX = source.rotateAngleX;
        dest.rotateAngleY = source.rotateAngleY;
        dest.rotateAngleZ = source.rotateAngleZ;
        dest.rotationPointX = source.rotationPointX;
        dest.rotationPointY = source.rotationPointY;
        dest.rotationPointZ = source.rotationPointZ;
    }

}
