<?php

require_once 'RestControllerAbs.php';
require_once 'dao/DaoShift.php';

class ShiftController extends RestControllerAbs
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
		
		if ($this->getRequest()->getQuery('SYORI_YM') != null) {
			$this->serviceGetDate($this->getRequest()->getQuery('SYORI_YM'));
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
	}
	
	public function putAction()
	{
		$this->getResponse()
		->setHttpResponseCode(200)
		->appendBody('putAction has been called');
		
	}
	
	public function deleteAction()
	{
		$this->getResponse()
		->setHttpResponseCode(200)
		->appendBody('deleteAction has been called');
		
	}
	
	private function serviceGetSyoriYm($date) {
		Zend_Registry::get('log')->info("serviceGetSyoriYm start");
		try {
			$dao = new DaoSagyo();
			$sel = $dao->select();
			$sel->where("SYORI_YM = ?", $date);
			Zend_Registry::get('log')->info($sel->__toString());
			$rows = $dao->fetchAll($sel);
			$this->view->SHIFT_LIST = $rows->toArray();
			
		} catch (Exception $e) {
			Zend_Registry::get('log')->info($e->getMessage());
		}
		Zend_Registry::get('log')->info("serviceGetSyoriYm end");
	}
	
}

