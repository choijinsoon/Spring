export default{
  data(){
    return {};
  },
  template:`
    <header class="header fixed-header">
      <div>
          <h1 class="header-title"><router-link to="/"><img class="logo" src="../image/logo-w.png" alt="알랜드"></router-link></h1>
          
          <ul class="main-menu d-none d-inline-flex-sm">
              <li><router-link class="" to="/menu/list">카페메뉴</router-link></li>
              <li><a class="" href="/notice/list.html">공지사항</a></li>
              <li><a class="" href="/user/login.html">로그인</a></li>
          </ul>
          <div class="d-none-sm"><a class="icon icon-menu icon-white" href="?m=on">메뉴버튼</a></div>
      </div>
    </header>
    `
};