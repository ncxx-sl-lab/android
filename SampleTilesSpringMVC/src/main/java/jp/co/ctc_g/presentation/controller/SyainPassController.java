package jp.co.ctc_g.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import jp.co.ctc_g.business.domain.ErrorMessage;
import jp.co.ctc_g.business.domain.Syain;
import jp.co.ctc_g.business.service.SyainService;

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
@RequestMapping(value="/pass/*")
public class SyainPassController {

    /**
     * ログ.
     */
    private static final Log LOG = LogFactory.getLog(SyainPassController.class);
 
	@RequestMapping(value="/pass/init",method=RequestMethod.GET)
	public String initPass(Model model) {
		
//		SyainForm formBean = new SyainForm();
		
//		formBean.setBushoList(syainService.getBushoList());
//		formBean.setGroupList(syainService.getGroupList());
//		formBean.setKengenList(syainService.getKengenList());
//		formBean.setDelList(syainService.getDelList());
//		formBean.setOtlList(syainService.getOtlList());
		
//		model.addAttribute("syainForm", formBean);

		return "syain.pass";
	}
	

}
