export default{
  data(){
    return {};
  },
  template:`
    <header class="header fixed-header">
      <div>
          <h1 class="header-title"><a href="/index.html"><img class="logo" src="../image/logo-w.png" alt="알랜드"></a></h1>
          
          <ul class="main-menu d-none d-inline-flex-sm">
              <li><a class="" href="/menu/list.html">카페메뉴</a></li>
              <li><a class="" href="/notice/list.html">공지사항</a></li>
              <li><a class="" href="/user/login.html">로그인</a></li>
          </ul>
          <div class="d-none-sm"><a class="icon icon-menu icon-white" href="?m=on">메뉴버튼</a></div>
      </div>
    </header>
    `
};