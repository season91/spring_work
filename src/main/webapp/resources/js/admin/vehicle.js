(()=>{
	/* 체크된 박스 개수 */
	function checkCnt() {
		let checkboxes = document.querySelectorAll('.vehicle');
    	 let cnt = 0;
    	 checkboxes.forEach((e)=>{
      		  if(e.checked == true){
      			  cnt++;  
      		  }
      	  })
      	  console.dir('펑션'+cnt);
		return cnt;
	};
	
	/* 체크박스 전체 선택 해제*/
	document.querySelector('.checkAll').addEventListener('click',()=>{
		let allvehicle = document.querySelector('.allvehicle');
        let checkboxes = document.querySelectorAll('.vehicle');
        
        if(allvehicle.checked == true){
           checkboxes.forEach((e)=>{
               e.checked = true;
            })
        } else if(allvehicle.checked == false){
           checkboxes.forEach((e)=>{
               e.checked = false;
            })
        }
	});
	
	/* 삭제버튼 누를시 체크개수 카운트*/
	document.querySelector('.vehicleDelete').addEventListener('click',()=>{
		let cnt = checkCnt();
   	 	document.getElementById('result').innerText = cnt;
	});
    
     /* 수정시 체크한 정보 가져오기 */
	document.querySelector('.vehicleInfo').addEventListener('click',()=>{
		let cnt = checkCnt();
		console.dir(cnt);
		if(cnt > 1) {
    		alert('한개만 선택하세요.');
    	} 

	});
	

})();  
      
     
     
     