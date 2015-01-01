<?php

require_once 'DbManager.php';
class DaoDept extends Zend_Db_Table_Abstract {
	protected $_name = 'DEPT';
	protected $_primary = 'DEPT_CD';

	function __construct($db = null) {
		if ($db == null) {
			$db = DbManager::getConnection();
		}
		parent::__construct(array('db'=>$db));
	}
}
