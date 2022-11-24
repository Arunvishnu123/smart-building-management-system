<template>
  <div>
    <w-app>
      <HeaderComponentVue
        :callAddNew="callRoomPost"
        :headerTitle="title"
       :backPage="backPageRoom"
       
      />
      <!-- <NoRoomAddedComponentVue /> -->
      <w-grid columns="3" gap="3" class="wrapper">
        <div
          v-for="room in $store.state.roomList"
          :key="room.id"
          class="room-display"
        >
          <RoomDataDisplayVue :room="room" />
        </div>
      </w-grid>

      <AddNewRoomVue />

      <w-notification
        v-model="$store.state.roomSuccessNotification"
        :timeout="timeout"
        warning
        bg-color="success"
        plain
        round
        shadow
        absolute
        class="notification-display"
      >
        Successfully new room is added
      </w-notification>

      
    </w-app>
  </div>
</template>

<script>
import HeaderComponentVue from "../components/Header/HeaderComponent.vue";
//import NoRoomAddedComponentVue from "../components/Room/NoRoomAddedComponent.vue";
import RoomDataDisplayVue from "../components/Room/RoomDataDisplay.vue";
import AddNewRoomVue from "../components/Room/AddRoomComponent.vue";
import store from "../store/index";
import axios from "axios";
import serverUrl from "../../variable";
export default {
  components: {
    HeaderComponentVue,
    //   NoRoomAddedComponentVue,
    RoomDataDisplayVue,
    AddNewRoomVue,
  },
  data: () => ({
    title: "Add a new Room",
    rooms: [],
    timeout:2000,
    backPage:false
  }),
  methods: {
    callRoomPost() {
      store.state.addNewRoom = true;
      console.log(store.state.addNewRoom);
    },

    getRoomData() {
      axios
        .get(serverUrl + "/api/v1/rooms/" + store.state.currrentBuildingID)
        .then((response) => {
          this.rooms = response.data;
          store.state.roomList = response.data;
          console.log(this.rooms);
        });
    },

    backPageRoom(){
      store.state.displayBackPageButton = false;
      this.$router.push("/");
      
      


    }
  },

  mounted() {
    this.getRoomData();
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

.notification-display{
    z-index: 1000091;
}
</style>
