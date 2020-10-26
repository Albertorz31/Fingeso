<template>
  <div class="submitform">
        <div v-if="!submitted">
            <div class="form-group">
              <label for="nombre">Nombre</label>
              <input type="text" class="form-control" id="nombre" require v-model="usuario.nombre" nombre="nombre">
            </div>

            <div class="form-group">
                <label for="correo">Correo</label>
                <input type="correo" class="form-control" id="correo" require v-model="usuario.correo" correo="correo">
            </div>
            <button v-on:click="guardarUsuario" class="btn btn-success">Aceptar</button>
        </div>

        <div v-else>
            <h4>Se ha agregado correctamente!</h4>
            <button class="btn btn-success" v-on:click="nuevoUsuario">Agregar otro usuario</button>
            <a class="btn btn-danger" href="/" role="button">Volver</a>
        </div>
    </div>
</template>

<script>
import http from "../http-common";
export default {
    titulo: "agregar usuario",
    data(){
        return{
            usuario:{
                id: 0,
                nombre: "",
                correo: "",
            },
            submitted: false
        };
    },
    methods:{
        /* eslint-disable no-console */
        guardarUsuario(){
            var data={
                nombre: this.usuario.nombre,
                correo: this.usuario.correo
            };

            http
               .post("/usuarios",data)
               .then(response=> {
                    this.usuario.id = response.data.id;
                    console.log(response.data);
                })
                .catch(e => {
                console.log(e);
                });
            this.submitted=true;
        },
        nuevoUsuario(){
            this.submitted=false;
            this.usuario={};
        }
    }
};
</script>

<style>
.submitform {
  max-width: 300px;
  margin: auto;
}
</style>  

