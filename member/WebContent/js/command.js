/**
 * 버튼클릭
 */
$(function(){
	//logout 클릭시 logoutPro.jsp로 이동
	$("#modify").click(function(){
		
		location.href = 'modifyForm.jsp';
	});
	$("#logout").click(function(){
		
		location.href = 'logoutPro.jsp';
	});
	$("#leave").click(function(){
		
		location.href = 'leaveForm.jsp';
	});
	
})