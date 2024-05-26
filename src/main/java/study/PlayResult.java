package study;

public class PlayResult {
    private int strike = 0;
    private int ball = 0;

    public String createResultMessage() {
        String result = "";

        if (strike > 0) {
            result += strike + "스트라이크 ";
        }

        if (ball > 0) {
            result += ball + "볼";
        }

        if (result.isEmpty()) {
            result += "낫싱";
        }

        return result;
    }
}
