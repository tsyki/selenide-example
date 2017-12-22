package samplecode;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

/**
 * �e�핔�i�y�[�W�̃e�X�g
 */
public class WidgetTest {

	@Test
	public void comboTest() {
		Configuration.browser = WebDriverRunner.CHROME;
		open("http://localhost:8080/widgets.html");
		// �R���{�I��
		SelenideElement val1Combo = $(byId("value1Combo"));
		val1Combo.selectOptionByValue("2"); // �l�őI��
		SelenideElement val2Combo = $(byId("value2Combo"));
		val2Combo.selectOption("�l2"); // ���x���őI��
		// ���Z�{�^������
		$(byId("addComboButton")).click();
		// �A�T�[�g
		$(byId("result")).should(value("4"));
	}
	
	@Test
	public void radioTest() {
		Configuration.browser = WebDriverRunner.CHROME;
		open("http://localhost:8080/widgets.html");
		// ���W�I�I��
		$(byName("value1")).selectRadio("2");
		// selectRadio(byName("value1"), "2"); // deprecated
		getSelectedRadio(byName("value1")).should(value("2"));
		
		$(byName("value2")).selectRadio("1");
		// selectRadio(byName("value2"), "1"); // deprecated
		getSelectedRadio(byName("value2")).should(value("1"));
		// ���Z�{�^������
		$(byId("addRadioButton")).click();
		// �A�T�[�g
		$(byId("result")).should(value("3"));
	}
}
