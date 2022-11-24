<!-- eslint-disable prettier/prettier -->
<template>
<div class="main">
    <w-app>
        <HeaderComponentVue :callAddNew="callBuildingPost" :headerTitle="title" :refreshPage="getBuildingData" />
        <!-- <NoBuildingFoundComponentVue /> -->
        <w-grid columns="3" gap="3" class="wrapper">
            <div v-for="building in $store.state.buildingList" :key="building.id">
                <BuildingDataDisplayComponentVue :building="building" />
            </div>
        </w-grid>
        <AddNewBuildingComponentVue />
        <w-notification v-model="$store.state.buildingSuccessNotification" :timeout="timeout" warning plain bg-color="success" round shadow absolute class="notification-display">
            Successfully building data is added
        </w-notification>
    </w-app>
</div>
</template>

<script>
//import NoBuildingFoundComponentVue from "../components/Building/NoBuildingAddedComponent.vue";
import HeaderComponentVue from "../components/Header/HeaderComponent.vue";
import BuildingDataDisplayComponentVue from "../components/Building/BuildingDataDisplayComponent.vue";
import AddNewBuildingComponentVue from "../components/Building/AddBuildingComponent.vue";
import store from "../store/index";
import axios from "axios";
import serverUrl from "../../variable";

export default {
    components: {
        HeaderComponentVue,
        // NoBuildingFoundComponentVue,
        BuildingDataDisplayComponentVue,
        AddNewBuildingComponentVue,
    },
    data: function () {
        return {
            buildings: [],
            title: "Add a new Building",
            showNotification: false,
            timeout: 2000
        };
    },
    computed: {},
    methods: {
        callBuildingPost() {
            store.state.addNewBuilding = true;
            console.log(store.state.addNewBuilding);
        },

        getBuildingData() {
            axios.get(serverUrl + "/api/v1/buildings").then((response) => {
                this.buildings = response.data;
                store.state.buildingList = response.data;
                console.log(this.buildings);
            });
        },
    },

    mounted() {
        this.getBuildingData();
    },
};
</script>

<style scoped>
.main {
    padding: 0;
    margin: 0;
}

.building-display {
    display: contents;
    align-content: center;
    text-align: justify;
    text-align: center;
    align-items: center;
}

.notification-display {
    z-index: 1000091;
}
</style>
