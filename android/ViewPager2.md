# [ViewPager2](https://developer.android.com/jetpack/androidx/releases/viewpager2)



 `build.gradle`

```groovy
implementation "androidx.viewpager2:viewpager2:1.0.0"    
```



### 기존 ViewPager 구현에서 달라진 점

- ViewPager2에서는 리사이클러뷰를 사용한다.

  > 원래 ViewPager은 PagerAdapter기반이다.
  >
  > ViewPager2에서는 PagerAdapter를 커스텀할 필요가 없다.

- FragmentStateAdapter를 이용하여 프레그먼트를 짠다.

  > FragmentStateAdapter를 이용하면 이전처럼 페이지 아이템을 프래그먼트로 구성할 수 있다. 기존 ViewPager 의 FragmentStatePagerAdapter를 대체한 API이다.

- ViewPager2의 OnPageChangeCallback은 추상 클래스이기 때문에 필요한 메서드만 재정의하면 된다.

  >  기존 ViewPager의 addPageChangeListener는 인터페이스여서 메서드를 모두 재정의 했었다.

- RTL(오른쪽에서 왼쪽) 레이아웃 지원

- 수직 방향 지원

- 안정적인 `Fragment` 지원(기본 `Fragment` 컬렉션 변경사항 처리 포함)
- 데이터세트 변경 애니메이션(`DiffUtil` 지원 포함)

- 이전 `ViewPager` 구현에서 쉽게 이전 가능.
