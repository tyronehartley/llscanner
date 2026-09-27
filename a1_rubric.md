# A1 Rubric Explanation

This document is part of your first submission.  Complete it and include it in your submission zip, alongside your parser, example programs.

## How it works

The rubric explanation is the set of questions below.  The first set, the basic questions, is graded directly and is worth 10\% of your marks for this submission.  Answer them accurately to earn those marks.

The remaining sections ask one question for each of the other rubric items.  These are not graded directly, but your answers help your marker award you the marks for each rubric item, so write your answers below each question text in markdown format and point your marker to where the evidence lives in your submission.

## Basic questions (10)

1. Which chapter of the book did you use as the starting point for your solution?

### Your answer

_up to chapter 6_

2. What is the "working folder", and what command(s) compile your parser?

### Your answer

_llscanner\src\lox_

3. What literal in your language represents a river that gets 10L/s of flow on the first day after 1mm of rainfall?

### Your answer

_10>[1]_

4. What symbol in your language shows two rivers combine, and is it a "unary", "binary", or "literal"?

### Your answer

_'>' is used to mark a confluence. It is a unary production and is considered a 'Token operator'_

5. Does your language include statements, or is it an expression language?

### Your answer

_expressions. you could technically have a program with an arbitrary line `10;` and it technically would be a statement_

6. In your language, how long does it take all the water to work through a river system after 1 day of rain?

### Your answer

_timeflow and delay is not modelled_

## Log-book submissions (10)

Which file in the zip are your log-book entries and when did you make them?  Your teacher needs to have seen them during the semester.

### Your answer

_a1logbook.pdf_

## Grammar given in the document in Nystrom's notation (20)

Provide the grammar for your language, and how does each of your example programs parse according to it?

### Your answer

expression -> 
    literal
    grouping
    series
    binary

literal     -> NUMBER | STRING | NIL
grouping    -> "(" expression* ")"
series      -> "[" expression* "]"
binary      -> expression operator expression
operator    -> "+" | ">" 

## Three example programs (20)

Provide your three example programs here and identify which files in your zip contain them.

### Your answer

_samplePrograms.md. _

## Parser written in Java based on Lox codebase (20)

Which chapter of the book is your parser based on?  What did you add beyond the Chapter 6 code, and where is that explained?

### Your answer

-The parser was modified to accept square brackets and a series of expressions. 

-GREATER_THAN `>` was modified to be a redundant `+`. `<` was removed. 

-Comparison logic was also removed ie `!=` or `==` was removed.


## Uniqueness and Creativity (20)

What did you do beyond the in-class work?  Point your marker to where it lives in your submission.

### Your answer

_only brainstorming of ideas and comprehension was shared. refer to `ADDED:` to find modifications to the Lox code_
