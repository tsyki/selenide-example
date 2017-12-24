package samplecode;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import com.codeborne.selenide.SelenideElement;

/**
 * シンプルな要素取得の検証サンプルコード
 */
public class SimpleSelectorTest {

	@Test
	public void selectorTest() {
		open("/input.html");
		
		SelenideElement byIdElem =  $(byId("value1"));
		byIdElem.val("1").should(value("1"));
		
		SelenideElement byStyleElem =  $(byClassName("ui-input"));
		byStyleElem.val("2").should(value("2"));
		
		SelenideElement byAttrElem=  $(byAttribute("type","text"));
		byAttrElem.val("3").should(value("3"));
	}
	
}
