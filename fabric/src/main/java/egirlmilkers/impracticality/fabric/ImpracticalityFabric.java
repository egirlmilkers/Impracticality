package egirlmilkers.impracticality.fabric;

import egirlmilkers.impracticality.Impracticality;
import net.fabricmc.api.ModInitializer;

public class ImpracticalityFabric implements ModInitializer
{
    @Override
    public void onInitialize() // This code runs as soon as Minecraft is in a mod-load-ready state. However, some things (like resources) may still be uninitialized.
    {
        Impracticality.LOGGER.info("Impracticality :Fabric > init");
        Impracticality.init(); // Call the init method from the common module
    }

    /* // Should be used for things like setting how blocks are rendered (grass, glass, etc.)
    @Override
    public void onInitializeClient() // This entrypoint is suitable for setting up client-specific logic, such as rendering.
    {
        // Common would include code to set block rendering properties
        // Fabric specific client code would do some more niche things like fluid render handler registration
    }
    */
}
