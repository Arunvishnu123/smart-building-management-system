<!-- eslint-disable prettier/prettier -->
<template>
<div>
    <w-dialog persistent v-model="addNewRoom" width="500px" title-class="primary-light1--bg white">
        <template #title>
            <w-icon class="mr2">fa fa-building-o </w-icon>
            Add new Room
        </template>
        <w-form @submit.prevent="onSubmitRoomData">

            <w-input type="number" v-model="roomID" class="mb1" label="Room ID" round>
            </w-input>
            <w-input v-model="roomName" class="mb1" label="Room Name" round>
            </w-input>

            <w-input v-model="roomTemperature" type="number" class="mb1" label="Room Temerature" round>
            </w-input>

            <div class="spacer" />
            <w-button bg-color="warning" type="reset" @click="$store.state.addNewRoom = false">Close</w-button>
            <w-button class="submit-button my1" type="submit"> Submit </w-button>
        </w-form>
    </w-dialog>
</div>
</template>

<script>
import store from "../../store/index";
export default {
    name: "addNewBuilding",

    data: () => ({}),

    computed: {
        addNewRoom: {
            get() {
                return store.state.addNewRoom;
            },
        },
        buildingID: {
            get() {
                return store.state.buildingIdRoom;
            },
            set(value) {
                store.commit("updateBuildingIdRoom", value);
            },
        },

        roomID: {
            get() {
                return store.state.roomID;
            },
            set(value) {
                store.commit("updateRoomID", value);
            },
        },

        roomName: {
            get() {
                return store.state.roomName;
            },
            set(value) {
                store.commit("updateRoomName", value);
            },
        },
        roomTemperature: {
            get() {
                return store.state.roomTemperature;
            },
            set(value) {
                store.commit("updateRoomTemperature", value);
            },
        },
    },

    methods: {
        onSubmitRoomData() {
            console.log(store);
            store.dispatch("onSubmitRoomData");
            store.state.addNewRoom = false;
        },
    },
};
</script>

<style scoped>
.submit-button {
    margin-left: 10px;
}
</style>
