package jp.co.ctc_g.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import jp.co.ctc_g.business.domain.ErrorMessage;
import jp.co.ctc_g.business.domain.Syain;
import jp.co.ctc_g.business.service.SyainService;
import jp.co.ctc_g.presentation.controller.common.DhtmlXGridForm;
import jp.co.ctc_g.presentation.controller.common.Grids;
import jp.co.ctc_g.presentation.controller.common.JqGridForm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value="/entry/*")
public class EntryController {

    /**
     * ログ.
     */
    private static final Log LOG = LogFactory.getLog(EntryController.class);
 
	@RequestMapping(value="/entry/init", method=RequestMethod.GET)
	public String initSyain(Model model) {
		
		return "entry.show";
	}


}
