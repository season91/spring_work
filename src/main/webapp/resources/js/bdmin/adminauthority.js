(()=>{
	/* 체크된 박스 개수 */
	function checkCnt() {
		let checkboxes = document.querySelectorAll('.admin');
		let arr = [];
    	checkboxes.forEach((e)=>{
  		  if(e.checked == true){
			arr.push(e);
  		  }
      	})
		return arr;
	};
	
	/* 체크박스 전체 선택 해제*/
	document.querySelector('.checkAll').addEventListener('click',()=>{
		console.dir('오나용?');
		let allcar = document.querySelector('.alladmin');
        let checkboxes = document.querySelectorAll('.admin');
        
        if(allcar.checked == true){
           checkboxes.forEach((e)=>{
               e.checked = true;
            })
        } else if(allcar.checked == false){
           checkboxes.forEach((e)=>{
               e.checked = false;
            })
        }
	});
	
	/* 삭제버튼 누를시 체크개수 카운트해 모달창에 건수 넣어주기.*/
	document.querySelector('.adminDelete').addEventListener('click',()=>{
		let checkboxes = checkCnt();
		console.dir(checkboxes.length);
   	 	document.getElementById('result').innerText = checkboxes.length;
	});
	
	/* 삭제 비동기통신 */
	/* 모달창에서 승인 삭제버튼 누를시 비동기로 삭제요청 보낸다.*/
	document.querySelector('.btn-delete-admin').addEventListener('click',()=>{
		let managerIdx = [];
		let checkboxes = checkCnt();
		checkboxes.forEach((e)=>{
  			let trElement = e.parentElement.parentElement.parentElement.parentElement;
			let tdElement = trElement.children;
			managerIdx.push(tdElement[1].outerText);
		})
		
		let headerObj = new Headers();
		headerObj.append('content-type', "application/x-www-form-urlencoded");
		
		fetch("/bdmin/management/admindelete?manageridx="+managerIdx,{
			method:"GET",
			header : headerObj
		}).then(response => {
			if(response.ok){
				alert('권한 회수되었습니다.');
				return location.href="/bdmin/management/adminauthority";
			}
			throw new AsyncPageError(response.text()); 
		})
		.catch(error =>{
			error.alertMessage();
		})
	});
	
	/*document.querySelector('.apartmentSearch').addEventListener('click',()=>{
		console.dir('찍히나용');
		let test = document.createElement('div');
		test.innerHTML += "test";
		
	})*/

	
})();  