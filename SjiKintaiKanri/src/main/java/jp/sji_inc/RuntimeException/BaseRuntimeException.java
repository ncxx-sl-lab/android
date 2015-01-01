/**
 *
 */
package jp.sji_inc.RuntimeException;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author z1j7663
 *
 */
public class BaseRuntimeException extends RuntimeException {

	/** BindingResultエラーメッセージ */
	private ErrorForm errors = new ErrorForm();

	/**
	 * コンストラクタ
	 */
	public BaseRuntimeException() {}

	/**
	 * コンストラクタ
	 * @param result エラー
	 */
	public BaseRuntimeException(BindingResult result) {
		List<FieldError> allErrors = result.getFieldErrors();
		List<ErrorMessage> errors = this.errors.getErrors();
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
		MessageSource messageSource = (MessageSource) wac.getBean("messageSource");
		Locale locale = LocaleContextHolder.getLocale();
		for (FieldError objectError : allErrors) {
			StringBuffer sb = new StringBuffer();
			sb.append(objectError.getObjectName()).append(".").append(objectError.getField());
			String fileName = messageSource.getMessage(sb.toString(), null, locale);
			errors.add(new ErrorMessage(objectError.getField(), fileName, objectError.getDefaultMessage()));
		}
	}

	/**
	 * @return errors
	 */
	public ErrorForm getErrors() {
		return errors;
	}

	/**
	 * @param errors セットする errors
	 */
	public void setErrors(ErrorForm errors) {
		this.errors = errors;
	}

}
