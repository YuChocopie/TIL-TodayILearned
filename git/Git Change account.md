# git bash 터미널 계정 변경

- 전체정보 출력

```git config -l ```

- 구 계정 확인하기

```git config user.name```

- 구 이메일 확인하기

```git config user.email```

- 변경 방법 

```git config -global user.name 새계정이름```

```git config -global user.email 새이메일```

- SSH keys값 새로 생성하기

```ssh-keygen -t rsa -b 4096 -C "새이메일" ```

- SSH keys값을 클립보드에 복사

``` clip < ~/.ssh/id_rsa.pub```

- Github 페이지에서 세팅

``` Github -> Settings -> SSH keys에 붙여넣기 후 Add SSH key```

## 윈도우 setting

Windows 제어판 > 사용자계정 > 자격 증명 관리 > Windows 자격 증명 > 일반 자격 증명

기존 사용하던 토큰들중 git과 관련된 것 제거

프로젝트 업로드

 gitbash에서 업로드 할 프로젝트로 이동
```
 git init
 git remote add origin 레파지토리 주소
 git pull origin master
 git add .
 git commit -m "메세지"
 git push -u origin master
```
