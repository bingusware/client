package me.bigratenthusiast.bingusware.module.modules;

import me.bigratenthusiast.bingusware.Client;
import me.bigratenthusiast.bingusware.module.Module;
import net.minecraft.src.Packet10Flying;
import org.lwjgl.input.Keyboard;

public class NoFall extends Module {
    public NoFall() { super("NoFall", Keyboard.KEY_SEMICOLON, Type.MOVEMENT); }

    @Override
    public boolean onEvent(Client.EventType type, Object... params) {
        if (type == Client.EventType.TICK) {
            if (mc.thePlayer.fallDistance > 2) {
                mc.thePlayer.sendQueue.addToSendQueue(new Packet10Flying(true));
            }
        }
        return true;
    }
}
