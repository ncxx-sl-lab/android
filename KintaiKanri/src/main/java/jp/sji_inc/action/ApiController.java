/**
 *
 */
package jp.sji_inc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kyon
 *
 */
@Controller
@RequestMapping(value = "/api")
public class ApiController {

	/**
	 * 初期表示
	 * @return 遷移先
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String show() {
		return "api.show";
	}

}
