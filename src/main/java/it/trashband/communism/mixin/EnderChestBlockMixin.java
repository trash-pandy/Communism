package it.trashband.communism.mixin;

import it.trashband.communism.Communism;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraft.world.level.block.EnderChestBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnderChestBlock.class)
public class EnderChestBlockMixin
{
	@Redirect(method = "use", at = @At(value = "NEW", target = "(Lnet/minecraft/world/inventory/MenuConstructor;Lnet/minecraft/network/chat/Component;)Lnet/minecraft/world/SimpleMenuProvider;"))
	SimpleMenuProvider a(MenuConstructor menuConstructor, Component title) {
		return new SimpleMenuProvider((i, inventory, player) ->
			ChestMenu.threeRows(i, inventory, Communism.data.globalContainer), title);
	}
}
