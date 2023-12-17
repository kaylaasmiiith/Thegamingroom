package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		// FIXME: obtain local reference to the singleton instance
		// Purpose: Ensure only one instance of GameService exists in memory.
        // Characteristics: Private constructor, private static instance variable, public static method.
		GameService service = GameService.getInstance(); // Obtain the singleton instance
        
        // a simple for loop to print the games
        for (int i = 0; i < service.getGameCount(); i++) {
            System.out.println(service.getGame(i));
        }

    }
    
}
