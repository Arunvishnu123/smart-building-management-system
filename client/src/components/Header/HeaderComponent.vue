<!-- eslint-disable prettier/prettier -->
<!-- eslint-disable prettier/prettier -->
<!-- eslint-disable prettier/prettier -->
<template>
<div class="header-contents">
    <w-tag xl height="2em" class="header-label mr4" bg-color="indigo-dark5">Smart Building Management System</w-tag>
    <w-tooltip left>
        <template #activator="{ on }">
            <w-button @click="callAddNew()" class="add-building ma1" v-on="on" xl color="white" bg-color="indigo-dark5" icon="wi-plus"></w-button>
        </template>
        {{ headerTitle }}
    </w-tooltip>

    <w-button v-if="$store.state.displayBackPageButton == true" @click="backPage()" class="refresh-page ma1" v-on="on" xl color="white" bg-color="indigo-dark5" icon="fa fa-arrow-circle-left"></w-button>
</div>
</template>

<script>
export default {
    props: {
        callAddNew: {
            type: Function,
            default () {
                return {};
            },
        },

        backPage: {
            type: Function,
            default () {
                return {};
            },
        },

        headerTitle: {
            type: String,
        },
    },
};
</script>

<style scoped>
.header-contents {
    padding: 0;
    margin: 0;
    background-color: #171e44;
}

.header-label {
    position: absolute;
    width: 100%;
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
    color: white;
    padding: 0;
    margin: 0;
}

.add-building {
    margin-right: 10px;
    z-index: 1000002;
    float: right;
}

.refresh-page {
    margin-right: 10px;
    z-index: 1000002;
    float: left;
}

.tool-tip {
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}
</style>
