// Copyright (C) 2013 ＣＴＣ伊藤忠テクノソリューションズ（株） All rights reserved
package jp.co.ctc_g.common;

import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author z1j7663
 * @version 1.0.0
 *
 */
public class HtmlEscapeObjectMapperFactory extends CharacterEscapes {

	/** エスケープ文字列 */
	private final int[] asciiEscapes;

	/**
	 * コンストラクタ
	 */
	public HtmlEscapeObjectMapperFactory() {
		// start with set of characters known to require escaping (double-quote, backslash etc)
		int[] esc = CharacterEscapes.standardAsciiEscapesForJSON();
		// and force escaping of a few others:
		esc['<'] = CharacterEscapes.ESCAPE_STANDARD;
		esc['>'] = CharacterEscapes.ESCAPE_STANDARD;
		esc['&'] = CharacterEscapes.ESCAPE_STANDARD;
		esc['\''] = CharacterEscapes.ESCAPE_STANDARD;
		asciiEscapes = esc;
	}

	@Override
	public int[] getEscapeCodesForAscii() {
		return asciiEscapes;
	}

	@Override
	public SerializableString getEscapeSequence(int arg0) {
		return null;
	}

	/**
	 * XSS対策したObjectMapperを生成する
	 * @return ObjectMapper
	 */
	public static ObjectMapper createObjectMapper() {
		ObjectMapper om = new ObjectMapper();
		om.getJsonFactory().setCharacterEscapes(new HtmlEscapeObjectMapperFactory());
		return om;
	}

}
