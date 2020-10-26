<template>
    <div class="container">
        <h1>Clientes</h1>
        <table class="table table-striped table table-bordered">
            <thead>
            <tr>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Teléfono</th>
                <th>Dirección</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(cliente , index) in Clientes" :key="index">
                <td>{{cliente.nombre}}</td>
                <td>{{cliente.correo}}</td>
                <td>{{cliente.telefono}}</td>
                <td>{{cliente.direccion}}</td>
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
                Clientes: []
            };
        },

        mounted() {
            this.obtenerClientes();
        },

        methods: {
            /* eslint-disable no-console */
            obtenerClientes() {
                http
                    .get("/clientes")
                    .then(response => {
                        this.Clientes = response.data._embedded.clientes;
                        console.log(response.data_embedded.clientes);
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            actualizar() {
                this.obtenerClientes();
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