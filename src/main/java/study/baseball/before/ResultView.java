package study.baseball.before;

public class ResultView {

    /**
     * 결과 상태와 스트라이크, 볼 카운트로 화면에 결과를 표시
     * @param status
     * @param strike
     * @param ball
     */
    public void showResult(ResultStatus status, int strike, int ball) {
        String result = "";
        if (status == ResultStatus.END) {
           result = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        } else if (status == ResultStatus.REPLAYABLE) {
            String ballMessage = makeStrikeBallMessage(ball, "볼 ");
            String strikeMessage = makeStrikeBallMessage(strike, "스트라이크");
            result = ballMessage + strikeMessage;
        }

        if (result.isEmpty()) {
            result = "낫싱";
        }

        System.out.println(result);
    }

    /**
     * 스트라이크/볼 메세지 반환
     * @param count 횟수
     * @param type 결과 타입
     * @return ex) 1볼 1스트라이크
     */
    private String makeStrikeBallMessage(int count, String type) {
        if (count == 0) {
            return "";
        }

        return String.valueOf(count) + type;
    }
}
