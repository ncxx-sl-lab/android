<?php
#$Id: Bootstrap.php 209 2012-11-10 06:15:10Z mizoguchi $

class Bootstrap extends Zend_Application_Bootstrap_Bootstrap
{

	protected function _initRoutes()
	{
		$this->bootstrap('frontController');
		$frontController = Zend_Controller_Front::getInstance();
		$restRoute = new Zend_Rest_Route($frontController);
		$frontController->getRouter()->addRoute('default', $restRoute);
	}
	
	protected function _initLog()
	{
		$resource = $this->getPluginResource('log');
		$log = $resource->getLog();
		Zend_Registry::set('log', $log);
		return $log;
	}
}
