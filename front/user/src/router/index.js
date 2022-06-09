import Vue from 'vue'
import Router from 'vue-router'
import { constantRouterMap, asyncRouterMap } from './router.config'

Vue.use(Router)

// noinspection JSCheckFunctionSignatures
export default new Router({
  mode: 'hash',
  routes: constantRouterMap.concat(asyncRouterMap)
})
