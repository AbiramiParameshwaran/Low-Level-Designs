package controllers;

import exceptions.InvalidBotCountException;
import exceptions.InvalidMoveException;
import exceptions.InvalidPlayerCountException;
import exceptions.InvalidSymbolException;
import models.Game;
import models.GameState;
import models.Player;
import strategies.winningStrategies.WinningStrategies;

import java.util.List;

public class GameController {
    public Game initialiseGame(int dimension, List<Player> players, List<WinningStrategies> winningStrategies) throws InvalidBotCountException, InvalidPlayerCountException, InvalidSymbolException {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void startGame(Game game) throws InvalidMoveException {
        while(game.getGameState().equals(GameState.IN_PROGRESS)) {
            game.printBoard();
            game.makeMove();
        }

        if(game.getGameState().equals(GameState.ENDED)) {
            System.out.println("Winner is="+ game.getWinner().getName());
        } else {
            System.out.println("Game is Drawn");
        }
    }
}
