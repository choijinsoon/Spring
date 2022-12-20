// console.log("test");
// let searchHeader = document.querySelector(".search-header");
// console.log(searchHeader);

window.addEventListener("load", function(){
    const ul = document.querySelector(".menu-category ul");
    const currentLi = document.querySelector(".menu-category ul li.menu-selected")
    
    ul.onclick = function(e){
        e.preventDefault();
        const el = e.target;
        
        if(el.tagName != "LI" && el.tagName != "A")
            return;
        
        let li = el;
        if(el.tagName == "A")
            li = el.parentElement;

        li.classList.add("menu-selected");
        currentLi.classList.remove("menu-seleted");

        currentLi = li;

        //데이터를 요청 ?c=2 -> param:2
        // /api/menu/list?c=2
        // /api/menu/c/2


        //화면을 갱싱
    }
});