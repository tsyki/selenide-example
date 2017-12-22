package samplecode;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

/**
 * 要素取得の検証
 */
public class SelectorTest {

	@Test
	public void getByIdTest() {
		Configuration.browser = WebDriverRunner.CHROME;
		open("http://localhost:8080/calc.html");
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
		Configuration.browser = WebDriverRunner.CHROME;
		open("http://localhost:8080/calc.html");
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
