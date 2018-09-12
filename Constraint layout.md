## Constraint layout

- 형제 View들과의 관계를 정의해서 레이아웃을 구성한다는 점은 RelativeLayout과 비슷하지만, 자식 뷰 간의 상호 관계 정의가 가능
- LinearLAyout을 써야만 했던 뷰 비율 조정도 간단히 가능

#### Gradle 설정

```
repositories {
    google()
}

dependencies {
    implementation 'com.android.support.constraint:constraint-layout:1.1.2'
}
```

#### Constraint

- 자식 뷰의 위치를 잡는 기준

- 다른 뷰나 부모레이아웃과의 정렬 조건, 연결관계를 나타냄

- layout_constraint(기준1)_to(기준2)of="viewId or parent"

- start, end 속성은 left, right 속성보다 우선된다

- RelativeLayout의 alineLeft / toLeftOf 와는 다르다

- Top/Bottom/Left/Right를 모두 선언해야 하는 것은 아니다

  - 예기치 못한 상황이 발생할 수 있으므로 4방향 모두 선언하는 습관이 있는게 좋다

- match_parent 는 쓰면 안된다! match_constraint 을 써야 한다.

  match_constraint 라는 속성 값은 없다 0dp라 쓰고 math_constraint라고 읽는다

#### 뷰 크기 - 가로 세로 비율 지정

- dimensionRatio :  뷰의 가로/세로 비율 결정

  적어도 한 방향은 match_constraint 여야 한다

  - app:layout_constraintDimensionRatio="1" -> 가로/세로 = 1/1

  - app:layout_constraintDimensionRatio="1:1" -> 가로:세로 = 1:1

- 명시적으로 비율을 적용할 축을 지정할 수 있다 : (W|H),비율

  - W : 높이에 맞춰 폭을 조정
  - H : 폭에 맞춰 높이를 조정

```
renderMainHeaderButton(handleClickWriteButton);
```