## Android Animation : TweenAnimation

: 위치나 크기, 회전을 지정한 시간내에 수행하는 애니메이션

​    

1. 회전(rotate) : 중심점을 기준으로 회전하는 애니메이션

2. 크기(scale) : 중심점을 기준으로 크기가 커지거나 줄어드는 애니메이션

3. 투명도(alpha) : View가 흐려지거나 다시 진해지는 애니메이션

4. 이동(translate) : View가 상,하,좌,우로 이동하는 애니메이션

5. 복합 애니메이션(set) : 여러 애니메이션을 중첩하는 애니메이션

​     
### <조건>
​     
애니메이션 효과 파일은 res/anim 또는 res/animation 라는 폴더안에 저장해야 한다

​    
### <속성>
​    
- interpolator : 애니메이션의 속도패턴을 바꾼다
  -  linear_interpolator : 등속
  -  accelerate_interpolator : 애니메이션이 처음에 느리가다 빨라진다
  - decelerate_interpolator : 애니메이션이 처음에 빠르다가 점점 느려진다
  - accelerate_decelerate_interpolator : 애니메이션이 과속했다가 급정거한다
  - overshoot_interpolator : 애니메이션이 마지막부분에서 조금 더 진행한다
  - bounce_interpolator : 애니메이션이 마지막 부분에서 통통 튕긴다
  - cycle_interpolator : 애니메이션이 마지막까지 갔다가 다시 처음으로 돌아온다

- repeatCount : 추가 반복횟수를 입력 (default = 0,무한동작 "infinite")
- duration : 동작시간 (n초 동안 동작)
- pviotX,Y : 기준점을 정해준다 (default는 view의 좌측상단 끝점, X,Y를 50%로 설정해야 중앙으로 이동한다.)
- from, to ~  : from부터 to까지 (0,360이면 0도부터 시계방향으로 회전)
- android:fillAfter="true"애니메이션 종료 후 상태 유지
​    
1. 회전(rotate)

   ~~~
   <set xmlns:android="http://schemas.android.com/apk/res/android">
       <rotate
           android:fromDegrees="0"
           android:toDegrees="360"
           android:pivotX="50%"
           android:pivotY="50%"
           android:duration="3000"
            />
   </set>
   ~~~
​    
2. 크기(scale) 

   ~~~
   <?xml version="1.0" encoding="utf-8"?>
   <scale xmlns:android="http://schemas.android.com/apk/res/android"
       android:duration="6000"
       android:fromXScale="0.0"	//0.0일땐 보이지 않음
       android:fromYScale="0.0"
       android:toXScale="3.0"		//3배크기
       android:toYScale="3.0"
       android:pivotX="50%"		//중앙을 기준
       android:pivotY="50%">
   </scale>
   ~~~
​    
3. 투명도(alpha)

   ~~~
   <?xml version="1.0" encoding="utf-8"?>
   <alpha xmlns:android="http://schemas.android.com/apk/res/android"
       android:duration="4000"
       android:fromAlpha="0.0"		//0.0일땐 보이지 않음
       android:interpolator="@android:anim/accelerate_interpolator"
       android:toAlpha="1.0" />
   ~~~
​    
4. 이동(translate)  // 나타나있다가 우측으로 사라진다.

   ~~~
   <?xml version="1.0" encoding="utf-8"?>
   <translate
           xmlns:android="http://schemas.android.com/apk/res/android"
           android:duration="4000"
           android:fillAfter="true"	//끝난뒤 원위치로 돌아오지 않음
           android:fromXDelta="0%"
           android:repeatCount="1"		//1번만 반복(-1 : 무한반복)
           android:toXDelta="100%">
   </translate>
   ~~~
​    
5. 복합 애니메이션(set) 

   <set> 태그 안에 애니매이션 태그들을 넣어주면 된다.

   // 이미지가 점점 짙어짐 + 커졌다 작아진다

   ~~~
   <?xml version="1.0" encoding="utf-8"?>
   <set xmlns:android="http://schemas.android.com/apk/res/android" android:interpolator="@android:anim/accelerate_interpolator">
       <alpha
           android:fromAlpha="0.0"
           android:toAlpha="1.0"
           android:duration="4000"/>
       <scale
           android:fromXScale="0.5" android:toXScale="1.5"
           android:fromYScale="0.5" android:toYScale="1.5"
           android:pivotX="50%" android:pivotY="50%"
           android:duration="2000"/>
       <scale 
           android:fromXScale="1.5" android:toXScale="1.0"
           android:fromYScale="1.5" android:toYScale="1.0"
           android:pivotX="50%" android:pivotY="50%"
           android:startOffset="2000"	//2000초 후에 시작
           android:duration="2000"/>
   </set>
   ~~~
​    
​    
### <적용>
​    
java

~~~
Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
view.startAnimation(animation);
~~~

kotln

~~~
val rotate: Animation = AnimationUtils.loadAnimation(this, R.anim.retate)
imageView.startAnimation(rotate)
~~~


## Reference
https://m.blog.naver.com/PostView.nhn?blogId=tkddlf4209&logNo=220700530627&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
