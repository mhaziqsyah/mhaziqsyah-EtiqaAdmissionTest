<template>
     <v-data-table
      :headers="headers"
      :items="students"
    >
    <template v-slot:[`item.edit`]="{ item }">
        <v-btn color="success" @click="editItem(item)"> Edit </v-btn>
    </template>
    <template v-slot:[`item.delete`]="{ item }">
        <v-btn color="warning" @click="deleteItem(item.id)"> Delete </v-btn>
    </template>
    <template v-slot:[`item.view`]="{ item }">
        <v-btn color="primary" @click="goto(item.id)"> Submit </v-btn>
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
        { text: 'Clubs', value: 'club' },
        { text: 'Edit', value: 'edit' },
        { text: 'Delete', value: 'delete' },
      ],
      students: [
          {
            name: 'Haziq',
            email: 'haziq@gmail.com',
            club: 'Cooking Club',
          },
          {
            name: 'Puteri',
            email: 'puteri@gmail.com',
            club: 'Computer Club',
          },
          {
            name: 'Anis',
            email: 'anis@gmail.com',
            club: 'History Club',
          },
          {
            name: 'Farahin',
            email: 'farahin@gmail.com',
            club: 'English Club',
          },
          {
            name: 'syahmi',
            email: 'syahmi@gmail.com',
            club: 'Culture Club',
          },
          {
            name: 'Matthias',
            email: 'matthias@gmail.com',
            club: 'Science Club',
          },
          {
            name: 'nik amir',
            email: 'amir@gmail.com',
            club: 'Baking Club',
          }
      ]
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
         this.$store.commit("student/storeId", student.id);
         this.$store.commit("student/storeName", student.name);
         this.$store.commit("student/storeEmail", student.email);
         this.$store.commit("student/storePassword", student.password);
         this.$store.commit("student/storeClub", student.club);
     }
 }
}
</script>

<style>

</style>