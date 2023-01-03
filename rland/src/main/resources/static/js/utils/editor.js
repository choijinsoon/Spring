window.addEventListener("load", () => {
   var editorDiv = this.document.querySelector("#editor"); 
   var toolBox = this.document.querySelector(".toolbox");

   toolBox.onclick = function(e){
      e.preventDefault();

      let target = e.target;
      if(target.classList.contains("btn-bold")){
         const selObj = window.getSelection();
         console.log(selObj.toString());

         let template = `<span style="font-weight: bold;color: red">${selObj.toString()}</span>`;

         const range = selObj.getRangeAt(0);

         let frag = document.createDocumentFragment();
         // template 문자열을 dom 객체로 만들기
         let el = document.createElement("div");
         el.innerHTML = template;

         frag.append(el.firstChild);

         selObj.deleteFromDocument();
         
         range.insertNode(frag);

      }
      else if(target.classList.contains("btn-italic")){
         document.execCommand("italic");

      }      
      else if(target.classList.contains("btn-underline")){
         document.execCommand("underline");

      }

   }
   



});
