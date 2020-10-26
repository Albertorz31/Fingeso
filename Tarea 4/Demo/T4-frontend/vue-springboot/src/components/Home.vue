<template>
  <div class="container_fluid">
    <div class="site-info">
      <img src="https://www.symbiose.cl/assets/img/symbiose-logo-72.png"
      width="220" height="80">
      <h3>Propuestas</h3>
    
    <nav>
      <router-link class="btn btn-info btn-lg" to="/propuestas">Lista de Propuestas</router-link>
      <h3></h3>
      <router-link class="btn btn-info btn-lg" to="/agregar">Agregar Propuesta</router-link>
      <h3>Clientes</h3>
      <router-link class="btn btn-info btn-lg" to="/clientes">Lista de Clientes</router-link>
      <h3></h3>
      <router-link class="btn btn-info btn-lg" to="/agregarCliente">Agregar Cliente</router-link>
      <h3>Usuarios</h3>
      <router-link class="btn btn-info btn-lg" to="/usuarios">Lista de Usuarios</router-link>
      <h3></h3>
      <router-link class="btn btn-info btn-lg" to="/agregarUsuario">Agregar Usuario</router-link>
    </nav>
    </div>
  </div>
</template>

<script>
export default{
  name: "app"
};
</script>

<style>
.site-info {
  color: rgb(3, 117, 112);
  margin-bottom: 20px;
}
 
.btn-primary {
  margin-right: 5px;
}
 
.container-fluid {
  text-align: center;
}
</style>