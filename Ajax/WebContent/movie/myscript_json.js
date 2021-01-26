/**
 * api - json 로 데이터를 받는 경우
 */
$(function(){
   init();
   
   $("#btn1").click(function(){
      let url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=";
		url += $("#txtYear").val()+$("#selMon").val()+$("#selDay").val();
      
		var result = "";
		
		$.getJSON({
         url : url,
         success:function(data){
            console.log(data);
			$(data.boxOfficeResult.dailyBoxOfficeList).each(function(idx,item){
				var rank = item.rank;
				var rankInten =item.rankInten;
				var movieNm = item.movieNm;
				
				result += rank+" 위(";
				if(rankInten>0){
					result += "▲";
				}else if(rankInten<0){
					result += "▼";
				}
				//영화 코드
				var movieCd = item.movieCd;
				
				result += rankInten+") : "+"<a href='#' onclick='javascript:info("+movieCd+")'>"+movieNm+"</a><br>";
	
				$("#msg").html(result);
			})
			
			
         }
      })
   })
})
function info(movieCd){
	var url = "	http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd="+movieCd;
	
	$.get({
		url : url,
		success:function(data){
			console.log(data);
			var data1=data.movieInfoResult.movieInfo;
			var result = "<ul>";
			var movieNm = data1.movieNm;
			var movieNmEn = data1.movieNmEn;
			var showTm = data1.showTm;
			var peopleNm = data1.directors.peopleNm;
			var actors ="";
			/*$(data).find("actor").each(function(){
				actors +=$(this).find("peopleNm").text()
			})*/
			$(data1.actors).each(function(idx,item){
				if(idx == 0){
					actors += item.peopleNm;					
				}else{
					actors += ","+item.peopleNm;
				}
			})
			result += "<li>영화제목 : "+movieNm+"</li>";
			result += "<li>영어제목 : "+movieNmEn+"</li>";
			result += "<li>상영시간 : "+showTm+"</li>";
			result += "<li>감독 : "+peopleNm+"</li>";
			result += "<li>출연배우 : "+actors+"</li></ul>";
			
			$(".box3").html(result);
		}
	})
}
function init(){
 	//어제날자 세팅
	var newDate = new Date();
	var year = newDate.getFullYear();
	var month = newDate.getMonth()+1;
	var day = newDate.getDate()-1;
	
	$("#txtYear").val(year);
	
	if(month<10){
		month = "0"+month;
	}
	if(day<10){
		day="0"+day;
	}
	
	$("#selMon").val(month);
	$("#selDay").val(day);
	  
}