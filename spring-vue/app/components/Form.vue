<template>
    <v-form>
        <br>
        <h2>Form</h2>
        <br>
        <v-text-field v-if="id" v-model="id" label="Id"></v-text-field>
        <v-text-field v-model="name" label="Name"></v-text-field>
        <v-text-field v-model="email" label="Email"></v-text-field>
        <v-text-field v-model="password" label="Password"></v-text-field>
    <v-btn @click="submit({id, name ,email, password})">{{id ? 'edit': 'Submit' }}</v-btn>
    </v-form>
</template>

<script>
export default {
    computed:{
        id:{
            get(){
                return this.$store.state.student.id;
            },
            set(value){
                this.$store.commit("student/storeId", value)
            }
        },
        name:{
            get(){
                return this.$store.state.student.name;
            },
            set(value){
                this.$store.commit("student/storeName", value)
            }
        },
        email:{
            get(){
                return this.$store.state.student.email;
            },
            set(value){
                this.$store.commit("student/storeEmail", value)
            }
        },
        password:{
            get(){
                return this.$store.state.student.password;
            },
            set(value){
                this.$store.commit("student/storePassword", value)
            }
        }
    },
    methods:{
        async submit(student){
            if(student.id){
                await this.$axios.put("http://localhost:8080/students/"+ student.id, student);
            }
            else{
                await this.$axios.put("http://localhost:8080/students/", student);
            }
            await this.restForm({id:0, name:"", email:"", password:""});
        },
        restForm(student){
            this.$store.commit("student/storeId", student.id);
            this.$store.commit("student/storeName", student.name);
            this.$store.commit("student/storeEmail", student.email);
            this.$store.commit("student/storePassword", student.password);
        },
    },

}
</script>

<style>

</style>