import Vue from "vue";
import Router from "vue-router";
import Home from "./components/Home.vue";
import AgregarCliente from "./components/AgregarCliente.vue";
import AgregarPropuesta from "./components/AgregarPropuesta.vue";
import AgregarUsuario from "./components/AgregarUsuario.vue";
import PropuestasList from "./components/PropuestasList";
import ClientesList from "./components/ClientesList";
import UsuarioList from "./components/UsuarioList";

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        {
            path: "/propuestas",
            name: "propuestas",
            component: PropuestasList
        },

        {
            path: "/",
            name: "home",
            component: Home
        }
        ,
        {  
            path: "/agregar",
            name: "agregar",
            component: AgregarPropuesta
        },
        
        {  
            path: "/AgregarCliente",
            name: "agregarCliente",
            component: AgregarCliente
        },
        {
            path: "/clientes",
            name: "clientes",
            component: ClientesList
        },
        {  
            path: "/AgregarUsuario",
            name: "agregarUsuario",
            component: AgregarUsuario
        },

        {
            path: "/usuarios",
            name: "usuarios",
            component: UsuarioList
        }

    ]
});