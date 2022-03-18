<template>
     <v-data-table
      :headers="headers"
      :items="students"
    >
    <template v-slot:[`item.edit`]="{ item }">
        <v-btn color="success" @click="editItem(item)"> Edit </v-btn>
    </template>
    <template v-slot:[`item.delete`]="{ item }">
        <v-btn color="warning" @click="deleteItem(item.id)"> Edit </v-btn>
    </template>
    <template v-slot:[`item.view`]="{ item }">
        <v-btn color="primary" @click="goto(item.id)"> Edit </v-btn>
    </template>
    </v-data-table>
</template>

<script>
export default {

 data () {
    return {
      headers: [
        { text: 'Name', value: 'name' },
        { text: 'Email', value: 'email' },
        { text: 'Password', value: 'password' },
        { text: 'Edit', value: 'edit' },
        { text: 'Delete', value: 'password' },
      ],
    }
 },
 computed:{
     students(){
         return this.$store.state.students.data;
     }
 },
 async fetch(){
     this.$store.commit(
         "students/storeData",
         (await this.$axios.get("http://localhost:8080/students/")).data
     )
 },
 methods:{
     async deleteItem(id){
         await this.$axios.delete("http://localhost:8080/students/" + id)
         this.$store.commit(
         "students/storeData",
         (await this.$axios.get("http://localhost:8080/students/")).data
     )
     },
     async editItem(student){
         this.$store.commit("students/storeId", student.id);
         this.$store.commit("students/storeName", student.name);
         this.$store.commit("students/storeEmail", student.email);
         this.$store.commit("students/storePassword", student.password);
     }
 }
}
</script>

<style>

</style>