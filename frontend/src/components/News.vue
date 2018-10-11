<template>
    <div>
        <b-alert :show="showAlert"
             dismissible
             @dismissed="showAlert=false"
             variant="danger">
             <h3>Olaboga! Problem!</h3>
             <p>{{errors}}</p>
        </b-alert>    
        <b-alert :show="showInfo"
             dismissible
             @dismissed="showInfo=false"
             variant="info">
             <h3>Nicość Panie, nic nie znaleziono</h3>
        </b-alert> 

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
            <div>
                <b-link v-b-toggle.collapse1 variant="primary">Zaawansowane</b-link>
                <b-collapse id="collapse1" class="mt-2 ">
                    <b-card class="mx-auto col-md-6 ">
                        <b-input-group prepend="Wpisz szukaną frazę :">
                            <b-form-input @keyup.enter="callRest()" v-model="keyword"></b-form-input>
                        </b-input-group>
                    </b-card>
                </b-collapse>
            </div>
        </div>
        <b-pagination align="center"
                      size="sm" 
                      :total-rows="totalRows" 
                      v-model="currentPage" 
                      ref="paginator"
                      v-show="articles.length > 0"
                      :per-page="rowsOnPage"/>
                      
        <div v-for="article in pagedArticles" >
            <div class="article">
                <div class="figure">
                    <img style="width:250px" :src="article.imageUrl" />
                </div>
                <div class="date">{{article.date}}</div>
                <h3>{{article.title}}</h3>
                <p>{{article.description}}</p>
                <b-link :href="article.articleUrl">Więcej...</b-link>
            </div>
        </div>
        
     </div>
</template>

<script>
import axios from "axios";

export default {
  name: "News",

  data() {
    return {
      articles: [],
      pagedArticles: [],
      errors: [],
      showAlert: false,
      showInfo: false,
      country: "pl",
      category: "general",
      keyword: "",
      currentPage: 1,
      rowsOnPage: 5,
      totalRows:0
    };
  },

  methods: {
    callRest() {
        axios.get(this.generateURL(), 
                {
                    timeout: 5000,
                    params: {keyword: this.keyword}
                })
            .then(response => {
                this.articles = response.data.articles;
                this.totalRows = this.articles.length;
                this.calculateArticlesOnPage();
            })
            .catch(e => {
                this.errors.push(e);
                this.showAlert = true;
            });
    },
    generateURL(){
        return "/news/" + this.country + "/" + this.category +"/";
    },
    calculateArticlesOnPage(){
        this.pagedArticles = this.articles.slice((this.currentPage - 1) * this.rowsOnPage, this.currentPage * this.rowsOnPage);
    }
  },
  watch:{
      currentPage(){
          this.calculateArticlesOnPage();
      },
      articles(){
          this.showInfo = this.articles.length === 0;
      }
  }
 
};
</script>

<style>

@import '../assets/css/styles.css';

</style>

