import {
  createRouter,
  createWebHistory
} from "vue-router";
import Building from "../views/Building.vue"
import Room from "../views/Room.vue"
import Heater from "../views/Heater.vue"
import Window from "../views/Window.vue"

const routes = [{
    path: "/",
    name: "Building",
    component: Building
  },
  {
    path: "/room",
    name: "room",
    component: Room
  },
  {
    path: "/room/heater",
    name: "Heater",
    component: Heater
  },

  {
    path: "/room/window",
    name: "Window",
    component: Window
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;