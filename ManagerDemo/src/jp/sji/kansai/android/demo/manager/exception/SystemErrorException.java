package jp.sji.kansai.android.demo.manager.exception;

/**
 * システムエラー発生時にスローする例外クラス
 */
public class SystemErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SystemErrorException() {
		super();
	}

	public SystemErrorException(String message) {
		super(message);
	}

	public SystemErrorException(Throwable th) {
		super(th);
	}

	public SystemErrorException(String message, Throwable th) {
		super(message, th);
	}
}
