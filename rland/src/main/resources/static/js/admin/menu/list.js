window.addEventListener("load", function(){
	const btnAdd = document.querySelector(".btn-add");
	const menuRegSection = document.querySelector(".menu-reg-section");
	const imgInput = document.querySelector(".img-input");
	const fileInput = document.querySelector(".file-input");

	btnAdd.onclick = function(e) {
		e.preventDefault();

		menuRegSection.classList.remove("d-none");
		console.log(btnAdd.value)
	};

	imgInput.onclick = function(e) {
		let event = new MouseEvent("click",{
			'view':window,
			'bubbles':true,
			'cancelable':true
		});
		fileInput.dispatchEvent(event);
	};

	fileInput.oninput = function(e) {
		let url = fileInput.files[0];

		let reader = new FileReader();
		reader.onload = (evt)=>{
			imgInput.src = evt.target.result; //화면에 보여주는 이미지
		};
		reader.readAsDataURL(url);
	}
});