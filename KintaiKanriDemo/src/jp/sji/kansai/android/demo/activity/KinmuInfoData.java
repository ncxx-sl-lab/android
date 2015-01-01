package jp.sji.kansai.android.demo.activity;

public class KinmuInfoData {  
	private String _date;
	private String _weekday;
	private String _starttime;
	private String _finishtime;
	
	public String getDate(){
		return _date; 
	}
	public void setDate(String date){
		_date = date;
	}
	
	public String getWeekDay(){
		return _weekday;
	}
	public void setWeekDay(String weekday){
		_weekday = weekday;
	}

	public String getStartTime(){
		return _starttime;
	}
	public void setStartTime(String starttime){
		_starttime = starttime;
	}
	
	public String getFinishTime(){
		return _finishtime;
	}
	public void setFinishTime(String finishtime){
		_finishtime = finishtime;
	}
	
}  