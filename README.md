# Microservices Sample

## Description
MySQLのsakilaサンプルを利用して作成したAPIです。

## 利用技術
利用技術は以下の通りとなっています。

- git/github
- gradle
    - Java EEアプリケーション(warファイル)のビルド・テスト・パッケージング
    - Mavneリポジトリからのライブラリ自動ダウンロード
- Java EE8 - WildFlyを想定
    - JAX-RS(RESTEasy - WildFly)
    - JAXB(オブジェクトをJSON化する際に裏で利用)
    - JPA(EclipseLink)
    - [予定]Swagger for RESTEasy
- docker for Mac
    - MySQL - Dockerfileを利用してビルド。[sakila](https://dev.mysql.com/doc/sakila/en/)サンプルを初期イメージ作成時に作成する。
    - WildFly - Dockerfileを利用してビルド予定。