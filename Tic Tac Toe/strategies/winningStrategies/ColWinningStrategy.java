package strategies.winningStrategies;

import models.Board;
import models.Move;
import models.Player;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategies{
    Map<Integer, Map<Symbol, Integer>> ColHashmaps = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int col = move.getCell().getCol();
        Player player = move.getPlayer();
        Symbol symbol = player.getSymbol();
        if(!ColHashmaps.containsKey(col)) {
            ColHashmaps.put(col, new HashMap<Symbol, Integer>());
        }
        Map<Symbol, Integer> map = ColHashmaps.get(col);
        if(!map.containsKey(symbol)) {
            map.put(symbol, 0);
        }
        map.put(symbol, map.get(symbol)+1);
        int count = map.get(symbol);
        return count == board.getDimension();
    }
}
