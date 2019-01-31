# RecyclerView

1. Gradle에서 Implement 추가
2. 데이터 클래스 정의
3. 레이아웃에 RecyclerView 추가
4. item 생성
5. 어댑터 생성
6. 어댑터 설정

## 1. Gradle에서 Implement 추가

```
implementation 'com.android.support:recyclerview-v7:28.0.0'
```

## 2. 데이터 클래스 정의

```
class Food (
    val image: String,
    val name: String
)
```

```
/* Main Activity*/    
var foodList = arrayListOf<Food>()
```

## 3. 레이아웃에 RecyclerView 추가

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".RecyclerViewActivity">
    <android.support.v7.widget.RecyclerView
            android:id="@+id/recyclerView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_margin="10dp">
    </android.support.v7.widget.RecyclerView>

</android.support.constraint.ConstraintLayout>
```

## 4. item 생성

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:background="@drawable/square"
        android:layout_margin="10dp"
        android:layout_width="match_parent"
        android:layout_height="150dp">

    <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:srcCompat="@drawable/ic_launcher_background"
            android:id="@+id/ivFood"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintBottom_toBottomOf="parent"
            android:layout_marginStart="36dp"/>
    <TextView
            tools:text="foodName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/tvFood"
            android:textSize="16sp"
            android:textStyle="bold"
            android:layout_marginStart="36dp"
            app:layout_constraintStart_toEndOf="@+id/ivFood"
            android:layout_marginTop="8dp"
            app:layout_constraintTop_toTopOf="@+id/ivFood"/>
</android.support.constraint.ConstraintLayout>
```



## 5. 어댑터 생성

```
class FoodRvAdapter(val context: Context, val foodList : ArrayList<Food>) :
    RecyclerView.Adapter<FoodRvAdapter.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodPhoto = itemView.findViewById<ImageView>(R.id.ivFood)
        val foodName = itemView.findViewById<TextView>(R.id.tvFood)

        fun bind(food: Food, context: Context) {
            /* foodPhoto의 setImageResource에 들어갈 이미지의 id를 파일명(string)으로 찾고,
            * 이미지가 없는 경우에 기본이미지로*/
            if (food.image != "") {
                val resourceId = context.resources.getIdentifier(food.image, "drawable", context.packageName)
                foodPhoto.setImageResource(resourceId)
            } else {
                foodPhoto.setImageResource(R.mipmap.ic_launcher)
            }

            foodName.text = food.name
        }
    }


}
```

```
override fun onCreateViewHolder(parent: ViewGroup, viweType: Int): Holder {
    val view = LayoutInflater.from(context).inflate(
        R.layout.item_food, parent, false
    )
    return Holder(view)
  }
override fun getItemCount(): Int {
	return foodList.size
        }
override fun onBindViewHolder(holder: Holder, position: Int) {
    holder.bind(foodList[position], context)
}

```



## 6. 어댑터 설정

```
class RecyclerViewActivity : AppCompatActivity() {

    var foodList = arrayListOf<Food>(
        Food("square","네모"),
        Food("","치킨")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val mAdapter = FoodRvAdapter(this, foodList)
        recyclerView.adapter = mAdapter

        /*LayoutManager 는 item이 더이상 보이지 않을 때 재사용 할지 결정
        * view의 요소를 다른 데이터로 대체할지 확인해 불필요한 findViewId를 수행하지 않도록 한다
        * setHasFixedSize 은 item이 추가나 삭제될 경우 뷰의 크기가 변경될 수 있고 계층구조에 따른 뷰의 크기가 변경될 가능성이 있어서다*/
        val lm = LinearLayoutManager(this)
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)
    }
}
```

