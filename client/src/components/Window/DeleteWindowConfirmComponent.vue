<template>
  <div>
    <w-dialog
      v-model="deleteWindow"
      title="Delete Window"
      persistent
      :width="550"
    >
      Do you want delete this Window?

      <template #actions>
        <div class="spacer" />
        <w-button
          class="mr2"
          @click="$store.state.deleteWindowConfirm = false"
          bg-color="error"
        >
          No
        </w-button>
        <w-button @click="deleteSelectedWindow()" bg-color="success">
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
    deleteSelectedWindow() {
      axios
        .delete(serverUrl + "/api/v1/windows/" + store.state.deleteWindowId)
        .then((response) => {
          store.state.windowDeletedSuccessNotification = true;
          console.log("Deleted", response);
          axios
        .get(serverUrl + "/api/v1/windows/" + store.state.currrentRoomID)
        .then((response) => {
          store.state.windowList = response.data;
        });
        });

      store.state.deleteWindowConfirm = false;
    },
  },

  computed: {
    deleteWindow: {
      get() {
        return store.state.deleteWindowConfirm;
      },
    },
  },
};
</script>

<style scoped></style>
