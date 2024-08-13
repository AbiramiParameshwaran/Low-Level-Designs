package models;

public class Move {
    Player player;
    Cell cell;

    public Move(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public boolean validateMove(int dimension) {
        int row = cell.row;
        int col = cell.col;
        if(row<0 || col<0 || row>=dimension || col>=dimension) {
            return false;
        } else if(cell.getCellState().equals(CellState.FILLED)) {
            return false;
        }
        return true;
    }
}
