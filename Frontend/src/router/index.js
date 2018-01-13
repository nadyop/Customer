import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import ListCustomers from '@/pages/ListCustomer'
import GetCustomer from '@/pages/GetCustomer'
import GetAddress from '@/pages/GetAddress'

Vue.use(Router)

export default new Router({
  mode : 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },{
      path: '/customers',
      name: 'ListCustomers',
      component: ListCustomers
    },{
      path: '/customers/:id',
      name: 'getCustomers',
      component: GetCustomer
    },{
      path: '/customers/:id/addresses/:address',
      name: 'getAddress',
      component: GetAddress
    }
  ]
})
