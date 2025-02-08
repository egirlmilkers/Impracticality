package egirlmilkers.impracticality.forge;

import egirlmilkers.impracticality.Impracticality;
import net.minecraftforge.fml.common.Mod;

@Mod(value = Impracticality.MOD_ID)
public class ImpracticalityForge
{
	public ImpracticalityForge()
	{
		Impracticality.LOGGER.info("Impracticality :Forge > init");
		Impracticality.init();
	}
}