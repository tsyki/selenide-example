package samplecode;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class CalcPage {
	private SelenideElement value1Text = $(byId("value1"));
	private SelenideElement value2Text = $(byId("value2"));
	private SelenideElement addButton = $(byId("addButton"));
	private SelenideElement result = $(byId("result"));

	public SelenideElement value1Text() {
		return value1Text;
	} 

	public SelenideElement value2Text() {
		return value2Text;
	}

	public void add() {
		addButton.click();
	}

	public SelenideElement result() {
		return result;
	}
}
