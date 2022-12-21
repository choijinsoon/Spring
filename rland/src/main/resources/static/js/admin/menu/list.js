window.addEventListener("load", function(){
	const btnAdd = document.querySelector(".btn-add");
	const menuRegSection = document.querySelector(".menu-reg-section");
	const imgInput = document.querySelector(".img-input");
	const fileInput = document.querySelector(".file-input");

	btnAdd.onclick = function(e) {
		e.preventDefault();

		menuRegSection.classList.remove("d-none");
	};

	imgInput.onclick = function(e) {
		let event = new MouseEvent("click",{
			'view':window,
			'bubbles':true,
			'cancelable':true
		});
		console.log(e.target);
		console.log(e.target.tagName);
		console.log(e.target.parentElement);
		fileInput.dispatchEvent(event);
	};
});