<?php

require_once 'DbManager.php';
class DaoKintai extends Zend_Db_Table_Abstract {
	protected $_name = 'KINTAI';
	protected $_primary = array('EMP_NO','K_DATE');

	function __construct($db = null) {
		if ($db == null) {
			$db = DbManager::getConnection();
		}
		parent::__construct(array('db'=>$db));
	}
}
