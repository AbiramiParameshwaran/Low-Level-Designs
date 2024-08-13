package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int dimension;
    List<List<Cell>> board;


    public Board(int dimension) {
        this.dimension = dimension;
        this.board = new ArrayList<>();
        for(int i=0; i<dimension; i++) {
            board.add(new ArrayList<>());
            for(int j=0; j<dimension; j++) {
                this.board.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void print() {
        for(List<Cell> cells: board) {
            for(Cell cell: cells) {
                if(cell.getCellState() == CellState.EMPTY) {
                    System.out.print("|  |");
                } else {
                    System.out.print("| "+ cell.getPlayer().getSymbol().getAchar()+ " |");
                }
            }
            System.out.println();
        }
    }

}
