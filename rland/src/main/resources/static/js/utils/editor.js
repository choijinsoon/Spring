window.addEventListener("load", () => {
   var editorDiv = this.document.querySelector("#editor"); 
   var toolBox = this.document.querySelector(".toolbox");

   toolBox.onclick = function(e){
      e.preventDefault();

      let target = e.target;
      if(target.classList.contains("btn-bold")){
         let range = window.getSelection().getRangeAt(0);
         let frag = document.createDocumentFragment()
         frag.appendChild(node);
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
