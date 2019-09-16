(window.webpackJsonp=window.webpackJsonp||[]).push([[18],{710:function(e,t,i){"use strict";i.r(t);var r=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("section",{staticClass:"table-container"},[i("div",{staticClass:"toolbar"},[i("el-input",{attrs:{placeholder:"请输入内容"},model:{value:e.tableParams.parameter,callback:function(t){e.$set(e.tableParams,"parameter",t)},expression:"tableParams.parameter"}}),e._v(" "),i("el-button",{attrs:{icon:"el-icon-search"},on:{click:e.tableListGet}}),e._v(" "),i("div",{staticClass:"placeholder"}),e._v(" "),i("el-button",{attrs:{type:"primary",icon:"el-icon-plus"},on:{click:e.rowAdd}},[e._v("添加")])],1),e._v(" "),i("div",{staticClass:"table"},[i("el-table",{attrs:{data:e.tableData}},[i("el-table-column",{attrs:{prop:"siteNum",label:"台站编号","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"siteName",label:"台站名称","min-width":"200",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"siteLongitude",label:"站点经度","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"siteLatitude",label:"站点纬度","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"siteAddress",label:"台站地址","min-width":"250",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"provinceName",label:"台站所属省","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"cityName",label:"台站所属市","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"siteCompanyName",label:"单位","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"siteSystemType",label:"系统型号","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"itemNumberName",label:"项目编号","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"projectManager",label:"项目经理","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"siteTypeName",label:"台站类型","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"siteManufactureTime",label:"出厂日期",formatter:e.dateFormat,"min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"siteGuaranteeTime",label:"保修日期",formatter:e.dateFormat,"min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"siteAcceptanceTime",label:"验收日期",formatter:e.dateFormat,"min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"integrateFirm",label:"集成厂商","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"siteNatureName",label:"站点性质","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"siteUsageStateName",label:"站点状态","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"antennaHeight",label:"天线高度","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"siteSerialNumber",label:"站点序号","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{label:"巡检记录",fixed:"right","min-width":"100",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{type:"text"},on:{click:function(i){return e.rowRecordDetail(t.row)}}},[e._v("详情")])]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"台站详情",fixed:"right","min-width":"100",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{type:"text"},on:{click:function(i){return e.rowEdit(t.row)}}},[e._v("详情")])]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"台站设备",fixed:"right","min-width":"100",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{type:"text"},on:{click:function(i){return e.rowDeviceShow(t.row)}}},[e._v("详情")])]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"图片展示",fixed:"right","min-width":"100",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{type:"text"},on:{click:function(i){return e.rowPcitureDetail(t.row)}}},[e._v("详情")])]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"台站二维码",fixed:"right","min-width":"100",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{type:"text"},on:{click:function(i){return e.QRCodeGen(t.row)}}},[e._v("查看")])]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"操作",fixed:"right",width:"100",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{staticStyle:{color:"#F56C6C"},attrs:{type:"text"},on:{click:function(i){return e.rowDelete(t.row)}}},[e._v("删除")])]}}])})],1)],1),e._v(" "),i("div",{staticClass:"pagination"},[i("div",{staticClass:"placeholder"}),e._v(" "),i("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:e.tableTotal},on:{"current-change":e.tablePageChange}})],1),e._v(" "),i("el-dialog",{attrs:{title:"添加",visible:e.visible.addDlg,width:"50%","close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.visible,"addDlg",t)},opened:e.rowAddOpened,close:e.clearAddData}},[i("el-form",{ref:"addForm",attrs:{"label-width":"120px","label-position":"right",model:e.addForm,rules:e.rules,size:"mini"}},[i("el-form-item",{attrs:{prop:"siteNum",label:"台站编号"}},[i("el-input",{model:{value:e.addForm.siteNum,callback:function(t){e.$set(e.addForm,"siteNum",t)},expression:"addForm.siteNum"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteName",label:"台站名称"}},[i("el-input",{model:{value:e.addForm.siteName,callback:function(t){e.$set(e.addForm,"siteName",t)},expression:"addForm.siteName"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteAddress",label:"台站地址"}},[i("el-input",{model:{value:e.addForm.siteAddress,callback:function(t){e.$set(e.addForm,"siteAddress",t)},expression:"addForm.siteAddress"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"itemNumberId",label:"项目编号"}},[i("el-select",{model:{value:e.addForm.itemNumberId,callback:function(t){e.$set(e.addForm,"itemNumberId",t)},expression:"addForm.itemNumberId"}},e._l(e.projectNumOptions,function(e,t){return i("el-option",{key:t,attrs:{value:e.itemNumberId,label:e.itemNumberName}})}),1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"projectManager",label:"项目经理"}},[i("el-input",{model:{value:e.addForm.projectManager,callback:function(t){e.$set(e.addForm,"projectManager",t)},expression:"addForm.projectManager"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"integrateFirm",label:"集成厂商"}},[i("el-input",{model:{value:e.addForm.integrateFirm,callback:function(t){e.$set(e.addForm,"integrateFirm",t)},expression:"addForm.integrateFirm"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteNatureId",label:"站点性质"}},[i("el-select",{model:{value:e.addForm.siteNatureId,callback:function(t){e.$set(e.addForm,"siteNatureId",t)},expression:"addForm.siteNatureId"}},e._l(e.siteNatureOptions,function(e,t){return i("el-option",{key:t,attrs:{value:e.siteNatureId,label:e.siteNatureName}})}),1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteUsageStateId",label:"站点状态"}},[i("el-select",{model:{value:e.addForm.siteUsageStateId,callback:function(t){e.$set(e.addForm,"siteUsageStateId",t)},expression:"addForm.siteUsageStateId"}},e._l(e.siteStateOptions,function(e,t){return i("el-option",{key:t,attrs:{value:e.siteUsageStateId,label:e.siteUsageStateName}})}),1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"antennaHeight",label:"天线高度"}},[i("el-input",{model:{value:e.addForm.antennaHeight,callback:function(t){e.$set(e.addForm,"antennaHeight",t)},expression:"addForm.antennaHeight"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteSerialNumber",label:"站点序号"}},[i("el-input",{model:{value:e.addForm.siteSerialNumber,callback:function(t){e.$set(e.addForm,"siteSerialNumber",t)},expression:"addForm.siteSerialNumber"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"productModelId",label:"产品型号"}},[i("el-select",{model:{value:e.editForm.productModelId,callback:function(t){e.$set(e.editForm,"productModelId",t)},expression:"editForm.productModelId"}},e._l(e.productTypeOptions,function(e,t){return i("el-option",{key:t,attrs:{value:e.productModelId,label:e.productModelName}})}),1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"area",label:"所属区域"}},[i("el-cascader",{attrs:{options:e.locationOptions,props:e.locationProps,placeholder:"请选择"},model:{value:e.addForm.area,callback:function(t){e.$set(e.addForm,"area",t)},expression:"addForm.area"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteCompanyId",label:"所属单位"}},[i("el-select",{model:{value:e.addForm.siteCompanyId,callback:function(t){e.$set(e.addForm,"siteCompanyId",t)},expression:"addForm.siteCompanyId"}},e._l(e.siteBelongOptions,function(e,t){return i("el-option",{key:t,attrs:{value:e.siteCompanyId,label:e.siteCompanyName}})}),1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteTypeId",label:"台站类型"}},[i("el-select",{model:{value:e.addForm.siteTypeId,callback:function(t){e.$set(e.addForm,"siteTypeId",t)},expression:"addForm.siteTypeId"}},e._l(e.siteTypeOptions,function(e,t){return i("el-option",{key:t,attrs:{value:e.siteTypeId,label:e.siteTypeName}})}),1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteLongitude",label:"经度"}},[i("el-input",{model:{value:e.addForm.siteLongitude,callback:function(t){e.$set(e.addForm,"siteLongitude",t)},expression:"addForm.siteLongitude"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteLatitude",label:"纬度"}},[i("el-input",{model:{value:e.addForm.siteLatitude,callback:function(t){e.$set(e.addForm,"siteLatitude",t)},expression:"addForm.siteLatitude"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"coreEquipment",label:"核心设备"}},[i("el-input",{model:{value:e.addForm.coreEquipment,callback:function(t){e.$set(e.addForm,"coreEquipment",t)},expression:"addForm.coreEquipment"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteSystemType",label:"系统型号"}},[i("el-input",{model:{value:e.addForm.siteSystemType,callback:function(t){e.$set(e.addForm,"siteSystemType",t)},expression:"addForm.siteSystemType"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"operSysVirsion",label:"操作系统版本"}},[i("el-input",{model:{value:e.addForm.operSysVirsion,callback:function(t){e.$set(e.addForm,"operSysVirsion",t)},expression:"addForm.operSysVirsion"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"monSoftVersion",label:"监测软件版本"}},[i("el-input",{model:{value:e.addForm.monSoftVersion,callback:function(t){e.$set(e.addForm,"monSoftVersion",t)},expression:"addForm.monSoftVersion"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"otherSoftInfo",label:"其他软件信息"}},[i("el-input",{model:{value:e.addForm.otherSoftInfo,callback:function(t){e.$set(e.addForm,"otherSoftInfo",t)},expression:"addForm.otherSoftInfo"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"isShutdown",label:"无人站关机服务"}},[i("el-select",{model:{value:e.addForm.isShutdown,callback:function(t){e.$set(e.addForm,"isShutdown",t)},expression:"addForm.isShutdown"}},[i("el-option",{attrs:{value:"1",label:"是"}}),e._v(" "),i("el-option",{attrs:{value:"0",label:"否"}})],1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteManufactureTime",label:"出厂日期"}},[i("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd hh:mm:ss"},model:{value:e.addForm.siteManufactureTime,callback:function(t){e.$set(e.addForm,"siteManufactureTime",t)},expression:"addForm.siteManufactureTime"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteGuaranteeTime",label:"保修日期"}},[i("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd hh:mm:ss"},model:{value:e.addForm.siteGuaranteeTime,callback:function(t){e.$set(e.addForm,"siteGuaranteeTime",t)},expression:"addForm.siteGuaranteeTime"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteAcceptanceTime",label:"验收日期"}},[i("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd hh:mm:ss"},model:{value:e.addForm.siteAcceptanceTime,callback:function(t){e.$set(e.addForm,"siteAcceptanceTime",t)},expression:"addForm.siteAcceptanceTime"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteDescribe",label:"站点描述"}},[i("el-input",{attrs:{type:"textarea",maxlength:"9999","show-word-limit":""},model:{value:e.addForm.siteDescribe,callback:function(t){e.$set(e.addForm,"siteDescribe",t)},expression:"addForm.siteDescribe"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"站点照片"}},[i("el-upload",{attrs:{action:"","auto-upload":!1,"file-list":e.addForm.imgList,"list-type":"picture",limit:8,"on-change":e.onChange,"on-remove":e.onRemove,"on-exceed":e.onExceed,accept:".jpg,.png",multiple:""}},[i("el-button",{attrs:{slot:"trigger",size:"small"},slot:"trigger"},[e._v("添加图片")]),e._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("只能上传jpg/png文件，且不超过8张")])],1)],1)],1),e._v(" "),i("div",{attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.visible.addDlg=!1}}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:e.rowAddSubmit}},[e._v("确 定")])],1)],1),e._v(" "),i("el-dialog",{attrs:{title:"编辑",visible:e.visible.editDlg,width:"50%","close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.visible,"editDlg",t)},close:e.clearEditData}},[i("el-form",{ref:"editForm",attrs:{"label-width":"120px","label-position":"right",model:e.editForm,rules:e.rules,size:"mini"}},[i("el-form-item",{attrs:{prop:"siteNum",label:"台站编号"}},[i("el-input",{model:{value:e.editForm.siteNum,callback:function(t){e.$set(e.editForm,"siteNum",t)},expression:"editForm.siteNum"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteName",label:"台站名称"}},[i("el-input",{model:{value:e.editForm.siteName,callback:function(t){e.$set(e.editForm,"siteName",t)},expression:"editForm.siteName"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteAddress",label:"台站地址"}},[i("el-input",{model:{value:e.editForm.siteAddress,callback:function(t){e.$set(e.editForm,"siteAddress",t)},expression:"editForm.siteAddress"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"itemNumberId",label:"项目编号"}},[i("el-select",{model:{value:e.editForm.itemNumberId,callback:function(t){e.$set(e.editForm,"itemNumberId",t)},expression:"editForm.itemNumberId"}},e._l(e.projectNumOptions,function(e,t){return i("el-option",{key:t,attrs:{value:e.itemNumberId,label:e.itemNumberName}})}),1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"projectManager",label:"项目经理"}},[i("el-input",{model:{value:e.editForm.projectManager,callback:function(t){e.$set(e.editForm,"projectManager",t)},expression:"editForm.projectManager"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"integrateFirm",label:"集成厂商"}},[i("el-input",{model:{value:e.editForm.integrateFirm,callback:function(t){e.$set(e.editForm,"integrateFirm",t)},expression:"editForm.integrateFirm"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteNatureId",label:"站点性质"}},[i("el-select",{model:{value:e.editForm.siteNatureId,callback:function(t){e.$set(e.editForm,"siteNatureId",t)},expression:"editForm.siteNatureId"}},e._l(e.siteNatureOptions,function(e,t){return i("el-option",{key:t,attrs:{value:e.siteNatureId,label:e.siteNatureName}})}),1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteUsageStateId",label:"站点状态"}},[i("el-select",{model:{value:e.editForm.siteUsageStateId,callback:function(t){e.$set(e.editForm,"siteUsageStateId",t)},expression:"editForm.siteUsageStateId"}},e._l(e.siteStateOptions,function(e,t){return i("el-option",{key:t,attrs:{value:e.siteUsageStateId,label:e.siteUsageStateName}})}),1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"antennaHeight",label:"天线高度"}},[i("el-input",{model:{value:e.editForm.antennaHeight,callback:function(t){e.$set(e.editForm,"antennaHeight",t)},expression:"editForm.antennaHeight"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteSerialNumber",label:"站点序号"}},[i("el-input",{model:{value:e.editForm.siteSerialNumber,callback:function(t){e.$set(e.editForm,"siteSerialNumber",t)},expression:"editForm.siteSerialNumber"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"productModelId",label:"产品型号"}},[i("el-select",{model:{value:e.editForm.productModelId,callback:function(t){e.$set(e.editForm,"productModelId",t)},expression:"editForm.productModelId"}},e._l(e.productTypeOptions,function(e,t){return i("el-option",{key:t,attrs:{value:e.productModelId,label:e.productModelName}})}),1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"area",label:"所属区域"}},[i("el-cascader",{attrs:{options:e.locationOptions,props:e.locationProps,placeholder:"请选择"},model:{value:e.editForm.area,callback:function(t){e.$set(e.editForm,"area",t)},expression:"editForm.area"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteCompanyId",label:"所属单位"}},[i("el-select",{model:{value:e.editForm.siteCompanyId,callback:function(t){e.$set(e.editForm,"siteCompanyId",t)},expression:"editForm.siteCompanyId"}},e._l(e.siteBelongOptions,function(e,t){return i("el-option",{key:t,attrs:{value:e.siteCompanyId,label:e.siteCompanyName}})}),1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteTypeId",label:"台站类型"}},[i("el-select",{model:{value:e.editForm.siteTypeId,callback:function(t){e.$set(e.editForm,"siteTypeId",t)},expression:"editForm.siteTypeId"}},e._l(e.siteTypeOptions,function(e,t){return i("el-option",{key:t,attrs:{value:e.siteTypeId,label:e.siteTypeName}})}),1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteLongitude",label:"经度"}},[i("el-input",{model:{value:e.editForm.siteLongitude,callback:function(t){e.$set(e.editForm,"siteLongitude",t)},expression:"editForm.siteLongitude"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteLatitude",label:"纬度"}},[i("el-input",{model:{value:e.editForm.siteLatitude,callback:function(t){e.$set(e.editForm,"siteLatitude",t)},expression:"editForm.siteLatitude"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"coreEquipment",label:"核心设备"}},[i("el-input",{model:{value:e.editForm.coreEquipment,callback:function(t){e.$set(e.editForm,"coreEquipment",t)},expression:"editForm.coreEquipment"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteSystemType",label:"系统型号"}},[i("el-input",{model:{value:e.editForm.siteSystemType,callback:function(t){e.$set(e.editForm,"siteSystemType",t)},expression:"editForm.siteSystemType"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"operSysVirsion",label:"操作系统版本"}},[i("el-input",{model:{value:e.editForm.operSysVirsion,callback:function(t){e.$set(e.editForm,"operSysVirsion",t)},expression:"editForm.operSysVirsion"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"monSoftVersion",label:"监测软件版本"}},[i("el-input",{model:{value:e.editForm.monSoftVersion,callback:function(t){e.$set(e.editForm,"monSoftVersion",t)},expression:"editForm.monSoftVersion"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"otherSoftInfo",label:"其他软件信息"}},[i("el-input",{model:{value:e.editForm.otherSoftInfo,callback:function(t){e.$set(e.editForm,"otherSoftInfo",t)},expression:"editForm.otherSoftInfo"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"isShutdown",label:"无人站关机服务"}},[i("el-select",{model:{value:e.editForm.isShutdown,callback:function(t){e.$set(e.editForm,"isShutdown",t)},expression:"editForm.isShutdown"}},[i("el-option",{attrs:{value:"1",label:"是"}}),e._v(" "),i("el-option",{attrs:{value:"0",label:"否"}})],1)],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteManufactureTime",label:"出厂日期"}},[i("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd hh:mm:ss"},model:{value:e.editForm.siteManufactureTime,callback:function(t){e.$set(e.editForm,"siteManufactureTime",t)},expression:"editForm.siteManufactureTime"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteGuaranteeTime",label:"保修日期"}},[i("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd hh:mm:ss"},model:{value:e.editForm.siteGuaranteeTime,callback:function(t){e.$set(e.editForm,"siteGuaranteeTime",t)},expression:"editForm.siteGuaranteeTime"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteAcceptanceTime",label:"验收日期"}},[i("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd hh:mm:ss"},model:{value:e.editForm.siteAcceptanceTime,callback:function(t){e.$set(e.editForm,"siteAcceptanceTime",t)},expression:"editForm.siteAcceptanceTime"}})],1),e._v(" "),i("el-form-item",{attrs:{prop:"siteDescribe",label:"站点描述"}},[i("el-input",{attrs:{type:"textarea",maxlength:"9999","show-word-limit":""},model:{value:e.editForm.siteDescribe,callback:function(t){e.$set(e.editForm,"siteDescribe",t)},expression:"editForm.siteDescribe"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"站点照片"}},[i("el-upload",{attrs:{action:"","auto-upload":!1,"list-type":"picture",limit:8,"on-change":e.onEditChange,"before-remove":e.beforeEditRemove,"on-remove":e.onEditRemove,accept:".jpg,.png","file-list":e.editForm.imgList,"on-exceed":e.onExceed,multiple:""}},[i("el-button",{attrs:{slot:"trigger",size:"small"},slot:"trigger"},[e._v("添加图片")]),e._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("只能上传jpg/png文件，且不超过8张")])],1)],1)],1),e._v(" "),i("div",{attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.visible.editDlg=!1}}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:e.rowEditSubmit}},[e._v("确 定")])],1)],1),e._v(" "),i("el-dialog",{attrs:{title:"巡检记录",visible:e.visible.recordDetail,width:"30%","close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.visible,"recordDetail",t)}}}),e._v(" "),i("el-dialog",{attrs:{title:"台站详情",visible:e.visible.infoDetail,width:"30%","close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.visible,"infoDetail",t)}}}),e._v(" "),i("el-dialog",{attrs:{title:"台站设备",visible:e.visible.deviceDetail,width:"70%","close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.visible,"deviceDetail",t)}}},[i("el-table",{attrs:{data:e.recordDetailData}},[i("el-table-column",{attrs:{prop:"deviceSystemNum",label:"子系统号","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"deviceName",label:"设备名称","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"deviceModel",label:"设备型号","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"deviceSerialNum",label:"设备序号","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"deviceState",label:"设备状态","min-width":"200",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"provinceName",label:"台站所属省","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{prop:"cityName",label:"台站所属市","min-width":"100",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{label:"设备照片","min-width":"100",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{type:"text"},on:{click:function(i){return e.rowDeviceDetailImg(t.row)}}},[e._v("查看")])]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"设备详情","min-width":"100",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{type:"text"},on:{click:function(i){return e.rowDeviceDetailInfo(t.row)}}},[e._v("详情")])]}}])})],1),e._v(" "),i("div",{staticClass:"pagination"},[i("div",{staticClass:"placeholder"}),e._v(" "),i("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:e.recordDetailTotal},on:{"current-change":e.recordDetailChange}})],1)],1),e._v(" "),i("el-dialog",{attrs:{title:"二维码",visible:e.visible.QRCode,width:"18%","close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.visible,"QRCode",t)}}},[i("img",{staticStyle:{width:"100%"},attrs:{src:e.QRCodeData,alt:"No Image"}})]),e._v(" "),i("z-img-view",{attrs:{imgs:e.fileList,visible:e.visible.pictureDetail},on:{"update:visible":function(t){return e.$set(e.visible,"pictureDetail",t)}}})],1)};r._withStripped=!0;var l=i(675),a=i.n(l),o={data:function(){return{tableData:null,tableParams:{parameter:null},tablePage:1,tableTotal:1,visible:{addDlg:!1,editDlg:!1,recordDetail:!1,infoDetail:!1,deviceDetail:!1,pictureDetail:!1,QRCode:!1},rules:{siteNum:[{required:!0,message:"请输入",trigger:"blur"}],siteName:[{required:!0,message:"请输入",trigger:"blur"}],siteAddress:[{required:!0,message:"请输入",trigger:"blur"}],itemNumberId:[{required:!0,message:"请输入",trigger:"blur"}],projectManager:[{required:!0,message:"请输入",trigger:"blur"}],integrateFirm:[{required:!1}],siteUsageStateId:[{required:!1}],antennaHeight:[{required:!1}],siteSerialNumber:[{required:!1}],productModelId:[{required:!0,message:"请输入",trigger:"blur"}],area:[{required:!0,message:"请输入",trigger:"blur"}],siteCompanyId:[{required:!0,message:"请输入",trigger:"blur"}],siteLongitude:[{required:!0,message:"请输入",trigger:"blur"}],siteLatitude:[{required:!0,message:"请输入",trigger:"blur"}],siteTypeId:[{required:!0,message:"请输入",trigger:"blur"}],siteSystemType:[{required:!0,message:"请输入",trigger:"blur"}],coreEquipment:[{required:!0,message:"请输入",trigger:"blur"}],operSysVirsion:[{required:!0,message:"请输入",trigger:"blur"}],monSoftVersion:[{required:!0,message:"请输入",trigger:"blur"}],otherSoftInfo:[{required:!0,message:"请输入",trigger:"blur"}],isShutdown:[{required:!0,message:"请输入",trigger:"blur"}],siteManufactureTime:[{required:!0,message:"请输入",trigger:"blur"}],siteGuaranteeTime:[{required:!1}],siteAcceptanceTime:[{required:!1}],siteDescribe:[{required:!0,message:"请输入",trigger:"blur"}]},addForm:{siteNum:null,siteName:null,siteAddress:null,itemNumberId:null,projectManager:null,integrateFirm:null,siteNatureId:null,siteUsageStateId:null,antennaHeight:null,siteSerialNumber:null,productModelId:null,area:[],siteCompanyId:null,siteLongitude:null,siteLatitude:null,siteTypeId:null,siteSystemType:null,imgList:[],coreEquipment:null,operSysVirsion:null,monSoftVersion:null,otherSoftInfo:null,isShutdown:null,siteManufactureTime:null,siteGuaranteeTime:null,siteAcceptanceTime:null,siteDescribe:null},editForm:{siteId:null,siteNum:null,siteName:null,siteAddress:null,itemNumberId:null,projectManager:null,integrateFirm:null,siteNatureId:null,siteUsageStateId:null,antennaHeight:null,siteSerialNumber:null,productModelId:null,area:[],siteCompanyId:null,siteLongitude:null,siteLatitude:null,siteTypeId:null,siteSystemType:null,imgList:[],coreEquipment:null,operSysVirsion:null,monSoftVersion:null,otherSoftInfo:null,isShutdown:null,siteManufactureTime:null,siteGuaranteeTime:null,siteAcceptanceTime:null,siteDescribe:null},rowDetailId:null,recordDetailData:[],recordDetailPage:1,recordDetailTotal:1,QRCodeData:null,imgListBin:[],locationOptions:[],projectNumOptions:[],siteNatureOptions:[],siteStateOptions:[],siteBelongOptions:[],siteTypeOptions:[],productTypeOptions:[],locationProps:{value:"id",label:"name",children:"child"},fileList:[]}},methods:{tableListGet:function(){var e=this;this.$API.SiteInfoGet(this.tableParams.parameter?this.tableParams:null,this.tablePage).then(function(t){e.tableData=t.records,e.tableTotal=t.total})},rowAdd:function(){var e=this;this.$API.LocationGet().then(function(t){e.locationOptions=t}),this.$API.ProjectNumGet().then(function(t){e.projectNumOptions=t}),this.$API.SiteNatureGet().then(function(t){e.siteNatureOptions=t}),this.$API.SiteStateGet().then(function(t){e.siteStateOptions=t}),this.$API.SiteBelongGet().then(function(t){e.siteBelongOptions=t}),this.$API.SiteTypeGet().then(function(t){e.siteTypeOptions=t}),this.$API.ProductTypeGet().then(function(t){e.productTypeOptions=t}),this.visible.addDlg=!0},rowAddOpened:function(){this.$refs.addForm.resetFields(),this.imgListBin=[]},rowAddSubmit:function(){var e=this,t={siteNum:this.addForm.siteNum||null,siteName:this.addForm.siteName||null,siteAddress:this.addForm.siteAddress||null,itemNumberId:this.addForm.itemNumberId||null,projectManager:this.addForm.projectManager||null,integrateFirm:this.addForm.integrateFirm||null,siteNatureId:this.addForm.siteNatureId||null,siteUsageStateId:this.addForm.siteUsageStateId||null,antennaHeight:this.addForm.antennaHeight||null,siteSerialNumber:this.addForm.siteSerialNumber||null,productModelId:this.addForm.productModelId||null,siteProvinceId:this.addForm.area[0]||null,siteCityId:this.addForm.area[1]||null,siteCompanyId:this.addForm.siteCompanyId||null,siteLongitude:this.addForm.siteLongitude||null,siteLatitude:this.addForm.siteLatitude||null,siteTypeId:this.addForm.siteTypeId||null,siteSystemType:this.addForm.siteSystemType||null,imgList:[],coreEquipment:this.addForm.coreEquipment||null,operSysVirsion:this.addForm.operSysVirsion||null,monSoftVersion:this.addForm.monSoftVersion||null,otherSoftInfo:this.addForm.otherSoftInfo||null,isShutdown:this.addForm.isShutdown||null,siteManufactureTime:this.addForm.siteManufactureTime||null,siteGuaranteeTime:this.addForm.siteGuaranteeTime||null,siteAcceptanceTime:this.addForm.siteAcceptanceTime||null,siteDescribe:this.addForm.siteDescribe||null};this.imgListBin.length<=0?this.$message({message:"请至少选择一张图片",type:"warning"}):this.$refs.addForm.validate(function(i){if(i){var r=new FormData;for(var l in e.imgListBin)r.append("multipartFiles",e.imgListBin[l]);e.$API.Uploads(r).then(function(i){t.imgList=i.map(function(e){return{resourceUrl:e}}),e.$API.SiteInfoAdd(t).then(function(){e.tableListGet(),e.visible.addDlg=!1})})}})},rowEdit:function(e){var t=this;this.$API.LocationGet().then(function(e){t.locationOptions=e}),this.$API.ProjectNumGet().then(function(e){t.projectNumOptions=e}),this.$API.SiteNatureGet().then(function(e){t.siteNatureOptions=e}),this.$API.SiteStateGet().then(function(e){t.siteStateOptions=e}),this.$API.SiteBelongGet().then(function(e){t.siteBelongOptions=e}),this.$API.SiteTypeGet().then(function(e){t.siteTypeOptions=e}),this.$API.ProductTypeGet().then(function(e){t.productTypeOptions=e}),this.$API.SiteInfoGetById(null,e.siteId).then(function(e){t.editForm.siteId=e.siteId||null,t.editForm.siteNum=e.siteNum||null,t.editForm.siteName=e.siteName||null,t.editForm.siteAddress=e.siteAddress||null,t.editForm.itemNumberId=e.itemNumberId||null,t.editForm.projectManager=e.projectManager||null,t.editForm.integrateFirm=e.integrateFirm||null,t.editForm.siteNatureId=e.siteNatureId||null,t.editForm.siteUsageStateId=e.siteUsageStateId||null,t.editForm.antennaHeight=e.antennaHeight||null,t.editForm.siteSerialNumber=e.siteSerialNumber||null,t.editForm.productModelId=e.productModelId||null,t.editForm.area=[e.siteProvinceId||null,e.siteCityId||null],t.editForm.siteCompanyId=e.siteCompanyId||null,t.editForm.siteLongitude=e.siteLongitude||null,t.editForm.siteLatitude=e.siteLatitude||null,t.editForm.siteTypeId=e.siteTypeId||null,t.editForm.siteSystemType=e.siteSystemType||null,t.editForm.imgList=e.imgList.map(function(e){return{name:e.resourceId,url:e.resourceUrl}}),t.editForm.coreEquipment=e.coreEquipment||null,t.editForm.operSysVirsion=e.operSysVirsion||null,t.editForm.monSoftVersion=e.monSoftVersion||null,t.editForm.otherSoftInfo=e.otherSoftInfo||null,t.editForm.isShutdown=e.isShutdown||null,t.editForm.siteManufactureTime=e.siteManufactureTime||null,t.editForm.siteGuaranteeTime=e.siteGuaranteeTime||null,t.editForm.siteAcceptanceTime=e.siteAcceptanceTime||null,t.editForm.siteDescribe=e.siteDescribe||null}),this.imgListBin=[],this.visible.editDlg=!0},rowEditSubmit:function(){var e=this,t={siteId:this.editForm.siteId||null,siteNum:this.editForm.siteNum||null,siteName:this.editForm.siteName||null,siteAddress:this.editForm.siteAddress||null,itemNumberId:this.editForm.itemNumberId||null,projectManager:this.editForm.projectManager||null,integrateFirm:this.editForm.integrateFirm||null,siteNatureId:this.editForm.siteNatureId||null,siteUsageStateId:this.editForm.siteUsageStateId||null,antennaHeight:this.editForm.antennaHeight||null,siteSerialNumber:this.editForm.siteSerialNumber||null,productModelId:this.editForm.productModelId||null,siteProvinceId:this.editForm.area[0]||null,siteCityId:this.editForm.area[1]||null,siteCompanyId:this.editForm.siteCompanyId||null,siteLongitude:this.editForm.siteLongitude||null,siteLatitude:this.editForm.siteLatitude||null,siteTypeId:this.editForm.siteTypeId||null,siteSystemType:this.editForm.siteSystemType||null,imgList:[],coreEquipment:this.editForm.coreEquipment||null,operSysVirsion:this.editForm.operSysVirsion||null,monSoftVersion:this.editForm.monSoftVersion||null,otherSoftInfo:this.editForm.otherSoftInfo||null,isShutdown:this.editForm.isShutdown||null,siteManufactureTime:this.editForm.siteManufactureTime||null,siteGuaranteeTime:this.editForm.siteGuaranteeTime||null,siteAcceptanceTime:this.editForm.siteAcceptanceTime||null,siteDescribe:this.editForm.siteDescribe||null};this.editForm.imgList.length+this.imgListBin.length<=0?this.$message({message:"请至少选择一张图片",type:"warning"}):this.$refs.editForm.validate(function(i){if(i){var r=new FormData;for(var l in e.imgListBin)r.append("multipartFiles",e.imgListBin[l]);e.$API.Uploads(r).then(function(i){t.imgList=i.map(function(e){return{resourceUrl:e}}),e.$API.SiteInfoEdit(t).then(function(){e.tableListGet(),e.visible.editDlg=!1})})}})},rowRecordDetail:function(e){this.visible.recordDetail=!0,this.$API.SiteInfoTaskGetById(null,e.siteId).then(function(e){})},deviceListGet:function(){var e=this,t={parameter:this.rowDetailId};this.$API.SiteInfoDeviceGetById(t,this.recordDetailPage).then(function(t){e.recordDetailData=t.records,e.recordDetailTotal=t.total})},rowDeviceShow:function(e){this.rowDetailId=e.siteId,this.deviceListGet(),this.visible.deviceDetail=!0},rowDeviceDetailInfo:function(e){this.$router.push({path:"/site/deviceInfo/"+e.deviceId})},rowDeviceDetailImg:function(e){this.fileList=e.imgList.map(function(e){return e.resourceUrl}),this.visible.pictureDetail=!0},rowPcitureDetail:function(e){this.fileList=e.imgList.map(function(e){return e.resourceUrl}),this.visible.pictureDetail=!0},QRCodeGen:function(e){var t=this;a.a.toDataURL(e.siteId.toString(),{scale:12,margin:2}).then(function(e){t.QRCodeData=e,t.visible.QRCode=!0}).catch(function(e){console.log(e)})},rowDelete:function(e){var t=this;this.$confirm("确认删除该条数据？","提示",{type:"warning"}).then(function(){t.$API.SiteInfoDelete(null,e.siteId).then(function(){t.tableListGet()})}).catch()},dateFormat:function(e,t,i,r){return this.$format(i)},tablePageChange:function(e){this.tablePage=e,this.tableListGet()},recordDetailChange:function(e){this.recordDetailPage=e,this.deviceListGet()},onExceed:function(){this.$message({message:"图片数不超过8张",type:"warning"})},onChange:function(e,t){this.imgListBin=t.map(function(e){return e.raw})},onRemove:function(e,t){this.imgListBin=t.map(function(e){return e.raw})},onEditChange:function(e,t){this.imgListBin=t.filter(function(e){return e.raw}).map(function(e){return e.raw})},beforeEditRemove:function(e,t){var i=this;return"success"===e.status?this.$confirm("确认删除该图片？","提示",{type:"warning"}).then(function(){i.$API.SiteInfoImgDelete(null,e.name).then(function(e){i.$message({message:"删除成功",type:"success"})}).catch(function(e){i.$message({message:"删除失败",type:"error"})})}):"ready"===e.status},onEditRemove:function(e,t){this.editForm.imgList=t,this.imgListBin=t.filter(function(e){return e.raw}).map(function(e){return e.raw})},clearAddData:function(){for(var e in this.addForm)this.addForm[e]="imgList"===e||"area"===e?[]:null},clearEditData:function(){for(var e in this.editForm)this.editForm[e]="imgList"===e||"area"===e?[]:null}},mounted:function(){if(this.$route.params.id){var e={siteId:this.$route.params.id};this.rowEdit(e)}this.tableListGet()}},n=i(8),s=Object(n.a)(o,r,[],!1,null,null,null);s.options.__file="src/views/Site/SiteInfo.vue";t.default=s.exports}}]);