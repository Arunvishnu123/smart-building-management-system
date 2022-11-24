<template>
  <div class="main-content-window">
    <div class="image-content-window">
      <w-image
        class="image-window"
        src="https://www.synox.io/wp-content/uploads/2021/08/smart-building-iot.jpg"
      >
      </w-image>
      <w-image
        class="image-window"
        src="https://www.synox.io/wp-content/uploads/2021/08/smart-building-iot.jpg"
      >
      </w-image>
    </div>

    <w-tag
      class="image-outline-window"
      bg-color="primary"
      color="white"
      xl
      height="3em"
    >
      No Window is added
    </w-tag>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.main-content-window {
  padding: 0;
  margin: 0;
}

.image-content-window {
  width: 100%;
  background-color: #383838;
  display: flex;
}

.image-window {
  margin-left: auto;
  margin-right: auto;
  display: block;
}

.image-outline-window {
  width: 100%;
  font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}
</style>
