package jp.sji_inc.RuntimeException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class BadRequestException extends BaseRuntimeException {

	/**
	 * デフォルトコンストラクタ
	 */
	public BadRequestException(){}

	/**
	 * コンストラクタ
	 * @param result バリデーション結果
	 */
	public BadRequestException(BindingResult result) {
		super(result);
	}

}
