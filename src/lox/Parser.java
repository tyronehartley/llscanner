package lox;

import java.util.ArrayList;
import java.util.List;

import static lox.TokenType.*;

class Parser {
    private static class ParseError extends RuntimeException {}

    private final List<Token> tokens;
    private int current = 0;

    Parser(List<Token> tokens) {
        this.tokens = tokens;
    }
    Expr parse() {
        try {
            return expression();
        } catch (ParseError error) {
            return null;
        }
    }

    private Expr expression() {
        return term();
    }

    //ADDED: removed comparison() and equality(). epression() now calls term() directly

    private Expr term() {
        Expr expr = factor();

        while (match(MINUS, PLUS, DOWNSTREAM)) { //ADDED: changed GREATER_THAN to DOWNSTREAM, REMOVED LESS_THAN
        Token operator = previous();
        Expr right = factor();
        expr = new Expr.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expr factor() {
        Expr expr = unary();

        while (match(SLASH, STAR)) {
        Token operator = previous();
        Expr right = unary();
        expr = new Expr.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expr unary() {
        if (match(MINUS)) {
        Token operator = previous();
        Expr right = unary();
        return new Expr.Unary(operator, right);
        }

        return primary();
    }

    private Expr primary() {
        if (match(FALSE)) return new Expr.Literal(false);
        if (match(TRUE)) return new Expr.Literal(true);
        if (match(NIL)) return new Expr.Literal(null);
        

        if (match(NUMBER, STRING)) {
        return new Expr.Literal(previous().literal);
        }

        if (match(LEFT_PAREN)) {
        Expr expr = expression();
        consume(RIGHT_PAREN, "Expect ')' after expression.");
        return new Expr.Grouping(expr);
        }
        //ADDED: square bracket case
        if (match(LEFT_BRACKET)) {
            return series();
        }

        throw error(peek(), "Expect expression.");
  }
    //ADDED series()
    private Expr series() {
        List<Expr> elements = new ArrayList<>();
        if (!check(RIGHT_BRACKET)) {
        do {
            elements.add(expression());
        } while (match(COMMA));
        consume(RIGHT_BRACKET, "Expect ']' to close series");
        return new Expr.Series(elements);
        }
        return new Expr.Series(elements);
        
    }
    
    private boolean match(TokenType... types) {
        for (TokenType type : types) {
        if (check(type)) {
            advance();
            return true;
        }
        }

        return false;
    }

    private Token consume(TokenType type, String message) {
        if (check(type)) return advance();

        throw error(peek(), message);
    }

    private boolean check(TokenType type) {
        if (isAtEnd()) return false;
        return peek().type == type;
    }

    private Token advance() {
        if (!isAtEnd()) current++;
        return previous();
    }

    private boolean isAtEnd() {
        return peek().type == EOF;
    }

    private Token peek() {
        return tokens.get(current);
    }

    private Token previous() {
        return tokens.get(current - 1);
    }

    private ParseError error(Token token, String message) {
        Lox.error(token, message);
        return new ParseError();
    }

    private void synchronize() {
        advance();

        while (!isAtEnd()) {
            if (previous().type == SEMICOLON) return;

            switch (peek().type) {
                case CLASS:
                case FUN:
                case VAR:
                case FOR:
                case IF:
                case WHILE:
                case PRINT:
                case RETURN:
                return;
            }

            advance();
        }
    }
}
