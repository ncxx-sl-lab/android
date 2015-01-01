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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/syain/*")
public class SyainController {

    /**
     * ログ.
     */
    private static final Log LOG = LogFactory.getLog(SyainController.class);

    @Autowired
	private MessageSource messageSource ;

    @Autowired
	private SyainService syainService;

//    @Autowired
//    private SyainValidator syainValidator;

	@RequestMapping(value="/syain/init", method=RequestMethod.GET)
	public String initSyain(Model model) {

		SyainForm formBean = new SyainForm();

		formBean.setBushoList(syainService.getBushoList());
		formBean.setGroupList(syainService.getGroupList());
		formBean.setKengenList(syainService.getKengenList());
		formBean.setDelList(syainService.getDelList());
		formBean.setOtlList(syainService.getOtlList());

		model.addAttribute("syainForm", formBean);

		return "syain.show";
	}

	 @SuppressWarnings("unchecked")
	@RequestMapping(value="/syain/list", method=RequestMethod.POST)
	 @ResponseBody
	 public Object listSyain(SyainForm formBean) {

		JqGridForm form = new JqGridForm();

		Syain syain = new Syain();
		syain.setSyainNo(formBean.getSerSyainNo());
		syain.setSyainName(formBean.getSerSyainName());
		syain.setBushoCd(formBean.getSerBusho());
		syain.setGroupCd(formBean.getSerGroup());
		syain.setKengenCd(formBean.getSerKengen());
		syain.setDelFlg(formBean.getSerDel());
		syain.setOtlFlg(formBean.getSerOtl());
		@SuppressWarnings("rawtypes")
		List rows = syainService.getSyainLst(syain);
		form.setTotal(1);
		form.setPage(1);
		form.setRecords(rows.size());
		form.setRows((List<Object>)rows);
		List<Object> ftmp = form.getRows();
//		for (Object s : ftmp ) System.out.println("name = " + ((Syain)s).getSyainName());

		return form;

	 }

	 @RequestMapping(value="/syain/list2", method=RequestMethod.POST)
	 @ResponseBody
	 public DhtmlXGridForm listSyain2(SyainForm formBean) {

		Syain syain = new Syain();
		syain.setSyainNo(formBean.getSerSyainNo());
		syain.setSyainName(formBean.getSerSyainName());
		syain.setBushoCd(formBean.getSerBusho());
		syain.setGroupCd(formBean.getSerGroup());
		syain.setKengenCd(formBean.getSerKengen());
		syain.setDelFlg(formBean.getSerDel());
		syain.setOtlFlg(formBean.getSerOtl());
		List<Syain> syainList= syainService.getSyainLst(syain);

		DhtmlXGridForm beanForm = new DhtmlXGridForm();
		beanForm.setRows(Grids.toArray(syainList, "selValue","syainNo", "syainName", "bushoName", "groupName", "kengenName", "delFlg", "otlFlg"));

		return beanForm;

	 }

	 @RequestMapping(value="/syain/info", method=RequestMethod.POST)
	 @ResponseBody
	 public SyainForm infoSyain(SyainForm formBean) {

		 Syain syain = syainService.getSyainInfo(formBean.getSyainNo());
		 formBean.setSyainName(syain.getSyainName());
		 formBean.setPassword(syain.getPassword());
		 formBean.setBushoCode(syain.getBushoCd());
		 formBean.setGroupCode(syain.getGroupCd());
		 formBean.setKengenCode(syain.getKengenCd());
		 formBean.setDelFlg(syain.getDelFlg());
		 formBean.setOtlFlg(syain.getOtlFlg());

		 return formBean;

	 }


	@RequestMapping(value="/syain/ent",method=RequestMethod.POST)
	@ResponseBody
	public SyainForm entrySyain(@Valid SyainForm formBean,BindingResult result) {

		formBean.setValErrFlag(false);
    	formBean.setValErrMsgList(null);

    	if(result.hasErrors()){
    		//エラーメッセージをセット
        	formBean.setValErrFlag(true);
			List<FieldError> allErrors = result.getFieldErrors();
			List<ErrorMessage> errorMesages = new ArrayList<ErrorMessage>();
			for (FieldError objectError : allErrors) {
				errorMesages.add(new ErrorMessage(objectError.getField(), objectError.getDefaultMessage()));
			}
			formBean.setValErrMsgList(errorMesages);
            return formBean;
        }

		return formBean;
	}

}
