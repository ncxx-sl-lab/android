<?php

require_once 'DbManager.php';
class DaoSagyo extends Zend_Db_Table_Abstract {
	protected $_name = 'SAGYO';
	protected $_primary = 'SAGYO_CD';

	function __construct($db = null) {
		if ($db == null) {
			$db = DbManager::getConnection();
		}
		parent::__construct(array('db'=>$db));
	}
}
