# selenide-example
Selenideを使ったテストコードとWebページのサンプルです。  
チェックアウト後、以下の手順を行ってテストコードを実行してください。  

1. 以下からテストするブラウザに対応するWebDriverをダウンロードし、プロジェクト直下に配置する  
http://www.seleniumhq.org/download/
2. Eclipseのメニューから`Run`→`Run Configuration...`を選択し`JUnit`→`samplecode`を選択
3. `Arguments`タブを選択し、`VM arguments`の`-Dselenide.baseUrl`の`C:/workspace/`の部分をチェックアウトしたワークスペースのパスに修正する
4. `samplecode`実行構成を実行する
