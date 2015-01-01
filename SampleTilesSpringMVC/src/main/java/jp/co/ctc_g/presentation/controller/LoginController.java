// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author z1j7663
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	/**
	 *
	 * @return 画面遷移先
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String show() {
		return "/login/login";
	}
}
