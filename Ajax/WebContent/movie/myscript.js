/**
 * 
 */
$(function(){
   init();
   
   $("#btn1").click(function(){
      let url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=f5eef3421c602c6cb7ea224104795888&targetDt=";
		url += $("#txtYear").val()+$("#selMon").val()+$("#selDay").val();
      
		var result = "";
		
		$.get({
         url : url,
         success:function(data){
            console.log(data);
			$(data).find("dailyBoxOffice").each(function(){
				var rank = $(this).find("rank").text();
				var rankInten =$(this).find("rankInten").text();
				var movieNm = $(this).find("movieNm").text();
				
				result += rank+" 위(";
				if(rankInten>0){
					result += "▲";
				}else if(rankInten<0){
					result += "▼";
				}
				//영화 코드
				var movieCd = $(this).find("movieCd").text();
				
				result += rankInten+") : "+"<a href='#' onclick='javascript:info("+movieCd+")'>"+movieNm+"</a><br>";
	
				$("#msg").html(result);
			})
			
			
         }
      })
   })
})
function info(movieCd){
	var url = "	http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.xml?key=f5eef3421c602c6cb7ea224104795888&movieCd="+movieCd;
	
	$.get({
		url : url,
		success:function(data){
			console.log(data);
			var result = "<ul>";
			var movieNm = $(data).find("movieNm").text();
			var movieNmEn = $(data).find("movieNmEn").text();
			var showTm = $(data).find("showTm").text();
			var peopleNm = $(data).find("director").find("peopleNm").text();
			var actors ="";
			/*$(data).find("actor").each(function(){
				actors +=$(this).find("peopleNm").text()
			})*/
			$(data).find("actor").each(function(idx,item){
				if(idx == $(data).find("actor").find("peopleNm").length - 1){
					actors +=$(this).find("peopleNm").text()					
				}else{
					actors +=$(this).find("peopleNm").text()+","
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