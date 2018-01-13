<template>
  <div class="container">
    <div class="jumbotron"><h1 class="display-3">Update Address</h1></div>

    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Update Address</h5>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="form-control-label">Country:</label>
            <input type="text" class="form-control" id="recipient-name" v-model="country" :placeholder="getAddress.country">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="form-control-label">Province:</label>
            <input type="text" class="form-control" id="recipient-name" v-model="province" :placeholder="getAddress.province">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="form-control-label">City:</label>
            <input type="text" class="form-control" id="recipient-name" v-model="city" :placeholder="getAddress.city">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="form-control-label">Street:</label>
            <input type="text" class="form-control" id="recipient-name" v-model="street" :placeholder="getAddress.street">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <!--<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>-->
        <button type="button" class="btn btn-primary" @click="updateAddress">Update Address</button>
      </div>
    </div>
  </div>
</template>

<script>
  import {mapGetters} from 'vuex'

  export default {
    name: "AddCustomer",
    data () {
      return {
        province: '',
        city: '',
        street: '',
        country: ''
      }
    },
    computed: {
      ...mapGetters([
        'getAddress',
      ])
    },
    mounted () {
      this.viewAddress(this.$route.path)
    },
    methods: {
      viewAddress (param) {
        this.$store.dispatch('doViewAddress', param)
      },
      updateAddress () {
        var param = [this.$route.path, this.street, this.city, this.province, this.country]
        this.$store.dispatch('doUpdateAddresses', param)
      }
    }
  }
</script>

<style>
  .jumbotron{
    background-color: white;
  }
</style>
