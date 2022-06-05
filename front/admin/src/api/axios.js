import axios from 'axios'

axios.interceptors.response.use(res => {
    return res.data
})

const AdminApi = axios.create({
    baseURL:process.env.BASE_API,
    // headers: {'Content-Type': 'application/json'},
    timeout: 1000,
})

export default AdminApi;
