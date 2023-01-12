import { defineStore } from "pinia";

export default defineStore("userStore",{
    state() {
        return {
            checkUser: null,
        }
    },
    getters: {
        user() {
            return this.checkUser
        },
    },
    actions:{
        setUser(value){
            this.checkUser = value
        },
    }
})