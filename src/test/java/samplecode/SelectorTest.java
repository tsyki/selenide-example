package samplecode;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import com.codeborne.selenide.SelenideElement;

/**
 * 要素取得の検証
 */
public class SelectorTest {

	@Test
	public void getByIdTest() {
		open("/calc.html");
		SelenideElement val1TextByXpath = $("form div input");
		val1TextByXpath.val("1");
		SelenideElement val2TextById = $(byId("value2"));
		val2TextById.val("2");
		// 加算ボタン押下
		$(byId("addButton")).click();
		// アサート
		$(byId("result")).should(value("3"));
	}
	
	@Test
	public void getByIdTest2() {
		open("/calc.html");
		SelenideElement val1Text = $$(".input-area .ui-input").first();
		val1Text.val("1");
		SelenideElement val2Text = $("#value2");
		val2Text.val("2");
		// 加算ボタン押下
		$(byId("addButton")).click();
		// アサート
		$(byId("result")).should(value("3"));
	}
}
