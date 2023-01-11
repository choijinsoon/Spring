import Header from './header.js';
import Footer from './footer.js';

export default{
  data() {
      return {

      };
  },
  components: { Header, Footer },
  template: `
  <Header></Header>
  <router-view></router-view>    
  <Footer></Footer>
`
}