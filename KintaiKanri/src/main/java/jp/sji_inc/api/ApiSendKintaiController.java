package jp.sji_inc.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/api/excel")
public class ApiSendKintaiController {

	@RequestMapping(value="/sendmail/{empNo}/{kintaiDate}", method=RequestMethod.GET)
	public String sendMail() {

		return null;
	}
}
