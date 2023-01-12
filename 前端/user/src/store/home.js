import { defineStore } from "pinia";

export default defineStore("home",{
    state() {
        return{
            toastText:"",
            loadingVisible: false,
            menuRouteLoad: false
        }
    },
    actions: {
        menuRouteLoaded(nv){
            this.menuRouteLoad=nv
        }
    }
})