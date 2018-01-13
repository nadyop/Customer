import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

const store = new Vuex.Store({
  state:{
    count: 0,
    customerList: [],
    customer: [],
    addresses: [],
    address: []
  },
  mutations:{
    increment (state){
      state.count++
    },
    setCustomers(state, value){
      state.customerList = value
    },
    setAddresses(state, value){
      state.addresses = value
    },
    setCustomer(state, value){
      state.customer = value
    },
    setAddress(state, value){
      state.address = value
    }
  },
  getters: {
    getCount: (state) => {
      return state.count
    },
    getCustomers: (state) => {
      return state.customerList
    },
    getAddresses: (state) => {
      return state.addresses
    },
    getCustomer: (state) => {
      return state.customer
    },
    getAddress: (state) => {
      return state.address
    }
  },
  actions: {
    doIncrement: ({commit}) => {
      commit('increment')
    },
    doGetAll: ({commit}) => {
      const URL = '/api/customers'
      // call API here
      axios.get(URL)
        .then(response => {
          console.log(response)
          commit('setCustomers', response.data)
        })
        .catch(error => {
          console.log(error)
        })
    },
    doAdd: ({commit}, param) => {
      const URL = '/api/customers'
      // call API here
      axios.post(URL, {name: param})
        .then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
    },
    doDelete: ({commit}, param) => {
      const URL = '/api/customers/' + param
      axios.delete(URL)
        .then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
    },
    doView: ({commit}, param) => {
      const URL = '/api' + param
      axios.get(URL)
        .then(response => {
          console.log(response)
          commit('setCustomer', response.data)
        })
        .catch(error => {
          console.log(error)
        })
    },
    doUpdate: ({commit}, param) => {
      const URL = '/api' + param[0]
      console.log(param[1])
      axios.put(URL, {name: param[1]})
        .then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
    },
    doGetAddresses: ({commit}, param) => {
      const URL = '/api' + param + '/addresses'
      console.log(URL)
      axios.get(URL)
        .then(response => {
          console.log(response)
          commit('setAddresses', response.data)
        })
        .catch(error => {
          console.log(error)
        })
    },
    doAddAddress: ({commit}, param) => {
      const URL = '/api' + param[4] + '/addresses'
      axios.post(URL, {street: param[0], city: param[1], province: param[2], country: param[3]})
        .then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
    },
    doDeleteAddresses: ({commit}, param) => {
      const URL = '/api' + param[0] + '/addresses/' + param[1]
      axios.delete(URL)
        .then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
    },
    doViewAddress: ({commit}, param) => {
      const URL = '/api' + param
      console.log(URL)
      axios.get(URL)
        .then(response => {
          console.log(response)
          commit('setAddress', response.data)
        })
        .catch(error => {
          console.log(error)
        })
    },
    doUpdateAddresses: ({commit}, param) => {
      const URL = '/api' + param[0]
      console.log(param[1])
      axios.put(URL, {street: param[1], city: param[2], province: param[3], country: param[4]})
        .then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
    }
  }
})

export default store
