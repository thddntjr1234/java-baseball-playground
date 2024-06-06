package study.baseball.before;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Baseball {

    private int strike;
    private int ball;

    List<Integer> computerNumberList;
    List<Integer> playerNumberList;

    static final int BASEBALL_NUMBER_LENGTH = 3;

    public void play() throws IOException {
        int computerNumber = getRandomNumber();
        computerNumberList = Arrays.stream(split(computerNumber)).boxed().collect(Collectors.toList());

        game();
    }

    public void replay() throws IOException {
        game();
    }

    public void game() throws IOException {
        init();

        InputView inputView = new InputView();
        int inputNumber = inputView.getInputNumber();

        if (!isValidNumber(inputNumber)) {
            System.out.println("3자리의 숫자를 입력해야 합니다.");
            inputNumber = inputView.getInputNumber();
        }

        playerNumberList = Arrays.stream(split(inputNumber)).boxed().collect(Collectors.toList());

        getBaseballResult(playerNumberList, computerNumberList);
        ResultView resultView = new ResultView();

        if (strike != 3) {
            resultView.showResult(ResultStatus.REPLAYABLE, strike, ball);
            replay();
            return;
        }

        resultView.showResult(ResultStatus.END, strike, ball);
        int playType = inputView.getPlayType();
        if (playType == 1) {
            play();
        }
    }

    /**
     * strike, ball 카운트 초기화
     */
    private void init() {
        strike = 0;
        ball = 0;
    }

    /**
     * 컴퓨터가 3자리의 자연수를 랜덤으로 추출
     * @return 100~999
     */
    public int getRandomNumber() {
        Random random = new Random();
        int num = random.nextInt(900) + 100;
        return num;
    }

    /**
     * 숫자 각 자리별 분리
     * @param number 분리할 숫자
     * @return 분리된 int[] arr
     */
    public int[] split(int number) {
        String strNumber = String.valueOf(number);

        int[] numArr = Arrays.stream(strNumber.split("")).mapToInt(Integer::parseInt).toArray();
        return numArr;
    }

    /**
     * 숫자가 지정된 길이에 해당하는지
     * @param number 검사할 숫자
     * @return true/false
     */
    public boolean isValidNumber(int number) {
        final int numberLength = BASEBALL_NUMBER_LENGTH;

        String strNumber = String.valueOf(number);
        if (strNumber.length() != BASEBALL_NUMBER_LENGTH) {
            return false;
        }

        return true;
    }

    /**
     * 사용자가 입력한 숫자에 대해 게임 결과를 확인
     * @param playerNumberList 사용자가 입력한 자리별 숫자
     * @param computerNumberList 컴퓨터가 랜덤으로 선택한 자리별 숫자 리스트
     */
    public void getBaseballResult(List<Integer> playerNumberList, List<Integer> computerNumberList) {
        int idx = 0;
        for (Integer num : playerNumberList) {
            checkStrikeOrBall(computerNumberList, num, idx);
            idx++;
        }
    }

    /**
     * 사용자가 입력한 숫자의 각 자리마다 스트라이크/볼을 계산한다.
     * @param computerNumberList 컴퓨터가 랜덤으로 선택한 자리별 숫자 리스트
     * @param num 자리별 숫자
     * @param idx 리스트 인덱스(가장 높은 자리수 = 0)
     */
    private void checkStrikeOrBall(List<Integer> computerNumberList, Integer num, int idx) {
        if (!computerNumberList.contains(num)) {
            return;
        } else if (computerNumberList.indexOf(num) != idx) {
            ball++;
            return;
        }
        strike++;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }
}
