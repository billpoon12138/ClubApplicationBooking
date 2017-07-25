<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
	
	$(function() {
		  $('#staticParent').on('keydown', '#phone', function(e){-1!==$.inArray(e.keyCode,[46,8,9,27,13,110,190])||/65|67|86|88/.test(e.keyCode)&&(!0===e.ctrlKey||!0===e.metaKey)||35<=e.keyCode&&40>=e.keyCode||(e.shiftKey||48>e.keyCode||57<e.keyCode)&&(96>e.keyCode||105<e.keyCode)&&e.preventDefault()});
		})
	
	$("#phone").keypress(function (e) {
	    if (String.fromCharCode(e.keyCode).match(/[^0-9]/g)) return false;
	});
	
	function checkPasswordMatch() {
	    var password = $("#password").val();
	    var confirmPassword = $("#rePassword").val();

	    if (password != confirmPassword)
	        $("#divCheckPasswordMatch").html("Passwords do not match!");
	    else
	        $("#divCheckPasswordMatch").html("Passwords match.");
	}
	
	var specialKeys = new Array();
  specialKeys.push(8); //Backspace
  function IsNumeric(e) {
      var keyCode = e.which ? e.which : e.keyCode
      var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
      document.getElementById("error").style.display = ret ? "none" : "inline";
      return ret;
  }  
</script>
<style>
.list{
	margin-left:37%;
	top:80px;
}
</style>
<div class="list">
<h1>Edit Member page</h1>
<form:form method="POST" commandName="member"
	action="${pageContext.request.contextPath}/member/edit/${member.userID}.html">
	<table>
		<tbody>
			<tr>
				<td>MemberName:</td>
				<td><form:input path="memberName" /></td>
			</tr>
			<tr>
				<td>NRIC Number:</td>
				<td><form:input path="nricNo" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" id="password" 
						name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{5,}"
						title="Password must contain at least 6 characters, including Uppercase,lowercase and numbers."
						type="password" /></td>
			</tr>
			<tr>
				<td>Re Password:</td>
				<td><form:input path="rePassword" id="rePassword"
						name="rePassword" onkeyup="checkPasswordMatch();"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{5,}"
						title="Please enter the same Password as above." type="password" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><form:select path="gender">
						<form:option value="Female">Female</form:option>
						<form:option value="Male">Male</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>JoinDate :</td>
				<td><form:input path="joinDate" type="text" id="datepicker" /></td>
			</tr>
			<tr>
				<td>Phone Number:</td>
				<td><div id="staticParent">
						<form:input path="phone" />
					</div></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" type="email" id="email" name="email" /></td>
			</tr>
			<tr>
				<td>Remarks:</td>
				<td><form:input path="remarks" type="textarea" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Upate" class="btn"/></td>
			</tr>
		</tbody>
	</table>
</form:form>
</div>