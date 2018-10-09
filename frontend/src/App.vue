<template>
  <div id="app">
    <News />
    
    <router-view/>
  </div>
</template>

<script>
import News from './components/News.vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  data() {
  	return{
    	test: 'testVAlue'
    	}
  },
  name: 'App',
  components: {
  	News
  }
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
