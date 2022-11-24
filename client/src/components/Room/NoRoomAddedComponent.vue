<template>
<div class="main-content-room">
    <div class="image-content-room">
        <w-image class="image-room" src="data:image/png;base64,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">
        </w-image>
        <!-- <w-image class="image-room" src="">
        </w-image> -->
    </div>

    <w-tag class="image-outline-room" bg-color="primary" color="white" xl height="3em">
        No room is added to the building
    </w-tag>
</div>
</template>

<script>
export default {};
</script>

<style scoped>
.main-content-room {
    padding: 0;
    margin: 0;
}

.image-content-room {
    width: 100%;
    background-color: #383838;
    display: flex;
}

.image-room {
    margin-left: auto;
    margin-right: auto;
    display: block;
}

.image-outline-room {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}
</style>
