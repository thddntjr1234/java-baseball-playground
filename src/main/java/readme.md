### 1. 기능별 객체 분리
1. 3자리 숫자 생성 -> generator
2. 숫자 비교, 아래와 같은 세부 기능으로 분류할 수 있다.
   1. 자리별로 숫자가 같은지 비교 -> playresult
   2. 몇 개의 숫자가 같은지 비교 - > playresult
3. 스트라이크, 볼, 낫싱 판단 -> playresult

### 2. 코딩 원칙
1. 실패하는 테스트를 구현한다
2. 테스트가 성공하도록 프로덕션 코드를 구현한다
3. 프로덕션 코드와 테스트 코드를 리팩토링한다.