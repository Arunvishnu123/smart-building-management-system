<template>
<div>
    <w-dialog v-model="deleteHeater" title="Delete Heater" persistent :width="550">
        Do you want delete this Heater?

        <template #actions>
            <div class="spacer" />
            <w-button class="mr2" @click="$store.state.deleteHeaterConfirm = false" bg-color="error">
                No
            </w-button>
            <w-button @click="deleteSelectedHeater()" bg-color="success">
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
        deleteSelectedHeater() {
            axios
                .delete(serverUrl + "/api/v1/heaters/" + store.state.deleteHeaterId)
                .then((response) => {
                    console.log("Deleted", response);
                    store.state.heaterDeletedSuccessNotification = true
                    axios
                        .get(serverUrl + "/api/v1/heaters/" + store.state.currrentRoomID)
                        .then((response) => {
                            store.state.heaterlist = response.data;
                        });
                });

            store.state.deleteHeaterConfirm = false;
        },
    },

    computed: {
        deleteHeater: {
            get() {
                return store.state.deleteHeaterConfirm;
            },
        },
    },
};
</script>

<style scoped></style>
