package controller;

import action.Action;
import action.MemberCheckidAction;
import action.MemberJoinAction;
import action.MemberLeaveAction;
import action.MemberLoginAction;
import action.MemberModifyAction;

public class MemberActionFactory {
	private static MemberActionFactory factory;
	
	private MemberActionFactory() {}
	
	public static MemberActionFactory getInstance() {
		if(factory == null) {
			factory = new MemberActionFactory();
		}
		return factory;
	}
	
	public Action action(String cmd) {
		Action action = null;
		if(cmd.equals("/join.do")) {
			action = new MemberJoinAction("view/loginForm.jsp");
		}else if(cmd.equals("/login.do")){
			action = new MemberLoginAction("view/loginForm.jsp");
		}else if(cmd.equals("/leave.do")) {
			action = new MemberLeaveAction("view/loginForm.jsp");
		}else if(cmd.equals("/modify.do")) {
			action = new MemberModifyAction("view/loginForm.jsp");
		}else if(cmd.equals("/modifyLogin.do")){
			action = new MemberLoginAction("modify.do");
		}else if(cmd.equals("/checkId.do")) {
			action = new MemberCheckidAction("view/checkId.jsp");
		}
		return action;
	}
}
