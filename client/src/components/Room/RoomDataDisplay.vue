<template>
<div class="room-data-contents">
    <w-tag class="room-name" bg-color="primary" color="white" xl>
        Room No - {{ room.roomID }}
    </w-tag>
    <w-tag class="room-name" bg-color="grey-dark5" color="white" xl>
        Room Name - {{ room.roomName }}
    </w-tag>
    <div class="temp-desgin">
        <w-tag class="room-name" bg-color="grey-dark5" color="white" xl>
            Temperature
        </w-tag>
        <vue3-slider disabled v-model="someValue" color="#FB278D" track-color="#FEFEFE" />
        <w-tag class="temp-value" bg-color="grey-dark5" color="white" xl>
            {{ room.roomTemperature }} <br />
            <span>&#8451;</span>
        </w-tag>
    </div>

    <div class="buttons">
        <w-button class="heater-button ma1" bg-color="primary" @click="goToHeater(room)" target="_blank">
            Heater lists
            <w-icon class="ml1">fa fa-thermometer-empty </w-icon>
        </w-button>

        <w-button class="window-button ma1" bg-color="primary" @click="goToWindow(room)" route="/getting-started" target="_blank">
            Window Lists
            <w-icon class="ml1">fa fa-window-maximize</w-icon>
        </w-button>
    </div>
</div>
</template>

<script>
import slider from "vue3-slider";
import store from "../../store/index";
export default {
    data: () => ({
        someValue: 50,
    }),

    props: ["room"],
    components: {
        "vue3-slider": slider,
    },
    methods: {
        goToHeater(room) {
            this.$router.push("/room/heater");
            store.state.currrentRoomID = room.roomID;
            console.log("weururueruereyreyrery", store.state.currrentRoomID);
        },

        goToWindow(room) {
            this.$router.push("/room/window");
            store.state.currrentRoomID = room.roomID;
        },
    },
};
</script>

<style scoped>
.room-data-contents {
    width: 400px;
    background-color: #383838;
    margin-left: auto;
    margin-right: auto;
    display: block;
    border-width: 3px;
    border-color: #474747;
    border-style: solid;
    border-radius: 6px;
}

.room-name {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.temp-value {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.buttons {
    text-align: center;
}

.temp-label {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.temp-desgin {
    margin-left: auto;
    margin-right: auto;
    display: block;
}

.temp-label {
    margin-left: auto;
    margin-right: auto;
    display: block;
}

.heater-button {
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.window-button {
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}
</style>
