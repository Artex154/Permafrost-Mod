package be.artex.permafrost.item.advanced.scythe;

import be.artex.permafrost.entity.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.consume.UseAction;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class ScytheItem extends SwordItem {
    public ScytheItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.NONE;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.permafrost.glacial_scythe.tooltip"));
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!(user instanceof PlayerEntity player))
            return ActionResult.PASS;

        if (world.isClient)
            return ActionResult.PASS;

        if (hand != Hand.MAIN_HAND)
            return ActionResult.PASS;

        ItemStack stack = user.getMainHandStack();
        stack.damage(5, player, EquipmentSlot.MAINHAND);

        user.getItemCooldownManager().set(stack, 60);

        ScytheProjectileEntity projectile = new ScytheProjectileEntity(ModEntityTypes.SCYTHE, world);

        projectile.setOwner(player);
        projectile.setPosition(player.getX(), player.getEyeY() - 0.1, player.getZ());

        Vec3d look = user.getRotationVec(1.0F);
        projectile.setVelocity(look.x, look.y, look.z, 1F, 0.0F);

        world.spawnEntity(projectile);

        return ActionResult.SUCCESS;
    }
}
