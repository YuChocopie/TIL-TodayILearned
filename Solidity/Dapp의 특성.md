# Dapp 의 특성

## 컨트랙트의 불변성

 이더리움에 컨트랙트를 배포하고 나면, 컨트랙트는 **변하지 않는다네(Immutable)**. 다시 말하자면 컨트랙트를 수정하거나 업데이트할 수 없다는 것이다.

컨트랙트로 배포한 최초의 코드는 항상, 블록체인에 영구적으로 존재한다. 이것이 바로 솔리디티에 있어서 보안이 굉장히 큰 이슈인 이유이다. 만약 컨트랙트 코드에 결점이 있다면, 그것을 이후에 고칠 수 있는 방법이 전혀 없다. 변경사항이 생긴다면 사용자들에게 결점을 보완한 다른 스마트 컨트랙트 주소를 쓰라고 말하고 다녀야 할 것 이다.

그러나 이것 또한 스마트 컨트랙트의 한 특징이 된다. 코드는 곧 법인 것이다. 당신이 어떤 스마트 컨트랙트의 코드를 읽고 검증을 했다면, 당신은 당신이 함수를 호출할 때마다, 코드에 쓰여진 그대로 함수가 실행될 것이라고 확신할 수 있다. 그 누구도 배포 이후에 함수를 수정하거나 예상치 못한 결과를 발생시키지 못한다.

### 외부 의존성

컨트랙트의 주소를 우리 DApp에 직접 써넣었을 경우. 만약 컨트랙트에 버그가 발생한다면 해당 DApp은 완전히 쓸모가 없어질 것이다. DApp은 주소를 코드에 직접 써넣기 때문에 어떤 행동도 하지 못 할 것이며 그걸 고치기 위해 컨트랙트를 수정할 수도 없을 것이다.

# 소유 가능한 컨트랙트

우리는 우리 컨트랙트에서 어떠한 값을 바꿀 수 있게끔 하고 싶지만, 그렇다고 모든 사람이 값을 업데이트할 수 있기를 원하지는 않는다.

이런 경우에 대처하기 위해서, 최근에 주로 쓰는 하나의 방법은 컨트랙트를 `소유 가능`하게 만드는 것으로 컨트랙트를 대상으로 특별한 권리를 가지는 소유자가 있음을 의미하는 것이다.

## OpenZeppelin의 `Ownable` 컨트랙트

~~~
/**
 * @title Ownable
 * @dev The Ownable contract has an owner address, and provides basic authorization control
 * functions, this simplifies the implementation of "user permissions".
 */
contract Ownable {
  address public owner;
  event OwnershipTransferred(address indexed previousOwner, address indexed newOwner);

  /**
   * @dev The Ownable constructor sets the original `owner` of the contract to the sender
   * account.
   */
  function Ownable() public {
    owner = msg.sender;
  }

  /**
   * @dev Throws if called by any account other than the owner.
   */
  modifier onlyOwner() {
    require(msg.sender == owner);
    _;
  }

  /**
   * @dev Allows the current owner to transfer control of the contract to a newOwner.
   * @param newOwner The address to transfer ownership to.
   */
  function transferOwnership(address newOwner) public onlyOwner {
    require(newOwner != address(0));
    OwnershipTransferred(owner, newOwner);
    owner = newOwner;
  }
}
~~~

- 생성자(Constructor): `function Ownable()`는 **생성자**이다. 컨트랙트와 동일한 이름을 가진,생략할 수 있는 특별한 함수이며, 이 함수는 컨트랙트가 생성될 때 딱 한 번만 실행된다.
- 함수 제어자(Function Modifier): `modifier onlyOwner()`. 제어자는 다른 함수들에 대한 접근을 제어하기 위해 사용되는 일종의 유사 함수다. 보통 함수 실행 전의 요구사항 충족 여부를 확인하는 데에 사용하고 `onlyOwner`의 경우에는 접근을 제한해서 **오직** 컨트랙트의 **소유자**만 해당 함수를 실행할 수 있도록 하기 위해 사용될 수 있다.
- `Ownable` 컨트랙트의 기본 기능
  1. 컨트랙트가 생성되면 컨트랙트의 생성자가 `owner`에 `msg.sender`(컨트랙트를 배포한 사람)를 대입한다.
  2. 특정한 함수들에 대해서 오직 `소유자`만 접근할 수 있도록 제한 가능한 `onlyOwner` 제어자를 추가한다.
  3. 새로운 `소유자`에게 해당 컨트랙트의 소유권을 옮길 수 있도록 한다.

- onlyOwner 는 컨트랙트에서 흔히 쓰는 것 중 하나이다. 대부분의 솔리디티 DApp들은 `Ownable` 컨트랙트를 복사/붙여넣기 하면서 시작하고 첫 컨트랙트는 이 컨트랙트를 상속해서 만든다.

## 함수제어자

함수 제어자는 함수처럼 보이지만, `function` 키워드 대신 `modifier` 키워드를 사용한다. 그리고 함수를 호출하듯이 직접 호출할 수는 없지만 대신에 함수 정의부 끝에 해당 함수의 작동 방식을 바꾸도록 제어자의 이름을 붙일 수 있다.

```
//@dev Throws if called by any account other than the owner.
modifier onlyOwner() {
  require(msg.sender == owner);
  _;
}
```

```
contract MyContract is Ownable {
  event LaughManiacally(string laughter);

  // 아래 `onlyOwner`의 사용 방법을 잘 보게:
  function likeABoss() external onlyOwner {
    LaughManiacally("Muahahahaha");
  }
}
```

`likeABoss` 함수를 호출하면, `onlyOwner`의 코드가 **먼저** 실행된다. 그리고 `onlyOwner`의 `_;` 부분을 `likeABoss` 함수로 되돌아가 해당 코드를 실행하게 됨.

제어자를 사용할 수 있는 다양한 방법이 있지만, 가장 일반적으로 쓰는 예시 중 하나는 함수 실행 전에 `require` 체크를 넣는 것이다.

`onlyOwner`의 경우에는, 함수에 이 제어자를 추가하면 **오직** 컨트랙트의 **소유자**(자네가 배포했다면 자네겠지)만이 해당 함수를 호출할 수 있다.

# 가스(Gas)

## 가스 - 이더리움 DApp이 사용하는 연료

솔리디티에서는 사용자들이 만든 DApp의 함수를 실행할 때마다 **가스**라고 불리는 화폐를 지불해야 한다. 사용자는 이더(ETH, 이더리움의 화폐)를 이용해서 가스를 사기 때문에, DApp 함수를 실행하려면 사용자들은 ETH를 소모해야만 한다.

함수를 실행하는 데에 얼마나 많은 가스가 필요한지는 그 함수의 로직(논리 구조)이 얼마나 복잡한지에 따라 달라진다. 각각의 연산은 소모되는 **가스 비용(gas cost)**이 있고, 그 연산을 수행하는 데에 소모되는 컴퓨팅 자원의 양이 이 비용을 결정한다. 예를 들어, storage에 값을 쓰는 것은 두 개의 정수를 더하는 것보다 훨씬 비용이 높다. 함수의 전체 **가스 비용**은 그 함수를 구성하는 개별 연산들의 가스 비용을 모두 합친 것과 같다.

함수를 실행하는 것은 자네의 사용자들에게 실제 돈을 쓰게 하기 때문에, 이더리움에서 코드 최적화는 다른 프로그래밍 언어들에 비해 훨씬 더 중요하다. 만약 코드가 엉망이라면, 사용자들은 함수를 실행하기 위해 일종의 할증료를 더 내야 하므로 불필요한 할증료가 수십 억 원까지 쌓일 수 있다

## 가스는 왜 필요한가?

이더리움은 크고 느린, 하지만 굉장히 안전한 컴퓨터와 같다고 할 수 있다. 어떤 함수를 실행할 때, 네트워크상의 모든 개별 노드가 함수의 출력값을 검증하기 위해 그 함수를 실행해야 하기 때문에 모든 함수의 실행을 검증하는 수천 개의 노드가 바로 이더리움을 분산화하고, 데이터를 보존하며 누군가 검열할 수 없도록 하는 요소이다.

이더리움을 만든 사람들은 누군가가 무한 반복문을 써서 네트워크를 방해하거나, 자원 소모가 큰 연산을 써서 네트워크 자원을 모두 사용하지 못하도록 만들길 원해서 연산 처리에 비용이 들도록 만들었고, 사용자들은 저장 공간 뿐만 아니라 연산 사용 시간에 따라서도 비용을 지불해야 한다.

> 참고: 사이드체인에서는 반드시 이렇지는 않다.  DApp을 사이드체인에 올릴지, 이더리움 메인넷에 올릴지 판단하는 방법들에 따라 다르다.

## 가스를 아끼기 위한 구조체 압축

솔리디티에서는 `uint`의 크기에 상관없이 256비트의 저장 공간을 미리 잡아놓기 때문에 하위 타입들을 쓰는 것은 아무런 이득이 없다. 예를 들면, `uint`(`uint256`) 대신에 `uint8`을 쓰는 것은 가스 소모를 줄이는 데에 아무 영향이 없는 것 이다.

하지만 `struct`의 안에서는 가스소모를 줄일 수 있게 된다. 만약 구조체 안에 여러 개의 `uint`를 만든다면, 가능한 더 작은 크기의 `uint`를 쓰도록 하여 솔리디티에서 그 변수들을 더 적은 공간을 차지하도록 압축할 것이다. 

또한 동일한 데이터 타입은 하나로 묶어놓는 것이 좋다. 즉, 구조체에서 서로 옆에 있도록 선언하면 솔리디티에서 사용하는 저장 공간을 최소화한다. 예를 들면, `uint c; uint32 a; uint32 b;`라는 필드로 구성된 구조체가 `uint32 a; uint c; uint32 b;` 필드로 구성된 구조체보다 `uint32` 필드가 묶여있기 때문에  가스를 덜 소모한다.

# 시간 단위(Time units)

솔리디티는 시간을 다룰 수 있는 단위계를 기본적으로 제공한다.

`now` 변수를 쓰면 현재의 유닉스 타임스탬프(1970년 1월 1일부터 지금까지의 초 단위 합) 값을 얻을 수 있다.

> 참고: 유닉스 타임은 전통적으로 32비트 숫자로 저장된다. 이는 유닉스 타임스탬프 값이 32비트로 표시가 되지 않을 만큼 커졌을 때 많은 구형 시스템에 문제가 발생할 "Year 2038" 문제를 일으킬 것이다. 그러니 만약 우리 DApp이 지금부터 20년 이상 운영되길 원한다면, 우리는 64비트 숫자를 써야 할 것이다. 하지만 유저들은 그동안 더 많은 가스를 소모해야 하므로 설계를 보고 결정을 해야 한다.

솔리디티는 또한 `seconds`, `minutes`, `hours`, `days`, `weeks`, `years` 같은 시간 단위 또한 포함하고 있다. 이들은 그에 해당하는 길이 만큼의 초 단위 `uint` 숫자로 변환된다. 즉 `1 minutes`는 `60`, `1 hours`는 `3600`(60초 x 60 분), `1 days`는 `86400`(24시간 x 60분 x 60초) 같이 변환되는 것 이다.
