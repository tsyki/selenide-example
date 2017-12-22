package samplecode;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

/**
 * �v�Z�y�[�W�̃e�X�g
 */
public class SampleTest {

    @Test
	public void addTest() {
		Configuration.browser = WebDriverRunner.CHROME;
		open("http://localhost:8080/calc.html");
		// ���l����
		SelenideElement val1Text = $(By.xpath("//input[@id='value1']"));
		val1Text.val("1");
		SelenideElement val2Text = $(By.xpath("//input[@id='value2']"));
		val2Text.val("2");
		// ���Z�{�^������
		$(byId("addButton")).click();
		// �A�T�[�g
		$(byId("result")).should(value("3"));
		// $(byId("result")).should(text("3"));
	}
	
	@Test
	public void addAsyncFastTest() {
		Configuration.browser = WebDriverRunner.CHROME;
		open("/calc.html");
		// ���l����
		SelenideElement val1Text = $(By.xpath("//input[@id='value1']"));
		val1Text.val("1");
		SelenideElement val2Text = $(By.xpath("//input[@id='value2']"));
		val2Text.val("2");
		// ���Z�{�^������
		$(byId("addAsyncFastButton")).click();
		// �A�T�[�g
		$(byId("result")).should(value("3"));
		// $(byId("result")).should(text("3"));
	}

	@Test
	public void addAsyncSlowTest() {
		Configuration.browser = WebDriverRunner.CHROME;
		open("/calc.html");
		// ���l����
		SelenideElement val1Text = $(By.xpath("//input[@id='value1']"));
		val1Text.val("1");
		SelenideElement val2Text = $(By.xpath("//input[@id='value2']"));
		val2Text.val("2");
		// ���Z�{�^������
		$(byId("addAsyncSlowButton")).click();
		// �A�T�[�g
		$(byId("result")).waitUntil(value("3"),6000);
		// $(byId("result")).should(value("3"));
		// $(byId("result")).should(text("3"));
	}
}
