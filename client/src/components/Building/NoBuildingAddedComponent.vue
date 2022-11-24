<!-- eslint-disable prettier/prettier -->
<template>
<div class="main-content">
    <div class="image-content">
        <w-image class="image-buildings" src="https://www.synox.io/wp-content/uploads/2021/08/smart-building-iot.jpg">
        </w-image>
        <w-image class="image-buildings" src="https://www.synox.io/wp-content/uploads/2021/08/smart-building-iot.jpg">
        </w-image>
    </div>

    <w-tag class="image-outline" bg-color="primary" color="white" xl height="3em">
        No building is added
    </w-tag>
</div>
</template>

<script>
export default {};
</script>

<style scoped>
.main-content {
    padding: 0;
    margin: 0;
}

.image-content {
    width: 100%;
    background-color: #383838;
    display: flex;
}

.image-buildings {
    margin-left: auto;
    margin-right: auto;
    display: block;
}

.image-outline {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}
</style>
