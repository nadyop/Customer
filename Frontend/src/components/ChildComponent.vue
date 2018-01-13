<template>
  <div>
    <h2>Aku Child</h2>
    <h4>{{someProps}}</h4>
    <input type="String" v-model="someProps"/>
    <button @click="handleClick">Click to fire parent</button>

  </div>
</template>

<script>
  export default {
    name: 'Child-Component',
    props: {
      someProps: {
        type: String,
        default: ''
      }
    },
    data(){
      return{
        data1: 'Mantap'
      }
    },
    methods:{
      handleClick(){
        this.$emit('ClickMe', 'I Pass param ya')
      }
    }
  }
</script>

<style scoped>

</style>
