<template>
  <nav class="navbar navbar-toggleable-md navbar-light bg-faded">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">Navbar</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item" v-for="item in menus" v-if="item.disabled">
          <router-link class="nav-link" v-bind:to="item.url" >
            {{item.label}}
          </router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
  export default {
    name: 'Loop',
    data(){
      return{
        menus: {
          home:{
            url:'/customers',
            label: 'Home',
            disabled: true
          }
        }
      }
    }
  }


</script>

<style scoped>
  .navbar{
    background-color: white;
  }
</style>
