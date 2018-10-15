- 컨트랙트(contract )

  : 모든 변수와 합수는 한 컨트랙트 안에 속한다.

    컨트랙트는 모든 프로젝트의 시작점

  ```
  contract HelloWorld {

  }
  ```

- 솔리디티 소스코드는 "version pragma"로 시작한다.

  ``` 
  pragma solidity ^0.4.19;
  ```

- 상태 변수 & 정수

  :상태 변수는 컨트랙트 저장소에 영구적으로 저장된다. (즉, 이더리움 블록테인에 기록된다.)

  uint : 부호 없는 정수

  uint8, uint16, uint32 등과 같이 비트로 선언 할 수 있다.

  int : 부호 있는 정수

  ``` 
  contract Example {
      uint example = 16;
  }
  ```

- 수학 연산
  - 덧셈:  x + y
  - 뺄셈:  x - y
  - 곱셈:  x * y
  - 나눗셈:  x / y
  - 나머지: x % y
  - 지수연산: x ** y (x의 y승, x^y )
- struct : 구조체 

   여러 특성을 가진 보다 복잡한 자료형을 생성할 수 있다.

  ```
  struct Person {
      uint age;
      string name;
  }
  ```

- 배열
  - 정적배열 : uint[2] = fixedArray;
  - 동적배열: uint[] = dynamicArray;
  - 구조체의 배열 : Person[] people;
  - public배열 : Person[] public peoples;
- 함수 선언

  ``` 
  function createPerson(Strign name, uint age) {

  }
  ```

- 새로운 구조체 생성

  ```
  Person a1 = Person(22,yujeong);
  people.push(a1);
  //한 줄로 표현 가능
  people.push(Person(22,yujeong))
  ```

- Private / Public 함수

  ```
  //동적배열 person
  uint[] person;
  function _addToArray1(uint _person) private {
      person.push(_person);
  }

  function _addToArray2(uint _person) public {
      person.push(_person);
  }
  ```

- 반환값

  : 함수에서 어떤 값을 반환 받기 위해 사용

  - 함수가 데이터를 보기만 하고 변경하지 않을 떄 때 **view** 함수로 선언
  - 함수가 앱에서 어떤 데이터도 접근하지 않을 때 **pure** 함수사용

  ```
  string ever = "Hello Everland";
  function sayHello() public return (string) {
      return ever;
  }
  // view 사용
  function sayHello() public view return (string) {
  // pure 사용
  function _plus(uint a ,uint b) private pure return (uint) {
      return a + b;
  }
  ```

- **keccak256**

  : 이더리움 SHA3의 내상해시 함수로 기본적으로 입력 스트림을 랜덤 256비트 16진수로 매핑한다.

  ``` 
  string a = "hello";
  // ret 에는 256bit 16진수로 이루어져 있다
  uint ret = keccak256(a);
  //10**16 으로 나누게 되면 나머지가 16자리 숫자로만 이뤄지게 된다
  ret % (10 ** 16)
  ```

  

  

- 형변환

  ```
  uint8 a = 10;
  uint b = 2;
  
  // a / b 가 uint8 이 아닌 uint를 반환하기 때문에 에러 발생
  uint8 c = a / b;
  
  // b 를 uint8로 형 변환하여 코드가 제대로 작동.
  uint8 c = a / uint8(b);
  ```

  

- 이벤트

  : 컨트랙트가 블록체인 상에서 앱의 사용자 단에서 액션이 발생했을 때 의사소통 하는 방법.

  ```
  event IntegersAdded(uint x, uint y, uint result);
  
  function add(uint _x, uint _y) public {
    uint result = _x + _y;
    // 이벤트를 실행하여 앱에게 add 함수가 실행되었음을 알린다
    IntegersAdded(_x, _y, result);
    return result;
  }
  ```

  
