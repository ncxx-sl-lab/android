<?php
#$Id: DbManager.php 165 2012-07-23 17:44:05Z mizoguchi $

class DbManager {
	public static function getConnection() {
		$db = NULL;
		try {
			$config = new Zend_Config_Ini('../application/configs/database.ini','database');
			$db = Zend_Db::factory($config);
			$db->query('SET CHARACTER SET utf8');
			return $db;
		} catch (Zend_Exception $e) {
			die($e->getMessage());
		}
	}
}

