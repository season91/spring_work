(()=>{
	document.querySelector('.btn-mgmtfee-upload').addEventListener('click',()=>{
		const url = "/admin/mgmtfeeuploadimpl";
		let file = document.querySelector('.file-mgmtfee');
		
		let headerObj = new Headers();
		headerObj.append("content-type","multipart/form-data")
		
		fetch(url,{
			method:"post",
			headers:headerObj,
			body:JSON.stringify(file)
		}).then(response => {
			console.dir(response.status);
			console.dir(JSON.stringify(response));
		})
		.catch(error=>{
			console.dir('에러');
		})
		
	})
})();