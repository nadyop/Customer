<template>
  <div class="container">
    <div class="jumbotron"><h1 class="display-3">Hi {{getCustomer.name}}!</h1></div>

    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Customer</h5>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="id" class="form-control-label">ID:</label>
            <input type="text" class="form-control" id="id" disabled :placeholder="getCustomer.id">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="form-control-label">Name:</label>
            <input type="text" class="form-control" id="recipient-name" v-model="name">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <!--<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>-->
        <button type="button" class="btn btn-primary" @click="updateCustomer">Update Customer</button>
      </div>
    </div>

    <br>

    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Address</h5>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="form-control-label">Country:</label>
            <input type="text" class="form-control" id="recipient-name" v-model="country">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="form-control-label">Province:</label>
            <input type="text" class="form-control" id="recipient-name" v-model="province">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="form-control-label">City:</label>
            <input type="text" class="form-control" id="recipient-name" v-model="city">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="form-control-label">Street:</label>
            <input type="text" class="form-control" id="recipient-name" v-model="street">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <!--<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>-->
        <button type="button" class="btn btn-primary" @click="addAddress">Add Address</button>
      </div>
    </div>

    <br>

    <table class="table table-striped table-bordered table-hover">
      <thead>
      <tr>
        <th>No</th>
        <th>ID</th>
        <th>Street</th>
        <th>City</th>
        <th>Province</th>
        <th>Country</th>
        <th></th>
        <th></th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(item, index) in getAddresses" :key="item.id">
        <td>{{index + 1}}.</td>
        <td>{{item.id}}</td>
        <td>{{item.street}}</td>
        <td>{{item.city}}</td>
        <td>{{item.province}}</td>
        <td>{{item.country}}</td>
        <td><router-link :to="'/customers/' + getCustomer.id + '/addresses/' + item.id">Update</router-link></td>
        <td><button class="btn btn-sm" @click="deleteAddresses(item.id)">Delete</button></td>
      </tr>
      </tbody>
    </table>

  </div>
</template>

<script>
  import {mapGetters} from 'vuex'

  export default {
    name: "GetCustomer",
    data () {
      return {
        name: '',
        province: '',
        city: '',
        street: '',
        country: ''
      }
    },
    computed: {
      ...mapGetters([
        'getCustomer',
      ]),
      ...mapGetters([
        'getAddresses',
      ])
    },
    mounted () {
      this.viewCustomers(this.$route.path)
      this.setAddresses()
    },
    methods: {
      viewCustomers (param) {
        this.$store.dispatch('doView', param)
      },
      updateCustomer () {
        var param = [this.$route.path, this.name]
        this.$store.dispatch('doUpdate', param)
      },
      setAddresses () {
        this.$store.dispatch('doGetAddresses', this.$route.path)
      },
      addAddress () {
        var param = [this.street, this.city, this.province, this.country, this.$route.path]
        this.$store.dispatch('doAddAddress', param)
        this.$store.dispatch('doGetAddresses', this.$route.path)
      },
      deleteAddresses(param){
        var params = [this.$route.path, param]
        this.$store.dispatch('doDeleteAddresses', params)
        this.$store.dispatch('doGetAddresses', this.$route.path)
      }
    }
  }
</script>

<style>
  .jumbotron{
    background-color: white;
  }
</style>
