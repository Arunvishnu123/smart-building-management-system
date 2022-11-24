<!-- eslint-disable prettier/prettier -->
<template>
<div>
    <w-dialog v-model="turnOwnHeater" title="Change Heater Status" persistent :width="550">
        Do you want to change the heater status?

        <template #actions>
            <div class="spacer" />
            <w-button class="mr2" @click="$store.state.heaterTurnOnDialogBox = false" bg-color="error">
                No
            </w-button>
            <w-button @click="changeHeaterStatus()" bg-color="success">
                Yes
            </w-button>
        </template>
    </w-dialog>
</div>
</template>

<script>
import store from "../../store/index";
import axios from "axios";
import serverUrl from "../../../variable";
export default {
    data: () => ({
        dialog: {
            show: false,
        },
    }),

    methods: {
        changeHeaterStatus() {
            axios
                .put(
                    serverUrl +
                    "/api/v1/heater/" +
                    store.state.heaterTurnOnID +
                    "/status"
                )
                .then((response) => {
                    console.log("put", response.data.heaterStatus);
                    store.state.heaterstatusChangeNotification = true
                    store.state.heaterTurnOnDialogBox = false
                    axios
                        .get(serverUrl + "/api/v1/heaters/" + store.state.currrentRoomID)
                        .then((response) => {
                            store.state.heaterlist = response.data;
                        });

                });
        },
    },
    computed: {
        turnOwnHeater: {
            get() {
                return store.state.heaterTurnOnDialogBox;
            },
        },
    },
};
</script>

<style scoped></style>
