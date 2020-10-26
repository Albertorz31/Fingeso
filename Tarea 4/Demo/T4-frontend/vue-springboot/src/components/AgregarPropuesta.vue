<template>
  <div class="submitform">
        <div v-if="!submitted">
            <div class="form-group">
              <label for="titulo">Titulo</label>
              <input type="text" class="form-control" id="titulo" require v-model="propuesta.titulo" titulo="titulo">
            </div>

            <div class="form-group">
                <label for="descripcion">Descripcion</label>
                <input type="descripcion" class="form-control" id="descripcion" require v-model="propuesta.descripcion" descripcion="descripcion">
            </div>
            <button v-on:click="guardarPropuesta" class="btn btn-success">Aceptar</button>
        </div>

        <div v-else>
            <h4>Se ha agregado correctamente!</h4>
            <button class="btn btn-success" v-on:click="nuevaPropuesta">Agregar otro cliente</button>
            <a class="btn btn-danger" href="/" role="button">Volver</a>
        </div>
    </div>
</template>

<script>
import http from "../http-common";
export default {
    titulo: "agregar propuesta",
    data(){
        return{
            propuesta:{
                id: 0,
                titulo: "",
                descripcion: "",
            },
            submitted: false
        };
    },
    methods:{
        /* eslint-disable no-console */
        guardarPropuesta(){
            var data={
                titulo: this.propuesta.titulo,
                descripcion: this.propuesta.descripcion
            };

            http
               .post("/propuestas",data)
               .then(response=> {
                    this.propuesta.id = response.data.id;
                    console.log(response.data);
                })
                .catch(e => {
                console.log(e);
                });
            this.submitted=true;
        },
        nuevaPropuesta(){
            this.submitted=false;
            this.propuesta={};
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


