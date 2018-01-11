<template>
  <div>
    <div>
      Name: <input type="text" v-model="nameCustomer" placeholder="Type">

    </div>
    <div>
      Address: <input type="text" v-model="addressCust" placeholder="Type">
      <button type="submit" @click="insertCustomers">Submit</button>
    </div>
    <table align="center">
      <tr>
        <th>Name</th>
      </tr>
      <tr v-for="d in datas" :key="d.id">
        {{d.name}}
      </tr>
    </table>
  </div>
</template>
<script>
  import axios from 'axios'

  export default {
    name: 'user-index',
    data () {
      return {
        nameCustomer: '',
        addressCust: '',
        datas: null
      }
    },
    methods: {
      getUsers () {
        const URL = '/api/customers'
        axios.get(URL)
          .then(response => {
            this.datas = response.data
            alert(JSON.stringify(this.datas))
          })
          .catch(error => {
            alert(error)
          })
      },
      getUsersById (id) {
        const URL = '/api/customers/' + id
        axios.get(URL)
          .then(response => {
            this.datas = response.data
            alert(JSON.stringify(this.datas))
          })
          .catch(error => {
            alert(error)
          })
      },
      insertCustomers: function () {
        const URL = '/api/customers'
        axios.post(URL, {
          name: this.nameCustomer,
          address: this.addressCust
        }, {
          headers: {
            'Content-type': 'application/json'
          }
        })
          .then(response => {
            this.datas = response.data
            alert(JSON.stringify(this.datas))
          })
          .catch(error => {
            alert(error)
          })
      }
    },
    mounted () {
      this.getUsers()
    }
  }
</script>
