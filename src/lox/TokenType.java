package lox;

enum TokenType {
  // Single-character tokens.
  LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE, 
  COMMA, DOT, MINUS, PLUS, SEMICOLON, SLASH, STAR,
  //ADDED: square brackets, downstream(>)
  RIGHT_BRACKET, LEFT_BRACKET,
  DOWNSTREAM,

  // Literals.
  IDENTIFIER, STRING, NUMBER,

  // Keywords.
  AND, CLASS, ELSE, FALSE, FUN, FOR, IF, NIL, OR,
  PRINT, RETURN, SUPER, THIS, TRUE, VAR, WHILE,

  EOF
}