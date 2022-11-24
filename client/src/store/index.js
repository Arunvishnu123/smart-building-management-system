/* eslint-disable prettier/prettier */
import {
  createStore
} from "vuex";
import axios from "axios";
import serverUrl from "../../variable";

const store = createStore({
  state: {
    addNewBuilding: false,
    addNewRoom: false,
    addNewHeater: false,
    editNewHeater: false,
    deleteHeaterConfirm: false,
    addNewWindow: false,
    editNewWindow: false,
    deleteWindowConfirm: false,
    //building data post

    buildingId: null,
    buildingName: null,
    buildingAddress: null,
    buildingSize: null,
    buildingAge: null,
    storeyNumber: null,
    buildingOwner: null,



    //post room data
    buildingIdRoom: null,
    roomID: null,
    roomName: null,
    roomTemperature: null,

    //post heater data
    currentTemperature: 0,
    heaterStatus: false,
    name: null,
    targetTemperature: null,

    //editHeater data
    editId: 0,
    editCurrentTemperature: 0,
    editHeaterStatus: false,
    editName: null,
    editTargetTemperature: null,

    //post window data
    nameWindow: null,
    windowStatus: null,

    //edit window data
    editWindowId: 0,
    editNameWindow: null,
    editWindowStatus: null,

    //get building id when clicked go to room;
    currrentBuildingID: 0,

    //get building id when clicked go to heater or windows;
    currrentRoomID: 0,

    //get id of heater to be deleted
    deleteHeaterId: 0,

    //get id of window to be deleted 
    deleteWindowId: 0,

    //heater list 
    heaterlist: null,

    //show notification 
    buildingSuccessNotification: false,
    buildingFailedNotification: false,

    //heaterturn on
    heaterTurnOnDialogBox: false,
    heaterTurnOnID: 0,
    currentHeaterStatus: null,
    displayHeaterStatus: false,
    updateHeaterStatus: null,

    //window turn on 
    windowOpenCloseDialogBox: false,
    windowTurnOnID: 0,

    //window list 

    windowList: null,

    //building list

    buildingList: null,

    //room list 

    roomList: null,

    //room new add notification
    roomSuccessNotification: false,
    heaterSuccessNotification: false,
    heaterEditSuccessNotification: false,
    heaterstatusChangeNotification: false,
    heaterDeleteSuccessNotification: false,
    windowEditSuccessNotfication: false,
    windowDeleteSuccessNotfication: false,
    windowSuccessNotification: false,
    windowStatusChangedNotification: false,
    heaterDeletedSuccessNotification: false,
    windowDeletedSuccessNotification: false,

    //display back ppage button
    displayBackPageButton: false

  },
  mutations: {
    updateBuildingId(state, buildingId) {
      this.state.buildingId = buildingId;
    },
    updateBuildingName(state, buildingName) {
      this.state.buildingName = buildingName;
    },

    updateBuildingAddress(state, buildingAddress) {
      this.state.buildingAddress = buildingAddress;
    },
    updateBuildingSize(state, buildingSize) {
      this.state.buildingSize = buildingSize;
    },
    updateBuildingAge(state, buildingAge) {
      this.state.buildingAge = buildingAge;
    },
    updateStoreyNumber(state, storeyNumber) {
      this.state.storeyNumber = storeyNumber;
    },
    updateBuildingOwner(state, buildingOwner) {
      this.state.buildingOwner = buildingOwner;
    },

    updateBuildingIdRoom(state, buildingIdRoom) {
      state.buildingIdRoom = buildingIdRoom;
    },
    updateRoomID(state, roomID) {
      state.roomID = roomID;
    },

    updateRoomName(state, roomName) {
      state.roomName = roomName;
    },
    updateRoomTemperature(state, roomTemperature) {
      state.roomTemperature = roomTemperature;
    },
    updateCurrentTemperature(state, currentTemperature) {
      state.currentTemperature = currentTemperature;
    },
    updateHeaterStatus(state, heaterStatus) {
      state.heaterStatus = heaterStatus;
    },
    updateName(state, name) {
      state.name = name;
    },
    updateTargetTemperature(state, targetTemperature) {
      state.targetTemperature = targetTemperature;
    },

    updateEditCurrentTemperature(state, editCurrentTemperature) {
      state.editCurrentTemperature = editCurrentTemperature;
    },
    updateEditHeaterStatus(state, editHeaterStatus) {
      state.editHeaterStatus = editHeaterStatus;
    },
    updateEditName(state, editName) {
      state.editName = editName;
    },
    updateEditTargetTemperature(state, editTargetTemperature) {
      state.editTargetTemperature = editTargetTemperature;
    },

    updateNameWindow(state, nameWindow) {
      state.nameWindow = nameWindow;
    },
    updateWindowStatus(state, windowStatus) {
      state.windowStatus = windowStatus;
    },
    updateEditWindowName(state, editNameWindow) {
      state.editNameWindow = editNameWindow;
    },
    updateEditWindowStatus(state, editWindowStatus) {
      state.editWindowStatus = editWindowStatus;
    },
  },
  actions: {
    async onSubmitBuildingData() {
      let responseStatus;
      await axios
        .post(serverUrl + "/api/v1/building/new", {
          buildingAddress: this.state.buildingAddress,
          buildingAge: this.state.buildingAge,
          buildingID: this.state.buildingId,
          buildingName: this.state.buildingName,
          buildingOwner: this.state.buildingOwner,
          buildingSize: this.state.buildingSize,
          buildingType: this.state.buildingType,
          storeyNumber: this.state.storeyNumber,
        })
        .then((response) => {
          console.log("dbfhdsfdsf", response);
          responseStatus = response.status;
          axios.get(serverUrl + "/api/v1/buildings").then((response) => {

            this.state.buildingList = response.data;
            console.log(this.buildings);
          });

        });

      if (responseStatus == 201) {
        this.state.buildingSuccessNotification = true;
      } else {
        this.state.buildingFailedNotification = true;
      }

      console.log("sdjhsdjfhsjdfhjsdfhsjdhf", responseStatus)
    },

    async onSubmitRoomData() {
      await axios
        .post(serverUrl + "/api/v1/rooms/new", {
          buildingID: this.state.currrentBuildingID,
          roomID: this.state.roomID,
          roomName: this.state.roomName,
          roomTemperature: this.state.roomTemperature,
        })
        .then((response) => {

          this.state.roomSuccessNotification = true
          console.log(response);
          axios
            .get(serverUrl + "/api/v1/rooms/" + store.state.currrentBuildingID)
            .then((response) => {
              this.rooms = response.data;
              this.state.roomList = response.data;
              console.log(this.rooms);
            });
        });
    },

    async onSubmitHeaterData() {
      console.log("ghdshhdshfgdshfgdhfdgf", this.state.currrentRoomID)
      await axios
        .post(serverUrl + "/api/v1/newheater", {
          roomID: this.state.currrentRoomID,
          name: this.state.name,
          heaterStatus: "OFF",
          currentTemperature: this.state.currentTemperature,
          targetTemperature: this.state.targetTemperature,

        })
        .then((response) => {
          console.log(response);
          this.state.heaterSuccessNotification = true
          axios
            .get(serverUrl + "/api/v1/heaters/" + store.state.currrentRoomID)
            .then((response) => {
              this.state.heaterlist = response.data;
            });
        });
    },

    async onSubmitWindowData() {
      await axios
        .post(serverUrl + "/api/v1/windows/new", {
          roomID: this.state.currrentRoomID,
          name: this.state.nameWindow,
          windowStatus: "CLOSE",
        })
        .then((response) => {
          console.log(response);
          this.state.windowSuccessNotification = true
          axios
            .get(serverUrl + "/api/v1/windows/" + store.state.currrentRoomID)
            .then((response) => {
              this.state.windowList = response.data;
            });
        });
    },

    async updateHeaterData() {

      await axios
        .post(serverUrl + "/api/v1/newheater", {
          roomID: this.state.currrentRoomID,
          name: this.state.editName,
          id: this.state.editId,
          heaterStatus: "OFF",
          currentTemperature: this.state.editCurrentTemperature,
          targetTemperature: this.state.editTargetTemperature,


        })
        .then((response) => {
          console.log(response);
          this.state.heaterEditSuccessNotification = true;
          axios
            .get(serverUrl + "/api/v1/heaters/" + store.state.currrentRoomID)
            .then((response) => {

              this.state.heaterlist = response.data;
            });
        });


    },



    async updateWindowData() {
      await axios
        .post(serverUrl + "/api/v1/windows/new", {
          id: this.state.editWindowId,
          roomID: this.state.currrentRoomID,
          name: this.state.editNameWindow,
          windowStatus: "CLOSE",
        })
        .then((response) => {
          console.log(response);
          this.state.windowEditSuccessNotfication = true
          axios
            .get(serverUrl + "/api/v1/windows/" + store.state.currrentRoomID)
            .then((response) => {

              this.state.windowList = response.data;
            });
        });
    },

    //turn on heater 

  },

  modules: {},
});

export default store;