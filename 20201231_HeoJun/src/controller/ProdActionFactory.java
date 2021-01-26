package controller;

import Action.Action;
import Action.ProdAddAction;
import Action.ProdListAction;

public class ProdActionFactory {

	private static ProdActionFactory PAF;
	private ProdActionFactory(){};
	public static ProdActionFactory getInstance() {
		if (PAF == null) {
			PAF = new ProdActionFactory();
		}
		return PAF;
	}
	
	public Action action(String CMD) {
		Action action = null;
		
		if (CMD.equals("/insert.do")) {
			action = new ProdAddAction("list.do");
			
		} else if(CMD.equals("/list.do")){
			action = new ProdListAction("view/product_list.jsp");
		}		
		return action;
	}
}