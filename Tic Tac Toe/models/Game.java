package models;

import exceptions.InvalidBotCountException;
import exceptions.InvalidMoveException;
import exceptions.InvalidPlayerCountException;
import exceptions.InvalidSymbolException;
import strategies.winningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Game {
    Board board;
    List<Player> players;
    List<Move> moves;
    Player winner;
    GameState gameState;
    int nextPlayerIndex;
    List<WinningStrategies> winningStrategies;

    private Game(int dimension, List<Player> players, List<WinningStrategies> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void printBoard() {
        board.print();
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerIndex);
        Move move = currentPlayer.makeMove();
        if(!move.validateMove(board.getDimension())) {
            throw new InvalidMoveException("Invalid Move");
        }
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);

        Move finalMove = new Move(currentPlayer, cell);

        moves.add(finalMove);

        nextPlayerIndex = (nextPlayerIndex+1)% players.size();

        if(checkWinner(finalMove)) {
            gameState = GameState.ENDED;
            winner = currentPlayer;
        } else if(moves.size() == board.getDimension() * board.getDimension()){
            gameState = GameState.DRAW;
        }
    }

    public boolean checkWinner(Move move) {
        for (WinningStrategies winningStrategy: winningStrategies) {
            if(winningStrategy.checkWinner(move, board)) {
                return true;
            }
        }
        return false;
    }

    public static class Builder {
        int dimension;
        List<Player> players;
        List<WinningStrategies> winningStrategies;

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return  this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return  this;
        }

        public List<WinningStrategies> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategies> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        void validatePlayerCount() throws InvalidPlayerCountException {
            if(this.players.size() != this.dimension-1) {
                throw new InvalidPlayerCountException("Player count is invalid");
            }
        }

        void validateBotCount() throws InvalidBotCountException {
            List<Player> botPlayers = this.players
                                        .stream()
                                        .filter(player -> player.playertype == PlayerType.BOT)
                                        .toList();
            if(botPlayers.size() > 1) {
                throw new InvalidBotCountException("Bot count is not valid");
            }
        }

        void validateUniqueSymbol() throws InvalidSymbolException {
            List<String> symbols= this.players
                                    .stream()
                                    .map(player -> player.getSymbol().getAchar())
                                    .toList();
            System.out.println(symbols.toString());
            boolean validateSymbol = symbols
                                    .stream()
                                    .distinct()
                                    .count() == this.players.size();
            if(!validateSymbol) {
                throw new InvalidSymbolException("No 2 players should have same symbol");
            }
        }

        public void validate() throws InvalidPlayerCountException, InvalidBotCountException, InvalidSymbolException {
            validatePlayerCount();
            validateBotCount();
            validateUniqueSymbol();
        }

        public Game build() throws InvalidPlayerCountException, InvalidBotCountException, InvalidSymbolException {
            validate();
            return  new Game(this.dimension, this.players, this.winningStrategies);
        }
    }
}
