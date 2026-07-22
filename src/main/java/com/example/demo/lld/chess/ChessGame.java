package com.example.demo.lld.chess;


import com.example.demo.lld.chess.enums.Color;
import com.example.demo.lld.chess.enums.GameStatus;
import com.example.demo.lld.chess.models.*;

public class ChessGame {
    private final Board board;
    private Color currentTurn;
    private GameStatus gameStatus;
    public ChessGame(){
        this.board = new Board(8,8);
        this.currentTurn = Color.WHITE;
        this.gameStatus = GameStatus.ACTIVE;
        initializeBoard();

    }

    private void initializeBoard(){
        board.placePiece(new Rook(Color.BLACK, new Position(0,0)),new Position(0,0));
        board.placePiece(new Bishop(Color.BLACK, new Position(0,2)),new Position(0,2));
        board.placePiece(new Queen(Color.BLACK, new Position(0,3)),new Position(0,3));
        board.placePiece(new King(Color.BLACK, new Position(0,4)),new Position(0,4));
        board.placePiece(new Bishop(Color.BLACK, new Position(0,5)),new Position(0,5));
        board.placePiece(new Rook(Color.BLACK, new Position(0,7)),new Position(0,7));


        board.placePiece(new Rook(Color.WHITE, new Position(7,0)),new Position(7,0));
        board.placePiece(new Bishop(Color.WHITE, new Position(7,2)),new Position(7,2));
        board.placePiece(new Queen(Color.WHITE, new Position(7,3)),new Position(7,3));
        board.placePiece(new King(Color.WHITE, new Position(7,4)),new Position(7,4));
        board.placePiece(new Bishop(Color.WHITE, new Position(7,5)),new Position(7,5));
        board.placePiece(new Rook(Color.WHITE, new Position(7,7)),new Position(7,7));

    }

    public MoveResult makeMove(Position from, Position to){
        if(gameStatus != GameStatus.ACTIVE){
            return new MoveResult(false, "game already ended " + gameStatus);
        }
        Move move = new Move(from , to);
        ValidationResult validationResult = validateMove(move);
        if(!validationResult.isValid()){
            return new MoveResult(false, validationResult.getReason());
        }
        board.movePiece(move);
        switchTurn();
        return new MoveResult(true, " move successful " + gameStatus);
    }


    private boolean isKingInCheck(Color player) {
        return false;
    }

    private void switchTurn() {
        currentTurn = (currentTurn == Color.WHITE) ? Color.BLACK:Color.WHITE;

    }

    private ValidationResult validateMove(Move move) {
        Piece piece = board.getPiece(move.getFrom());
        if(piece == null){
            return new ValidationResult(false, "No piece found");
        }
        if(piece.getColor() != currentTurn){
            return new ValidationResult(false, " it is " + currentTurn + " player turn");
        }
        boolean legalPattern =
                piece.getValidMoves(board).stream().anyMatch(m -> m.getTo().equals(move.getTo()));
        if(!legalPattern){
            return new ValidationResult(false, "Illegal move for selected piece");
        }
        return new ValidationResult(true, "valid move");
    }

    
}
