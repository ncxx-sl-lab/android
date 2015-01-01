package jp.co.ctc_g.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import jp.co.ctc_g.business.domain.CmbBox;
import jp.co.ctc_g.business.domain.ErrorMessage;
import jp.co.ctc_g.presentation.validator.constraints.FieldCompare;
import jp.co.ctc_g.presentation.validator.constraints.NotBlankEx;

/**
 * 社員フォーム
 * @author z1sg0496
 *
 */
@FieldCompare(compareTo = "password", field = "confPassword")
public class SyainForm {
	
	private boolean vErrFlag = false;
    
	private List<ErrorMessage> vErrMsgList = null;

	private String serSyainNo;
	
	private String serSyainName;
	
	private String serBusho;
	
	private String serGroup;

	private String serKengen;

	private String serDel;

	private String serOtl;

    @NotBlankEx
	private String syainNo = "";
	
    @NotBlankEx
	private String syainName = "";
	
    @NotBlankEx
	private String bushoCode = "";
	
    @NotBlankEx
	private String groupCode = "";

    @NotBlankEx
	private String password = "";
	
	private String confPassword = "";
	
    @NotBlankEx
	private String kengenCode = "";
	
    @NotBlankEx
	private String delFlg = "";

    @NotBlankEx
	private String otlFlg = "";
    
    @AssertTrue(message = "{error.ngpassword}")
    public boolean isNgConfPassword(){
    	boolean bFlg = true;
    	if(this.confPassword.trim().length() > 0){
    		if(!this.confPassword.equals(this.password)){
    			bFlg = false;
    		}
    	}
    	return bFlg;
    }

	private List<CmbBox> bushoList = null;
	
	private List<CmbBox> groupList = null;
	
	private List<CmbBox> kengenList = null;
	
	private List<CmbBox> delList = null;
	
	private List<CmbBox> otlList = null;
	
	private List<Object> syainList = null; 
	
	public boolean isValErrFlag() {
		return vErrFlag;
	}

	public void setValErrFlag(boolean bValue) {
		this.vErrFlag = bValue;
	}
	
	public List<ErrorMessage> getValErrMsgList(){
		return vErrMsgList;
	}
	
	public void setValErrMsgList(List<ErrorMessage> listWk){
		this.vErrMsgList = listWk;
	}
	
	public void addValErrMsg(String errFld,String errMsg){
		if(vErrMsgList == null){
			vErrMsgList = new ArrayList<ErrorMessage>();
		}
		vErrMsgList.add(new ErrorMessage(errFld,errMsg));
	}

	public String getSerSyainNo() {
		return serSyainNo;
	}

	public void setSerSyainNo(String sValue) {
		this.serSyainNo = sValue;
	}
	
	public String getSerSyainName() {
		return serSyainName;
	}

	public void setSerSyainName(String sValue) {
		this.serSyainName = sValue;
	}
	
	public String getSerBusho() {
		return serBusho;
	}

	public void setSerBusho(String sValue) {
		this.serBusho = sValue;
	}
	
	public String getSerGroup() {
		return serGroup;
	}

	public void setSerGroup(String sValue) {
		this.serGroup = sValue;
	}
	
	public String getSerKengen() {
		return serKengen;
	}

	public void setSerKengen(String sValue) {
		this.serKengen = sValue;
	}
	
	public String getSerDel() {
		return serDel;
	}

	public void setSerDel(String sValue) {
		this.serDel = sValue;
	}
	
	public String getSerOtl() {
		return serOtl;
	}

	public void setSerOtl(String sValue) {
		this.serOtl = sValue;
	}
	
	public String getSyainNo() {
		return syainNo;
	}

	public void setSyainNo(String sValue) {
		this.syainNo = sValue;
	}
	
	public String getSyainName() {
		return syainName;
	}

	public void setSyainName(String sValue) {
		this.syainName = sValue;
	}
	
	public String getBushoCode() {
		return bushoCode;
	}

	public void setBushoCode(String sValue) {
		this.bushoCode = sValue;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String sValue) {
		this.groupCode = sValue;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String sValue) {
		this.password = sValue;
	}

	public String getConfPassword() {
		return confPassword;
	}

	public void setConfPassword(String sValue) {
		this.confPassword = sValue;
	}

	public String getKengenCode() {
		return kengenCode;
	}

	public void setKengenCode(String sValue) {
		this.kengenCode = sValue;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String sValue) {
		this.delFlg = sValue;
	}

	public String getOtlFlg() {
		return otlFlg;
	}

	public void setOtlFlg(String sValue) {
		this.otlFlg = sValue;
	}

	public List<CmbBox> getBushoList(){
		return bushoList;
	}
	
	public void setBushoList(List<CmbBox> listWk){
		this.bushoList = listWk;
	}

	public List<CmbBox> getGroupList(){
		return groupList;
	}
	
	public void setGroupList(List<CmbBox> listWk){
		this.groupList = listWk;
	}

	public List<CmbBox> getKengenList(){
		return kengenList;
	}
	
	public void setKengenList(List<CmbBox> listWk){
		this.kengenList = listWk;
	}

	public List<CmbBox> getDelList(){
		return delList;
	}
	
	public void setDelList(List<CmbBox> listWk){
		this.delList = listWk;
	}

	public List<CmbBox> getOtlList(){
		return otlList;
	}
	
	public void setOtlList(List<CmbBox> listWk){
		this.otlList = listWk;
	}

	public List<Object> getSyainList(){
		return syainList;
	}
	
	public void setSyainList(List<Object> listWk){
		this.syainList = listWk;
	}
	
	public int getSyainListCnt(){
		int iCnt = 0;
		if(this.syainList != null){
			iCnt =  this.syainList.size();
		}
		return iCnt;
	}

}
