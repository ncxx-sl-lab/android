package jp.sji.kansai.demo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.sji.kansai.demo.constants.AppConstants;
import jp.sji.kansai.demo.exception.ApiException;
import jp.sji.kansai.demo.form.BaseApiForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * APIの基底アクションクラス
 *
 * @author teraoka
 */
abstract public class BaseApiAction extends Action {

	private static final long serialVersionUID = 1L;

	/**
	 * APIの処理を実行する。
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		BaseApiForm baseForm = (BaseApiForm) form;
		baseForm.setResultCode(AppConstants.RESULT_CODE_SUCCESS);
		baseForm.setResultMessage("正常終了しました。");

		try {
			process(baseForm, request);
		} catch (ApiException ex) {
			baseForm.setResultCode(ex.getResultCode());
			baseForm.setResultMessage(ex.getResultMessage());
		} catch (Exception ex) {
			baseForm.setResultCode(AppConstants.RESULT_CODE_SYSTEM_ERROR);
			baseForm.setResultMessage("予期せぬエラーが発生しました。");
			ex.printStackTrace();
		}
		return mapping.findForward("xml");
	}

	abstract public void process(BaseApiForm form, HttpServletRequest request) throws Exception;
}
