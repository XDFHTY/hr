(window.webpackJsonp=window.webpackJsonp||[]).push([[21],{699:function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{staticClass:"table-container"},[n("div",{staticClass:"toolbar"},[n("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd hh:mm:ss",placeholder:"开始时间"},model:{value:t.startTime,callback:function(e){t.startTime=e},expression:"startTime"}}),t._v(" "),n("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd hh:mm:ss",placeholder:"结束时间"},model:{value:t.endTime,callback:function(e){t.endTime=e},expression:"endTime"}}),t._v(" "),n("el-select",{attrs:{placeholder:"所属部门",clearable:""},on:{change:t.personListGet},model:{value:t.departmentId,callback:function(e){t.departmentId=e},expression:"departmentId"}},t._l(t.departmentOptions,function(t,e){return n("el-option",{key:e,attrs:{label:t.departmentName,value:t.departmentId}})}),1),t._v(" "),n("el-select",{attrs:{placeholder:"人员",clearable:""},model:{value:t.personId,callback:function(e){t.personId=e},expression:"personId"}},t._l(t.personOptions,function(t,e){return n("el-option",{key:e,attrs:{label:t.fullName,value:t.adminId}})}),1),t._v(" "),n("el-button",{attrs:{icon:"el-icon-search"},on:{click:t.tableListGet}}),t._v(" "),n("div",{staticClass:"placeholder"}),t._v(" "),n("el-button",{attrs:{icon:"el-icon-download",type:"primary"},on:{click:t.exportExcel}},[t._v("导出")])],1),t._v(" "),n("div",{staticClass:"table"},[n("el-table",{attrs:{data:t.tableData}},[n("el-table-column",{attrs:{prop:"siteType",label:"站点类型","min-width":"100",align:"center"}}),t._v(" "),n("el-table-column",{attrs:{prop:"patNum",label:"巡查次数","min-width":"100",align:"center"}}),t._v(" "),n("el-table-column",{attrs:{prop:"staNum",label:"售后处理次数","min-width":"100",align:"center"}})],1)],1)])};a._withStripped=!0;n(213);var l={data:function(){return{tableData:[],startTime:null,endTime:null,departmentId:null,personId:null,locationPOptions:[],locationCOptions:[],departmentOptions:[],personOptions:[]}},methods:{tableListGet:function(){var t=this,e={parameters:{adminId:this.personId||null,start:this.startTime||null,end:this.endTime||null}};this.$API.StatisticWorkGet(e).then(function(e){t.tableData=e})},cityListGet:function(){var t=this;this.cityId=null,this.$API.LocationGetC({pid:this.provinceId}).then(function(e){t.locationCOptions=e})},personListGet:function(){var t=this;this.$API.PersonGet(null,0,this.departmentId).then(function(e){t.personOptions=e})},exportExcel:function(){var t={parameters:{adminId:this.personId||null,start:this.startTime||null,end:this.endTime||null}};this.$API.StatisticWorkExport(t).then(function(t){var e=new Blob([t],{type:"application/vnd.ms-excel"}),n=window.URL.createObjectURL(e),a=document.createElement("a");a.href=n,a.download="Excel.xlsx",a.click(),window.URL.revokeObjectURL(n)})}},mounted:function(){var t=this;this.$API.LocationGetP().then(function(e){t.locationPOptions=e}),this.$API.DepartmentGet().then(function(e){t.departmentOptions=e})}},i=n(8),o=Object(i.a)(l,a,[],!1,null,null,null);o.options.__file="src/views/Statistic/Work.vue";e.default=o.exports}}]);