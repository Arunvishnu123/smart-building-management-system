<template>
<div class="main-content-heater">
    <div class="image-content-heater">
        <w-image class="image-heater" src="https://www.synox.io/wp-content/uploads/2021/08/smart-building-iot.jpg">
        </w-image>
        <w-image class="image-heater" src="https://www.synox.io/wp-content/uploads/2021/08/smart-building-iot.jpg">
        </w-image>
    </div>

    <w-tag class="image-outline-heater" bg-color="primary" color="white" xl height="3em">
        No heater is added
    </w-tag>
</div>
</template>

<script>
export default {};
</script>

<style scoped>
.main-content-heater {
    padding: 0;
    margin: 0;
}

.image-content-heater {
    width: 100%;
    background-color: #383838;
    display: flex;
}

.image-heater {
    margin-left: auto;
    margin-right: auto;
    display: block;
}

.image-outline-heater {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}
</style>
