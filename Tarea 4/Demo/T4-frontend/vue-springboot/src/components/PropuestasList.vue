<template>
<div class="container">
    <h1>Propuestas</h1>
    <table class="table table-striped table table-bordered">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Fecha de ingreso</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(propuesta , index) in Propuestas" :key="index">
            <td>{{propuesta.titulo}}</td>
            <td>{{propuesta.descripcion}}</td>
            <td>{{propuesta.date}}</td>
            <td><span class="button btn-light" v-on:click="eliminarPropuesta(index)">Eliminar</span></td>
        </tr>
        </tbody>
    </table>
</div>
</template>

<script>
    import http from "../http-common";

    export default {
        titulo: "lista",
        data() {
            return {
                Propuestas: []
            };
        },

        mounted() {
            this.obtenerPropuestas();
        },

        methods: {
            /* eslint-disable no-console */
            obtenerPropuestas() {
                http
                    .get("/propuestas")
                    .then(response => {
                        this.Propuestas = response.data._embedded.propuestas;
                        console.log(response.data_embedded.propuestas);
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            eliminarPropuesta(index) {
                http
                    .delete("/propuesta/" + index)
                    .then(response => {
                        console.log(response.data);
                        this.$emit("refresh");
                        this.$router.push('/');
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            actualizar() {
                this.obtenerPropuestas();
            }
        }
    };
</script>

<style>
    .list {
        text-align: left;
        max-width: 450px;
        margin: auto;
    }
</style>