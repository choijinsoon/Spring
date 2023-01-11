import {createApp} from 'vue';
import {createRouter, createWebHashHistory} from 'vue-router';

import App from './components/app.js';
import index from './components/index.js';
import MenuList from './components/menu/list.js';

const router = createRouter({
    history: createWebHashHistory(),
    routes:[
        {path: '/', component: index},
        {path: '/menu/list', component: MenuList}
    ]
})

createApp(App)
.use(router)
.mount("#app");