<!-- eslint-disable prettier/prettier -->
<!-- eslint-disable prettier/prettier -->
<!-- eslint-disable prettier/prettier -->
<template>
<div>
    <w-app>
        <HeaderComponentVue :callAddNew="callWindowPost" :headerTitle="title" :refreshPage="getWindowData" :backPage="backPageRoom" />
        <!-- <NoRoomAddedComponentVue /> -->
        <w-grid columns="3" gap="3" class="wrapper">
            <div class="window-display" v-for="window in $store.state.windowList" :key="window.id">
                <WindowDataDisplayVue :window="window" />
            </div>
        </w-grid>
        <AddWindowComponentVue />
        <EditWindowComponentVue />
        <DeleteWindowConfirmComponentVue />
        <ChangeWindowStatusComponentVue />
        <w-notification v-model="$store.state.windowSuccessNotification" :timeout="timeout" warning plain bg-color="success" round shadow absolute class="notification-display">
            New Window is successfully added
        </w-notification>

        <w-notification v-model="$store.state.windowDeletedSuccessNotification" :timeout="timeout1" warning plain bg-color="error-dark2" color="white" round shadow absolute class="notification-display">
            window is successfully deleted
        </w-notification>

        <w-notification v-model="$store.state.windowEditSuccessNotfication" :timeout="timeout2" warning plain bg-color="light-green-dark4" color="white" round shadow absolute class="notification-display">
            Window is edited successfully
        </w-notification>

        <w-notification v-model="$store.state.windowStatusChangedNotification" :timeout="timeout3" warning plain bg-color="light-green-dark4" color="white" round shadow absolute class="notification-display">
            window status changed
        </w-notification>
    </w-app>
</div>
</template>

<script>
import HeaderComponentVue from "../components/Header/HeaderComponent.vue";
import WindowDataDisplayVue from "../components/Window/WindowDataDisplay.vue";
import AddWindowComponentVue from "../components/Window/AddWindowComponent.vue";
import EditWindowComponentVue from "../components/Window/EditWindowComponent.vue";
import DeleteWindowConfirmComponentVue from "../components/Window/DeleteWindowConfirmComponent.vue";
import axios from "axios";
import serverUrl from "../../variable";
import ChangeWindowStatusComponentVue from "../components/Window/ChangeWindowStatusComponent.vue";

import store from "../store/index";
export default {
    components: {
        HeaderComponentVue,
        WindowDataDisplayVue,
        AddWindowComponentVue,
        EditWindowComponentVue,
        DeleteWindowConfirmComponentVue,
        ChangeWindowStatusComponentVue
    },
    data: () => ({
        title: "Add a new Window",
        windows: [],
        timeout: 3000,
        timeout1: 3000,
        timeout2: 3000,
        timeout3: 3000,

    }),
    methods: {
        callWindowPost() {
            store.state.addNewWindow = true;
            console.log(store.state.addNewWindow);
        },

        getWindowData() {
            axios
                .get(serverUrl + "/api/v1/windows/" + store.state.currrentRoomID)
                .then((response) => {
                    this.windows = response.data;
                    store.state.windowList = response.data;
                });
        },

        backPageRoom() {
            this.$router.push("/room");
        }
    },

    mounted() {
        this.getWindowData();
    },
};
</script>

<style scoped>
.window-display {
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
