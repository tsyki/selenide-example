package samplecode;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import com.codeborne.selenide.SelenideElement;

/**
 * シンプルな要素取得の検証サンプルコード
 */
public class SimpleSelectorTest {

	@Test
	public void selectorTest() {
		open("/simpleSelector.html");
		
		// ID指定で取得
		SelenideElement byIdElem = $(byId("value1"));
		byIdElem.val("1").should(value("1"));
		
		// スタイル名指定で取得
		SelenideElement byStyleElem = $(byClassName("ui-input"));
		byStyleElem.val("2").should(value("2"));
		
		// 任意の属性の値指定で取得
		SelenideElement byAttrElem = $(byAttribute("type","text"));
		byAttrElem.val("3").should(value("3"));
		
		// valueの値指定で取得
		SelenideElement byValueElem = $(byValue("2"));
		byValueElem.should(text("値2"));
		
		// テキスト完全一致で取得
		SelenideElement byTextElem = $(byText("値1"));
		byTextElem.should(id("val1Label"));
		
		// テキスト部分一致で取得
		SelenideElement withTextElem = $(withText("値"));
		withTextElem.should(id("val1Label"));
	}
}
