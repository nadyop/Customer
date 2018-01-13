<template>
  <div class="container">
    <div class="jumbotron"><h1 class="display-3">Customer Database</h1></div>

    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Customer</h5>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="form-control-label">Name:</label>
            <input type="text" class="form-control" id="recipient-name" v-model="name">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" @click="addCustomers">Add Customer</button>
      </div>
    </div>

    <br>

    <table class="table table-striped table-bordered table-hover">
      <thead>
        <tr>
          <th>No</th>
          <th>ID</th>
          <th>Nama</th>
          <th>Detail</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, index) in getCustomers" :key="item.id">
          <td>{{index + 1}}.</td>
          <td>{{item.id}}</td>
          <td>{{item.name}}</td>
          <td><router-link :to="'/customers/' + item.id">Detail</router-link></td>
          <td><router-link :to="'/customers/' + item.id">Update</router-link></td>
          <td><button class="btn btn-sm" @click="deleteCustomers(item.id)">Delete</button></td>
        </tr>
      </tbody>
    </table>

    <!--<button @click="callApi">Call API</button>-->

  </div>
</template>

<script>
  import { mapGetters } from 'vuex'

  export default {
    name: 'LearnAPI',
    data () {
      return{
        name: ''
      }
    },
    computed:{
      ...mapGetters([
        'getCustomers',
      ])
    },
    mounted () {
      this.setCustomers()
    },
    methods: {
      setCustomers () {
       this.$store.dispatch('doGetAll')
      },
      addCustomers () {
        this.$store.dispatch('doAdd', this.name)
        this.$store.dispatch('doGetAll')
      },
      deleteCustomers (param) {
        this.$store.dispatch('doDelete', param)
        this.$store.dispatch('doGetAll')
      }
    }
  }
</script>

<style scoped>
  .jumbotron{
    background-color: white;
  }

  .table{
    margin-top: 48px;
  }
</style>
