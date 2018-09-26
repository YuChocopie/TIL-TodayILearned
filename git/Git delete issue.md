## git bash 이전 issue 모두 날리기
  
```git branch -r | grep -Eo 'issue/.*' | xargs git push --delete downstream```

```git branch -av      //삭제내역 확인```
  
## issue가 모두 날라가지 않은 경우 
```
git fetch downstream

git branch -av                          //추가되었나 확인

git branch -r | grep -Eo 'issue/.*'     //올리기

git branch -r | grep -Eo 'issue/.*' | xargs git push --delete downstream    

//delete된걸 확인할 수 있다.
```
