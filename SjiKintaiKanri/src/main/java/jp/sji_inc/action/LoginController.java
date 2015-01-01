/**
 *
 */
package jp.sji_inc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author z1j7663
 *
 */
@Controller
public class LoginController {

	/**
	 * ログイン
	 * @return 遷移先
	 */
	@RequestMapping(value = "/login")
	public String login() {
		return "login/login";
	}


}
