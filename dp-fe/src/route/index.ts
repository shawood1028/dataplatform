import { createMemoryHistory, createRouter } from 'vue-router'

import HomeView from '../components/HelloWorld.vue'
import AIView from '../views/AI.vue'
import DataView from '../views/Data.vue'

const routes = [
  { path: '/',
    name: 'home', 
    component: HomeView 
},
  { path: '/ai',
    name: 'ai',
    component: AIView 

  },
  { path: '/data',
    name: 'data',
    component: DataView },
]

const router = createRouter({
  history: createMemoryHistory(),
  routes,
})

export default router