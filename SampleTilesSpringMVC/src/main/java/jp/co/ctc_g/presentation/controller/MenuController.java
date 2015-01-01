package jp.co.ctc_g.presentation.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value="/menu/*")
public class MenuController {

    /**
     * ログ.
     */
    private static final Log LOG = LogFactory.getLog(MenuController.class);
 
	@RequestMapping(value="/menu/{menuId}",method=RequestMethod.GET)
	public String showSyain(Model model,@PathVariable String menuId) {
		
		model.addAttribute("selMenu", menuId);

		return "forward:/" + menuId + "/init";
	}
	

}
