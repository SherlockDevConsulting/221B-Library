<template>
  <main class="container">
    <h1>221B Library</h1>
    <section>
      <h2>Health</h2>
      <p>
        Backend status: <strong>{{ statusText }}</strong>
      </p>
      <button @click="checkHealth">Re-check</button>
    </section>
  </main>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const statusText = ref<string>('unknown')

async function checkHealth() {
  try {
    const res = await fetch('/api/health')
    if (!res.ok) throw new Error(String(res.status))
    const data = await res.json()
    statusText.value = data.status ?? 'ok'
  } catch (e) {
    statusText.value = 'down'
  }
}

checkHealth()
</script>

<style scoped>
.container { padding: 2rem; font-family: system-ui, sans-serif; }
button { margin-top: 0.5rem; }
</style>
