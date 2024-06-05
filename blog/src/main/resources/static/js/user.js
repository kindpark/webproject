let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{
			this.save();
		});
	}
	,save: function(){
		//alert('user의 save 호출');
		let data = {// joinform input tag id로 값을 저장
			userName: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
			//프로토타입 : 오브젝트(username, password, email을 갖고 있음)
		}
		
		//alert(data);
		//console.log(data);
		//자바의 try catch와 유사?
		//dataType:"json"
		$.ajax({
			//create는 postMapping을 했음
			type:"POST",
			url:"/blog/api/user",
			data:JSON.stringify(data),//데이터를 JSON형식으로 전달
			contentType: "application/json; charset=UTF-8",//body의 데이터 타입
			dataType:"json"
			//요청을 서버로 해서 응답이 왔을떄 JSON이라면 js object로 변환
			//done - > 성공
		}).done(function(resp){
			alert(data.userName + "님 반갑습니다.");
			console.log(resp)
			location.href="/blog";
			//catch와 좀 더 유사한듯 -> error 처리
		}).fail(function(error){
			alert(JSON.stringify(error));
			
		});
	}
}



index.init();