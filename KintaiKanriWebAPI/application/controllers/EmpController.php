<?php

require_once 'RestControllerAbs.php';
require_once 'dao/DaoEmp.php';

class EmpController extends RestControllerAbs
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
		$row = Zend_Registry::get('emp');
		$this->view->EMP = $row->toArray();
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
		#$row = Zend_Registry::get('emp');
		$obj = null;
		$contentType = $this->getRequest()->getHeader('Content-Type');
		if ($contentType == 'application/xml') {
	 		$obj = simplexml_load_string($this->getRequest()->getRawBody());
		} else if ($contentType == 'application/json') {
			$obj = json_decode($this->getRequest()->getRawBody());
		}
		$obj->{'EMP_NO'} = "00002";
		$this->view->EMP = $obj;
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
	
}

