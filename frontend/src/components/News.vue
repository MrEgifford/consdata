<template>
    <div>
        <div class="jumbotron">
            <h1 class="display-3">Breaking news!</h1>
            <p class="lead">Gorące wiadomości z Polski i reszty świata</p>
            <hr class="my-4">
            <p class="lead">
                <b-form inline>
                        <div class="col-md-2"/>
                        <div class="col-md-1">
                            Pokaż
                        </div>
                        <div class="dropdown col-md-2">
                            <select v-model="category" title="Select type" class="form-control ">
                                <option value="general" selected>Ogólne</option>
                                <option value="business">Biznesowe</option>
                                <option value="sport">Sportowe</option>
                            </select>
                        </div>
                        <div class="col-md-2">
                            wiadomości z
                        </div>
                        <div class="dropdown col-md-2">
                            <select v-model="country" title="Pick a number" class="form-control ">
                                
                                <option value="pl" selected>Polski</option>
                                <option value="de">Niemiec</option>
                                <option value="it">Włoch</option>
                            </select>
                        </div>
                        <button class="btn btn-primary col-md-2" type="button" @click="callRest()">Pokaż</button>
                        <div class="col-md-1"/>
                </b-form>
            </p>

        </div>
        <div v-for="article in response.articles" v-show="response !== null">
            
            <artic>
                <figure>
                    <img style="width:250px" v-bind:src="article.imageUrl" />
                </figure>
                <div class="date">{{article.date}}</div>
                <h3>{{article.title}}</h3>
                <p>{{article.description}}</p>
                <blockquote>
                    <b-link v-bind:href="article.articleUrl">Więcej...</b-link>
                </blockquote>
                
                
            </artic>
            </div>
     </div>
    
</template>

<script>
import axios from "axios";

export default {
  name: "News",
  data() {
    return {
      mojKomponentName: " Nazwa komponentu news",
      response: [],
      errors: [],
      country: "pl",
      category: "general"
    };
  },
  methods: {
    callRest() {
      axios
        .get("/api/news/" + this.country + "/" + this.category)
        .then(response => {
          this.response = response.data;
        })
        .catch(e => {
          this.errors.push(e);
        });
    }
  }
};
</script>

<style>

artic {
    display: grid;
    grid-template-columns: 1fr 1fr 10px 740px 10px 1fr 1fr;
    margin-bottom: 20px;

}
artic > * {
    grid-column: 4;
}
artic > blockquote {
    grid-column: 3 / 5;
    padding-left: 10px;
    color: #666;
   
}

figure {
    grid-column: 2 / 3;
    grid-row: 1 / 4; 
    margin: 20px 0;
}
artic > p {
    text-align:left;
}

artic > h3 {
     margin-top: 5px;
    margin-bottom: 15px;
}

.date{
    margin-top: 10px;
    margin-bottom: 10px;
    font-size: 12px;
    text-align: right;
}
.aside {
    grid-column: 5;
}


</style>

