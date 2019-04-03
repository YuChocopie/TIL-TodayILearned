## CSS 기초

디자인을 줄 수 있다

- CSS를 웹페이지에 삽입하는 방법은 무엇인가요?

  - 태그 안에 style 안에 property(속성)에 CSS라는 문법을 사용하면 된다.

- 선택자가 무엇인가?

  ​	class는 그루핑하고싶은걸 쓴느 것 이고

  ​	id는 식별 하는 것

  ​	CSS 선택자 : id > class > 태그

~~~
<style>
	.js{  		// 클래스 값 참조 태그의 클래스 값이 js 라면 전부적용
	    font-weight: bold;
	    color:red;
    }
    #first{		//id는 #을 앞에
        color:green;
    }
    span{		//아무것도 붙이지 않으면 모든 span태그를 말한다
        color:blue;
    }
</style>

<span id="first" class="js">hello world</span>
~~~
