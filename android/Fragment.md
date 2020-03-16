# Fragment 

### 프래그먼트의 특징

- 액티비티를 분할하여 화면의 한부분을 정의한다.
- 액티비티와 같이 레이아웃, 동작 처리, 생명주기를 가지는 독립적인 모듈이다.
- 다른 액티비티에서도 사용 할 수 있어 재사용성이 뛰어나다.
- 액티비티 내에서 실행 중에 추가, 제거가 가능하다.



### Fragment를 생성 할 때 default 생성자만 사용하길 추천하는 이유

---

**Fragment**를 만들 때는 생성자를 오버로딩 하지 않고 생성 시 필요한 파라미터가 생기면 `Bundle` 객체에 담아서 setArgument() 함수를 호출하는 방식을 사용하는 것이 일반적이다. 



안드로이드에 의해서 **Fragment**가 복원(재생성)될 때는 Fragment의 기본 생성자를 호출하기 때문에 오버로딩된 생성자의 호출이 보장되지 않는다.

> 안드로이드에서는 메모리가 부족하게되면 액티비티를 파기하여 메모리를 확보한다.
> 액티비티 뿐만 아니고 메모리가 부족하면 프래그먼트도 파기되며 필요시 재생성 하기 때문이다.

생성자를 명시하지 않는다면 Java는 자동적으로 기본 생성자를 만든다.

재생성시에 필요한 생성자는 아무것도 매개변수가 없는 생성자이기 때문에 빈 생성자를 사용할수 없는경우 경우에 따라 상태 복원 중에 런타임 예외가 발생한다.

> 기본 생성자를 명시하지 않고 오버로딩된 생성자만 명시하게 되면  `Fragment fragment = new Fragment();` 문장을 호출했을 때 에러를 겪게 된다. 

그래서 저장하거나 넘겨야 할 값이 존재한다면 `newInstance()` 함수에 파라미터로 전달하고 이 함수 안에서 Bundle 객체를 통해서 파라미터로 넘어온 값을 저장한다.



그러니 아래와 같이 기본 생성자를 사용하도록 한다.(대신 구현은 구현부는 비워놓는다.)

java

~~~JAVA
public static MyFragment newInstance(int index) {
	MyFragment f = new MyFragment();
	Bundle args = new Bundle();
	f.setArguments(args); 
	return f;
}
~~~

kotln

~~~kotlin
companion object {
    @JvmStatic
    fun newInstance(Number: Int): MyFragment {
        return MyFragment().apply {
            arguments = Bundle().apply {
            }
        }
    }
}
~~~



####  setter를 통해서 생성할경우

프래그먼트가 재생성될때에 호출되는 메소드는 아래와 같다.

`Fragment #instantiate(Context context, String fname, Bundle args)`

재생성시 빈생성자를 호출한다고 했는데 매개변수를 보니 newInstance()를 통해서 셋팅했던 Bundle이 재생성될때 다시 셋팅되어 넘어온다.
그렇기 때문에 Bundle를 통해서 설정한 멤버변수들은 액티비티가 파기될때 따로 onSaveInstanceState()을 하지 않아도 잘 복구가 가능하다

>  복원될 때는 `getArguments()` 함수를 통해서 값을 복원하면 된다.





## Reference

https://lanace.github.io/articles/why-do-not-use-arguments-in-fragment/
