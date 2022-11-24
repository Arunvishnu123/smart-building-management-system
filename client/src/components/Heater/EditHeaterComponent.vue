<!-- eslint-disable prettier/prettier -->
<template>
<div>
    <w-dialog persistent v-model="editNewHeater" width="500px" title-class="primary-light1--bg white">
        <template #title>
            <w-icon class="mr2">fa fa-thermometer-empty </w-icon>
            Edit Heater
        </template>
        <w-form @submit.prevent=" editHeaterData">
            <!-- <w-input v-model="buildingID" class="mb1" label="Building ID" round>
                    </w-input> -->
            <w-input v-model="editName" class="mb1" label="Heater Name" round>
            </w-input>
            <w-input v-model=" editCurrentTemperature" type="number" class="mb1" label="Current Temperature" round>
            </w-input>

            <w-input v-model="editTargetTemperature" type="number" class="mb1" label="Target Temperature" round>
            </w-input>

            <div class="spacer" />
            <w-button bg-color="warning" type="reset" @click="$store.state.editNewHeater = false">Close</w-button>
            <w-button class="submit-button-heater-edit my1" type="submit">
                Submit
            </w-button>

        </w-form>
    </w-dialog>
</div>
</template>

<script>
import store from "../../store/index";
export default {
    name: "editHeater",

    data: () => ({}),
    computed: {
        editNewHeater: {
            get() {
                return store.state.editNewHeater;
            },
        },
        editCurrentTemperature: {
            get() {
                return store.state.editCurrentTemperature;
            },
            set(value) {
                store.commit("updateEditCurrentTemperature", value);
            },
        },

        editHeaterStatus: {
            get() {
                return store.state.editHeaterStatus;
            },
            set(value) {
                store.commit("updateEditHeaterStatus", value);
            },
        },

        editName: {
            get() {
                return store.state.editName;
            },
            set(value) {
                store.commit("updateEditName", value);
            },
        },

        editTargetTemperature: {
            get() {
                return store.state.editTargetTemperature;
            },
            set(value) {
                store.commit("updateEditTargetTemperature", value);
            },
        },
    },

    methods: {
        editHeaterData() {
            store.dispatch("updateHeaterData");
            store.state.editNewHeater = false
        }
    }
};
</script>

<style scoped>
.submit-button-heater-edit {
    margin-left: 10px;
}
</style>
