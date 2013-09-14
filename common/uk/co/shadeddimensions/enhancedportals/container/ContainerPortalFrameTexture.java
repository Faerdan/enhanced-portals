package uk.co.shadeddimensions.enhancedportals.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import uk.co.shadeddimensions.enhancedportals.gui.slots.SlotPhantom;
import uk.co.shadeddimensions.enhancedportals.tileentity.TilePortalFrameController;

public class ContainerPortalFrameTexture extends ContainerEnhancedPortals
{
    public ContainerPortalFrameTexture(EntityPlayer player, TilePortalFrameController frame)
    {
        super(frame.getSizeInventory(), frame);

        addSlotToContainer(new SlotPhantom(frame, 0, 69, 21));

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++)
        {
            addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return ((TilePortalFrameController) tile).isUseableByPlayer(entityplayer);
    }
}