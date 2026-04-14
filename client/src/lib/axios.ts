import axios from "axios";

export const api = axios.create({
  baseURL: "http://localhost:8080",
});

// Intercepta todas as requisições antes delas saírem
api.interceptors.request.use(
    (config) => {
      // Busca o token JWT salvo no momento do login.
      // Ajuste "token" para o nome exato da chave que você usou no seu AuthContext/Login
      const token = localStorage.getItem("token");

      if (token) {
        // Injeta o cabeçalho Authorization de forma segura
        config.headers.Authorization = `Bearer ${token}`;
      }

      return config;
    },
    (error) => {
      return Promise.reject(error);
    }
);