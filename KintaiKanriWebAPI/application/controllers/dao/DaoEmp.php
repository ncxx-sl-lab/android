<?php

require_once 'DbManager.php';
class DaoEmp extends Zend_Db_Table_Abstract {
	protected $_name = 'EMP';
	protected $_primary = array('EMP_NO');
	function __construct($db = null) {
		if ($db == null) {
			$db = DbManager::getConnection();
		}
		parent::__construct(array('db'=>$db));
	}
}
