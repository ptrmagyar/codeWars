package hu.progmatic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
  BowlingGame game;
  @BeforeEach
  void setUp() {
    game = new BowlingGame();
  }

  @Test
  void extractedTest() {
    assertEquals(20,game.extract("11 11 11 11 11 11 11 11 11 11"));
    assertEquals(12,game.extract("X X X X X X X X X XXX"));
  }

  @Test
  void toArrayTest() {
    assertEquals("[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]", Arrays.toString(game.scoreToArray("11 11 11 11 11 11 11 11 11 11")));
    assertEquals("[10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]", Arrays.toString(game.scoreToArray("X X X X X X X X X XXX")));
  }

  @Test
  void name() {
    assertEquals(300,game.bowling_score("X X X X X X X X X XXX"));
    assertEquals(300,game.bowling_score("X 3/ X X X X X X X XXX"));
  }


}