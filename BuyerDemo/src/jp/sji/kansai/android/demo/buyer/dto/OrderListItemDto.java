package jp.sji.kansai.android.demo.buyer.dto;

public class OrderListItemDto {

	private String material;
	private String date;
	private String status;

	public void setMaterial( String material ){
		this.material = material;
	}

	public void setDate( String date ){
		this.date = date;
	}

	public void setStatus( String status ){
		this.status = status;
	}

	public String getMaterial(){
		return this.material;
	}

	public String getDate(){
		return this.date;
	}


	public String getStatus(){
		return this.status;
	}
}