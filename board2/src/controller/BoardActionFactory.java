package controller;

import action.Action;
import action.BoardInsertAction;
import action.BoardListAction;

public class BoardActionFactory {
	private static BoardActionFactory baf;
	private BoardActionFactory() {}
	public static BoardActionFactory getInstance() {
		if(baf == null) {
			baf = new BoardActionFactory();
		}
		return baf;
	}
	
	public Action action(String cmd) {
		Action action = null;
		
		if(cmd.equals("/insert.do")) {
			action = new BoardInsertAction("list.do");
		}else if(cmd.equals("/list.do")){
			action = new BoardListAction("/view/qna_board_list.jsp");
		}
		
		return action;
	}
}
