package Mail_It;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class testLog {

	
	/* Get actual class name to be printed on */
	
		private static org.apache.log4j.Logger log = Logger.getLogger(LogClass.class);
		
		public static void main(String[] args) {
		log.trace("Trace Message!");
		log.debug("Debug Message!");
		log.info("Info Message!");
		log.warn("Warn Message!");
		log.error("Error Message!");
		log.fatal("Fatal Message!");
		}
	}
