import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import Login from './views/Login.vue';
import Reg from './views/Reg.vue';
import StockDetails from './views/StockDetails.vue';
import Count from './views/Count.vue';
import Information from './views/Information.vue';
// eslint-disable-next-line camelcase
import Information_2 from './views/Information_2.vue';
// eslint-disable-next-line import/no-unresolved
import Header from '@/components/Header.vue';
import PostDetail from './views/PostDetail.vue';
import StockDeal from './views/StockDeal.vue';
import Forget from './views/Forget.vue';
import Error from './views/Error.vue';

Vue.use(Router);
export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [{
      path: '/',
      name: 'home',
      components: {
        // eslint-disable-next-line indent
        default: Home,
        top: Header,
      },
    },
    {
      path: '/login',
      name: 'login',
      components: {
        default: Login,
        top: Header,
      },
    },
    {
      path: '/reg',
      name: 'reg',
      components: {
        default: Reg,
        top: Header,
      },
    },
    {
      path: '/stockdetails/:id',
      name: 'stockdetails',
      components: {
        default: StockDetails,
        top: Header,
      },
    },
    {
      path: '/forget',
      name: 'forget',
      component: Forget,
    },
    {
      path: '/count',
      name: 'count',
      components: {
        default: Count,
        top: Header,
      },
    },
    {
      path: '/information',
      name: 'information',
      components: {
        default: Information,
        top: Header,
      },
    },
    {
      path: '/information-2',
      name: 'information-2',
      components: {
        default: Information_2,
        top: Header,
      },
    },
    {
      path: '/detail/:id',
      name: 'home',
      component: PostDetail,
    },
    {
      path: '/stockdeal/:id',
      name: 'stockdeal',
      components: {
        default: StockDeal,
        top: Header,
      },
    },
    {
      path: '*',
      component: Error,
    },
  ],
});
