--★★★★★★★★★★★★★★ Hibernate 結合調査用★★★★★★★★★★★★★★★★★
insert into TEST_CHILD(C_ID1,C_ID2,NAME) values (1, 1, 'CHILD_1_1');
insert into TEST_CHILD(C_ID1,C_ID2,NAME) values (1, 2, 'CHILD_1_2');
insert into TEST_PARENT(P_ID,C_ID1,C_ID2) values (1, 1, 1);
insert into TEST_PARENT(P_ID,C_ID1,C_ID2) values (2, 1, 2);
insert into TEST_PARENT(P_ID,C_ID1,C_ID2) values (3, 1, null);
--★★★★★★★★★★★★★★ Hibernate 結合調査用★★★★★★★★★★★★★★★★★

-- オフィスマスタ
insert into OFFICE(OFFICE_NO, OFFICE_NAME) values ('001', '関西事業部');

-- エクセルテンプレート
insert into EXCEL_TEMPLATE(FILENAME,KINTAI_MONTH_FROM,KINTAI_MONTH_TO) values ('sjiw130_13{MONTH}_{BUSYOCD}_{EMPNO}_{EMPNAME}.xls', '201304', '999999');

-- 部署マスタ
insert into DEPT(DEPT_NO,DEPT_NAME,DEPT_NAME_FURI_KANA) values ('633330','関西ソリューション部','かんさいそりゅーしょんぶ');

-- 休暇マスタ
insert into KYUKA(NO,NAME) values ('01', '有給(全休)');
insert into KYUKA(NO,NAME) values ('02', '有給(午前)');
insert into KYUKA(NO,NAME) values ('03', '有給(午後)');
insert into KYUKA(NO,NAME) values ('04', '欠勤');
insert into KYUKA(NO,NAME) values ('05', '健康診断');
insert into KYUKA(NO,NAME) values ('06', '無給休暇');
insert into KYUKA(NO,NAME) values ('07', '振休');
insert into KYUKA(NO,NAME) values ('08', '代休');
insert into KYUKA(NO,NAME) values ('09', '特別休暇');
insert into KYUKA(NO,NAME) values ('10', '結婚・忌引・配出産');
insert into KYUKA(NO,NAME) values ('11', 'SP5');
insert into KYUKA(NO,NAME) values ('12', 'その他特休');
insert into KYUKA(NO,NAME) values ('13', '積立休暇');
insert into KYUKA(NO,NAME) values ('14', '休業');
insert into KYUKA(NO,NAME) values ('15', '教育訓練');

-- 権限マスタ
insert into AUTH(AUTHORITY) values ('ROLE_ADMIN');
insert into AUTH(AUTHORITY) values ('ROLE_STAFF');

-- 社員マスタ
insert into EMP(EMP_NO,EMP_NAME_LAST,EMP_NAME_FIRST,EMP_NAME_LAST_FURI_KANA,EMP_NAME_FIRST_FURI_KANA,PASSWORD,DEPT_NO,ENABLED,ACCOUNT_NON_EXPIRED,ACCOUNT_NON_LOCKED,CREDENTIALS_NON_EXPIRED,OFFICE_NO) values ( '00924', '溝口','一徳','みぞぐち','かづのり', '1234', '633330', true, true, true, true, '001');

-- 社員権限
insert into EMP_AUTH(EMP_NO,AUTHORITY) values ( '00924', 'ROLE_STAFF');

-- ｼﾌﾄ
--insert into SHIFT(EMP_NO,KINTAI_MONTH,SHIFT_NO,START_TIME,END_TIME,HANKYU_KBN,REST1_START,REST1_END,REST2_START,REST2_END,REST3_START,REST3_END,REST4_START,REST4_END,REST5_START,REST5_END,REST6_START,REST6_END) values ('00924','201305', '1', '09:00', '17:45','12:00','13:00','17:45','18:00','19:30','20:00','22:00','22:15','26:30','27:00','32:30','33:00');
--insert into SHIFT(EMP_NO,KINTAI_MONTH,SHIFT_NO,START_TIME,END_TIME,HANKYU_KBN,REST1_START,REST1_END,REST2_START,REST2_END,REST3_START,REST3_END,REST4_START,REST4_END,REST5_START,REST5_END,REST6_START,REST6_END) values ('00924','201305', '2', '09:00', '17:45','12:00','13:00','17:45','18:00','19:30','20:00','22:00','22:15','26:30','27:00','32:30','33:00');

-- ｼﾌﾄ　コピー用
insert into SHIFT_DEFAULT(SHIFT_NO,START_TIME,END_TIME,TYOUKA,DAY_HOURS,HANKYU_KBN,REST1_START,REST1_END,REST2_START,REST2_END,REST3_START,REST3_END,REST4_START,REST4_END,REST5_START,REST5_END,REST6_START,REST6_END) values ('1', '09:00', '17:45',0,7.4,'','12:00','13:00','17:45','18:00','19:30','20:00','22:00','22:15','26:30','27:00','32:30','33:00');

-- ﾌﾟﾛｼﾞｪｸﾄマスタ
insert into PROJECT(EMP_NO,PROJECT_NO,PROJECT_NAME) values ('00924','5V-69313104-012','アイフル保守4月');
insert into PROJECT(EMP_NO,PROJECT_NO,PROJECT_NAME) values ('00924','5V-69313104-013','アイフル保守5月');

-- 作業マスタ
insert into SAGYO(SAGYO_CD,SAGYO_NAME) values ('Z0100', '全体会議');
insert into SAGYO(SAGYO_CD,SAGYO_NAME) values ('L', '保守');

-- KINTAI テーブル
--insert into KINTAI(EMP_NO,KINTAI_DATE,KINTAI_MONTH,START_TIME,END_TIME,SHIFT_NO) values ( '00924', '20130401', '201304', '09:00', '17:45','1');


