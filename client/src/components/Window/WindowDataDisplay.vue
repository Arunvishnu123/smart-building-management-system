<template>
<div class="window-data-contents">
    <w-tag class="window-name-heading" bg-color="primary" color="white" xl>
        Window Name - {{ window.name }}
    </w-tag>
    <w-flex>
        <w-button @click="editWindow(window)" class="edit-window ma1" color="white" bg-color="indigo-dark5" icon="fa fa-pencil"></w-button>
        <w-button @click="deleteWindowConfirm(window)" class="edit-window ma1" color="white" bg-color="red" icon="fa fa-trash-o"></w-button>
    </w-flex>

    <w-tag class="window-name" bg-color="grey-dark5" color="white" xl>
        Room No - {{ window.roomID }}
    </w-tag>
    <w-tag @click="changeWindowStatus(window)" class="window-status" v-if="window.windowStatus == 'OPEN'" lg color="white" bg-color="success-dark2">Window Opened</w-tag>
    <w-tag @click="changeWindowStatus(window)" class="window-status" v-else-if="window.windowStatus == 'CLOSE'" lg color="white" bg-color="error-dark2">Window Closed</w-tag>
</div>
</template>

<script>
import store from "../../store/index";
export default {
    data: () => ({
        someValue: 40,
        tagOn: false,
        image: "@/assets/windowOpen.png",
    }),

    props: ["window"],

    methods: {
        editWindow(window) {
            store.state.editNewWindow = true;
            console.log(store.state.editNewWindow);
            store.state.editWindowId = window.id;
            store.state.editNameWindow = window.name;
        },

        deleteWindowConfirm(window) {
            store.state.deleteWindowConfirm = true;
            console.log(store.state.deleteWindowConfirm);
            store.state.deleteWindowId = window.id
        },

        changeWindowStatus(window) {
            store.state.windowOpenCloseDialogBox = true;
            store.state.windowTurnOnID = window.id;
        }
    },

    mounted() {},
};
</script>

<style scoped>
.window-data-contents {
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

.edit-window {
    bottom: 32px;
}

.window-name-heading {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.window-name {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
    bottom: 18px;
}

.window-temp-value {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.window-temp-label {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.window-temp-desgin {
    margin-left: auto;
    margin-right: auto;
    display: block;
}

.window-temp-label {
    margin-left: auto;
    margin-right: auto;
    display: block;
}

.window-heater-button {
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.window-window-button {
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.window-status {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}
</style>
