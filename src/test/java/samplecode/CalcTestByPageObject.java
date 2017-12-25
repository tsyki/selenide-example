package samplecode;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;
 
/**
 * PageObjectを使った計算ページのテスト
 */
public class CalcTestByPageObject {

	@Test
	public void ayncTestNotDuplicate() {
		CalcPage calcPage = open("/calc.html", CalcPage.class);
		// 数値入力
		calcPage.value1Text().val("1");
		calcPage.value2Text().val("2");
		// 加算ボタン押下
		calcPage.add();
		// アサート
		calcPage.result().should(value("3"));
	}

}
