import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    phone: '未登录',
  },
  mutations: {
    changeLogin(state, status) {
      // eslint-disable-next-line no-param-reassign
      state.phone = status;
      localStorage.setItem('phone', state.phone); //本地存储
    },
    localLogin(state, states) {
      // eslint-disable-next-line no-param-reassign
      state.phone = states;
    },
    checkStock(state, data) {
      // eslint-disable-next-line no-param-reassign
      state.stockInfo = data;
    },
    exitLogin(state) {
      // eslint-disable-next-line no-param-reassign
      state.phone = '未登录';
      localStorage.setItem('phone', state.phone)
      // window.localStorage.removeItem('phone', state.phone); //清除文件
    },
  },
  actions: {
    loginAction({
      commit
    }, user) {
      commit('changeLogin', user);
    }
  },
});
