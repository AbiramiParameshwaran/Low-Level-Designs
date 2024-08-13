package strategies.winningStrategies;

import models.Board;
import models.Move;
import models.Player;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategies{

    Map<Integer, Map<Symbol, Integer>> rowHashmaps = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        Player player = move.getPlayer();
        Symbol symbol = player.getSymbol();
        if(!rowHashmaps.containsKey(row)) {
            rowHashmaps.put(row, new HashMap<Symbol, Integer>());
        }
        Map<Symbol, Integer> map = rowHashmaps.get(row);
        if(!map.containsKey(symbol)) {
            map.put(symbol, 0);
        }
        map.put(symbol, map.get(symbol)+1);
        int count = map.get(symbol);
        return count == board.getDimension();
    }

}
