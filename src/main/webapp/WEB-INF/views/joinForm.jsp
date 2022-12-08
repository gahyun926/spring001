<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
      <form id="inputForm" action="joinAction" method="post">
         <table border="1">
            <tr>
               <td>아이디</td>
               <td><input type="text" id="mid" name="mid" "></td>
            </tr>
            <tr>
               <td>비밀번호</td>
               <td><input type="password" id="pass" name="pass""></td>
            </tr>
            <tr>
               <td>회원성명</td>
               <td><input type="text" id="name" name="name"></td>
            </tr>
            <tr>
               <td colspan="2"><center><input type="submit" value="등록" > <input type="button" value="조회"></center></td>
            </tr>
         </table>
      </form>
	
</body>
</html>