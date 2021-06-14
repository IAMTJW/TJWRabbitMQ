package com.tianjunwei.limit;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	public static final String IDCARD = "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65)[0-9]{4})"
			+ "(([1|2][0-9]{3}[0|1][0-9][0-3][0-9][0-9]{3}" + "[Xx0-9])|([0-9]{2}[0|1][0-9][0-3][0-9][0-9]{3}))";

	public static final String IS_URL = "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+#$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$";

	/**
	 * @see #isNumeric(String)
 	 */
	static final Pattern ISNUMERIC_PATTERN = Pattern.compile("[0-9]*");

	/**
	 * @see #isNumeric2(String)
	 */
	static final Pattern ISNUMERIC2_PATTERN = Pattern.compile("[\\-]?[0-9]*");

	/**
	 * @see #isMobilePhone(String)
	 */
	static final Pattern ISMOBILEPHONE_PATTERN = Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$");



	// 判断是否为正整数
	public static boolean isNumeric(String str) {
		if (!isEmpty(str)) {
			return false;
		}
		Matcher isNum = ISNUMERIC_PATTERN.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	// 判断是否为整数
	public static boolean isNumeric2(String str) {
		if (!isEmpty(str)) {
			return false;
		}
		Matcher isNum = ISNUMERIC2_PATTERN.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	// 判断字符串是否为空
	public static boolean isEmpty(String str) {
		if (str != null && !"".equals(str) && !"null".equals(str)) {
			return true;
		}
		return false;
	}

	// 判断图片的url数组是否为空，strs.leng必须为3，否则直接返回false
	public static boolean isEmpty(String[] strs) {
		if (strs != null) {
			if (strs.length == 3) {
				if (isEmpty(strs[0]) && isEmpty(strs[1]) && isEmpty(strs[2])) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// 判断是否为浮点型
	public static boolean isFloat(String str) {
		return str.matches("[\\d]+\\.[\\d]+");
	}

	// 判断是否为HH:MM:SS的时间类型
	public static boolean isTime(String str) {
		boolean isSuccess = false;
		try {
			Time.valueOf(str);
			isSuccess = true;
		} catch (Exception e) {
			isSuccess = false;
		}
		return isSuccess;
	}

	// 判断身份证号码
	public static boolean isCard(String str) {
		if (!isEmpty(str)) {
			return false;
		}
		Pattern idNumPattern = Pattern.compile(IDCARD);
		// 通过Pattern获得Matcher
		Matcher idNumMatcher = idNumPattern.matcher(str);
		return idNumMatcher.matches();
	}

	// 验证是不是手机号
	public static boolean isMobilePhone(String phone) {//
		if (!isEmpty(phone)) {
			return false;
		}
		Matcher matcher = ISMOBILEPHONE_PATTERN.matcher(phone);
		return matcher.matches();
	}

	/**
	 * 校验银行卡卡号
	 * 
	 * @param cardId
	 * @return
	 */
	public static boolean checkBankCard(String cardId) {
		if (!RegexUtil.isEmpty(cardId)) {
			return false;
		}
		char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
		if (bit == 'N') {
			return false;
		}
		return cardId.charAt(cardId.length() - 1) == bit;
	}

	/**
	 * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
	 * 
	 * @param nonCheckCodeCardId
	 * @return
	 */
	public static char getBankCardCheckCode(String nonCheckCodeCardId) {
		if (nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
				|| !nonCheckCodeCardId.matches("\\d+")) {
			// 如果传的不是数据返回N
			return 'N';
		}
		char[] chs = nonCheckCodeCardId.trim().toCharArray();
		int luhmSum = 0;
		for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
			int k = chs[i] - '0';
			if (j % 2 == 0) {
				k *= 2;
				k = k / 10 + k % 10;
			}
			luhmSum += k;
		}
		return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
	}

	// 判断是否为6为数字
	public static boolean isNumberLength6(String str) {
		if (!isEmpty(str)) {
			return false;
		}
		return str.matches("\\d{6}$");
	}

	/**
	 * 密码校验
	 * 
	 * @param password
	 * @return
	 */
	public static boolean isQualifiedPwd(String password) {
		if (password.length() <= 20 && password.length() >= 6) {
			boolean isDigit = false;// 定义一个boolean值，用来表示是否包含数字
			boolean isLetter = false;// 定义一个boolean值，用来表示是否包含字母
			boolean isConSpe = false;// 是否包含特殊字符
			for (int i = 0; i < password.length(); i++) {
				if (Character.isDigit(password.charAt(i))) { // 用char包装类中的判断数字的方法判断每一个字符
					isDigit = true;
				}
				if (Character.isLetter(password.charAt(i))) { // 用char包装类中的判断字母的方法判断每一个字符
					isLetter = true;
				}
			}
			if (password.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() == 0) {
				// 不包含特殊字符
				isConSpe = false;
			} else {
				isConSpe = true;
			}
			if ((isDigit && isLetter) || (isDigit && isConSpe) || (isLetter && isConSpe)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static List<Integer> checkNumbers(String str) {
		if (!isEmpty(str)) {
			return null;
		}
		if(!str.startsWith("[")||!str.endsWith("]")){
			return null;
		}
		List<Integer> list = new ArrayList<>();
		str = str.replace("[", "");
		String str1 = str.replace("]", "");
		String[] array = str1.split(",");
		boolean isNumber = true;
		for (String string : array) {
			if (!isNumeric(string)) {
				isNumber = false;
				break;
			}else{
				list.add(Integer.valueOf(string));
			}
		}
		if (isNumber) {
			return list;
		} else {
			return null;
		}
	}
	
	public static List<String> checkStrings(String str){
		if (!isEmpty(str)) {
			return null;
		}
		List<String> list = new ArrayList<>();
		String[] array = str.split(",");
		for(int i=0;i<array.length;i++){
			list.add(array[i]);
		}
		return list;
	}

	public static boolean intInArray(int num, int[] arrayInt){
		for(int i : arrayInt){
			if(i == num){
				return true;
			}
		}
		return false;
	}
	public static boolean stringInArray(String num, String[] arrayString){
		for(String i : arrayString){
			if(i.equals(num)){
				return true;
			}
		}
		return false;
	}
	// 判断是URL
	public static boolean isUrl(String str) {
		if (!isEmpty(str)) {
			return false;
		}
		Pattern idUrlPattern = Pattern.compile(IS_URL);
		// 通过Pattern获得Matcher
		Matcher idNumMatcher = idUrlPattern.matcher(str);
		return idNumMatcher.matches();
	}

	public static void main(String[] args) {
		System.out.println(isUrl("sds"));
		;
	}

}
