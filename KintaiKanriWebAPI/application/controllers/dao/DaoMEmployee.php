<?php
#$Id: DaoMEmployee.php 165 2012-07-23 17:44:05Z mizoguchi $

require_once 'DbManager.php';
class DaoMEmployee extends Zend_Db_Table_Abstract {
	protected $_name = 'M_EMPLOYEE';
	protected $_primary = array('EMPLOYEE_NO');
	function __construct($db = null) {
		if ($db == null) {
			$db = DbManager::getConnection();
		}
		parent::__construct(array('db'=>$db));
	}
}
