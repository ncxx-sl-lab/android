package jp.sji_inc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpController {

	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String show() {
		return "rest/emp/show";
	}
}
