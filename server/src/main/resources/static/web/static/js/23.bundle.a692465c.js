(window.webpackJsonp=window.webpackJsonp||[]).push([[23],{714:function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("section",{staticClass:"table-container"},[a("div",{staticClass:"toolbar"},[a("div",{staticClass:"placeholder"}),e._v(" "),a("el-button",{attrs:{type:"primary",icon:"el-icon-plus"},on:{click:e.rowAdd}},[e._v("新增")])],1),e._v(" "),a("div",{staticClass:"table"},[a("el-table",{attrs:{data:e.tableData},on:{"selection-change":e.tableSelectChange}},[a("el-table-column",{attrs:{prop:"adminName",label:"用户名","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"voAdminInfo.fullName",label:"姓名","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"voAdminInfo.phone",label:"电话号码","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"voAdminInfo.departmentName",label:"所属部门","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"roleName",label:"角色","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{label:"密码","min-width":"100",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text"},on:{click:function(a){return e.pwdReset(t.row)}}},[e._v("重置密码")])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作",width:"150",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text"},on:{click:function(a){return e.rowEdit(t.row)}}},[e._v("修改")])]}}])})],1)],1),e._v(" "),a("div",{staticClass:"pagination"},[a("div",{staticClass:"placeholder"}),e._v(" "),a("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:e.tableTotal},on:{"current-change":e.tablePageChange}})],1),e._v(" "),a("el-dialog",{attrs:{visible:e.visible.addDlg,width:"25%",title:"添加用户","close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.visible,"addDlg",t)},opened:e.rowAddOpend}},[a("el-form",{ref:"addForm",attrs:{"label-width":"120px","label-position":"right",model:e.addForm,rules:e.rules,size:"mini"}},[a("el-form-item",{attrs:{prop:"adminName",label:"用户名"}},[a("el-input",{model:{value:e.addForm.adminName,callback:function(t){e.$set(e.addForm,"adminName",t)},expression:"addForm.adminName"}})],1),e._v(" "),a("el-form-item",{attrs:{prop:"fullName",label:"姓名"}},[a("el-input",{model:{value:e.addForm.fullName,callback:function(t){e.$set(e.addForm,"fullName",t)},expression:"addForm.fullName"}})],1),e._v(" "),a("el-form-item",{attrs:{prop:"phone",label:"手机号"}},[a("el-input",{model:{value:e.addForm.phone,callback:function(t){e.$set(e.addForm,"phone",t)},expression:"addForm.phone"}})],1),e._v(" "),a("el-form-item",{attrs:{prop:"departmentId",label:"所属部门"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.addForm.departmentId,callback:function(t){e.$set(e.addForm,"departmentId",t)},expression:"addForm.departmentId"}},e._l(e.departmentOptions,function(e,t){return a("el-option",{key:t,attrs:{value:e.departmentId,label:e.departmentName}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{prop:"roleId",label:"账号角色"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.addForm.roleId,callback:function(t){e.$set(e.addForm,"roleId",t)},expression:"addForm.roleId"}},e._l(e.roleOptions,function(e,t){return a("el-option",{key:t,attrs:{value:e.roleId,label:e.roleName}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{prop:"area",label:"归属地"}},[a("el-cascader",{attrs:{options:e.locationOptions,props:e.locationProps,"change-on-select":"",clearable:"",placeholder:"请选择"},model:{value:e.addForm.area,callback:function(t){e.$set(e.addForm,"area",t)},expression:"addForm.area"}})],1)],1),e._v(" "),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.visible.addDlg=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:e.rowAddSubmit}},[e._v("确 定")])],1)],1),e._v(" "),a("el-dialog",{attrs:{visible:e.visible.editDlg,width:"30%",title:"编辑用户","close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.visible,"editDlg",t)},opened:e.rowEditOpend}},[a("el-form",{ref:"editForm",attrs:{"label-width":"120px","label-position":"right",model:e.editForm,rules:e.rules,size:"mini"}},[a("el-form-item",{attrs:{prop:"adminName",label:"用户名"}},[a("el-input",{attrs:{disabled:""},model:{value:e.editForm.adminName,callback:function(t){e.$set(e.editForm,"adminName",t)},expression:"editForm.adminName"}})],1),e._v(" "),a("el-form-item",{attrs:{prop:"fullName",label:"姓名"}},[a("el-input",{model:{value:e.editForm.fullName,callback:function(t){e.$set(e.editForm,"fullName",t)},expression:"editForm.fullName"}})],1),e._v(" "),a("el-form-item",{attrs:{prop:"phone",label:"手机号"}},[a("el-input",{model:{value:e.editForm.phone,callback:function(t){e.$set(e.editForm,"phone",t)},expression:"editForm.phone"}})],1),e._v(" "),a("el-form-item",{attrs:{prop:"departmentId",label:"所属部门"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.editForm.departmentId,callback:function(t){e.$set(e.editForm,"departmentId",t)},expression:"editForm.departmentId"}},e._l(e.departmentOptions,function(e,t){return a("el-option",{key:t,attrs:{value:e.departmentId,label:e.departmentName}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{prop:"roleId",label:"账号角色"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.editForm.roleId,callback:function(t){e.$set(e.editForm,"roleId",t)},expression:"editForm.roleId"}},e._l(e.roleOptions,function(e,t){return a("el-option",{key:t,attrs:{value:e.roleId,label:e.roleName}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{prop:"area",label:"归属地"}},[a("el-cascader",{attrs:{options:e.locationOptions,props:e.locationProps,"change-on-select":"",clearable:"",placeholder:"请选择"},model:{value:e.editForm.area,callback:function(t){e.$set(e.editForm,"area",t)},expression:"editForm.area"}})],1)],1),e._v(" "),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.visible.editDlg=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:e.rowEditSubmit}},[e._v("确 定")])],1)],1)],1)};l._withStripped=!0;var o={data:function(){return{tableData:null,tableFilter:{},tablePage:1,tableTotal:1,sels:[],visible:{addDlg:!1,editDlg:!1,imgView:!1,deviceDetail:!1},rules:{departmentId:[{required:!0,message:"请选择",trigger:"change"}],fullName:[{required:!0,message:"请输入",trigger:"blur"}],phone:[{required:!0,message:"请输入",trigger:"blur"},{pattern:/^1\d{10}$/,message:"请输入11位手机号码",trigger:"blur"}],adminName:[{required:!0,message:"请输入",trigger:"blur"}],roleId:[{required:!0,message:"请选择",trigger:"change"}],area:[{required:!1}]},addForm:{area:null,departmentId:null,fullName:null,phone:null,adminName:null,roleId:null},editForm:{adminId:null,adminInfoId:null,area:[0,0],departmentId:null,fullName:null,phone:null,adminName:null,roleId:null},roleOptions:[],locationOptions:[],departmentOptions:[],locationProps:{value:"id",label:"name",children:"child"}}},methods:{tableListGet:function(){var e=this;this.$API.UserGet(null,this.tablePage).then(function(t){e.tableData=t.records,e.tableTotal=t.total})},rowAdd:function(){var e=this;this.$API.LocationGet().then(function(t){e.locationOptions=t}),this.$API.DepartmentGet().then(function(t){e.departmentOptions=t}),this.$API.RoleGet().then(function(t){e.roleOptions=t.authRoles}),this.visible.addDlg=!0},rowAddOpend:function(){this.$refs.addForm.resetFields()},rowAddSubmit:function(){var e=this;this.$refs.addForm.validate(function(t){if(t){var a={adminInfo:{provinceId:e.addForm.area?e.addForm.area[0]:0,cityId:e.addForm.area?e.addForm.area[1]:0,departmentId:e.addForm.departmentId,fullName:e.addForm.fullName,phone:e.addForm.phone},adminName:e.addForm.adminName,roleId:e.addForm.roleId};e.$API.UserAdd(a).then(function(t){e.tableListGet(),e.visible.addDlg=!1})}})},rowEdit:function(e){var t=this;this.$API.LocationGet().then(function(e){t.locationOptions=e}),this.$API.DepartmentGet().then(function(e){t.departmentOptions=e}),this.$API.RoleGet().then(function(e){t.roleOptions=e.authRoles}),this.editForm.adminId=e.adminId,this.editForm.adminInfoId=e.voAdminInfo.adminInfoId,this.editForm.fullName=e.voAdminInfo.fullName,this.editForm.phone=e.voAdminInfo.phone,this.editForm.adminName=e.adminName,this.editForm.area[0]=e.voAdminInfo.provinceId||0,this.editForm.area[1]=e.voAdminInfo.cityId||0,this.editForm.departmentId=e.voAdminInfo.departmentId,this.editForm.roleId=e.roleId,this.visible.editDlg=!0},rowEditOpend:function(){this.$refs.editForm.resetFields()},rowEditSubmit:function(){var e=this;this.$refs.editForm.validate(function(t){if(t){var a={adminId:e.editForm.adminId,roleId:e.editForm.roleId,adminInfo:{adminId:e.editForm.adminId,adminInfoId:e.editForm.adminInfoId,provinceId:e.editForm.area?e.editForm.area[0]:0,cityId:e.editForm.area?e.editForm.area[1]:0,departmentId:e.editForm.departmentId,fullName:e.editForm.fullName,phone:e.editForm.phone}};e.$API.UserEdit(a).then(function(t){e.tableListGet(),e.visible.editDlg=!1})}})},pwdReset:function(e){var t=this;this.$confirm("确认重置密码？").then(function(){var a={adminId:e.adminId,adminName:e.adminName,adminPass:"123456"};t.$API.UserPwdReset(a).then(function(e){t.$message({message:e.msg,type:"success"})})}).catch()},tablePageChange:function(e){this.tablePage=e,this.tableListGet()},tableSelectChange:function(e){this.sels=e}},mounted:function(){this.tableListGet()}},i=a(8),n=Object(i.a)(o,l,[],!1,null,null,null);n.options.__file="src/views/System/User.vue";t.default=n.exports}}]);