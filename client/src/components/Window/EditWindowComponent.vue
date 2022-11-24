<template>
  <div>
    <w-dialog
      v-model="editNewWindow"
      persistent
      width="500px"
      title-class="primary-light1--bg white"
    >
      <template #title>
        <w-icon class="mr2">fa fa-window-maximize </w-icon>
        Edit new Window
      </template>
      <w-form @submit.prevent="updateWindow">
        <!-- <w-input v-model="buildingID" class="mb1" label="Building ID" round>
                    </w-input> -->
        <w-input v-model="editNameWindow" class="mb1" label="Window Name" round>
        </w-input>
     
   
        <div class="spacer" />
        <w-button
          bg-color="warning"
          type="reset"
          @click="$store.state.editNewWindow = false"
          >Close</w-button
        >
        <w-button class="submit-button-window my1" type="submit">
          Submit
        </w-button>
    </w-form>
    </w-dialog>
  </div>
</template>

<script>
import store from "../../store/index";
export default {
  name: "editNewWindow",

  data: () => ({}),
  computed: {
    editNewWindow: {
      get() {
        return store.state.editNewWindow;
      },
    },
    editNameWindow: {
      get() {
        return store.state.editNameWindow;
      },
      set(value) {
        store.commit("updateEditWindowName", value);
      },
    },

    editWindowStatus: {
      get() {
        return store.state.editWindowStatus;
      },
      set(value) {
        store.commit("updateEditWindowName", value);
      },
    },
  },

  methods:{
    updateWindow(){
        store.dispatch("updateWindowData");
        store.state.editNewWindow = false
    }
  }
};
</script>

<style scoped>
.submit-button-window {
  margin-left: 10px;
}
</style>
