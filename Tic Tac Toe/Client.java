import controllers.GameController;
import exceptions.InvalidBotCountException;
import exceptions.InvalidMoveException;
import exceptions.InvalidPlayerCountException;
import exceptions.InvalidSymbolException;
import models.Game;
import models.Player;
import models.PlayerType;
import models.Symbol;
import strategies.winningStrategies.ColWinningStrategy;
import strategies.winningStrategies.DiagonalWinningStrategy;
import strategies.winningStrategies.RowWinningStrategy;
import strategies.winningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, InvalidPlayerCountException, InvalidSymbolException, InvalidMoveException {
        int dimension = 3;

        List<Player> players = new ArrayList<>();
        players.add(new Player("Abi", new Symbol("X"), PlayerType.HUMAN));
        players.add(new Player("Kavin", new Symbol("O"), PlayerType.HUMAN));

        List<WinningStrategies> winningStrategies= new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        GameController gameController = new GameController();
        Game game = gameController.initialiseGame(dimension, players, winningStrategies);
        gameController.startGame(game);
    }
}
