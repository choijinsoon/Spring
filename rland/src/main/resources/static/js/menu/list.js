// console.log("test");
// let searchHeader = document.querySelector(".search-header");
// console.log(searchHeader);

window.addEventListener("load", function(){
    const ul = document.querySelector(".menu-category ul");

    ul.onclick = function(e){
        e.preventDefault();
        
        if(e.target.tagName != "LI" && e.target.tagName != "A")
        return;
        
        console.log(e.target.tagName)
    }
});