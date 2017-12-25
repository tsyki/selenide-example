package samplecode;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import com.codeborne.selenide.SelenideElement;

/**
 * CSSセレクタを使った要素取得のサンプルコード
 */
public class CSSSelectorTest {

	@Test
	public void selectorTest() {
		open("/structSelector.html");

		// IDがemployeeCode1である要素を取得
		SelenideElement cssSelectorElem = $("#employeeCode1");
		cssSelectorElem.val("1").should(value("1"));

		// 「editable-table」というスタイル名を持ったtableタグの中で最初のtdタグの中のinput要素を取得
		SelenideElement cssSelectorElem2 = $("table.editable-table td:first-child input");
		cssSelectorElem2.val("2").should(value("2"));

		// 「editable-table」というスタイル名を持ったtableタグの中で最初のtdタグの中のinput要素を取得
		SelenideElement cssSelectorElem3 = $("table.editable-table td:nth-child(1) input");
		cssSelectorElem3.val("3").should(value("3"));

		// 「employeeTable」というIDを持ったtableタグの中で、typeが「text」である最初のinput要素を取得
		SelenideElement cssSelectorElem4 = $("table#employeeTable input[type=\"text\"]:first-child");
		cssSelectorElem4.val("4").should(value("4"));
	}

}
