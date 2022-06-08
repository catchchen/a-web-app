import Vue from 'vue'
import Router from 'vue-router'
import { constantRouter, asyncRouter } from './router.config'

Vue.use(Router)

export default new Router({
  mode: 'hash',
  routes: asyncRouter.concat(constantRouter)
})
