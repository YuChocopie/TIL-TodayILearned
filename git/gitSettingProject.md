
## git 프로젝트 세팅
#### git 프로젝트 받아오기
  
- git 에서 clone or download	를 누르고 HTTP주소를 복사해 붙여넣는다
- 작업 디렉토리로 이동하여 git clone ~ 입력하면 다운로드 받아진다.

~~~
git clone https://github.com/dbwjd/mashup-android-6th.git
~~~

#### git upstream downstream 설정하기

~~~
// 클론 후 저장소를 보면 origin밖에 설정되어있지 않다.
remote -v 
// pull 받을 저장소를 추가한다
remote add upstream https://github.com/dbwjd/mashup-android-6th.git
// fork받은 저장소는 내 저장소 이기 때문에 downstream으로 설정한다.
remote rename origin downstream
~~~

#### git 작업 디렉토리의 이름이 바뀌었을 때

- 주소 바꾸기   git remote로 확인
~~~
git remote set -url downstream https://github.com/dbwjd/chetty-android.git
~~~
