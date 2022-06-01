import { Form, Input, Button, Layout, Menu, Row, Col } from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'

const components = [
  Form,
  Input,
  Button,
  Layout,
  Menu,
  Row,
  Col
]

//  按需引入
export function setupAntd(app) {
    components.forEach(component => {
      app.use(component)
    })
}
