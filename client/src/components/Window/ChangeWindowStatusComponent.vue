<!-- eslint-disable prettier/prettier -->
<!-- eslint-disable prettier/prettier -->
<template>
  <div>
    <w-dialog
      v-model="openWindow"
      title="Change Window Status"
      persistent
      :width="550"
    >
      Do you want to change the Window Status?

      <template #actions>
        <div class="spacer" />
        <w-button
          class="mr2"
          @click="$store.state.windowOpenCloseDialogBox = false"
          bg-color="error"
        >
          No
        </w-button>
        <w-button @click="changeWindowStatus()" bg-color="success">
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
    changeWindowStatus() {
      axios
        .put(
          serverUrl + "/api/v1/window/" + store.state.windowTurnOnID + "/status"
        )
        .then((response) => {
          store.state.windowStatusChangedNotification = true;
          console.log("put", response);
          store.state.windowOpenCloseDialogBox = false
          axios
            .get(serverUrl + "/api/v1/windows/" + store.state.currrentRoomID)
            .then((response) => {
              this.windows = response.data;
              store.state.windowList = response.data;
            });
        });
    },
  },
  computed: {
    openWindow: {
      get() {
        return store.state.windowOpenCloseDialogBox;
      },
    },
  },
};
</script>

<style scoped></style>
