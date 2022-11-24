<!-- eslint-disable prettier/prettier -->
<template>
<div class="heater-data-contents">
    <w-tag class="heater-name-heading" bg-color="primary" color="white" xl>
        Heater Name - {{ heater.name }}
    </w-tag>

    <w-flex>
        <w-button @click="editheater(heater)" class="edit-heater ma1" color="white" bg-color="indigo-dark5" icon="fa fa-pencil"></w-button>
        <w-button @click="deleteheaterConfirm(heater)" class="edit-heater ma1" color="white" bg-color="red" icon="fa fa-trash-o"></w-button>
    </w-flex>
    <w-tag class="heater-name" bg-color="grey-dark5" color="white" xl>
        Room No - {{ $store.state.currrentRoomID }}
    </w-tag>
    <div class="heater-temp-desgin">
        <w-tag class="room-name" bg-color="grey-dark5" color="white" xl>
            Current Temperature -
        </w-tag>
        <vue3-slider disabled v-model="someValue" color="#800d34" track-color="#FEFEFE" />
        <w-tag class="heater-temp-value" bg-color="grey-dark5" color="white" xl>
            {{ heater.currentTemperature }} <br />
            <span>&#8451;</span>
        </w-tag>
    </div>
    <div class="heater-temp-desgin">
        <w-tag class="room-name" bg-color="grey-dark5" color="white" xl>
            Target Temperature -
        </w-tag>
        <vue3-slider disabled v-model="someValue" color="#275a29" track-color="#FEFEFE" />
        <w-tag class="heater-temp-value" bg-color="grey-dark5" color="white" xl>
            {{ heater.targetTemperature }} <br />
            <span>&#8451;</span>
        </w-tag>
    </div>
    <w-tag @click="heaterTurnOnDialogBox(heater)" class="heater-status" v-if="heater.heaterStatus == 'ON'" lg color="white" bg-color="success-dark2">Turn ON Heater</w-tag>
    <w-tag @click="heaterTurnOnDialogBox(heater)" class="heater-status" v-else-if="heater.heaterStatus == 'OFF'" lg color="white" bg-color="error-dark2">Turn OFF Heater</w-tag>
</div>
</template>

<script>
import slider from "vue3-slider";
import store from "../../store/index";
export default {
    data: () => ({
        someValue: 34,
        tagOn: false,
    }),
    components: {
        "vue3-slider": slider,
    },

    props: ["heater"],
    editId: 0,
    editCurrentTemperature: 0,
    editHeaterStatus: false,
    editName: null,
    editTargetTemperature: null,
    methods: {
        editheater(heater) {
            store.state.editNewHeater = true;
            console.log(store.state.editNewHeater);
            store.state.editName = heater.name;
            store.state.editCurrentTemperature = heater.currentTemperature;
            store.state.editTargetTemperature = heater.targetTemperature;
            store.state.editId = heater.id;
        },

        deleteheaterConfirm(heater) {
            store.state.deleteHeaterConfirm = true;
            console.log(store.state.deleteHeaterConfirm);
            store.state.deleteHeaterId = heater.id;
        },

        heaterTurnOnDialogBox(heater) {
            store.state.heaterTurnOnDialogBox = true;
            store.state.heaterTurnOnID = heater.id;
            console.log(store.state.heaterTurnOnDialogBox);
            store.state.currentHeaterStatus = heater.heaterStatus;

        },

    }
};
</script>

<style scoped>
.heater-data-contents {
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

.edit-heater {
    bottom: 32px;
}

.heater-name-heading {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.heater-name {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.heater-temp-value {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.heater-temp-label {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.heater-temp-desgin {
    margin-left: auto;
    margin-right: auto;
    display: block;
}

.heater-temp-label {
    margin-left: auto;
    margin-right: auto;
    display: block;
}

.heater-heater-button {
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.heater-window-button {
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.heater-status {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}
</style>
