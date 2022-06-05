import AdminApi from './axios'

const api = {}

api.login = (loginForm) => {
    return AdminApi.post('api/admin/login', loginForm)
}

export default api;
