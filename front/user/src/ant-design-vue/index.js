import Vue from 'vue'
import {
  Affix,
  // Anchor,
  // AutoComplete,
  // Alert,
  Avatar,
  // Badge,
  // Breadcrumb,
  Button,
  Card,
  // Collapse,
  // Checkbox,
  Col,
  Space,
  Dropdown,
  Form,
  FormModel,
  Icon,
  Input,
  // InputNumber,
  Layout,
  message,
  Menu,
  Modal,
  notification,
  // PageHeader,
  // Pagination,
  // Popover,
  // Progress,
  Row,
  // Select,
  // Spin,
  // Switch,
  // TreeSelect,
  // Tabs,
  // Tag,
  // Tooltip,
  Drawer,
  // Skeleton,
  // Comment,
  Table
} from 'ant-design-vue'

Vue.use(Affix)
Vue.use(Table)
// Vue.use(AutoComplete)
Vue.use(Avatar)
Vue.use(Button)
Vue.use(Col)
Vue.use(Drawer)
Vue.use(Dropdown)
Vue.use(Icon)
Vue.use(Input)
Vue.use(Layout)
Vue.use(Menu)
Vue.use(FormModel)
Vue.use(Form)
Vue.use(Card)
// Vue.use(Pagination)
// Vue.use(Progress)
// Vue.use(Radio)
Vue.use(Modal)
Vue.use(Row)
Vue.use(Space)
// Vue.use(Select)

// message config
// message.config({
//   maxCount: 1
// })
// 挂载原型上
Vue.prototype.$message = message
Vue.prototype.$notification = notification
Vue.prototype.$info = Modal.info
Vue.prototype.$success = Modal.success
Vue.prototype.$error = Modal.error
Vue.prototype.$warning = Modal.warning
Vue.prototype.$confirm = Modal.confirm
