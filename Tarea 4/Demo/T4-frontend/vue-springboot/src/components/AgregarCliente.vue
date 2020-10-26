<template>
  <div class="submitform">
        <div v-if="!submitted">
            <div class="form-group">
              <label for="nombre">Nombre</label>
              <input type="text" class="form-control" id="nombre" require v-model="cliente.nombre" nombre="nombre">
            </div>

            <div class="form-group">
                <label for="correo">Correo</label>
                <input type="correo" class="form-control" id="correo" require v-model="cliente.correo" correo="correo">
            </div>

            <div class="form-group">
                <label for="telefono">Teléfono</label>
                <input type="telefono" class="form-control" id="telefono" require v-model="cliente.telefono" telefono="telefono">
            </div>

            <div class="form-group">
                <label for="direccion">Dirección</label>
                <input type="direccion" class="form-control" id="direccion" require v-model="cliente.direccion" direccion="direccion">
            </div>
            <button v-on:click="guardarClientes" class="btn btn-success">Aceptar</button>
        </div>

        <div v-else>
            <h4>Se ha agregado correctamente!</h4>
            <div>
                <button class="btn btn-success" v-on:click="nuevocliente">Agregar</button>
                <a class="btn btn-danger" href="/" role="button">Volver</a>
            </div>
        </div>
    </div>
</template>

<script>
import http from "../http-common";
export default {
    titulo: "agregar cliente",
    data(){
        return{
            cliente:{
                id: 0,
                nombre: "",
                correo: "",
                telefono: "",
                direccion: "",
            },
            submitted: false
        };
    },
    methods:{
        /* eslint-disable no-console */
        guardarClientes(){
            var data={
                nombre: this.cliente.nombre,
                correo: this.cliente.correo,
                telefono: this.cliente.telefono,
                direccion: this.cliente.direccion
            };

            http
               .post("/clientes",data)
               .then(response=> {
                    this.cliente.id = response.data.id;
                    console.log(response.data);
                })
                .catch(e => {
                console.log(e);
                });
            this.submitted=true;
        },
        nuevocliente(){
            this.submitted=false;
            this.cliente={};
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


