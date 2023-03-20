package example.controller;

import example.service.ButtonService;

public class Button1Controller {

	public String getResult() {
		
		//service를 이용해서 로직처리를 부탁!
		ButtonService service = new ButtonService();
		String result = service.clickButton();
		
		return result;
	}

}
