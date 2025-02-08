package egirlmilkers.impracticality.neoforge;

import egirlmilkers.impracticality.Impracticality;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = Impracticality.MOD_ID)
public class ImpracticalityNeoForge
{
	public ImpracticalityNeoForge(IEventBus eventBus)
	{
		Impracticality.LOGGER.info("Impracticality :NeoForge > init");
		Impracticality.init();
	}
}