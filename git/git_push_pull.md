
## Git push/pull

### 커밋한 로그들 내용 보기

~~~
git log
~~~

### git에 올리기


- 현재 변경한 부분 보기
~~~
git status
~~~
- 변경 내용 모두 더하기(변경사항을 add시켜 git이 알 수 있게 트랙시켜준다)
~~~
git add .
~~~
- 변경된 지점을 로컬에 저장한다
~~~
git commit
~~~

- 로컬에 저장된 것을 remote브랜치에 추가 (온라인에 추가 하는 것)
- dev 에 있는것 올리기
~~~
git push downstream dev(주로 issue/num)
~~~

### git에서 받기
- dev에 변경사항을 다운받는다
~~~
git pull upstream dev --rebase
~~~
