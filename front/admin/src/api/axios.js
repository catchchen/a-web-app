import axios from 'axios'

const AdminApi = axios.create({
    baseURL: '/api/admin',
})

export default AdminApi;