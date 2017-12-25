package samplecode;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.getSelectedRadio;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import com.codeborne.selenide.SelenideElement;

/**
 * ヒットする要素が複数ある場合のサンプルコード
 */
public class DuplicateTest {

	@Test
	public void singleSelectTest() {
		open("/duplicate.html");
		// テキストボックス入力
		$(".ui-input-text").val("2");
		$(".ui-input-text").should(value("2"));
		// コンボボックス入力
		$(".ui-input-combo").selectOptionByValue("2");
		$(".ui-input-combo").should(value("2"));
		// ラジオ選択
		$(".ui-input-radio").selectRadio("2");
		$(".ui-input-radio:checked").should(value("2"));
		getSelectedRadio(byCssSelector(".ui-input-radio")).should(value("2"));
	}

	@Test
	public void multiSelectTest() {
		open("/duplicate.html");
		// テキストボックス入力
		// スタイルが「.ui-input-text」である要素全てに「2」を設定(for-each版)
		for (SelenideElement elem : $$(".ui-input-text")) {
			elem.val("2");
		}
		// スタイルが「.ui-input-text」である要素全てに「2」を設定(ラムダ式利用版)
		$$(".ui-input-text").forEach(elem -> elem.val("2"));
		$$(".ui-input-text").forEach(elem -> elem.should(value("2")));
		// コンボボックス入力
		$$(".ui-input-combo").forEach(elem -> elem.selectOptionByValue("2"));
		$$(".ui-input-combo").forEach(elem -> elem.should(value("2")));
		// ラジオ選択
		$$(".ui-input-radio[value=\"2\"]").forEach(elem -> elem.click());
		$$(".ui-input-radio:checked").forEach(elem -> elem.should(value("2")));
	}
}
