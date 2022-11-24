<template>
  <div>
    <w-dialog
      v-model="addNewWindow"
      persistent
      width="500px"
      title-class="primary-light1--bg white"
    >
      <template #title>
        <w-icon class="mr2">fa fa-window-maximize </w-icon>
        Add new Window
      </template>
      <w-form @submit.prevent="onSubmitWindowData">
        <!-- <w-input v-model="buildingID" class="mb1" label="Building ID" round>
                    </w-input> -->
        <w-input v-model="nameWindow" class="mb1" label="Window Name" round>
        </w-input>
      
     
        <div class="spacer" />
        <w-button
          bg-color="warning"
          type="reset"
          @click="$store.state.addNewWindow = false"
          >Close</w-button
        >
        <w-button  class="submit-button-window my1" type="submit">
          Submit
        </w-button>
     
    </w-form>
    </w-dialog>
  </div>
</template>

<script>
import store from "../../store/index";
export default {
  name: "addNewWindow",

  data: () => ({}),

  methods: {
        onSubmitWindowData() {
            console.log(store);
            store.dispatch("onSubmitWindowData");
            store.state.addNewWindow = false
        },
    },
  computed: {
    addNewWindow: {
      get() {
        return store.state.addNewWindow;
      },
    },
  
    nameWindow: {
      get() {
        return store.state.nameWindow;
      },
      set(value) {
        store.commit("updateNameWindow", value);
      },
    },

    windowStatus: {
      get() {
        return store.state.windowStatus;
      },
      set(value) {
        store.commit("updateWindowStatus", value);
      },
    },
  },
};
</script>

<style scoped>
.submit-button-window {
  margin-left: 10px;
}
</style>
