package fi.dy.masa.litematica;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.fabricmc.api.ModInitializer;
import fi.dy.masa.malilib.event.InitializationHandler;
import fi.dy.masa.litematica.config.Configs;

public class Litematica implements ModInitializer
{
    public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);

    @Override
    public void onInitialize()
    {
        InitializationHandler.getInstance().registerInitializationHandler(new InitHandler());
    }

    public static void debugLog(String msg, Object... args)
    {
        if (Configs.Generic.DEBUG_LOGGING.getBooleanValue())
        {
            Litematica.logger.info(msg, args);
        }
    }

    public static void addChat(String msg)
    {
        MinecraftClient client = MinecraftClient.getInstance();
        msg = msg.replace("&", "§");
        Text message = Text.of("§8[§bLitematica§8] §f" + msg);
        client.inGameHud.getChatHud().addMessage(message);
    }
}
