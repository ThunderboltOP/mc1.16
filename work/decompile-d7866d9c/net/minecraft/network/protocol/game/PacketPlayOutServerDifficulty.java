package net.minecraft.network.protocol.game;

import java.io.IOException;
import net.minecraft.network.PacketDataSerializer;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.EnumDifficulty;

public class PacketPlayOutServerDifficulty implements Packet<PacketListenerPlayOut> {

    private EnumDifficulty a;
    private boolean b;

    public PacketPlayOutServerDifficulty() {}

    public PacketPlayOutServerDifficulty(EnumDifficulty enumdifficulty, boolean flag) {
        this.a = enumdifficulty;
        this.b = flag;
    }

    public void a(PacketListenerPlayOut packetlistenerplayout) {
        packetlistenerplayout.a(this);
    }

    @Override
    public void a(PacketDataSerializer packetdataserializer) throws IOException {
        this.a = EnumDifficulty.getById(packetdataserializer.readUnsignedByte());
        this.b = packetdataserializer.readBoolean();
    }

    @Override
    public void b(PacketDataSerializer packetdataserializer) throws IOException {
        packetdataserializer.writeByte(this.a.a());
        packetdataserializer.writeBoolean(this.b);
    }
}
