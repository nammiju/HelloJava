<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="border-end bg-white" id="sidebar-wrapper">
   <div class="sidebar-heading border-bottom bg-light">
   <c:choose>
   		<c:when test="${sessionScope.id != null}">
   			<p>${sessionScope.id }</p>
   		</c:when>
   		<c:otherwise>
   			GUEST
   		</c:otherwise>
   </c:choose>
   </div>
   <div class="list-group list-group-flush">
       <a class="list-group-item list-group-item-action list-group-item-light p-3" href="bulletin.do">❤ B O A R D</a>
       <a class="list-group-item list-group-item-action list-group-item-light p-3" href="writeBoardForm.do">🧡 W R I T E</a>
       <a class="list-group-item list-group-item-action list-group-item-light p-3" href="signUpForm.do">💛 S I G N - U P</a>
       <a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberList.do">💚 M E M B E R L I S T</a>
       <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a>
       <a class="list-group-item list-group-item-action list-group-item-light p-3" href="signInForm.do">🤍 L O G I N</a>
       <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logOut.do">🖤 L O G O U T</a>
   </div>
</div>