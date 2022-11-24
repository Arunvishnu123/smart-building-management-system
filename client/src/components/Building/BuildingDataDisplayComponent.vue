<template>
<div class="building-data-contents">
    <w-tag class="building-name" bg-color="primary" color="white" xl>
        Building ID - {{ building?.buildingID }}
    </w-tag>

    <w-tag class="building-name" bg-color="grey-dark5" color="white" xl>
        Building Name - {{ building?.buildingName }}
    </w-tag>

    <w-tag class="building-name" bg-color="grey-dark5" color="white" xl>
        Building Address - {{ building?.buildingAddress }}
    </w-tag>
    <w-tag class="building-name" bg-color="grey-dark5" color="white" xl>
        Building Size - {{ building?.buildingSize }} M2
    </w-tag>
    <w-tag class="building-name" bg-color="grey-dark5" color="white" xl>
        Building Age - {{ building?.buildingAge }} years
    </w-tag>
    <w-tag class="building-name" bg-color="grey-dark5" color="white" xl>
        Number of Storeys - {{ building?.storeyNumber }}
    </w-tag>
    <w-tag class="building-name" bg-color="grey-dark5" color="white" xl>
        Building Owner - {{ building?.buildingOwner }}
    </w-tag>

    <w-button @click="goToRoom(building)" class="room-menu" bg-color="primary">
        Go to rooms
        <w-icon class="ml2" sm> fa fa-building </w-icon>
    </w-button>
</div>
</template>

<script>
import store from "../../store/index"
export default {
    methods: {
        goToRoom(building) {
            this.$router.push("/room");
            store.state.currrentBuildingID = building.buildingID;
            store.state.displayBackPageButton = true;
        }
    },

    props: ["building"],
};
</script>

<style scoped>
.data-contents {
    width: 100%;
    height: 100%;
    background-color: #383838;
}

.building-data-contents {
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

.building-name {
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

.room-menu {
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
    width: 100%;
}
</style>
