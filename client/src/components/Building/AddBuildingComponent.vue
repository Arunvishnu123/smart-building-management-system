<!-- eslint-disable prettier/prettier -->
<template>
<div>
    <w-dialog persistent v-model="addNewBuilding" width="500px" title-class="primary-light1--bg white">
        <template #title>
            <w-icon class="mr2">fa fa-building-o </w-icon>
            Add new building
        </template>
        <w-form @submit.prevent="onSubmitBuildingData">
            <w-input type="number" v-model="buildingID" class="mb1" label="Building ID" round>
            </w-input>
            <w-input v-model="buildingName" class="mb1" label="Building Name" round>
            </w-input>
            <w-input v-model="buildingAddress" class="mb1" label="BuildingAddress" round>
            </w-input>

            <w-input type="number" v-model="buildingSize" class="mb1" label="Building Size" round>
            </w-input>
            <w-input type="number" v-model="buildingAge" class="mb1" label="Building Age" round>
            </w-input>
            <w-input v-model="storeyNumber" class="mb1" label="Number of Storeys" round>
            </w-input>

            <w-input v-model="buildingOwner" class="mb1" label="Building Owner" round>
            </w-input>

            <w-button bg-color="warning" type="reset" @click="$store.state.addNewBuilding = false">Close</w-button>
            <w-button class="submit-button my1" type="submit"> Validate </w-button>
        </w-form>
    </w-dialog>
</div>
</template>

<script>
import store from "../../store/index";

export default {
    name: "addNewBuilding",
    mounted() {
        //  console.log("divjiosdjfisdf",  addNewBuilding)
    },

    data: () => ({}),

    computed: {
        addNewBuilding: {
            get() {
                return store.state.addNewBuilding;
            },
        },

        buildingID: {
            get() {
                return store.state.buildingId;
            },
            set(value) {
                store.commit("updateBuildingId", value);
            },
        },

        buildingName: {
            get() {
                return store.state.buildingName;
            },
            set(value) {
                store.commit("updateBuildingName", value);
            },
        },

        buildingAddress: {
            get() {
                return store.state.buildingAddress;
            },
            set(value) {
                store.commit("updateBuildingAddress", value);
            },
        },
        buildingSize: {
            get() {
                return store.state.buildingSize;
            },
            set(value) {
                store.commit("updateBuildingSize", value);
            },
        },
        buildingAge: {
            get() {
                return store.state.buildingAge;
            },
            set(value) {
                store.commit("updateBuildingAge", value);
            },
        },
        storeyNumber: {
            get() {
                return store.state.storeyNumber;
            },
            set(value) {
                store.commit("updateStoreyNumber", value);
            },
        },
        buildingOwner: {
            get() {
                return store.state.buildingOwner;
            },
            set(value) {
                store.commit("updateBuildingOwner", value);
            },
        },
    },

    methods: {
        onSubmitBuildingData() {
            console.log(store);
            store.dispatch("onSubmitBuildingData");
            store.state.addNewBuilding = false
        },
    },
};
</script>

<style scoped>
.submit-button {
    margin-left: 10px;
}
</style>
