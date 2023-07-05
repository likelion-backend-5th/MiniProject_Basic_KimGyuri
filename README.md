# 백엔드 미니 프로젝트 ♻️멋사마켓♻️

> **당근마켓, 중고나라 등에서 착안하여 나만의 중고 제품 거래 플랫폼을 만들어보는 미니 프로젝트입니다.  
사용자가 중고 물품을 자유롭게 올리고, 댓글을 통해 소통하며,  
최종적으로 구매 제안에 대하여 수락할 수 있는 형태의 중고 거래 플랫폼의 백엔드를 만드는 것이 목표입니다.**
<br>

## 💡 프로젝트 요구사항 💡
### ❤ 중고 물품 관리
```
1. 누구든지 중고 거래를 목적으로 물품에 대한 정보를 등록할 수 있다. 
    1. 이때 반드시 포함되어야 하는 내용은 제목, 설명, 최소 가격, 작성자이다.
    2. 또한 사용자가 물품을 등록할 때, 비밀번호 항목을 추가해서 등록한다.
    3. 최초로 물품이 등록될 때, 중고 물품의 상태는 판매중 상태가 된다.
2. 등록된 물품 정보는 누구든지 열람할 수 있다.
    1. 페이지 단위 조회가 가능하다.
    2. 전체 조회, 단일 조회 모두 가능하다.
3. 등록된 물품 정보는 수정이 가능하다.
    1. 이때, 물품이 등록될 때 추가한 비밀번호를 첨부해야 한다.
4. 등록된 물품 정보에 이미지를 첨부할 수 있다.
    1. 이때, 물품이 등록될 때 추가한 비밀번호를 첨부해야 한다.
    2. 이미지를 관리하는 방법은 자율이다.
5. 등록된 물품 정보는 삭제가 가능하다. 
    1. 이때, 물품이 등록될 때 추가한 비밀번호를 첨부해야 한다.
```
### 💛 중고 물품 댓글
```
1. 등록된 물품에 대한 질문을 위하여 댓글을 등록할 수 있다. 
    1. 이때 반드시 포함되어야 하는 내용은 대상 물품, 댓글 내용, 작성자이다.
    2. 또한 댓글을 등록할 때, 비밀번호 항목을 추가해서 등록한다.
2. 등록된 댓글은 누구든지 열람할 수 있다. 
    1. 페이지 단위 조회가 가능하다.
3. 등록된 댓글은 수정이 가능하다. 
    1. 이때, 댓글이 등록될 때 추가한 비밀번호를 첨부해야 한다.
4. 등록된 댓글은 삭제가 가능하다. 
    1. 이때, 댓글이 등록될 때 추가한 비밀번호를 첨부해야 한다.
5. 댓글에는 초기에 비워져 있는 답글 항목이 존재한다. 
    1. 만약 댓글이 등록된 대상 물품을 등록한 사람일 경우, 물품을 등록할 때 사용한 비밀번호를 첨부할 경우 답글 항목을 수정할 수 있다.
    2. 답글은 댓글에 포함된 공개 정보이다.
```
### 💚 구매 제안
```
1. 등록된 물품에 대하여 구매 제안을 등록할 수 있다. 
    1. 이때 반드시 포함되어야 하는 내용은 대상 물품, 제안 가격, 작성자이다.
    2. 또한 구매 제안을 등록할 때, 비밀번호 항목을 추가해서 등록한다.
    3. 구매 제안이 등록될 때, 제안의 상태는 제안 상태가 된다.
2. 구매 제안은 대상 물품의 주인과 등록한 사용자만 조회할 수 있다.
    1. 대상 물품의 주인은, 대상 물품을 등록할 때 사용한 작성자와 비밀번호를 첨부해야 한다. 이때 물품에 등록된 모든 구매 제안이 확인 가능하다. 페이지 기능을 지원한다.
    2. 등록한 사용자는, 조회를 위해서 자신이 사용한 작성자와 비밀번호를 첨부해야 한다. 이때 자신이 등록한 구매 제안만 확인이 가능하다. 페이지 기능을 지원한다.
3. 등록된 제안은 수정이 가능하다. 
    1. 이때, 제안이 등록될때 추가한 작성자와 비밀번호를 첨부해야 한다.
4. 등록된 제안은 삭제가 가능하다. 
    1. 이때, 제안이 등록될때 추가한 작성자와 비밀번호를 첨부해야 한다.
5. 대상 물품의 주인은 구매 제안을 수락할 수 있다. 
    1. 이를 위해서 제안의 대상 물품을 등록할 때 사용한 작성자와 비밀번호를 첨부해야 한다.
    2. 이때 구매 제안의 상태는 수락이 된다.
6. 대상 물품의 주인은 구매 제안을 거절할 수 있다. 
    1. 이를 위해서 제안의 대상 물품을 등록할 때 사용한 작성자와 비밀번호를 첨부해야 한다.
    2. 이때 구매 제안의 상태는 거절이 된다.
7. 구매 제안을 등록한 사용자는, 자신이 등록한 제안이 수락 상태일 경우, 구매 확정을 할 수 있다. 
    1. 이를 위해서 제안을 등록할 때 사용한 작성자와 비밀번호를 첨부해야 한다.
    2. 이때 구매 제안의 상태는 확정 상태가 된다.
    3. 구매 제안이 확정될 경우, 대상 물품의 상태는 판매 완료가 된다.
    4. 구매 제안이 확정될 경우, 확정되지 않은 다른 구매 제안의 상태는 모두 거절이 된다.
```
<br>

## 💻 프로젝트 진행 상황
### ❤ 중고 물품 관리
> **23.06.29**  
> - 기본 CRUD(물품 등록, 물품 조회(전체/단일), 물품 정보 수정, 물품 정보 삭제) + 물품 이미지 등록 구현
> - 물품 등록 : 반드시 포함되어야 하는 정보에 대해 Jakarta Bean Validation API를 사용하여 비어있지 않도록 사용자의 입력 유효성 검증
> - 물품 이미지 등록 : 이미지 파일명 설정 및 id별 이미지 관리 폴더 추가

> **23.07.03**  
> - 물품 등록 : 유효성 검증 오류 메시지 기본값 변경
> - 물품 정보 수정 시 수정 항목 변경 : writer, password는 수정 X
> - 물품 정보 수정, 삭제, 이미지 등록 : 유효성 검증 조건 변경 (password 검증 -> writer + password 검증)

> **23.07.04**  
> - ResponseBody에 원하는 메시지만 반환되게끔 RuntimeException클래스를 상속받아 각각의 클래스를 구현하는 방법으로 예외 처리 구현
<br>

### 💛 중고 물품 댓글
> **23.07.03**
> - 게시글의 댓글에 대한 기본 CRUD(댓글 등록, 댓글 조회, 댓글 수정, 댓글 삭제) 구현
> - 게시글 작성자의 댓글에 대한 답글 등록(수정) 구현
> - 댓글 등록 : 반드시 포함되어야 하는 정보에 대해 Jakarta Bean Validation API를 사용하여 비어있지 않도록 사용자의 입력 유효성 검증

> **23.07.04**  
> - ResponseBody에 원하는 메시지만 반환되게끔 RuntimeException클래스를 상속받아 각각의 클래스를 구현하는 방법으로 예외 처리 구현
<br>

### 💚 구매 제안
> **23.07.03**
> - 구매 제안 등록 기능 구현
> - 구매 제안 등록 : 반드시 포함되어야 하는 정보에 대해 Jakarta Bean Validation API를 사용하여 비어있지 않도록 사용자의 입력 유효성 검증

> **23.07.04**
> - 구매 제안에 대한 RUD(제안 조회, 제안 수정, 제안 삭제) 구현
> - 구매 제안 조회 : 판매자(물품 등록자)의 경우, DTO의 writer, password 비교 후 repository에서 비교할 건 없기 때문에 Page<> findAllByItemId() 메소드를 만들어서 조회
> - 구매 제안 조회 : 구매자(구매 제안자)의 경우, DTO의 writer, password를 비교하고 repository에서도 itemId, writer, password가 일치하는 레코드만 조회해야 하기 때문에 Page<> findAllByItemIdAndWriterAndPassword() 메소드를 만들어서 조회
> - 구매 제안 수정 : 제안 확정 기능과 구분 - [구매 제안의 status가 "제안"일 때 && DTO의 status가 null일 때] 조건을 추가하여 제안 수정인 경우를 특정 (status가 "제안"일 경우 구매 확정 불가)
> - 구매 제안 수정 : @Data 어노테이션을 사용하지 않고 Getter / Setter 수동으로 써주는 방법으로 DTO의 status(null)를 받음
> - 구매 제안 확정 : 제안 수정 기능과 구분 - [구매 제안의 status가 "수락"일 때] 조건을 추가하여 구매 확정인 경우를 특정
> - 구매 제안 확정 : List<> findAllByItemId() 메소드를 만들어서 해당 itemId의 status가 "확정"이 아닌 레코드의 status를 모두 "거절"로 변경
> - 구매 제안 수락/거절 : DTO의 status를 그대로 받아 status에 저장
> - ResponseBody에 원하는 메시지만 반환되게끔 RuntimeException클래스를 상속받아 각각의 클래스를 구현하는 방법으로 예외 처리 구현

> **23.07.05**
> - 구매 제안 수락/거절 : 이미 확정/거절/수락된 구매 제안에 대해 구매 제안 수락/거절 불가능하도록 변경
> - 구매 제안 등록 : 이미 판매 완료된 물품에 대해 구매 제안 등록 불가능하도록 변경
<br>

### 😁 프로젝트 완성 23.07.05
<br>

## ⭕ ♻️멋사마켓♻️ 동작 예시
### ❤ 중고 물품 관리
- #### 물품 등록 (POST /items)
Request
 ```json
 {
    "title": "중고 맥북 팝니다",
    "description": "2019년 맥북 프로 13인치 모델입니다",
    "minPriceWanted": 1000000,
    "writer": "jeeho.dev",
    "password": "1qaz2wsx"
}
 ```    
Response
```json
{
    "message": "등록이 완료되었습니다."
}
```
- #### 물품 조회 (전체) (GET /items?page={page}&limit={limit})
Query Params   
page = 0   
limit = 20   
<br>
Response
```json
{
    "content": [
        {
            "id": 1,
            "title": "중고 맥북 팝니다",
            "description": "2019년 맥북 프로 13인치 모델입니다",
            "minPriceWanted": 1000000,
            "imageUrl": null,
            "status": "판매중"
        },
        {
            "id": 2,
            "title": "중고 맥북 팝니다2",
            "description": "2019년 맥북 프로 13인치 모델입니다",
            "minPriceWanted": 1000000,
            "imageUrl": null,
            "status": "판매중"
        },
        {
            "id": 3,
            "title": "중고 맥북 팝니다3",
            "description": "2019년 맥북 프로 13인치 모델입니다",
            "minPriceWanted": 1000000,
            "imageUrl": null,
            "status": "판매중"
        }
    ],
    "pageable": {
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 3,
    "size": 20,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 3,
    "empty": false
}
```
- #### 물품 조회 (단일) (GET /items/{itemId})
Request -> X   
Response
```json
{
    "title": "중고 맥북 팝니다",
    "description": "2019년 맥북 프로 13인치 모델입니다",
    "minPriceWanted": 1000000,
    "status": "판매중"
}
```
- #### 물품 정보 수정 (PUT /items/{itemId})
Request
```json
{
    "title": "중고 맥북 안팝니다",
    "description": "2019년 맥북 프로 13인치 모델입니다",
    "minPriceWanted": 1000000,
    "writer": "jeeho.dev",
    "password": "1qaz2wsx"
}
```
Response
```json
{
    "message": "물품이 수정되었습니다."
}
```
- #### 물품 이미지 등록 (PUT /items/{itemId}/image)
Request  
image = notebook.jpg    
writer = jeeho.dev    
password = 1qaz2wsx     
<br>
Response
```json
{
    "message": "이미지가 등록되었습니다."
}
```
- #### 물품 정보 삭제 (DELETE /items/{itemId})
Request
```json
{
    "writer": "jeeho.dev",
    "password": "1qaz2wsx"
}
```
Response
```json
{
    "message": "물품을 삭제했습니다."
}
```
<br>

### 💛 중고 물품 댓글
- #### 댓글 등록 (POST /items/{itemId}/comments)
Request
```json
{
    "writer": "jeeho.edu",
    "password": "qwerty1234",
    "content": "할인 가능하신가요?"
}
```
Response
```json
{
    "message": "댓글이 등록되었습니다."
}
```
- #### 댓글 조회 (GET /items/{itemId}/comments)
Request -> X   
Response
```json
{
    "content": [
        {
            "id": 1,
            "content": "할인 가능하신가요?",
            "reply": null
        }
    ],
    "pageable": {
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "pageSize": 25,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "last": true,
    "totalElements": 1,
    "totalPages": 1,
    "size": 25,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}
```
- #### 댓글 수정 (PUT /items/{itemId}/comments/{commentId})
Request
```json
{
    "writer": "jeeho.edu",
    "password": "qwerty1234",
    "content": "할인 가능하신가요? 1000000 정도면 고려 가능합니다"
}
```
Response
```json
{
    "message": "댓글이 수정되었습니다."
}
```
- #### 댓글 삭제 (DELETE /items/{itemId}/comments/{commentId})
Request
```json
{
    "writer": "jeeho.edu",
    "password": "qwerty1234"
}
```
Response
```json
{
    "message": "댓글을 삭제했습니다."
}
```
- #### 답글 작성 (PUT /items/{itemId}/comments/{commentId}/reply)
Request
```json
{
    "writer": "jeeho.dev",
    "password": "1qaz2wsx",
    "reply": "안됩니다"
}
```
Response
```json
{
    "message": "댓글에 답변이 추가되었습니다."
}
```
<br>

### 💚 구매 제안
- #### 구매 제안 등록 (POST /items/{itemId}/proposals)
Request
```json
{
    "writer": "jeeho.edu",
    "password": "qwerty1234",
    "suggestedPrice": 1000000
}
```
Response
```json
{
    "message": "구매 제안이 등록되었습니다."
}
```
- #### 구매 제안 조회 (제안자) (GET /items/{itemId}/proposals?writer=jeeho.edu&password=qwerty1234&page=0)
Request -> X  
Response
```json
{
    "content": [
        {
            "id": 1,
            "suggestedPrice": 1000000,
            "status": "제안"
        },
        {
            "id": 2,
            "suggestedPrice": 1100000,
            "status": "제안"
        },
        {
            "id": 3,
            "suggestedPrice": 1200000,
            "status": "제안"
        }
    ],
    "pageable": {
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "pageSize": 25,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "last": true,
    "totalElements": 3,
    "totalPages": 1,
    "size": 25,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 3,
    "empty": false
}
```
- #### 구매 제안 조회 (판매자) (GET /items/{itemId}/proposals?writer=jeeho.dev&password=1qaz2wsx&page=0)
Request -> X   
Response
```json
{
    "content": [
        {
            "id": 1,
            "suggestedPrice": 1000000,
            "status": "제안"
        },
        {
            "id": 2,
            "suggestedPrice": 1100000,
            "status": "제안"
        },
        {
            "id": 3,
            "suggestedPrice": 1200000,
            "status": "제안"
        },
        {
            "id": 4,
            "suggestedPrice": 1200000,
            "status": "제안"
        }
    ],
    "pageable": {
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "pageSize": 25,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "last": true,
    "totalElements": 4,
    "totalPages": 1,
    "size": 25,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 4,
    "empty": false
}
```
- #### 구매 제안 수정 (PUT /items/{itemId}/proposals/{proposalId})
Request
```json
{
    "writer": "jeeho.edu",
    "password": "qwerty1234",
    "suggestedPrice": 1100000
}
```
Response
```json
{
    "message": "제안이 수정되었습니다."
}
```
- #### 구매 제안 삭제 (DELETE /items/{itemId}/proposals/{proposalId})
Request
```json
{
    "writer": "jeeho.edu",
    "password": "qwerty1234"
}
```
Response
```json
{
    "message": "제안을 삭제했습니다."
}
```
- #### 구매 제안 수락/거절 (PUT /items/{itemId}/proposals/{proposalId})
Request
```json
{
    "writer": "jeeho.dev",
    "password": "1qaz2wsx",
    "status": "수락"
}
```
또는
```json
{
    "writer": "jeeho.dev",
    "password": "1qaz2wsx",
    "status": "거절"
}
```
Response
```json
{
    "message": "제안의 상태가 변경되었습니다."
}
```
- #### 구매 제안 확정 (PUT /items/{itemId}/proposals/{proposalId})
Request
```json
{
    "writer": "jeeho.edu",
    "password": "qwerty1234",
    "status": "확정"
}
```
Response
```json
{
    "message": "구매가 확정되었습니다."
}
```
<br>

## ❌ ♻️멋사마켓♻️ 동작 오류 예시
- #### 존재하지 않는 물품 번호 입력
Response
```json
{
    "message": "해당 물품을 찾을 수 없습니다."
}
```
- #### 존재하지 않는 댓글 번호 입력
Response
```json
{
    "message": "해당 댓글을 찾을 수 없습니다."
}
```
- #### 존재하지 않는 구매 제안 번호 입력
Response
```json
{
    "message": "해당 구매 제안을 찾을 수 없습니다."
}
```
- #### 이미지 업로드 오류
Response
```json
{
    "message": "이미지 업로드 과정에서 오류가 발생했습니다."
}
```
- #### 이미지 업로드 오류
Response
```json
{
    "message": "이미지 업로드 과정에서 오류가 발생했습니다."
}
```
- #### 작성자 또는 비밀번호 불일치
Response
```json
{
    "message": "작성자와 비밀번호를 확인해주세요."
}
```
- #### 구매 제안의 상태가 "수락"이 아닐 때 확정 변경 시도 || 구매 제안의 상태가 "제안"이 아닐 때 제안 변경 시도 || 구매 제안의 상태가 "제안"이 아닐 때 수락 시도
Response
```json
{
    "message": "구매 제안 상태를 확인해주세요."
}
```
- #### 판매 완료된 물품에 대해 구매 제안 시도
Response
```json
{
    "message": "이미 판매 완료된 물품입니다."
}
```
