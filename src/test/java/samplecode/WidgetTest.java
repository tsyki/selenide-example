package samplecode;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getSelectedRadio;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import com.codeborne.selenide.SelenideElement;

/**
 * 各種部品ページのテスト
 */
public class WidgetTest {

	@Test
	public void comboTest() {
		open("/widgets.html");
		// コンボ選択
		SelenideElement val1Combo = $(byId("value1Combo"));
		val1Combo.selectOptionByValue("2"); // 値で選択
		SelenideElement val2Combo = $(byId("value2Combo"));
		val2Combo.selectOption("値2"); // ラベルで選択
		// 加算ボタン押下
		$(byId("addComboButton")).click();
		// アサート
		$(byId("result")).should(value("4"));
	}

	@Test
	public void radioTest() {
		open("/widgets.html");
		// ラジオ選択
		$(byName("value1")).selectRadio("2");
		getSelectedRadio(byName("value1")).should(value("2"));

		$(byName("value2")).selectRadio("1");
		getSelectedRadio(byName("value2")).should(value("1"));
		// 加算ボタン押下
		$(byId("addRadioButton")).click();
		// アサート
		$(byId("result")).should(value("3"));
	}
}
