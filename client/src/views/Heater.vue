<!-- eslint-disable prettier/prettier -->
<template>
<div>
    <w-app>
        <HeaderComponentVue :callAddNew="callHeaterPost" :headerTitle="title" :backPage="backPageRoom" />
        <!-- <NoRoomAddedComponentVue /> -->
        <w-grid columns="3" gap="3" class="wrapper">
            <div v-for="heater in $store.state.heaterlist" :key="heater.id" class="room-display">
                <HeaterDataDisplayVue :heater="heater" />
            </div>
        </w-grid>

        <AddHeaterComponentVue />
        <EditHeaterComponentVue />
        <DeleteHeaterConfirmVue />
        <HeaterTurnOwnDialogBoxComponentVue />
        <w-notification v-model="$store.state.heaterSuccessNotification" :timeout="timeout" warning plain bg-color="success" round shadow absolute class="notification-display">
            New heater is successfully added
        </w-notification>

        <w-notification v-model="$store.state.heaterDeletedSuccessNotification" :timeout="timeout1" warning plain bg-color="error-dark2" color="white" round shadow absolute class="notification-display">
            heater is successfully deleted
        </w-notification>

        <w-notification v-model="$store.state.heaterEditSuccessNotification" :timeout="timeout2" warning plain bg-color="light-green-dark4" color="white" round shadow absolute class="notification-display">
            heater is edited successfully
        </w-notification>

        <w-notification v-model="$store.state.heaterstatusChangeNotification" :timeout="timeout3" warning plain bg-color="light-green-dark4" color="white" round shadow absolute class="notification-display">
            heater status changed
        </w-notification>
    </w-app>
</div>
</template>

<script>
import HeaderComponentVue from "../components/Header/HeaderComponent.vue";
import HeaterDataDisplayVue from "../components/Heater/HeaterDataDisplay.vue";
import AddHeaterComponentVue from "../components/Heater/AddHeaterComponent.vue";
import EditHeaterComponentVue from "../components/Heater/EditHeaterComponent.vue";
import DeleteHeaterConfirmVue from "../components/Heater/DeleteConfirmComponent.vue";
import axios from "axios";
import serverUrl from "../../variable";
import HeaterTurnOwnDialogBoxComponentVue from "../components/Heater/HeaterTurnOwnDialogBoxComponent.vue";

import store from "../store/index";
export default {
    components: {
        HeaderComponentVue,
        HeaterDataDisplayVue,
        AddHeaterComponentVue,
        EditHeaterComponentVue,
        DeleteHeaterConfirmVue,
        HeaterTurnOwnDialogBoxComponentVue,
    },
    data: () => ({
        title: "Add a new Heater",
        heaters: [],
        timeout: 3000,
        timeout1: 3000,
        timeout2: 3000,
        timeout3: 3000
    }),
    methods: {
        callHeaterPost() {
            store.state.addNewHeater = true;
            console.log(store.state.addNewHeater);
        },

        getHeaterData() {
            axios
                .get(serverUrl + "/api/v1/heaters/" + store.state.currrentRoomID)
                .then((response) => {
                    this.heaters = response.data;
                    store.state.heaterlist = response.data;
                });
        },

        backPageRoom() {
            this.$router.push("/room");
        }
    },
    mounted() {
        this.getHeaterData();
    },
};
</script>

<style scoped>
.room-display {
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
