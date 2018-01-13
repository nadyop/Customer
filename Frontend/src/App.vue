<template>
  <div id="app">
    <link-tutorial/>
    <img src="./assets/logo.png">
    <router-view/>
    <br/>
  </div>
</template>

<script>

import LinkTutorial from '@/components/LinkTutorial'

export default {
  name: 'app',
  components: {LinkTutorial}
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

img{
  margin-top: 48px;
}
</style>
