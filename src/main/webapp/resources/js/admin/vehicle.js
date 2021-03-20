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
	
	/* 삭제버튼 누를시 체크개수 카운트해 모달창에 건수 넣어주기.*/
	document.querySelector('.vehicleDelete').addEventListener('click',()=>{
		let cnt = checkCnt();
   	 	document.getElementById('result').innerText = cnt;
	});
    
	/* 등록모달청에서 등록하기*/
	document.querySelector('.btn-add-vehicle').addEventListener('click',()=>{
		console.dir('여기오나?');
	});
	
	/* 수정모달청에서 수정하기*/
	document.querySelector('.vehicleModify').addEventListener('click',()=>{
		let checkboxes = document.querySelectorAll('.vehicle');
		let inpBuilding = document.querySelector('#generation-bulding');
		console.dir(inpBuilding);
		 checkboxes.forEach((e)=>{
      		  if(e.checked == true){
      			  let pare = e.parentElement.parentElement.parentElement.parentElement;
					let tdele = pare.children;
					console.dir(tdele[1].outerText);
					inpBuilding.value = tdele[1].outerText;
      		  }
      	  })
	});
	
})();  