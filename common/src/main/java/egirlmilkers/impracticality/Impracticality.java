package egirlmilkers.impracticality;

import egirlmilkers.impracticality.api.ImpracticalityAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Impracticality
{
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = ImpracticalityAPI.MOD_ID;
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public static void init()
	{
		LOGGER.info("Impracticality > init");
	}
}