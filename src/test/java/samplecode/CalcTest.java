package samplecode;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

/**
 * 計算ページのテスト(非同期実行含む)
 */
public class CalcTest {

	@Test
	public void addTest() {
		// 1. テスト対象のURLを開く
		open("/calc.html");
		// 2. テスト対象の要素(ボタンやテキストボックスなど)を取得する
		// 3. テスト対象の要素に対し操作(クリックやキー入力)を行う
		// テキストボックスに値入力
		$("#value1").val("1");
		$("#value2").val("2");
		// 加算ボタン押下(同期実行)
		$(byId("addButton")).click();
		// 4. 操作結果のアサーションを行う
		$(byId("result")).should(value("3"));
	}
 
	@Test
	public void addAsyncFastTest() {
		// 1. テスト対象のURLを開く
		open("/calc.html");
		// 2. テスト対象の要素(ボタンやテキストボックスなど)を取得する
		// 3. テスト対象の要素に対し操作(クリックやキー入力)を行う
		// テキストボックスに値入力
		$("#value1").val("1");
		$("#value2").val("2");
		// 加算ボタン押下(非同期実行_4秒以内)
		$(byId("addAsyncFastButton")).click();
		// 4. 操作結果のアサーションを行う
		$(byId("result")).should(value("3"));
	}

	@Test
	public void addAsyncSlowTest() {
		// 1. テスト対象のURLを開く
		open("/calc.html");
		// 2. テスト対象の要素(ボタンやテキストボックスなど)を取得する
		// 3. テスト対象の要素に対し操作(クリックやキー入力)を行う
		// テキストボックスに値入力
		$("#value1").val("1");
		$("#value2").val("2");
		// 加算ボタン押下(非同期実行_5秒かかる処理)
		$(byId("addAsyncSlowButton")).click();
		// アサート(余裕を持って6秒待つ)
		$(byId("result")).waitUntil(value("3"), 6000);
	}

	@Test(expected = AssertionError.class)
	public void addAsyncSlowTestFail() {
		// 1. テスト対象のURLを開く
		open("/calc.html");
		// 2. テスト対象の要素(ボタンやテキストボックスなど)を取得する
		// 3. テスト対象の要素に対し操作(クリックやキー入力)を行う
		// テキストボックスに値入力
		$("#value1").val("1");
		$("#value2").val("2");
		// 加算ボタン押下(非同期実行_4秒以上かかる処理)
		$(byId("addAsyncSlowButton")).click();
		// アサート。デフォルトのタイムアウト待ち時間4秒ではここでエラーとなる
		$(byId("result")).should(value("3"));
	}
}
