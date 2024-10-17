 ### 프로젝트 명	 
JSP 쇼핑몰 

### 수행기간	
2024년 7월 4일 ~ 2024년 7월 11일

### 수행인원	 
본인 1인

### 프로젝트 목표/소개	
이 프로젝트는 JSP, JDBC, Oracle을 기반으로 쇼핑몰의 기본 기능을 구현하는 것을 목표로 했습니다. 

쇼핑몰 운영의 핵심 기능을 이해하고 개발하는 과정에서 회원 관리(회원가입, 로그인, 정보 수정, 탈퇴)와 

상품 관리(상품 등록, 수정, 삭제, 목록 표시, 장바구니) 기능을 구현했습니다. 

이를 통해 데이터베이스 연동 및 웹 애플리케이션 개발의 기초를 다지는 데 중점을 두었습니다.

### 개발환경 (사용도구/언어)	
Spring Tool Suite 3, Java, JSP, JDBC
Visual Studio Code, JavaScript, HTML5, CSS3
Oracle SQL Developer, Oracle

### 담당역할	 
설계, 구현


### 수행 결과물

![login](https://github.com/user-attachments/assets/8a735426-fc95-4610-93dd-43eb3dd52dae)

![account_update](https://github.com/user-attachments/assets/9cbb6d00-d9b8-4ba9-99b1-3d4131fe0b34)

![mypage(normal_user)](https://github.com/user-attachments/assets/d45cde6c-416e-47fe-8952-14a21f35dc91)

![mypage(admin)](https://github.com/user-attachments/assets/e88dc083-40f6-4a61-b317-ca537244376f)

![product_list](https://github.com/user-attachments/assets/37233522-84d8-4e1d-aa9c-6d1084c24be2)

![product_detail](https://github.com/user-attachments/assets/3f43f122-5da8-4e25-ae65-de672ea4d21c)

![cart](https://github.com/user-attachments/assets/e006e623-08e4-4030-b595-0b0807d5dca5)


##### 로그인 : 
입력한 값이 데이터베이스의 값과 일치하면 해당 정보로 로그인

##### 회원가입 : 
입력한 값을 데이터베이스에 저장

##### 회원정보 수정 : 
로그인 한 회원의 데이터베이스 정보를 수정

##### 마이페이지 : 
회원정보 수정,  로그아웃, 상품목록 페이지로 이동 할 수 있으며,  관리자(admin)는 상품 등록 페이지로 이동 할 수 있음

##### 상품 목록 : 
관리자(admin)가 등록해둔 상품들을 보여줌

##### 상품 상세 정보 : 
해당 상품의 상세 정보를 보여줌

##### 장바구니 : 
상품 상세정보에서 장바구니 담기하면 세션에 저장하고 세션의 목록을 보여줌

##### 상품 등록 : 
관리자(admin)가 상품을 등록함 


### 프로젝트 후기
##### 어려웠던 점과 해결 과정:
 회원탈퇴 기능을 구현할 때, 데이터베이스에서 계정 정보를 삭제한 후에도 로그인 된 상태가 유지되는 문제가 있었습니다. 
 
 회원 정보가 삭제되었지만, 세션에 남아 있는 로그인 정보가 계속 유효해서 사용자가 탈퇴 후에도 사이트에 로그인 된 상태로 머물러 있었습니다. 
 
 이를 해결하기 위해 회원탈퇴 시 세션을 강제로 무효화(invalidate)하도록 처리했습니다. 
 
 탈퇴가 완료된 후 세션 정보를 삭제하여 탈퇴 즉시 사용자가 더 이상 로그인 상태로 남아 있지 않도록 했습니다. 
 
 이러한 조치를 통해 로그아웃 처리와 회원탈퇴 기능의 구현을 완료할 수 있었습니다.
 
