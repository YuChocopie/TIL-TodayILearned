## View

android에서 눈에 보이는 모든 요소

View 클래스는 모든 UI요소들의 부모클래스로 위젯과 레이아웃으로 나뉜다



## Fragment

Activity 화면의 작은 조각으로 액티비티가 관리하기 때문에 가벼운 화면 구성 가능

- Activity 화면의 작은 조각으로 Activity의 화면을 여러 영역으로 나누어 관리하고자 하는 목적으로 사용
- xml 레이아웃과 소스파일 한 쌍을 이룸
- 객체로 만들어서 소스 파일 한 쌍을 이룸



## ViewPager

- 좌우로 스와이프하며 View를 전환하는 AdapterView
- 화면이 바뀌는 것이 아닌 화면 크기의 View들이 전환되는 개념
  - onPageSelected : 화면 전환이 끝났을 때 해당 포지션 반환.
  - onPageScrolled : 스크롤효과가 나는 동안 계속해서 호출됨
  - onPageScrolledChanged : 포지션과는 상관없이 페이지의 상태 자체를 나타냄
    - 0 : SCROLL_STATE_IDLE
    - 1 : SCROLL_STATE_DRAGGING
    - 2 : SCROLL_STATE_SETTLING

## Adapter

- PagerAdapter를 구현하여 사용한다.
  - getCount : ViewPager로 보여줄 뷰의 전체 개수
  - isViewFromObject : instantiateItem에서 만듣 객체를 사용할 것 인지의 여부를 결정한다
  - instantiateItem : ViewPaget에서 뷰가 사라질 때 제서하는 작업을 한다
  - getCount() : 현재 PagerAdapter 에서 관리할 갯수 
  - instantiateItem() : ViewPager에서 사용할 뷰객체 생성 및 등록
  - destroyItem() : View 객체를 삭제 한다.
  - isViewFromObject() :instantiateItem 메소드에서 생성한 객체를 이용할 것인지 여부를 반환한다.
  - restoreState() : saveState() 상태에서 저장했던 Adapter와 page를 복구한다.
  - saveState() : 현재 UI 상태를 저장하기 위해 Adapter와 Page 관련 인스턴스 상태를 저장한다.
  - startUpdate() : 페이지 변경이 시작될 때 호출 된다.
  - finishUpdate() : 페이지 변경이 완료 됐을 때 호출 된다.

![image-20190417185202415](/Users/kim-yujeong/Library/Application Support/typora-user-images/image-20190417185202415.png)



