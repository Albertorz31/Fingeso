<template>
    <div class="container">
        <h1>Usuarios</h1>
        <table class="table table-striped table table-bordered">
            <thead>
            <tr>
                <th>Nombre</th>
                <th>Correo</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(usuario , index) in Usuarios" :key="index">
                <td>{{usuario.nombre}}</td>
                <td>{{usuario.correo}}</td>
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
                Usuarios: []
            };
        },

        mounted() {
            this.obtenerUsuarios();
        },

        methods: {
            /* eslint-disable no-console */
            obtenerUsuarios() {
                http
                    .get("/usuarios")
                    .then(response => {
                        this.Usuarios = response.data._embedded.usuarios;
                        console.log(response.data_embedded.usuarios);
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