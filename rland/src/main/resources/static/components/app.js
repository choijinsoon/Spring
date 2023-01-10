import Header from './header.js';
import Footer from './footer.js';

Vue.createApp({
  data(){
    return{

    };
  },
  components:{Header,Footer},
  template:`
    <Header></Header>
    <!-- ---------------------------------------------------------------------- -->   
    <nav class="cafe">
        <div>
            <h1 class="cafe-title">부안에 오면 꼭! 들리는 카페</h1>
            <div class="mt-auto d-flex justify-content-end"><a class="btn btn-leaf mr-3" href="menu/list.html">전체메뉴</a></div>
            <nav class="top-menu item-list">
                <h1 class="d-none">인기메뉴</h1>
                <ul class="d-inline-block">
                    <li>
                        <img height="100" src="./image/product/17.png" alt="딸기청">
                        <a target="_blank" href="menu/detail.html">딸기청</a>
                    </li>
                    <li>
                        <img height="100" src="./image/product/8.png" alt="카페 아메리카노">
                        <a target="_blank" href="menu/detail.html">카페 아메리카노</a>
                    </li>
                    <li>
                        <img height="100" src="./image/product/28.png" alt="버터쿠키">
                        <a target="_blank" href="menu/detail.html">버터쿠키</a>
                    </li>
                    <li>
                        <img height="100" src="./image/product/17.png" alt="딸기청">
                        <a target="_blank" href="menu/detail.html">딸기청</a>
                    </li>
                    <li>
                        <img height="100" src="./image/product/8.png" alt="카페 아메리카노">
                        <a target="_blank" href="menu/detail.html">카페 아메리카노</a>
                    </li>
                    <li>
                        <img height="100" src="./image/product/28.png" alt="버터쿠키">
                        <a target="_blank" href="menu/detail.html">버터쿠키</a>
                    </li>
                </ul>
            </nav>
            
            <div><a class="btn btn-block-link deco deco-location deco-white deco-mr-1 deco-ml-1" href="">알랜드 오시는 길</a></div> 
        </div>
    </nav>
    
    <!-- ---------------------------------------------------------------------- -->
    <section class="rland">
        <div>
            <h1 class="d-none">알랜드 소개</h1>
            
            <article class="">
                <h1 class="font-family-arial">직접 만든 과일청을 맛보세요.</h1>
                <div><img src="./image/product/17.png" alt="과일청"></div>

                <p>
                    신선한 과일과 알랜드만의 레시피로
                    과일향의 풍미를 충분히 느낄 수 있는
                    수제청을 드셔보세요.
                </p>
            </article>
            

            <article>

                <h1>
                    직접 구운 수제 쿠키를 만나보세요.
                </h1>
                <div><img src="./image/product/17.png" alt="과일청"></div>

                <p>
                    신선한 버터 그리고 견과류를
                    이용해 바삭함을 더해 매일마다
                    직접 구운 맛난 쿠키를 만나보세요.
                </p>
            </article>

            <article>
                <h1>
                    다양한 로스팅으로 다채로운 맛을 느껴보세요.
                </h1>
                <div><img src="./image/product/18.png" alt="과일청"></div>

                    
                <p>
                    코롬비아산의 상큼한 맛, 과테말라
                    산의 풍미, 그 외에 5가지 이상의
                    다채로운 원두의 맛을 느껴보세요.
                </p>
            </article>

            <article>
                <h1>
                    알랜드 주변의 명소를 찾아보세요.
                </h1>
                <div><img src="./image/product/19.jpg" alt="과일청"></div>


                <p>
                    알랜드 주변에는 30곳이 넘는
                    힐링 장소에서 맛나는 커피와 경치로
                    힐링을 해보세요.
                </p>      
            </article>
        </div>
    </section>
    <!-- ---------------------------------------------------------------------- -->
    <section class="spot">
        <div>
            <header class="spot-header">
              <div class="d-flex justify-content-between">
                  <h1 class="spot-title deco deco-location deco-white deco-mr-1 ml-3">부안의 아름다운 명소</h1>
                  <div class="d-flex align-items-center">
                    <a class="btn btn-leaf mr-3" href="">전체명소</a>
                  </div>
                </div>
            </header>
            <div>
                <article>
                    <header>
                        <h1>채석강</h1>
                        <div lass="deco-pen"><a href="">89</a></div>
                    </header>
                    <div>
                        <p>
                            <a href="">
                                바닷물에 침식이 되어
                                서 쌓인 절벽이 여러
                                권의 책을 쌓아 놓은 듯..
                            </a>
                        </p>
                        <div>
                            <a href="https://map.naver.com/v5/search/%EC%95%8C%EB%9E%9C%EB%93%9C/place/1281711613?placePath=%3Fentry=pll%26from=nx%26fromNxList=true&c=14084751.7063168,4258510.9452342,13.3,0,0,0,dh" target="_blank">
                                <img src="./image/spot/map.png" alt="">
                            </a>
                        </div>
                    </div>
                </article>
                <nav class="item-list">
                    <h1 class="d-none">명소목록</h1>
                    <ul>
                        <li><img src="./image/spot/b2.jpg" alt="바위"><a href="">바위</a></li>
                        <li><img src="./image/spot/b13.jpg" alt="명소2"><a href="">명소2</a></li>
                        <li><img src="./image/spot/b14.jpg" alt="명소3"><a href="">명소3</a></li>
                        <li><img src="./image/spot/b7.jpg" alt="명소4"><a href="">명소4</a></li>
                        <li><img src="./image/spot/b9.jpg" alt="명소5"><a href="">명소5</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </section>

    <!-- ---------------------------------------------------------------------- -->
    <section class="visited-review">
        <!-- <header>
            <h1>방문 네이버 리뷰</h1>
            <div>더보기</div>
            <div>영수증으로 인증된 이용자가 네이버를 통해 남긴 평가입니다.</div>
        </header>

        <section>
            <h1>리뷰 목록</h1>
            <div>
                <div>
                    <div>5</div>
                    <p>탁트인 창이 곳곳에 있어 좋아용 음료도 맛나요 사장
                        님이 만드신 수제과자도 너무 고소하니...</p>
                    <div>bhj**** </div>
                    <div>2021.09.15</div>
                    <div>1번째 방문</div>

                </div>
                <div>
                    <div>5</div>
                    <p>탁트인 창이 곳곳에 있어 좋아용 음료도 맛나요 사장
                        님이 만드신 수제과자도 너무 고소하니...</p>
                    <div>bhj**** </div>
                    <div>2021.09.15</div>
                    <div>1번째 방문</div>
                </div>
            </div>
        </section>
    
        <div>
            <a href="">이전</a>
            <a href="">다음</a>
        </div> -->

    </section>

    <section class="blog">
    </section>
    <section class="location"></section>
    <section class="business-hour"></section>
    
    <Footer></Footer>
  `
}).mount("#app");