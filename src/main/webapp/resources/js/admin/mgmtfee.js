(()=>{
/*	document.querySelector('.btn-search-vehicleNumber').addEventListener('click',()=>{
		console.dir('관리비번호 검색');
		let keyword = document.querySelector('.mgmtfee-keyword').value;
		console.dir(keyword);
		let url = "/admin/mgmtfee/search?mgmtfeeidx="+keyword;
		

		let headerObj = new Headers();
        headerObj.append('content-type','application/x-www-form-urlencoded');

		fetch(url,{
			method:"get",
			headers:headerObj
		}).then(response =>{
			console.dir(response.status);
		})
		.catch(error=>{
			console.dir('실패');
		})
		
		
	});
	*/
	document.querySelector('.btn-nopayment').addEventListener('click',()=>{
		console.dir('넘어온다?');
	});
	
})();