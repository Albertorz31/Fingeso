<template>
  <div id="app" class="container_fluid">
    <router-view></router-view>
  </div>
</template>

<script>
export default{
  name: "app"
};
</script>

<style>
.site-info {
  color: blue;
  margin-bottom: 20px;
}
 
.btn-primary {
  margin-right: 5px;
}
 
.container-fluid {
  text-align: center;
}
</style>
