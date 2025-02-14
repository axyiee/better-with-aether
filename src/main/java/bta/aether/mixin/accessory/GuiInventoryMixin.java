package bta.aether.mixin.accessory;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiContainer;
import net.minecraft.client.gui.GuiInventory;
import net.minecraft.core.player.inventory.Container;
import org.lwjgl.opengl.GL11;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GuiInventory.class, remap = false)
public abstract class GuiInventoryMixin extends GuiContainer {

	@Shadow
	private GuiButton armorButton;

	@Shadow
	protected float xSize_lo;

	@Unique
	private static final int CORNER_INSET = 7;

	public GuiInventoryMixin(Container container) {
		super(container);
	}

	@Inject(method = "init", at = @At("TAIL"))
	public void init(CallbackInfo ci) {
		if (this.armorButton != null) {
			this.armorButton.xPosition = (width - xSize) / 2 + CORNER_INSET + 2;
			this.armorButton.yPosition = (height - ySize) / 2 + CORNER_INSET + 2;
		}
	}

	@Inject(method = "drawGuiContainerBackgroundLayer", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/GL11;glEnable(I)V", ordinal = 0))
	public void bindGuiTexture(float f, CallbackInfo ci) {
		Minecraft minecraft = Minecraft.getMinecraft(this);

		int startX = (width - xSize) / 2;
		int startY = (height - ySize) / 2;
		int texture_id;

		// draw aether inventory texture
		texture_id = minecraft.renderEngine.getTexture("assets/aether/gui/inventory.png");
		minecraft.renderEngine.bindTexture(texture_id);
		drawTexturedModalRect(startX, startY, 0, 0, 175, 165);
	}

	// move the player 'doll' over to the left some
	@Redirect(method = "drawGuiContainerBackgroundLayer", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/GL11;glTranslatef(FFF)V",ordinal = 0))
	public void translatePlayerModel(float x, float y, float z) {
		GL11.glTranslatef(x - 18, y, z);
	}

	// make the player model face correctly given the new shift
	@Redirect(method = "drawGuiContainerBackgroundLayer", at = @At(value = "FIELD", target = "Lnet/minecraft/client/entity/player/EntityPlayerSP;yRot:F", opcode = Opcodes.PUTFIELD, ordinal = 0))
	private void fixPlayerModelYaw(EntityPlayerSP instance, float yaw) {
		int startX = (width - xSize) / 2;
		instance.yRot = (float) Math.atan((startX + 33 - this.xSize_lo) / 40.0F) * 40.0F;
	}

	// don't draw the inventory text
	@Inject(method = "drawGuiContainerForegroundLayer", at = @At("HEAD"), cancellable = true)
	public void renderForeground(CallbackInfo ci) {
		ci.cancel();
	}
}
