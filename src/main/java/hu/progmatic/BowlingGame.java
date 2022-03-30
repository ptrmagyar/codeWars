package hu.progmatic;

public class BowlingGame {

  public int extract(String score) {
    int counter = 0;
    for (int i = 0; i < score.length(); i++) {
      if (score.charAt(i) != ' ') {
        counter++;
      }
    }
    return counter;
  }

  public int[] scoreToArray(String score) {
    int[] scored = new int[extract(score)];
    int counter = 0;
    for (int i = 0; i < score.length(); i++) {
      if (score.charAt(i) == 'X') {
        scored[counter] = 10;
        counter++;
        continue;
      }
      if (score.charAt(i) == '/') {
        scored[counter] = 10 - Integer.parseInt(score.substring(i - 1, i));
        counter++;
        continue;
      }
      if (score.charAt(i) != ' ') {
        scored[counter] = Integer.parseInt(score.substring(i, i + 1));
        counter++;
      }
    }
    return scored;
  }

  public int bowling_score(String score) {
    int[] scoreAll = scoreToArray(score);
    int scores = 0;
    int rollIndex = 0;
    for (int i = 0; i < 10; i++) {
      if (scoreAll[rollIndex] == 10) {
        scores += scoreAll[rollIndex] + scoreAll[rollIndex + 1] + scoreAll[rollIndex + 2];
        rollIndex ++;
      }
      else if (scoreAll[rollIndex] + scoreAll[rollIndex + 1] == 10){
        scores += scoreAll[rollIndex] + scoreAll[rollIndex + 1] + scoreAll[rollIndex + 2];
        rollIndex+=2;
      }
      else {
        scores += scoreAll[rollIndex] + scoreAll[rollIndex + 1];
        rollIndex += 2;
      }
    }
    return scores;
  }
}
