
# Git push/pull

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
#### dev 에서 issue로 pull 받기

~~~
git rebase dev
add .
git rebase --continue
~~~  
  
    
    
# Git 브랜치

#### 작업 브랜치 변경

~~~
git checkout dev(혹은issue)
~~~

#### 새 이슈 만들기

~~~
git checkout -b issue/num
~~~  
    
      
# Git Commit 

#### 커밋 내용 덮어씌우기

~~~
// 앞에 커밋에 이어쓰거나 수정
git commit --amend
//덮어쓰기, 주의해서 사용
git push downstream issue/num -f
~~~

#### 커밋 날리기

~~~~
git reset
// 커밋하기 한단계 전
git reset HEAD~1
~~~~  
  
    
# Git stash

#### 작업 내용 보관

~~~
//작업 내용 모두 숨겨놓기
git stash
//-u 는 새로 추가 된 파일 (untracked)도 포함되도록한다.
git stash -u
//안에 넣어둔 것 꺼내기
git stash pop
~~~
