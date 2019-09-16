(window.webpackJsonp=window.webpackJsonp||[]).push([[14],{718:function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("section",{staticClass:"table-container"},[a("div",{staticClass:"toolbar"},[a("el-input",{attrs:{placeholder:"请输入内容"},model:{value:e.tableParams.parameter,callback:function(t){e.$set(e.tableParams,"parameter",t)},expression:"tableParams.parameter"}}),e._v(" "),a("el-button",{attrs:{icon:"el-icon-search"},on:{click:e.tableListGet}}),e._v(" "),a("div",{staticClass:"placeholder"}),e._v(" "),a("el-button",{attrs:{type:"danger",icon:"el-icon-delete"},on:{click:e.rowDelete}},[e._v("删除")]),e._v(" "),a("el-button",{attrs:{type:"primary",icon:"el-icon-plus"},on:{click:e.rowAdd}},[e._v("添加周期计划")])],1),e._v(" "),a("div",{staticClass:"table"},[a("el-table",{attrs:{data:e.tableData},on:{"selection-change":e.tableSelectChange}},[a("el-table-column",{attrs:{type:"selection"}}),e._v(" "),a("el-table-column",{attrs:{prop:"taskName",label:"任务名称","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"provinceName",label:"巡检区域","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"createName",label:"生成人","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"patrolName",label:"巡检人","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{label:"操作",width:"150",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text"},on:{click:function(a){return e.rowDetail(t.row)}}},[e._v("详情")]),e._v(" "),a("el-button",{attrs:{type:"text"},on:{click:function(a){return e.rowEdit(t.row)}}},[e._v("重新指派")])]}}])})],1)],1),e._v(" "),a("div",{staticClass:"pagination"},[a("div",{staticClass:"placeholder"}),e._v(" "),a("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:e.tableTotal},on:{"current-change":e.tablePageChange}})],1),e._v(" "),a("el-dialog",{attrs:{title:"添加",visible:e.visible.addDlg,width:"50%","close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.visible,"addDlg",t)},opened:e.rowAddOpened}},[a("el-form",{ref:"addForm",attrs:{"label-width":"120px","label-position":"right",model:e.addForm,rules:e.rules,size:"mini"}},[a("el-form-item",{attrs:{prop:"taskName",label:"任务名称"}},[a("el-input",{model:{value:e.addForm.taskName,callback:function(t){e.$set(e.addForm,"taskName",t)},expression:"addForm.taskName"}})],1),e._v(" "),a("el-form-item",{attrs:{prop:"provinceId",label:"巡检省"}},[a("el-select",{model:{value:e.addForm.provinceId,callback:function(t){e.$set(e.addForm,"provinceId",t)},expression:"addForm.provinceId"}},e._l(e.locationPOptions,function(e,t){return a("el-option",{key:t,attrs:{label:e.name,value:e.id}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{prop:"roleId",label:"所属角色"}},[a("el-select",{attrs:{clearable:""},on:{change:e.personListGet},model:{value:e.addForm.roleId,callback:function(t){e.$set(e.addForm,"roleId",t)},expression:"addForm.roleId"}},e._l(e.roleOptions,function(e,t){return a("el-option",{key:t,attrs:{value:e.roleId,label:e.roleName}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{prop:"departmentId",label:"所属部门"}},[a("el-select",{attrs:{clearable:""},on:{change:e.personListGet},model:{value:e.addForm.departmentId,callback:function(t){e.$set(e.addForm,"departmentId",t)},expression:"addForm.departmentId"}},e._l(e.departmentOptions,function(e,t){return a("el-option",{key:t,attrs:{value:e.departmentId,label:e.departmentName}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{prop:"patrolId",label:"巡检人"}},[a("el-select",{attrs:{clearable:""},model:{value:e.addForm.patrolId,callback:function(t){e.$set(e.addForm,"patrolId",t)},expression:"addForm.patrolId"}},e._l(e.personOptions,function(e,t){return a("el-option",{key:t,attrs:{value:e.adminId,label:e.fullName}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{prop:"cycle",label:"计划周期"}},[a("el-input",{model:{value:e.addForm.cycle,callback:function(t){e.$set(e.addForm,"cycle",e._n(t))},expression:"addForm.cycle"}},[a("span",{attrs:{slot:"suffix"},slot:"suffix"},[e._v("月·次")])])],1),e._v(" "),a("el-form-item",{attrs:{label:"开始时间"}},[a("el-date-picker",{attrs:{disabled:""},model:{value:e.totalStartTime,callback:function(t){e.totalStartTime=t},expression:"totalStartTime"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"结束时间"}},[a("el-date-picker",{attrs:{disabled:""},model:{value:e.totalEndTime,callback:function(t){e.totalEndTime=t},expression:"totalEndTime"}})],1),e._v(" "),a("el-form-item",{attrs:{prop:"advance",label:"提前触发天数"}},[a("el-input",{model:{value:e.addForm.advance,callback:function(t){e.$set(e.addForm,"advance",e._n(t))},expression:"addForm.advance"}})],1)],1),e._v(" "),a("el-divider",{attrs:{"content-position":"left"}},[a("span",{staticStyle:{"font-size":"1.4rem"}},[e._v("任务列表")])]),e._v(" "),a("el-button",{staticStyle:{float:"right"},attrs:{size:"mini"},on:{click:e.rowAddTask}},[e._v("添加")]),e._v(" "),a("el-table",{attrs:{data:e.addForm.listPSM}},[a("el-table-column",{attrs:{prop:"cityId",label:"巡检市","min-width":"100",align:"center",formatter:e.cityId2Name}}),e._v(" "),a("el-table-column",{attrs:{prop:"startTime",formatter:e.timeFormat,label:"巡检开始时间","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"endTime",formatter:e.timeFormat,label:"巡检结束时间","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"siteIds",label:"站点","min-width":"100",align:"center",formatter:e.siteId2Name}})],1),e._v(" "),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.visible.addDlg=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:e.rowAddSubmit}},[e._v("确 定")])],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"添加",visible:e.visible.addTaskDlg,width:"30%","close-on-click-modal":!1,"append-to-body":""},on:{"update:visible":function(t){return e.$set(e.visible,"addTaskDlg",t)},opened:e.rowAddTaskOpened}},[a("el-form",{ref:"addTaskForm",attrs:{"label-width":"120px","label-position":"right",model:e.addTaskForm,rules:e.rulesTask,size:"mini"}},[a("el-form-item",{attrs:{prop:"cityId",label:"巡检市"}},[a("el-select",{model:{value:e.addTaskForm.cityId,callback:function(t){e.$set(e.addTaskForm,"cityId",t)},expression:"addTaskForm.cityId"}},e._l(e.locationCOptions,function(e,t){return a("el-option",{key:t,attrs:{label:e.name,value:e.id}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{prop:"startTime",label:"巡检开始时间"}},[a("el-date-picker",{attrs:{format:"yyyy-MM-dd","value-format":"timestamp"},model:{value:e.addTaskForm.startTime,callback:function(t){e.$set(e.addTaskForm,"startTime",t)},expression:"addTaskForm.startTime"}})],1),e._v(" "),a("el-form-item",{attrs:{prop:"endTime",label:"巡检结束时间"}},[a("el-date-picker",{attrs:{format:"yyyy-MM-dd","value-format":"timestamp"},model:{value:e.addTaskForm.endTime,callback:function(t){e.$set(e.addTaskForm,"endTime",t)},expression:"addTaskForm.endTime"}})],1),e._v(" "),a("el-divider",{attrs:{"content-position":"left"}},[e._v("站点选择")]),e._v(" "),[a("el-transfer",{attrs:{data:e.deviceOptions,titles:["站点列表","已选站点"]},model:{value:e.addTaskForm.siteIds,callback:function(t){e.$set(e.addTaskForm,"siteIds",t)},expression:"addTaskForm.siteIds"}})]],2),e._v(" "),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.visible.addTaskDlg=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:e.rowAddTaskSubmit}},[e._v("确 定")])],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"重新指派",visible:e.visible.editDlg,width:"25%","close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.visible,"editDlg",t)}}},[a("el-form",{attrs:{"label-width":"120px","label-position":"right",size:"mini"}},[a("el-form-item",{attrs:{prop:"roleId",label:"所属角色"}},[a("el-select",{attrs:{clearable:""},on:{change:e.personListGet},model:{value:e.addForm.roleId,callback:function(t){e.$set(e.addForm,"roleId",t)},expression:"addForm.roleId"}},e._l(e.roleOptions,function(e,t){return a("el-option",{key:t,attrs:{value:e.roleId,label:e.roleName}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{prop:"departmentId",label:"所属部门"}},[a("el-select",{attrs:{clearable:""},on:{change:e.personListGet},model:{value:e.addForm.departmentId,callback:function(t){e.$set(e.addForm,"departmentId",t)},expression:"addForm.departmentId"}},e._l(e.departmentOptions,function(e,t){return a("el-option",{key:t,attrs:{value:e.departmentId,label:e.departmentName}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{prop:"patrolId",label:"巡检人"}},[a("el-select",{attrs:{clearable:""},model:{value:e.editForm.patrolId,callback:function(t){e.$set(e.editForm,"patrolId",t)},expression:"editForm.patrolId"}},e._l(e.personOptions,function(e,t){return a("el-option",{key:t,attrs:{value:e.adminId,label:e.fullName}})}),1)],1)],1),e._v(" "),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.visible.editDlg=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:e.rowEditSubmit}},[e._v("确 定")])],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"详情",visible:e.visible.detailDlg,width:"50%","close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.visible,"detailDlg",t)}}},[a("el-form",{attrs:{"label-width":"120px","label-position":"right",size:"mini"}},[a("el-form-item",{attrs:{label:"任务名称"}},[a("el-input",{attrs:{disabled:""},model:{value:e.detailForm.taskName,callback:function(t){e.$set(e.detailForm,"taskName",t)},expression:"detailForm.taskName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"巡检省"}},[a("el-input",{attrs:{disabled:""},model:{value:e.detailForm.provinceName,callback:function(t){e.$set(e.detailForm,"provinceName",t)},expression:"detailForm.provinceName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"巡检人"}},[a("el-input",{attrs:{disabled:""},model:{value:e.detailForm.patrolName,callback:function(t){e.$set(e.detailForm,"patrolName",t)},expression:"detailForm.patrolName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"开始时间"}},[a("el-date-picker",{attrs:{disabled:""},model:{value:e.detailForm.startTime,callback:function(t){e.$set(e.detailForm,"startTime",t)},expression:"detailForm.startTime"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"结束时间"}},[a("el-date-picker",{attrs:{disabled:""},model:{value:e.detailForm.endTime,callback:function(t){e.$set(e.detailForm,"endTime",t)},expression:"detailForm.endTime"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"计划周期"}},[a("el-input",{attrs:{disabled:""},model:{value:e.detailForm.cycle,callback:function(t){e.$set(e.detailForm,"cycle",t)},expression:"detailForm.cycle"}},[a("span",{attrs:{slot:"suffix"},slot:"suffix"},[e._v("月·次")])])],1),e._v(" "),a("el-form-item",{attrs:{label:"提前触发天数"}},[a("el-input",{attrs:{disabled:""},model:{value:e.detailForm.advance,callback:function(t){e.$set(e.detailForm,"advance",t)},expression:"detailForm.advance"}})],1)],1),e._v(" "),a("el-divider",{attrs:{"content-position":"left"}},[a("span",{staticStyle:{"font-size":"1.4rem"}},[e._v("任务列表")])]),e._v(" "),a("el-table",{attrs:{data:e.detailForm.listPSM}},[a("el-table-column",{attrs:{prop:"cityName",label:"巡检市","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"startTime",formatter:e.timeShowFormat,label:"巡检开始时间","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"endTime",formatter:e.timeShowFormat,label:"巡检结束时间","min-width":"100",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"siteName",label:"站点","min-width":"100",align:"center"}})],1),e._v(" "),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.visible.detailDlg=!1}}},[e._v("关 闭")])],1)],1)],1)};l._withStripped=!0;var i={data:function(){return{tableData:null,tableParams:{parameter:null},tablePage:1,tableTotal:1,sels:[],visible:{addDlg:!1,addTaskDlg:!1,editDlg:!1,detailDlg:!1,imgView:!1,deviceDetail:!1},rules:{taskName:[{required:!0,message:"请输入",trigger:"blur"}],provinceId:[{required:!0,message:"请输入",trigger:"change"}],patrolId:[{required:!1}],cycle:[{required:!0,message:"请输入",trigger:"blur"},{type:"number",message:"请输入数字",trigger:"blur"}],advance:[{required:!0,message:"请输入",trigger:"blur"},{type:"number",message:"请输入数字",trigger:"blur"}]},rulesTask:{cityId:[{required:!0,message:"请输入",trigger:"blur"}],startTime:[{required:!0,message:"请输入",trigger:"blur"}],endTime:[{required:!0,message:"请输入",trigger:"blur"}]},addForm:{taskName:null,provinceId:0,patrolId:null,roleId:null,departmentId:null,cycle:0,advance:0,listPSM:[]},editForm:{patrolCycleId:0,patrolId:null},detailForm:{taskName:null,provinceName:0,patrolName:null,cycle:0,advance:0,listPSM:[]},addTaskForm:{cityId:0,startTime:null,endTime:null,siteIds:[]},departmentOptions:[],roleOptions:[{roleName:"员工",roleId:29},{roleName:"代维1级",roleId:30},{roleName:"代维2级",roleId:31},{roleName:"办事处员工",roleId:34}],personOptions:[],deviceOptions:[],locationPOptions:[],locationCOptions:[],cityIndex:{},siteIndex:{}}},computed:{totalStartTime:function(){var e=this.addForm.listPSM;if(0===e.length)return null;var t=this.addForm.listPSM[0].startTime;for(var a in e)e[a].startTime<t&&(t=e[a].startTime);return t},totalEndTime:function(){var e=this.addForm.listPSM;if(0===e.length)return null;var t=this.addForm.listPSM[0].endTime;for(var a in e)e[a].endTime>t&&(t=e[a].endTime);return t}},methods:{tableListGet:function(){var e=this;this.$API.PlanGet(this.tableParams.parameter?this.tableParams:null,this.tablePage).then(function(t){e.tableData=t.records,e.tableTotal=t.total})},personListGet:function(){var e=this;this.personOptions=[],this.addForm.patrolId=null,this.editForm.patrolId=null,this.$API.PersonGet(null,this.addForm.roleId||0,this.addForm.departmentId||0).then(function(t){e.personOptions=t})},rowAdd:function(){var e=this;for(var t in this.addForm)this.addForm[t]="listPSM"===t?[]:null;this.$API.LocationGetP().then(function(t){e.locationPOptions=t}),this.$API.DepartmentGet().then(function(t){e.departmentOptions=t}),this.visible.addDlg=!0},rowAddOpened:function(){this.$refs.addForm.resetFields()},rowAddSubmit:function(){var e=this;0!==this.addForm.listPSM.length?this.$refs.addForm.validate(function(t){if(t){var a={taskName:e.addForm.taskName,provinceId:e.addForm.provinceId||0,patrolId:e.addForm.patrolId||0,startTime:e.timeFormat(null,null,e.totalStartTime)+" 12:00:00",endTime:e.timeFormat(null,null,e.totalEndTime)+" 12:00:00",cycle:e.addForm.cycle||0,advance:e.addForm.advance||0,listPSM:[]};for(var l in e.addForm.listPSM)for(var i in e.addForm.listPSM[l].siteIds)a.listPSM.push({cityId:e.addForm.listPSM[l].cityId,startTime:e.addForm.listPSM[l].startTime,endTime:e.addForm.listPSM[l].endTime,siteId:e.addForm.listPSM[l].siteIds[i]});for(var r in a.listPSM)a.listPSM[r].startTime=e.timeFormat(null,null,a.listPSM[r].startTime)+" 12:00:00",a.listPSM[r].endTime=e.timeFormat(null,null,a.listPSM[r].endTime)+" 12:00:00";e.$API.PlanAdd(a).then(function(){e.tableListGet(),e.visible.addDlg=!1})}}):this.$message({message:"最少添加一个站点",type:"warning"})},rowAddTask:function(){var e=this;this.$refs.addForm.validate(function(t){if(t){for(var a in e.addTaskForm)e.addTaskForm[a]="siteIds"===a?[]:null;e.$API.DeviceSiteGet(null,0,e.addForm.provinceId||0,e.addForm.cityId||0).then(function(t){if(e.siteIndex={},0!==t.length)for(var a in e.deviceOptions=[],t)e.siteIndex[t[a].siteId]=t[a].siteName,e.deviceOptions.push({key:t[a].siteId,label:t[a].siteName})});var l={pid:e.addForm.provinceId||0};e.$API.LocationGetC(l).then(function(t){if(e.locationCOptions=t,e.cityIndex={},0!==t.length)for(var a in t)e.cityIndex[t[a].id]=t[a].name}),e.visible.addTaskDlg=!0}})},rowAddTaskOpened:function(){this.$refs.addTaskForm.resetFields()},rowAddTaskSubmit:function(){var e=this;0!==this.addTaskForm.siteIds.length?this.$refs.addTaskForm.validate(function(t){t&&(e.addForm.listPSM.push(JSON.parse(JSON.stringify(e.addTaskForm))),e.visible.addTaskDlg=!1)}):this.$message({message:"最少选择一个站点",type:"warning"})},rowDetail:function(e){this.detailForm=e,this.visible.detailDlg=!0},rowEdit:function(e){var t=this;this.$API.DepartmentGet().then(function(e){t.departmentOptions=e}),this.editForm.patrolCycleId=e.patrolCycleId,this.editForm.patrolId=null,this.visible.editDlg=!0},rowEditSubmit:function(){var e=this;if(this.editForm.patrolId){var t={patrolCycleId:this.editForm.patrolCycleId,patrolId:this.editForm.patrolId};this.$API.PlanEdit(t).then(function(t){e.visible.editDlg=!1,e.tableListGet()})}},rowDelete:function(){var e=this;0!==this.sels.length&&this.$confirm("确认删除这些数据？","提示",{type:"warning"}).then(function(){e.$API.PlanDelete(e.sels.map(function(e){return e.patrolCycleId})).then(function(){e.tableListGet()})}).catch()},cityId2Name:function(e,t,a,l){return this.cityIndex[a]},siteId2Name:function(e,t,a,l){var i=this;return a.map(function(e){return i.siteIndex[e]}).join(",")},timeFormat:function(e,t,a,l){var i=new Date;return i.setTime(a),this.$format(i.getFullYear()+"-"+(i.getMonth()+1)+"-"+i.getDate())},timeShowFormat:function(e,t,a,l){return this.$format(a)},tablePageChange:function(e){this.tablePage=e,this.tableListGet()},tableSelectChange:function(e){this.sels=e}},mounted:function(){this.tableListGet()}},r=a(8),o=Object(r.a)(i,l,[],!1,null,null,null);o.options.__file="src/views/Inspection/Plan.vue";t.default=o.exports}}]);