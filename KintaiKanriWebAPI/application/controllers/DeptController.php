<?php

require_once 'RestControllerAbs.php';
require_once 'dao/DaoDept.php';

class DeptController extends RestControllerAbs
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
		
		if ($this->getRequest()->getQuery('DATE') != null) {
			$this->serviceGetDate($this->getRequest()->getQuery('DATE'));
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
	
	private function serviceGetDate($date) {
		Zend_Registry::get('log')->info("serviceGetDate start");
		try {
			$dao = new DaoDept();
			$sel = $dao->select();
			$sel->where("S_DATE <= ?", $date)
				->where("E_DATE > ?", $date);
			Zend_Registry::get('log')->info($sel->__toString());
			$rows = $dao->fetchAll($sel);
			$this->view->DEPT_LIST = $rows->toArray();
			
		} catch (Exception $e) {
			Zend_Registry::get('log')->info($e->getMessage());
		}
		Zend_Registry::get('log')->info("serviceGetDate end");
	}
	
}

