<?php
require_once 'dao/DaoEmp.php';

abstract class RestControllerAbs extends Zend_Rest_Controller
{
    public function init()
    {
		#$empno = $this->_getParam("EMP_NO");
		#$passwd = $this->_getParam("PASSWD");
		$empno = "00000";
		$passwd = "test";
		$emptyValidate = new Zend_Validate_NotEmpty();
		if (!$emptyValidate->isValid($empno) || !$emptyValidate->isValid($passwd)) {
			throw new Exception("Unauthorized",401);
		}
		$passwd_sha256 = hash_hmac('sha256', $passwd, false);
		$dao = new DaoEmp();
		$sel = $dao->select();
		$sel->where("EMP_NO = ?", $empno)
			->where("PASSWD = ?", $passwd_sha256);
			#->where("PASSWD = ?", $passwd);
			#->where("PASSWD = ?", $passwd_sha256);
		$row = $dao->fetchRow($sel);
		if ($row == null) {
			throw new Exception("Unauthorized",401);
		}
		Zend_Registry::set('emp',$row);
    }
}
