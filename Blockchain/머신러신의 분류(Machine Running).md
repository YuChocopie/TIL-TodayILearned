
# 지도학습(supervised learning)
: 사람이 교사로 입력(x)에 대한 레이블(y)을 달아놓은 데이터를 컴퓨터에게 주면 컴퓨터가 그것을 학습하는 것.

사람이 직접 개입하므로 정확도가 높은 데이터를 사용할 수 있다는 장점이 있다. 대신에 사람이 직접 레이블을 달아야 하므로 인건비 문제가 있고, 따라서 구할 수 있는 데이터의 양도 작다는 문제가 있다.



**훈련 데이터호부터 함수를 만들어 내는 기계학습(Machine Learning) 기술**
: 문제를 해결하기 위한 맞춤코드를 작성하지 않고 일련의 데이터에 대해 무언가 흥미로운 것을 알려줄 수 있는 일반 알고리즘이 있다는 아이디어, 데이터를 알고리즘에 공급하면 데이터 기반의 자체 로직이 만들어진다.

- 훈련 데이터는 입력 대상의 쌍과 원하는 출력으로 구성된다. 

- 함수의 출력은 **연속값(Regression)**일 수 있고 또는 입력대상의 **분류명(Classification)**을 예상할 수도 있다.

  - Classification
    - 주어진 데이터를 정해진 카테고리에 따라 분류하는 문제 

      ex)이미지분류

    - **Binary Classification** : 맞다, 아니다 로 구분되는 문제

    - **	Multi-label Classification**: A / B / C / D / F으로 예측, 단계별로 나눔

- 지도학습기는 소수의 훈련(입력쌍과 목표 출력)을 보고 입력대상의 함수 값을 예측해야 하기 때문에 학습자는이성적인 방법으로 현재의 데이터로부터 보이지 않는 상황까지 일반화 해야 한다.

  - 지도학습의 문제 해결 법

    ```
    1. 훈련예의 유형(type)을 결정한다.
    2. 훈련집합을 모든다
    3. 학습함수의 입력 특징 표혀을 결정한다.
    4. 학습함수의 구조와 동등한 학습 알고리즘을 결정한다.
    5. 설계를 완성한 후 모아진 훈련집합 상에서 훈련 알고리즘을 작동시킨다.
    ```


# **비지도학습(unsupervised learning)**

: 라벨링이 되어 있지 않은 데이터로부터 미래를 예측하는 학습방법, 평가되어 있지 않은 데이터로부터 학습기로 하여금 숨어있는 패턴이나 형태를 찾아내는 것

-	"자율학습 **(unsupervised learning)**" 은 어떤 모델이 관찰한 것을 맞추는 기계학습의 한 방법으로 사전 정보가 없다는 사실에서 supervised learning와 구분된다.
-	자율학습에서는 입력 대상들의 집합을 모아둔 후, 그것을 임의 변수 (random variable)의 집합으로 취급한다.
  -	적용되는 확률밀도 (density)는 그 데이터 집합에 대해 만들어 진다 
-	자율학습은 다른 것에 주어진 임의 변수에 대한 조건부 확률(지도학습)을 계산하기 위해 **베이즈 추론** 과 함께 사용될 수 있다.
-	자율학습은 데이터 압축을 위해 또한 사용 가능하다.
  -	모든 데이터 압축 알고리즘은 입력집합에 대해 명시적으로나 암묵적으로 확률분포에 의존한다.
-	자율학습의 또다른 형태는 **군집화** 인데 이것은 때때로 비 확률 적일 수 있다.


## ::example ::

### **'자기조직화 (Self Organizing)'**  
https://github.com/YuChocopie/TIL-TodayILearned/blob/master/Blockchain/%EC%9E%90%EC%9C%A8%ED%95%99%EC%8A%B5_%EC%9E%90%EA%B8%B0%EC%A1%B0%EC%A7%81%ED%99%94(Unsupervised%20learning_Self%20Organizing).md

### **'군집화(Clustering)'** 
https://github.com/YuChocopie/TIL-TodayILearned/blob/master/Blockchain/%EC%9E%90%EC%9C%A8%ED%95%99%EC%8A%B5_%EA%B5%B0%EC%A7%91%ED%99%94(Unsupervised%20learning_Clustering).md


# 강화학습(Reinforcement Learning)

: 에이전트가 주어진 환경 (state) 에 대해 어떤 행동 (action) 을 취하고 이로부터 어떠 보상 (reword) 을 얻으며 학습을 진행하는 것 

보상은 행동을 취한 즉시 주어지지 않을 수도 있다 (지연된 보상). 이 때문에 문제의 난이도가 대폭 상승하며, 시스템을 제대로 보상하는 것과 관련된 **신뢰 할당 문제** 하는 난제가 생겼다.

다른 학습방법과는 다르게 실시간으로 학습을 진행하는 것이 일반적이다.

 - 지연된 보상

   대표적으로 게임 인공지능을 만들 때 체스에서 적의 말의 배치가 State가 되고 어떤 말을 어떻게 움직일지가 Action 이 된다. 상대 말을 잡게 되면 보상이 주어지는데 상대 말이 멀리 떨어져 이동할 때 까지의 시가이 필요할 수 있으므로, 상대말을 잡는 보상이 당장 주어지지 않는 경우도 생길 수 있다. 그리고 말을 잡는 것이 전술적으로는 이익이지만 결과적으로 게임에서 질 수도 있다.

   당장의 보상값이 조금 적더라도 나중에 얻을 보상 값의 총 합을 최대ghk 되도록 action을 택해야 한다.

응용

- Q-Learning
- Deep-Q-Learning
  
    
    
## Reference  
http://www.aistudy.com/neural  
https://namu.wiki

