package controller;

import action.Action;
import action.ProdAddAction;
import action.ProdListAction;

public class ProdActionFactory {
	private static ProdActionFactory baf;
	
	private ProdActionFactory() {}
	public static ProdActionFactory getInstance() {
		if(baf==null) {
			baf = new ProdActionFactory();
		}
		return baf;
	}
	
	public Action action(String cmd) {
		Action action = null;
		
		if(cmd.equals("/insert.do")) {
			action = new ProdAddAction("list.do");
		}else if(cmd.equals("/list.do")) {
			action = new ProdListAction("product_list.jsp");
		}
		
		return action;
	}
}
