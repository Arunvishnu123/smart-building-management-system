<!-- eslint-disable prettier/prettier -->
<template>
<div>
    <w-dialog persistent v-model="addNewHeater" width="500px" title-class="primary-light1--bg white">
        <template #title>
            <w-icon class="mr2">fa fa-thermometer-empty </w-icon>
            Add new Heater
        </template>
        <w-form @submit.prevent="onSubmitHeaterData">
            <!-- <w-input v-model="buildingID" class="mb1" label="Building ID" round>
                    </w-input> -->
            <w-input v-model="name" class="mb1" label="Heater Name" round>
            </w-input>
            <w-input v-model="currentTemperature" type="number" class="mb1" label="Current Temperature" round>
            </w-input>

            <w-input v-model="targetTemperature" type="number" class="mb1" label="Target Temperature" round>
            </w-input>

            <div class="spacer" />
            <w-button bg-color="warning" type="reset" @click="$store.state.addNewHeater = false">Close</w-button>
            <w-button class="submit-button-heater my1" type="submit">
                Submit
            </w-button>
        </w-form>
    </w-dialog>
</div>
</template>

<script>
import store from "../../store/index";
export default {
    name: "addNewHeater",

    data: () => ({}),
    computed: {
        addNewHeater: {
            get() {
                return store.state.addNewHeater;
            },
        },

        currentTemperature: {
            get() {
                return store.state.currentTemperature;
            },
            set(value) {
                store.commit("updateCurrentTemperature", value);
            },
        },

        heaterStatus: {
            get() {
                return store.state.heaterStatus;
            },
            set(value) {
                store.commit("updateHeaterStatus", value);
            },
        },

        name: {
            get() {
                return store.state.name;
            },
            set(value) {
                store.commit("updateName", value);
            },
        },

        targetTemperature: {
            get() {
                return store.state.targetTemperature;
            },
            set(value) {
                store.commit("updateTargetTemperature", value);
            },
        },
    },

    methods: {
        onSubmitHeaterData() {
            console.log(store);
            store.dispatch("onSubmitHeaterData");
            store.state.addNewHeater = false
        },
    },
};
</script>

<style scoped>
.submit-button-heater {
    margin-left: 10px;
}
</style>
