package samplecode;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

/**
 * �v�Z�y�[�W�̃e�X�g
 */
public class SampleTestByPageObject {

	@Test
	public void ayncTestNotDuplicate() {
		Configuration.browser = WebDriverRunner.CHROME;
		Configuration.baseUrl = "http://localhost:8080";
		CalcPage calcPage = open("/maeyes_UIS/calc.html", CalcPage.class);
		// ���l����
		calcPage.value1Text().val("1");
		calcPage.value2Text().val("2");
		// ���Z�{�^������
		calcPage.add();
		// �A�T�[�g
		calcPage.result().should(value("3"));
	}
	

}
