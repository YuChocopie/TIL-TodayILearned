## 지켜줄 것
- 첫 번쨰 줄은 70자를 초과 할 수 없다
- 두 번째 줄은 항상 비어있고 다른줄은 80자가 넘어가면 줄 바꿈 되어야 한다.
- 유형은 소문자로 하고 커밋 메세지의 시작은 동사 원형이 오게 한다.

```
<type>: <subject>
<body>
<footer>
```
  
```
refactor: Commit Msg

- 변경사항    //명령형이나 현재시제를 사용한다.

Fixes ~   //이슈를 자동으로 닫아준다.
```
  
## 첫 번째 줄 메세지 type  
- refactor : 새로운 기능이 아닌 코드를 재정비 하였을 때 (변수 이름 바꾸기)  
- fix : 빌드 스크립트의 버그를 수정  
- feat : 빌드 스트립트의 기능을 위한 것이 아니라 사용자의 편의를 위한 새로운 기능  
- chore : 새로운 기능을 추가  
- docs : 문서 변경  
- test : 누락된 테스트 추가, 생산적인 코드 생성은 없음  
  

## Reference

http://karma-runner.github.io/2.0/dev/git-commit-msg.html
