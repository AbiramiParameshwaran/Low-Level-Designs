package models;

import java.util.Scanner;

public class Player {
    String name;
    Symbol symbol;
    PlayerType playertype;
    Scanner sc = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playertype) {
        this.name = name;
        this.symbol = symbol;
        this.playertype = playertype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayertype() {
        return playertype;
    }

    public void setPlayertype(PlayerType playertype) {
        this.playertype = playertype;
    }

    public Move makeMove() {
        System.out.println("It is "+ name+"'s turn");
        System.out.println("Enter the row number where you want to make the move");
        int row = sc.nextInt();
        System.out.println("Enter the col number where you have to make the move");
        int col = sc.nextInt();
        return new Move(this, new Cell(row, col));
    }
}
