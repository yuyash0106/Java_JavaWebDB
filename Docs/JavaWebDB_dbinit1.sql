-- NI22 JavaWebDB Lesson サポートファイル
--
-- DB、ユーザ作成SQLファイル
-- rootユーザで使用
-- コマンド: mysql -u root --default-character-set=utf8 -p < "C:\…\JavaWebDB_dbinit1.sql"
--
-- @author Shinzo SAITO

-- DB作成
CREATE DATABASE javawebdb CHARACTER SET utf8;

-- ユーザ作成(権限付与)
GRANT ALL PRIVILEGES ON javawebdb.* TO scott@localhost IDENTIFIED BY 'tiger' WITH GRANT OPTION;

