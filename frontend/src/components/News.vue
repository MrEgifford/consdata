<template>
    <div>
        Tutaj jest nowy komponent {{mojKomponentName}}
        <button class=”Search__button” @click="callRest()">CALL Spring Boot REST backend service</button>
 
        <h3>{{ response }}</h3>
    </div>
    
</template>

<script>

import axios from 'axios'

export default {
    name: 'News',
    data() {
        return{
            mojKomponentName: ' Nazwa komponentu news',
            response: [],
            errors: []
        }
    },
    methods: {
        callRest(){
            axios.get('/api/news')
                .then(response=>{
                    this.response = response.data
                })
                .catch( e=>{
                    this.errors.push(e)
                })
        }
    }
}    
</script>