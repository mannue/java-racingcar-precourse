## 기능 요구 사항
### 사용자 입력
- 레이싱 횟수 를 입력
- 자동차 이름을 여러대 인 경우 쉼표(,)를 기준으로 5글자 이하로 입력

### 상세
- 자동차는 이름을 가지고 있다.
- 주어진 횟수 동안 n 대의 자동차는 move or stop
- 전진 조건은 0 ~ 9 사이의 random 값 에서 일정 값 이상이면 move , 일정 값 이하면 stop
- Exception 이 아닌 명확한 유형의 Exception 으로 처리

### 출력
- 전진하는 자동차를 출력할때 자동차 이름을 같이 출력
- 게임 완료 한후 우승자를 출력
- 우승자가 복수 인경우 쉼표(,) 로 이름을 구분

### 에러 발생
- 사용자가 잘못된 값을 입력한 경우 IllegalArgumentException 를 발생
- Exception 발생 시 "[ERROR]" 로 시작하는 에러 메시지를 출력
- 에러 발생한 부분 부터 다시 입력

----------------------
## 역할 class

### Energy class
- Energy 는 int 값을 가지며, VO 객체다.
- Energy 는 서로 비교할수 있다.

### EnergyGenerator class
- EnergyGenerator 는 일정범위를 주어지면 해당 범위에서 Energy 를 생성한다.
- ~~EnergyGenerator 는 입력 값 만큼 Energy 를 생성한다.~~
- EnergyGenerator 의 create 함수 호출 시 Energy 를 생성한다.

### Engine class
- Engine 는 움직이는데 필요한 Energy 기준이 되는 Gauge 값을 가진다
- Engine 는 외부로 부터 Energy 를 입력받아 동작 여부를 확인하는 메소드를 가진다.