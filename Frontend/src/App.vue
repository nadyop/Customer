<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-view/>
    <link></link>
  </div>
</template>

<script>
  import Link from '@/components/Link'

  export default {
    name: 'app',
    components: {Link}
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
