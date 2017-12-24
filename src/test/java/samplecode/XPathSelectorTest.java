package samplecode;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import com.codeborne.selenide.SelenideElement;

/**
 * XPathを使った要素取得のサンプルコード
 */
public class XPathSelectorTest {

	@Test
	public void selectorTest() {
		open("/structSelector.html");
		// IDがemployeeCode1である要素を取得(タグ名は任意)
		SelenideElement cssSelectorElem =  $(byXpath("//*[@id=\"employeeCode1\"]"));
		cssSelectorElem.val("1").should(value("1"));
		
		// 「editable-table」というスタイル名を持ったtableタグの中で最初のtdタグの中のinput要素を取得
		SelenideElement cssSelectorElem2=  $(byXpath("//table[@class=\"editable-table\"]//td[1]/input"));
		cssSelectorElem2.val("2").should(value("2"));

		// 「employeeTable」というIDを持ったtableタグの中で、typeが「text」である最初のinput要素を取得
		SelenideElement cssSelectorElem4=  $(byXpath("//table[@id=\"employeeTable\"]//input[@type=\"text\"][1]"));
		cssSelectorElem4.val("4").should(value("4"));
	}
	
}
