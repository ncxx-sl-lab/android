<?php

require_once 'DbManager.php';
class DaoRank extends Zend_Db_Table_Abstract {
	protected $_name = 'RANK';
	protected $_primary = array('RANK');
	function __construct($db = null) {
		if ($db == null) {
			$db = DbManager::getConnection();
		}
		parent::__construct(array('db'=>$db));
	}
}
