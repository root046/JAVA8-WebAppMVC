<%@ include file="include/header.jsp" %>

	<div class="container mtb">
		<div class="row">
			<div class="col-lg-6">
				<form action="${pageContext.request.contextPath}/operation" method="post">
						Username:<input type="text" name="username" value="${param.username }" required="required"/><br/>
						Email:<input type="email" name="email" value="${param.email }" required="required"/><br/>
						<input type="hidden" name="usersId" value="${param.usersId }"/>
						<input type="hidden" name="form" value="updateuserOperation"/><br/>
						<input type="submit" value="Update User"/>
				</form>
			
			</div>
		</div>	
	</div>
<%@include file="include/footer.jsp" %>