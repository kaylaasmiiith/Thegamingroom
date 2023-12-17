package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 *  * Characteristics of the Singleton Pattern:
 * - Private constructor to prevent direct instantiation.
 * - Private static instance variable to hold the single instance.
 * - Public static method to get the instance of the singleton.
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// FIXME: Add missing pieces to turn this class a singleton 
	// Step 2: Add a private static instance variable
    private static GameService instance;

    // Step 1: Add a private constructor
    private GameService() {
        // private constructor to prevent instantiation
    }

    // Step 3: Add a public static method to get the instance of the singleton
    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existingGame = iterator.next();
            if (existingGame.getName().equals(name)) {
                return existingGame;
            }
        }
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		 Iterator<Game> iterator = games.iterator();
	        while (iterator.hasNext()) {
	            Game existingGame = iterator.next();
	            if (existingGame.getId() == id) {
	                game = existingGame;
	                break;
	            }
	        }
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existingGame = iterator.next();
            if (existingGame.getName().equals(name)) {
                game = existingGame;
                break;
            }
        }
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
