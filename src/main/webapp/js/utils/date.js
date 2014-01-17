// 格式化日期
function formatDate(date){
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var date = date.getDate();
	if(month < 10){
		month = '0' + month;
	}
	if(date < 10){
		date = '0' + date;
	}
	return year + '-' + month + '-' + date;
}
//只显示时分秒
function showTime(time){
	return time.substring(11);
}