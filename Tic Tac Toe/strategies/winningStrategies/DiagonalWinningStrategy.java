package strategies.winningStrategies;

import models.Board;
import models.Move;
import models.Player;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategies{
    Map<Symbol, Integer> diagonal1 = new HashMap<>();
    Map<Symbol, Integer> diagonal2 = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Player player = move.getPlayer();
        Symbol symbol = player.getSymbol();

        if(row == col) {
            if(!diagonal1.containsKey(symbol)) {
                diagonal1.put(symbol, 0);
            }
            diagonal1.put(symbol, diagonal1.get(symbol)+1);
            int count = diagonal1.get(symbol);
            return count == board.getDimension();
        } else {
            if(row+col == board.getDimension()) {
                if(!diagonal2.containsKey(symbol)) {
                    diagonal2.put(symbol, 0);
                }
                diagonal2.put(symbol, diagonal2.get(symbol)+1);
                int count = diagonal2.get(symbol);
                return count == board.getDimension();
            }
        }
        return false;
    }
}
