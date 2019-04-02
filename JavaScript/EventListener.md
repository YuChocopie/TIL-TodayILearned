# JavaScript이벤트 리스너

      
- onbort : 이미지의 다운로드를 중지할 때 (브라우저의 중지 버튼)
- onactivate : 개체가 활성화 될 때 발생(태그의 기능이 작용할 때 발생하는 이벤트로 예를 들어 릴크를  누를 경우 링크가 옮겨질 때 발생하는 것을 감지하는 이벤트 핸들러.
- onafterprint : 문서가 출력되거나 혹은 출력하기 위해 출력 미리 보기를 한 후에 발생
- onafterupdate : 데이터 영역 개체에서 발생하는 이벤트로 데이터 소스 오브젝트내의 데이터가 업데이트 되었을 때 발생(데이터 개체 부분 참조)
- onbeforeactivate : 개체가 활성화 상태로 되기 바로 직전에 발생 (onactivate를 참고)
- onbeforecopy : 선택 영역이 시스템의 클립보드로 복사되기 바로 직전에 발생
- onbeforecut : 선택 영역이 지워 지기 바로 직전에 발생
- onbeforedeactivate : 모 문서에서 현재 개체에서 다른 개체로 activeElement가 바뀔 때 발생 (activeElement는 개체를 지칭하는 예약어로도 쓰임)
- onbeforeeditfocus : 편집 가능한 개체 내부에 포함된 개체가 편집 활성화 된 상태가 되거나 혹은 편집 가능한 개체가 제어를 위해 선택될때
- onbeforepaste : 시스템의 클립보드에서 문서로 붙여 넣기 될 때 대상 개체에서 발생
- onbeforeprint : 문서가 출력되거나 혹은 출력하기 위해 출력 미리 보기 직전에 발생
- onbeforeunload : 페이지가 업로드 되기 직전에 발생
- onbeforeupdate : 데이터 영역 개체에서 발생하는 이벤트로 데이터 소스 오브젝트내의 데이터가 업데이트 되기전에 발생(데이터 개체부분 참조)
- onblur : 개체가 포커스를 잃었을 때
- onbounce : 마퀴 태그에서 alernate상태에서 스크롤이 양 사이드에서 바운드 될 때 발생
- oncellchange : 데이터 제공 개체에서 데이터가 변화 할때 발생
- onchange : 개체 혹은 선택 영역의 내용이 바뀔 때 발생
  
#### -------- **Mouse Events** ----------------- 
  
- oncontextmenu : 클라이언트 영역에서 사용자가 마우스 오른쪽 버튼을 눌러 콘텍스트 메뉴를 열 때 발생
- onclick : 개체 위에서 마우스의 왼쪽 버튼을 누를 때 발
- ondblclick : 마우스로 해당 엘리먼트를 더블클릭함 
- onmousedown : 마우스를 누름(클릭은 마우스를 눌렀다 때는 것으로 구별됨) 
- onmousemove : 마우스가 엘리먼트 위에서 이동함 
- onmouseout : 마우스가 엘리먼트에서 벗어남 
- onmouseup : 마우스를 뗌(MouseDown과 반대됨 버튼을 누른 상태에서 떼는 경우) 
  
 ####  ----------- Keyboard Events -------------- 
  
- onkeydown : 키보드 버튼을 누르고 있는 경우 (어떤 키인지 읽으려면 함수를 호출하여 event.KeyCode를 참고해야 한다) 
- onkeypress : 키보드 버튼을 눌렀 땐 경우 ( 마우스의 클릭과 유사) 
- onkeyup : 키보드 버튼을 누르고 있다가 땐 경우 ( MouseUp과 유사) 

  
 #### ------- **HTML Control Events** ————
  
- onblur  : 엘리먼트가 Focus(초점)를 잃음. 예를 들어 버튼을 클릭하면 포커스(점선테두리로 보임)가 버튼에 잡혀있는데 이 때 다른 것을 클릭하거나 탭등으로 포커스를 이동할 경우를 의미함. 
- onChange : 엘리먼트에서 특정 내용을 선택 혹은 변경하는 경우. 셀렉트박스(select box)에서 선택된 아이템을 변경하는 경우가 이에 해당됨 
- onfocus : 엘리먼트에 초점이 맞춰지는 경우 
- onReset : 리셋 이벤트가 발생하는 경우. 대표적으로 input box의 타입 reset이 적용될 때이다. 
- onselect : 엘리먼트내 문자열을 블럭화 할 경우(즉 드래그 혹은 쉬프트+방향키등으로 문자열에 블럭을 씌우는 경우이다) 
- onsubmit : 폼(Form)태그내에서 전송(Submit) 이벤트가 발생하는 경우 
  
    
#### --------- **Window Events** ----------- 
  

- onload : 페이지나 이미지등의 엘리먼트가 로딩이 완료되는 경우 

- onresize : 윈도우나 프레임의 사이즈가 변경되는경우 

- onunload : 온로드의 반대로서 페이지를 이탈하는 경우  
  

## Reference
  http://bamtol.net/v5/bbs/board.php?bo_table=pp_js&wr_id=49
 
