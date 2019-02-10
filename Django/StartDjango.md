## VS Code 셋팅하기

git도, 파이썬 설치해서 정상작동되는걸 확인 후 터미널의 경로가 작업폴더 안에 있는 상태에서 아래 명령어를 입력

~~~
code .
~~~

## VENV 생성 & 가상환경 실행

```
//python -m venv 가상환경명
python -m venv myvenv
```

## 가상환경 실행하기

```
source myvenv/Scripts/activate
```

## 가상환경 끄기

```
deactivate
```

## Django 설치하기

**가상환경을 실행후 ** 아래 명령어를 입력

```
pip install django
```

## 새 프로젝트 생성

```
django-admin startproject projectname
```

## 프로젝트에 App 추가

manage.py가 있는 폴더에서 명령을 내리는 것을 추천

~~~
python3 manage.py startapp appname
~~~



1. [settings.py](http://settings.py) ⇒ project에게 app의 존재 알리기

   - appname.apps.Appname+Config

2. templates ⇒ views.py에서 처리된 데이터를 받아 사용자에게 화면을 보여줌

3. [views.py](http://views.py) ⇒ 데이터를 처리하는 함수 작성

   ~~~
   from django.shortcuts import render
       
       # Create your views here.
      
       def home(request):
           return render(request, 'home.html')
   ~~~

4. [urls.py](http://urls.py) ⇒ 요청에 맞는 함수를 views.py에서 찾아 요청 전달

```
from django.contrib import admin
from django.urls import path
import hello.views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', hello.views.home, name='home'),
]
```

## 서버 켜기

서버 종료 : ^c

```
python3 manage.py runserver
```
