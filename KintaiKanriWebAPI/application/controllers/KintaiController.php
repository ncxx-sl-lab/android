<?php

require_once 'RestControllerAbs.php';
require_once 'dao/DbManager.php';
require_once 'dao/DaoKintai.php';

class KintaiController extends RestControllerAbs
{

	/**
	 * (non-PHPdoc)
	 * @see application/controllers/ControllerAbs::init()
	 */
	public function init(){
	
		parent::init();
		$contextSwitch = $this->_helper->getHelper('contextSwitch');
		$contextSwitch->addActionContext('index', 'json')
				->addActionContext('index', 'xml')
				->addActionContext('post', 'xml')
				->addActionContext('post', 'json')
				->initContext();
	}
	
	public function indexAction()
	{
		$this->getResponse()
		->setHttpResponseCode(200);
		Zend_Registry::get('log')->info("indexAction start");
		return;
		if ($this->getRequest()->getQuery('KINTAI_DATE') != null) {
			$this->serviceGetDate($this->getRequest()->getQuery('KINTAI_DATE'));
		} else {
			throw new Exception("Bad Request", 400);
		}
	}
	
	public function getAction() 
	{
		//$this->view->employee = $row;
		//$this->view->req = $empno;
	}

	public function postAction()
	{
		$this->getResponse()
		->setHttpResponseCode(200);
		Zend_Registry::get('log')->info("postAction start");
		
		$obj = null;
		$contentType = $this->getRequest()->getHeader('Content-Type');
		if ($contentType == 'application/xml') {
			$obj = simplexml_load_string($this->getRequest()->getRawBody());
		} else if ($contentType == 'application/json') {
			$obj = json_decode($this->getRequest()->getRawBody());
		}
		
		$db = DbManager::getConnection();
		try {
			$db->beginTransaction();
			$dao = new DaoKintai($db);
			foreach($obj as $row) {
				$emp_no = $row->{'EMP_NO'};
				$sel = $dao->select();
				$sel->where('EMP_NO = ?', $row->{'EMP_NO'})
					->where('K_DATE = ?', $row->{'K_DATE'});
				$row2 = $dao->fetchRow($sel);
				if ($row2 == null) {
					$row2 = $dao->createRow();
					$row2->{'INS_DATE'} = new Zend_Db_Expr('now()');
					$row2->{'PJ_CD'} = $row->{'A'};
				} else {
					$row2->{'PJ_CD'} = $row->{'U'};
				}
				$row2->{'EMP_NO'} = $row->{'EMP_NO'};
				$row2->{'K_DATE'} = $row->{'K_DATE'};
				if ($row->{'S_TIME'} != "") {
					$row2->{'S_TIME'} = $row->{'S_TIME'};
				}
				if ($row->{'E_TIME'} != "") {
					$row2->{'E_TIME'} = $row->{'E_TIME'};
				}
				if ($row->{'PJ_CD'} != "") {
					$row2->{'PJ_CD'} = $row->{'PJ_CD'};
				}
				if ($row->{'UPD_KBN'} != "") {
					$row2->{'UPD_KBN'} = $row->{'UPD_KBN'};
				}
				if ($row->{'UPD_USER'} != "") {
					$row2->{'UPD_USER'} = $row->{'UPD_USER'};
				}
				$row2->{'UPD_DATE'} = new Zend_Db_Expr('now()');
				$row2->save();
			}
			$db->commit();
		} catch (Exception $e) {
			$db->rollBack();
			Zend_Registry::get('log')->info($e->getMessage());
			throw $e;
		}
		
		Zend_Registry::get('log')->info("postAction end");
		
	}
	
	public function putAction()
	{
		$this->getResponse()
		->setHttpResponseCode(200);
		#$row = Zend_Registry::get('emp');

		#$dao = new DaoKintai();
		
		#$obj->{'EMP_NO'} = "00002";
		#$this->view->EMP = $obj;
		
	}
	
	public function deleteAction()
	{
		$this->getResponse()
		->setHttpResponseCode(200)
		->appendBody('deleteAction has been called');
		
	}
	
	private function serviceGetDate($date) {
		Zend_Registry::get('log')->info("serviceGetDate start");
		try {
			$dao = new DaoSagyo();
			$sel = $dao->select();
			$sel->where("K_DATE = ?", $date);
			Zend_Registry::get('log')->info($sel->__toString());
			$rows = $dao->fetchAll($sel);
			$this->view->SAGYO_LIST = $rows->toArray();
			
		} catch (Exception $e) {
			Zend_Registry::get('log')->info($e->getMessage());
		}
		Zend_Registry::get('log')->info("serviceGetDate end");
	}
	
}

